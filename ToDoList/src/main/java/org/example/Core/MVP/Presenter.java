package org.example.Core.MVP;

import org.example.Core.Infrastructure.ToDoList;
import org.example.Core.Models.Task;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        model.load();

        if (model.currentTaskList.count() > 0) {
            model.setCurrentIndex(0);
            Task task = model.currentTask();

            view.setId(task.id);
            view.setTask(task.taskValue);
            view.setStartDate(task.startDate);
            view.setEndDate(task.endDate);
            view.setIsDone(task.isDone);
        }
    }

    public void add() {
        model.currentTaskList().add(
                new Task(view.getId(), view.getTask(), view.getStartDate(), view.getEndDate(), false));
    }

    public void remove() {
        Task task = new Task(view.getId(), view.getTask(), view.getStartDate(), view.getEndDate(), true);
        model.currentTaskList.remove(task);

        if (model.currentTaskList.count() < 1) {
            model.setCurrentIndex(-1);

            view.setId(0);
            view.setTask("");
            view.setStartDate("");
            view.setEndDate("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);

            Task temp = (Task) model.currentTaskList;
            view.setId(temp.id);
            view.setTask(temp.taskValue);
            view.setEndDate(String.valueOf(temp.startDate));
            view.setEndDate(String.valueOf(temp.endDate));
        }
    }
    public void showTaskList() {
        ToDoList.getTaskList();
    }

    public void saveToFile() {
        model.save();
    }

    public void next() {
        if (model.currentTaskList.count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentTaskList().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                Task task = model.currentTask();
                view.setId(task.id);
                view.setTask(task.taskValue);
                view.setStartDate(task.startDate);
                view.setEndDate(task.endDate);
                view.setIsDone(task.isDone);
            }
        }
    }

    public void prev() {
        if (model.currentTaskList.count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Task task = model.currentTask();
                view.setId(task.id);
                view.setTask(task.taskValue);
                view.setStartDate(task.startDate);
                view.setEndDate(task.endDate);
                view.setIsDone(task.isDone);
            }
        }
    }
}
