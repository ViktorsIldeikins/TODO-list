package example.todolist;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TaskList {

    private List<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public TaskList(List<Task> list) {
        this.list = list;
    }

    public List<Task> getList() {
        return list;
    }

    public void removeTask(String person, String task) {
        list.removeIf(t -> (t.getPerson().equals(person)) && (t.getTask().equals(task)));
    }


    @Override
    public String toString() {
        return "is this toString?";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(list, taskList.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    public void addTask(String person, String task, int amountOfCoffeeCups) {
        list.add(new Task(person, task, amountOfCoffeeCups));
    }
}
