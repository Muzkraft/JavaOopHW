package org.example.Core.MVP;

import org.example.Core.Infrastructure.ToDoList;
import org.example.Core.Models.Task;

import java.io.*;

public class Model {
    ToDoList currentTaskList;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentTaskList = new ToDoList();
        currentIndex = 0;
        this.path = path;
    }

    public Task currentTask() {
        if (currentIndex >= 0) {
            return currentTaskList.getTask(currentIndex);
        } else {
            System.out.println("Список задач пуст");
            return null;
        }
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String taskValue = reader.readLine();
            while (taskValue != null) {
                int id = reader.read();
//                String taskValue = reader.readLine();
                String startDate = reader.readLine();
                String endDate = reader.readLine();
                boolean isDone = Boolean.parseBoolean(reader.readLine());
                this.currentTaskList.add(new Task(id, taskValue, startDate, endDate, isDone));
                taskValue = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(path, true)) {
            for (int i = 0; i < currentTaskList.count(); i++) {
                Task task = currentTaskList.getTask(i);
                writer.append(String.format("id: %d\n", task.id));
                writer.append(String.format("Description: %s\n", task.taskValue));
                writer.append(String.format("Start at: %s\n", task.startDate));
                writer.append(String.format("End date: %s\n", task.endDate));
                writer.append(String.format("Done: %s\n", task.isDone));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ToDoList currentTaskList() {
        return this.currentTaskList;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}

