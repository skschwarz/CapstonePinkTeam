package sogeti.training.todo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="LIST")
public class ToDoList {
	
	private int id;
	private String name;
	
	private Set<ToDoItem> todoItems;
	
	private Set<User> users;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="LIST_ITEMS",
	joinColumns= @JoinColumn(name="LIST_ID"),
	inverseJoinColumns= @JoinColumn(name="ITEM_ID"))
	public Set<ToDoItem> getTodoItems() {
		return todoItems;
	}
	public void setTodoItems(Set<ToDoItem> todoItems) {
		this.todoItems = todoItems;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="LIST_ACCESS",
			joinColumns= @JoinColumn(name="LIST_ID"),
			inverseJoinColumns= @JoinColumn(name="USER_ID"))
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
