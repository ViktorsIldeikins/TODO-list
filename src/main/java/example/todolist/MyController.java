package example.todolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {

    @Autowired
    private TaskList list;

    @RequestMapping("")
    public String init() {
        list.getList().add(new Task("Jimmy", "has to delete this test task"));
        list.getList().add(new Task("JimmyLongName", "check that table works"));
        return "redirect:/test";
    }

    @RequestMapping("/test")
    public String testJsp(ModelMap model) {
        model.addAttribute("list", list);
        return "mainList";
    }

    @RequestMapping(value = "/removeTask", method = RequestMethod.POST)
    public String removeTask(@RequestParam("person") String person, @RequestParam("task") String task) {
        list.removeTask(person, task);
        return "redirect:/test";
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addTask(@RequestParam("person") String person, @RequestParam("task") String task) {
        list.addTask(person, task);
        return "redirect:/test";
    }

}
