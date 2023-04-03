package snhu;

import java.util.Date;

public class Appointment {

	private String ID;			// Length Max 10 
	private Date date;   		// Length Max 20 Date(year, month, date)
	private String description;	// Length Max 50


	private boolean validateDate(Date date) {
      	
      	Date now = new Date();
      
		if (date != null && date.after(now)) {
			return true;
		}
		else {
			throw new IllegalArgumentException("Invalid Date");
		}

	}
	
	private boolean validateInput(String item, int length) {
		
		if (item != null && item.length() <= length) {
			return true;
		}
		else {
			throw new IllegalArgumentException("Invalid Argument");
		}
	}
	
	public Appointment(String ID, Date date, String description) {
		
		// Validate input and assign to class internal variables
		
		if (validateInput(ID, 10)) {
			this.ID = ID;
		}
		if (validateDate(date)) {
			this.date = date;
		}
		
		if (validateInput(description,50)) {
			this.description = description;
		}

	}
	
	// getters and setters 
	// ID is read only no setter
	
	public String getID() {
		return this.ID;
	}
	
	public Date getDate() {
		return this.date;	
	}
	
	public void setDate(Date date) {
		// Validate input
		if (validateDate(date)) {
			this.date = date;
		}
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		// Validate input
		if (validateInput(description,50)) {
			this.description = description;
		}
	}
}
