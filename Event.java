package sogeti.training.todo.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EVENT")
public class Event {
	
	private int id;
	private String title;
	private Date startDate;
	private Date endDate;
	private int category_ID; 
	private int type_ID; 
	private String description; 
	private int owner_ID; 
	private String logo_Path; 
	private String location; 
	private String status; 
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Column(name = "CATEGORY_ID")
	public int getCategory_ID() {
		return category_ID;
	}
	public void setCategory_ID(int category_ID) {
		this.category_ID = category_ID;
	}
	
	@Column(name = "TYPE_ID")
	public int getType_ID() {
		return type_ID;
	}
	public void setType_ID(int type_ID) {
		this.type_ID = type_ID;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "OWNER_ID")
	public int getOwner_ID() {
		return owner_ID;
	}
	public void setOwner_ID(int owner_ID) {
		this.owner_ID = owner_ID;
	}
	
	@Column(name = "LOGO_PATH")
	public String getLogo_Path() {
		return logo_Path;
	}
	public void setLogo_Path(String logo_Path) {
		this.logo_Path = logo_Path;
	}
	
	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		
	}
	
}
