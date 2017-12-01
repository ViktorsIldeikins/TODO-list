package example.todolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("list")
public class MyController {

	private final TaskList list;

	@Autowired
	public MyController(TaskList list) {
		this.list = list;
	}

	@RequestMapping("/")
	public String init() {
		list.getList().add(new Task("Jimmy", "has to delete this test task", 3));
		list.getList().add(new Task("JimmyLongName", "check that table works", 5));
		return "redirect:/test";
	}

	@RequestMapping("/test")
	public String testJsp(ModelMap model) {
		model.addAttribute("list", list);
		list.getList().forEach(t-> System.out.println(t.toString()));
		return "mainList";
	}

	@RequestMapping(value = "/removeTask", method = RequestMethod.POST)
	@ResponseBody
	public String remove(@RequestParam("person") String person, @RequestParam("task") String task) {
		System.out.println("removing-->" + person + " " + task);
		list.removeTask(person, task);
		return "success";
	}


	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	@ResponseBody
	public String addTask(@RequestParam("person") String person, @RequestParam("task") String task,
						  @RequestParam(value = "coffee", required = false, defaultValue = "0") int amountOfCoffeeCups) {
		list.addTask(person, task, amountOfCoffeeCups);
		return "success";
	}


}
