package example.todolist;

public class Task {

    private String person;
    private String task;

    public Task(String person, String task) {
        this.person = person;
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public String getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return person+"-->"+task;
    }

}
