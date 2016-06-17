package sogeti.training.todo.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TODO_ITEM")
public class ToDoItem {
	
	private int id;
	private String description;
	private Date startDate;
	private Date dueDate;
	private boolean active;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "DUE_DATE")
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date endDate) {
		this.dueDate = endDate;
	}
	
	@Column
	@Type(type = "yes_no")
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
