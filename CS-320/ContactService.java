package snhu;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

	private Map<String, Contact> contactMap;
		
		public ContactService() {
			contactMap = new HashMap<String, Contact>();
		}
		
		public boolean addContact(Contact contact) {
			boolean isSuccess = false;

			if(!contactMap.containsKey(contact.getID())){ 

				contactMap.put(contact.getID(), contact); 
				isSuccess = true; 

			}

			else {
				throw new IllegalArgumentException("Duplicate ID");
				// ID already exists, so cannot add 
			}

			return isSuccess;
		}
			

		public void removeContactById(String id) {
			contactMap.remove(id);
		}
		
		public boolean setFirstNameById(String id, String name) {
			if (contactMap.containsKey(id)){
				Contact contact = contactMap.get(id);
		        contact.setFirstName(name);
		        return true; // Name updated successfully
		    }
		    return false; // Employee with given ID not found
		}
		
		public boolean setLastNameById(String id, String name) {
			if (contactMap.containsKey(id)){
				Contact contact = contactMap.get(id);		        	
				contact.setLastName(name);
	            return true; // Name updated successfully
		    }
		    return false; // Employee with given ID not found
		}
		
		public boolean setPhoneById(String id, String phone) {
			if (contactMap.containsKey(id)){
				Contact contact = contactMap.get(id);
				contact.setPhone(phone);
		        return true; // Name updated successfully
		        }
		    return false; // Employee with given ID not found
		}

		public boolean setAddressById(String id, String address) {
			if (contactMap.containsKey(id)){
				Contact contact = contactMap.get(id);
				contact.setAddress(address);
		        return true; // Name updated successfully
		        }
		    return false; // Employee with given ID not found
		}
		
}

