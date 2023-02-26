package org.example.UI;

import org.example.Config;
import org.example.Core.MVP.Presenter;
import org.example.Core.MVP.View;

import java.util.Scanner;

public class App {
    public static boolean ButtonClick() {
        System.out.println("ToDo Manager");
        System.out.println("Здравствуйте");

        int choice;
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);
        presenter.LoadFromFile();
        try (Scanner in = new Scanner(System.in)) {
            while (true){
                // Display menu
                System.out.println("\n Выберите опцию: \n");
                System.out.println(" 1 - prev  2 - next");
                System.out.println("3. Добавить задачу");
                System.out.println("4. Удалить задачу");
                System.out.println("5. Показать все задачи");
                System.out.println("6. Выход");
                choice = in.nextInt();
                System.out.print("\033[H\033[J");
                switch (choice) {
                    case 1:
                        presenter.prev();
                        break;
                    case 2:
                        presenter.next();
                        break;
                    case 3:
                        presenter.add();
                        presenter.saveToFile();
                        break;
                    case 4:
                        System.out.println("Удаление задачи");
                        presenter.remove();
                        break;
                    case 5:
//                        presenter.LoadFromFile();
                        presenter.showTaskList();
                        break;
                    case 6:
                        return false;
                    default:
                        System.out.println("Такой команды нет");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
