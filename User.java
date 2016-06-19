package sogeti.training.todo.model;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {
	
	private int id;
	
	private String type;   	//required field
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="TYPE")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
