package tech.space_ant.todolistpro;

public class ToDoItem {

    private String task;

    public ToDoItem() {
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    @Override
    public String toString() {
        return task;
    }


}
