package org.example.UI;

import org.example.Core.MVP.View;

import java.util.Date;
import java.util.Scanner;

public class ConsoleView implements View {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }
    @Override
    public int getId() {
        System.out.printf("Id: ");
        return in.nextInt();
    }
    @Override
    public void setId(int value) {
        System.out.printf("Task: %d\n", value);
    }
    @Override
    public String getTask() {
        System.out.println("Description: ");
        return in.next();
    }
    @Override
    public void setTask(String value) {
        System.out.printf("Description: %s\n", value);
    }

    @Override
    public String getStartDate() {
        Date date = new Date();
        System.out.printf("Start at: %s", date.getTime());
        return String.valueOf(date);
    }
    @Override
    public void setStartDate(String startDate) {
        System.out.printf("Start Date: %s\n", startDate);
    }

    @Override
    public String getEndDate() {
        System.out.printf("Укажите дату завершения задачи: ");
        return in.next();
    }

    @Override
    public void setEndDate(String value) {
        System.out.println("End Date: " + value);
    }

    @Override
    public boolean getIsDone() {
        return false;
    }
    public void setIsDone(boolean value) {
        System.out.println("Done: " + value);
    }
}
