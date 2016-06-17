package sogeti.training.todo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sogeti.training.todo.model.ToDoList;
import sogeti.training.todo.model.User;
import sogeti.training.todo.service.ToDoItemService;
import sogeti.training.todo.service.ToDoListService;
import sogeti.training.todo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("todolist")
public class ToDoListController {
	private UserService userService;
	private ToDoListService toDoListService;

	@Autowired
	public ToDoListController(UserService userService, ToDoListService toDoListService) {
		this.userService = userService;
		this.toDoListService = toDoListService;
	}

	@RequestMapping(value = "/user/{id}", produces = "application/json", method = RequestMethod.GET)
	public List<ToDoList> getListsForUser(@PathVariable("id") int id) {
		try {
			return toDoListService.getListsForUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
	public ToDoList getList(@PathVariable("id") int id) {
		try {
			return toDoListService.getList(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "share/{listId}/{userId}", method = RequestMethod.PUT)
	public void shareList(@PathVariable("listId") int listId,
			@PathVariable("userId") int userId) {
		try {
			User user = userService.getUser(userId);
			
			ToDoList list = toDoListService.getList(listId);
			
			list.getUsers().add(user);
			toDoListService.saveOrUpdate(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "{userId}", consumes = "application/json", method = RequestMethod.POST)
	public void createList(@PathVariable("userId") int userId, String name) {
		try {
			User user = userService.getUser(userId);
			if(user != null) {
				ToDoList list = new ToDoList();
				list.setName(name);
				
				Set<User> users = new HashSet<>();
				users.add(user);
				list.setUsers(users);
				
				toDoListService.save(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteList(@PathVariable("id") int id) {
		try {
			toDoListService.deleteList(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
