package example.todolist;

import example.todolist.Mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TaskRepository {

	private TaskMapper taskMapper;

	@Autowired
	public TaskRepository(TaskMapper taskMapper){
		this.taskMapper=taskMapper;
		//TODO initialize table
	}

	public void newTable(){
		taskMapper.createTable();
	}

	public List<Task> getList() {
		return taskMapper.getAll();
	}

	public void removeTask(String person, String task) {
		taskMapper.remove(new Task(person,task,0));
	}

	public void addTask(String person, String task, int amountOfCoffeeCups) {
		taskMapper.insert(new Task(person,task,amountOfCoffeeCups));
	}

	@Override
	public String toString() {
		return "is this toString?";
	}

}
