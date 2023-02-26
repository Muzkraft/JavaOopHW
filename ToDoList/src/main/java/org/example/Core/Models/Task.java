package org.example.Core.Models;

import org.example.Core.Infrastructure.ToDoList;

import java.util.Objects;

public class Task extends ToDoList {
    public int id;
    public String taskValue;
    public String startDate;
    public String endDate;
    public boolean isDone;
    public Task(int id, String taskValue, String startDate, String endDate, Boolean isDone) {
        this.id = id;
        this.taskValue = taskValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isDone = isDone;

    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", task='" + taskValue + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", done=" + isDone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return startDate.equals(task.startDate) && endDate.equals(task.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}
