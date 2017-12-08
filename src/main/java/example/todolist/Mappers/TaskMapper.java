package example.todolist.Mappers;


import example.todolist.Task;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface TaskMapper {

	@Select("select * from tasks")
	List<Task> getAll();

	@Insert("insert into tasks(person,task,priority,amountOfCoffeeCups) values(#{person},#{task},#{priority},#{amountOfCoffeeCups})")
	void insert(Task task);

	@Update("update tasks set usedCoffeeCups=#{usedCoffeeCups} where (person=#{person})and(task=#{task})")
	void update(Task task);

	@Delete("Delete from tasks where (person=#{person})and(task=#{task})")
	void remove(Task task);

	@Insert("CREATE TABLE IF Not EXISTS Tasks\n" +
			"(\n" +
			"    person varchar  NOT NULL,\n" +
			"    task VARCHAR  NOT NULL,\n" +
			"    priority VARCHAR  NOT NULL,\n" +
			"    amountOfCoffeeCups int DEFAULT 0,\n" +
			"    usedCoffeeCups int DEFAULT 0\n" +
			");")
	void createTable();

}
