package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Calendar {
    long startDate;
    long endDate;

    long timeToDo;
    Scanner sc = new Scanner(System.in);

    Date date = new Date();
    String inputDate = sc.next();
    SimpleDateFormat formatter = new SimpleDateFormat();

    public Calendar(long time) {
        this.startDate = date.getTime();
        this.endDate = endDate;
        this.timeToDo = endDate - startDate;
    }

    public long setEndDate(long startDate) {
        Calendar calendar = new Calendar(date.getTime());

        return calendar.startDate + sc.nextInt();
    }

    public Date parseDate(String date) {
        Date endDate;
        try {
            endDate = formatter.parse(inputDate);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println(date);
        return endDate;
    }

}
