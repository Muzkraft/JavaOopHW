package org.example;

import org.example.log.MyFormatter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.*;

import static org.example.LexemeParser.lexAnalyze;
import static org.example.SyntaxParser.expr;
public class ServerApp {
    public static void main(String[] args) {
        Logger servLogger = Logger.getLogger(ServerApp.class.getName());
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }
        servLogger.setLevel(Level.FINE);
        servLogger.addHandler(new ConsoleHandler());

        try {
            FileHandler fh = new FileHandler("server.log");
            fh.setFormatter(new MyFormatter());
            servLogger.addHandler(fh);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидаем соединение....");
            servLogger.log(Level.INFO, "Сервер запущен, ожидаем соединение....");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился к серверу!");
            servLogger.log(Level.INFO, "Клиент подключился к серверу!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (clientRequest.equals("end")) break;

                System.out.println("Мы получили выражение: " + clientRequest);
                servLogger.log(Level.INFO, clientRequest);
                List<LexemeParser.Lexeme> lexemes = lexAnalyze(clientRequest);
                LexemeParser.LexemeBuffer lexemeBuffer = new LexemeParser.LexemeBuffer(lexemes);
                int res = expr(lexemeBuffer);
                dataOutputStream.writeUTF("Результат выражения = " + res);
                servLogger.log(Level.INFO, String.valueOf(res));
            }
        } catch (IOException e) {
            e.printStackTrace();
            servLogger.log(Level.WARNING, e.getMessage());
        }
    }
}
