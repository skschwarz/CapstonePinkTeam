package sogeti.training.todo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CATEGORY")
public class Category {
	
	private int id;
	private String category;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
