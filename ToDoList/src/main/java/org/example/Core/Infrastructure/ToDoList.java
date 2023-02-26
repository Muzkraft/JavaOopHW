package org.example.Core.Infrastructure;

import org.example.Core.Models.Task;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private static List<Task> taskList;

    public ToDoList() {
        taskList = new ArrayList<>();
    }

    public boolean add(Task task) {
        boolean flag = false;
        if (!taskList.contains(task)) {
            taskList.add(task);
            flag = true;
        }
        return flag;
    }
    public Task getTask(int index) {
        return contains(index) ? taskList.get(index) : null;
    }

    public boolean remove(Task task) {
        boolean flag = false;
        if (taskList.indexOf(task) != -1) {
            taskList.remove(task);
            flag = true;
        }
        return flag;
    }

    private boolean contains(int index) {
        return taskList != null
                && taskList.size() > index;
    }

    public static void getTaskList() {
        if (!taskList.isEmpty()) {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(taskList.get(i));
            }
        }
    }

    public int count() {
        return taskList.size();
    }

}
