package sogeti.training.todo.model;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {
	
	private int id;
	
	private String firstName;   	//required field
	private String lastName;		//required field
	private char middleInitial; 		//required field
	private String primPhoneNumber;	//required field
	private String streetAddress;	//required field
	private String homeCity;		//required field
	private String state;			//required field
	private String postalCode;		//required field
	private String country;			//required field
	private String primEmail;		//required field
	private String companyName;		//required field
	
	
	private String secPhoneNumber; 	//optional field
	private String faxNumber;		//optional field
	private String secEmail;		//optional field
	private String officeCity;		//optional field
	private String additionalInfo;	//optional field
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="MIDDLE_INITIAL")
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	@Column(name="PRIMARY_PHONE_NUMBER")
	public String getPrimaryPhoneNumber() {
		return primPhoneNumber;
	}
	public void setPrimaryPhoneNumber(String primPhoneNumber) {
		this.primPhoneNumber = primPhoneNumber;
	}
	
	@Column(name="STREET_ADDRESS")
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress ) {
		this.streetAddress = streetAddress ;
	}
	
	@Column(name="HOME_CITY")
	public String getHomeCity() {
		return homeCity;
	}
	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}
	
	@Column(name="STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="POSTAL_CODE")
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Column(name="COUNTRY")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country ;
	}
	
	@Column(name="PRIMARY_EMAIL")
	public String getPrimaryEmail() {
		return primEmail;
	}
	public void setPrimaryEmail(String primEmail) {
		this.primEmail = primEmail;
	}
	
	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="SECONDARY_PHONE_NUMBER")
	public String getSecondaryPhoneNumber() {
		return secPhoneNumber;
	}
	public void setSecondaryPhoneNumber(String secPhoneNumber) {
		this.secPhoneNumber = secPhoneNumber ;
	}

	@Column(name="FAX_NUMBER")
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	@Column(name="SECONDARY_EMAIL")
	public String getSecondaeyEmail() {
		return secEmail;
	}
	public void setSecondaryEmail(String secEmail) {
		this.secEmail = secEmail;
	}

	@Column(name="OFFICE_CITY")
	public String getOfficeCity() {
		return officeCity;
	}
	public void setOfficeCity(String officeCity) {
		this.officeCity = officeCity;
	}

	@Column(name="ADDITIONAL_INFO")
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
