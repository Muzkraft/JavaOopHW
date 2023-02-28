package org.example;

import java.util.*;

// Таблица функций
public interface Function {

    int apply(List<Integer> args);

    static HashMap<String, Function> getFunctionMap(){
        HashMap<String, Function> functionTable = new HashMap<>();
        functionTable.put("min", args -> {
           if (args.isEmpty()) {
               throw new RuntimeException("Аргументов для функции не найдено");
           }
           int min = args.get(0);
           for (Integer val: args) {
               if (val < min) {
                   min = val;
               }
           }
           return min;
        });

        functionTable.put("pow", args -> {
            if (args.size() != 2) {
                throw new RuntimeException("Аргументов для функции pow недостаточно" + args.size());
            }
            return (int) Math.pow(args.get(0), args.get(1));
        });

        functionTable.put("random", args -> {
            if (!args.isEmpty()) {
                throw new RuntimeException("Аргументы для функции rand не нужны");
            }
            return (int) (Math.random() * 256f);
        });

        functionTable.put("avg", args -> {
            int sum = 0;
            for (int i = 0; i < args.size(); i++) {
                sum += args.get(i);
            }
            return sum/ args.size();
        });
        return functionTable;
    }
}


