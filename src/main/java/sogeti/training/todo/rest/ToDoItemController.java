package sogeti.training.todo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sogeti.training.todo.model.ToDoItem;
import sogeti.training.todo.model.ToDoList;
import sogeti.training.todo.service.ToDoItemService;
import sogeti.training.todo.service.ToDoListService;

@RestController()
@RequestMapping("/todoitem")
public class ToDoItemController {

	private ToDoItemService toDoItemService;
	private ToDoListService toDoListService;

	@Autowired
	public ToDoItemController(ToDoItemService toDoItemService, ToDoListService toDoListService) {
		this.toDoItemService = toDoItemService;
		this.toDoListService = toDoListService;
	}

	@RequestMapping(value = "complete/{id}", method = RequestMethod.PUT)
	public void shareList(@PathVariable("id") int id) {
		try {
			ToDoItem item = toDoItemService.getToDoItem(id);
			item.setActive(false);
			toDoItemService.saveOrUpdate(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "{listId}", consumes = "application/json", method = RequestMethod.POST)
	public void createToDoItem(@PathVariable("listId") int listId, ToDoItem item) {
		try {
			toDoListService.save(item);
			
			ToDoListService toDoListService = new ToDoListService();
			ToDoList list = toDoListService.getList(listId);
			list.getTodoItems().add(item);
			toDoListService.saveOrUpdate(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteList(@PathVariable("id") int id) {
		try {
			ToDoItemService toDoItemService = new ToDoItemService();
			toDoItemService.deleteToDoItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
