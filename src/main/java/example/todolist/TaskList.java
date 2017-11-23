package example.todolist;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskList {

    private List<Task> list;

    public TaskList(){
        list=new ArrayList<>();
    }

    public TaskList(List<Task> list) {
        this.list = list;
    }

    public List<Task> getList() {
        return list;
    }

    public void setList(List<Task> list) {
        this.list = list;
    }

    public void removeTask(String person, String task) {
        list.removeIf(t -> (t.getPerson().equals(person))&&(t.getTask().equals(task)));
    }


    @Override
    public String toString() {
        return "is this toString?";
    }


    public void addTask(String person, String task) {
        list.add(new Task(person,task));
    }
}
