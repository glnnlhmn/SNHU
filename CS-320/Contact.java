package snhu;

//Java program to check phone 
//is valid as per E123 
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class Contact {
	
	private String ID;			// Length Max 10 
	private String firstName;   // Length Max 10
	private String lastName;	// Length Max 10
	private String phone;		// Length Exact 10
	private String address;		// Length Max 30
	
	private boolean TenDigits(String s) {
		if (s == null || s.length()!= 10) {
			return false;
		}
		String regex = "^\\d{10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		return matcher.matches(); // returns true if pattern matches, else returns false
	}
	
	public Contact(String ID, String firstName, String lastName, String phone, String address) {
		
		// Validate input
		if (ID == null || ID.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if (!TenDigits(phone)) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
				
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		// Assign to class internal variables
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// getters and setters 
	// ID is read only no setter
	
	public String getID() {
		return this.ID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		// Validate input
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		// Validate input
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		// Validate input
		if (!TenDigits(phone)) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phone = phone;
	}	
	
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		// Validate input
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
	
}
