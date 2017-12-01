package example.todolist;

import example.todolist.Mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TaskList {

	private TaskMapper taskMapper;

	@Autowired
	public TaskList(TaskMapper taskMapper){
		this.taskMapper=taskMapper;
	}

	private List<Task> list;

	public TaskList() {
		list = new ArrayList<>();
	}

	public TaskList(List<Task> list) {
		this.list = list;
	}

	public List<Task> getList() {
//		return list;
		return taskMapper.getAll();
	}

	public void removeTask(String person, String task) {
//		list.removeIf(t -> (t.getPerson().equals(person)) && (t.getTask().equals(task)));
		taskMapper.remove(new Task(person,task,0));
	}

	public void addTask(String person, String task, int amountOfCoffeeCups) {
//		list.add(new Task(person, task, amountOfCoffeeCups));
		taskMapper.insert(new Task(person,task,amountOfCoffeeCups));
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


}
