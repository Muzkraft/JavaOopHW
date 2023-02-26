package org.example.Core.MVP;

public interface View {
    int getId();
    void setId(int value);
    String getTask();
    void setTask(String value);
    String getStartDate();
    void setStartDate(String value);
    String getEndDate();
    void setEndDate(String value);
    boolean getIsDone();
    void setIsDone(boolean value);

}
