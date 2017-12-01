package example.todolist;

import java.util.Objects;

public class Task {

    private String person;
    private String task;
    private int amountOfCoffeeCups;

    public Task(String person, String task, int amountOfCoffeeCups) {
        this.person = person;
        this.task = task;
        this.amountOfCoffeeCups=amountOfCoffeeCups;
    }

    public int getAmountOfCoffeeCups() {
        return amountOfCoffeeCups;
    }

    public void setAmountOfCoffeeCups(int amountOfCoffeeCups) {
        this.amountOfCoffeeCups = amountOfCoffeeCups;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return Objects.equals(person, task1.person) &&
                Objects.equals(task, task1.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, task);
    }
}
