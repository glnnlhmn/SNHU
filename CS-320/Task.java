package snhu;


public class Task {

	private String ID;			// Length Max 10 
	private String name;   		// Length Max 20
	private String description;	// Length Max 50


	private boolean validateInput(String item, int length) {
		
		if (item != null && item.length() <= length) {
			return true;
		}
		else {
			throw new IllegalArgumentException("Invalid Argument");
		}
	}
	
	public Task(String ID, String name, String description) {
		
		// Validate input and assign to class internal variables
		
		if (validateInput(ID, 10)) {
			this.ID = ID;
		}
		if (validateInput(name, 20)) {
			this.name = name;
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
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		// Validate input
		if (validateInput(name, 20)) {
			this.name = name;
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
