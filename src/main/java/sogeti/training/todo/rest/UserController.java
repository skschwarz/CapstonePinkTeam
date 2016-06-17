package sogeti.training.todo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sogeti.training.todo.model.User;
import sogeti.training.todo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public List<User> getUsers() {
		try {
			return userService.getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int id) {
		try {
			return userService.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST)
	public void createUser(User user) {
		userService.save(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
