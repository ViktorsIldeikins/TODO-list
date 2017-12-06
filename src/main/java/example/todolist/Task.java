package example.todolist;

import java.util.Objects;

public class Task {

	private int id;
	private String person;
	private String task;
	private int amountOfCoffeeCups;
	private int usedCoffeeCups;

	public Task() {
	}

	public Task(String person, String task, int amountOfCoffeeCups, int usedCoffeeCups) {
		this.person = person;
		this.task = task;
		this.amountOfCoffeeCups = amountOfCoffeeCups;
		this.usedCoffeeCups = usedCoffeeCups;
	}

	public int getUsedCoffeeCups() {
		return usedCoffeeCups;
	}

	public void setUsedCoffeeCups(int usedCoffeeCups) {
		this.usedCoffeeCups = usedCoffeeCups;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Task{" +
				"id=" + id +
				", person='" + person + '\'' +
				", task='" + task + '\'' +
				", amountOfCoffeeCups=" + amountOfCoffeeCups +
				", usedCoffeeCups=" + usedCoffeeCups +
				'}';
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
