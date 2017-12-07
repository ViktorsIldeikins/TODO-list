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

	@Insert("insert into tasks(person,task,amountOfCoffeeCups) values(#{person},#{task},#{amountOfCoffeeCups})")
	@SelectKey(statement = "Select Last_Insert_id()", keyProperty ="id", before = false, resultType = Integer.class)
	void insert(Task task);

	@Update("update tasks set usedCoffeeCups=#{usedCoffeeCups} where (person=#{person})and(task=#{task})")
	void update(Task task);

	@Delete("Delete from tasks where (person=#{person})and(task=#{task})")
	void remove(Task task);

	@Insert("CREATE TABLE IF Not EXISTS Tasks\n" +
			"(\n" +
			"    person varchar[100] NOT NULL,\n" +
			"    task VARCHAR [100] NOT NULL,\n" +
			"    amountOfCoffeeCups int DEFAULT 0,\n" +
			"    usedCoffeeCups int DEFAULT 0\n" +
			");")
	void createTable();

}
