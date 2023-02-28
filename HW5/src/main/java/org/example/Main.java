package org.example;

import java.util.List;

import static org.example.LexemeParser.lexAnalyze;
import static org.example.SyntaxParser.expr;

/*Создать клиент-серверный калькулятор для работы с вещественными числами.
Вычисление должно быть на сервере. Принимаем выражение для вычисления от пользователя на клиенте.
*Добавить возможность логирования.
**Можно усложнить, если клиент будет отправлять выражение с несколькими действиями сразу,
 например: 3*10-(20+14)/2 (используя стек для парсинга).*/


public class Main {
    public static void main(String[] args) {

//        String expressionText = "122 - 34 - 3* (55 + 5* (3 - 2)) * 2";
        String expressionText = "pow(2 , min(7, 4 + 2, 5, 7))";
        List<LexemeParser.Lexeme> lexemes = lexAnalyze(expressionText);
        LexemeParser.LexemeBuffer lexemeBuffer = new LexemeParser.LexemeBuffer(lexemes);
        System.out.println(expr(lexemeBuffer));
    }
}