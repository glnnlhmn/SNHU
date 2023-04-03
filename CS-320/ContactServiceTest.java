package snhu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
 * Need to add testing and code to deal with Null ID on all setById
 * 
 * 
 */

class ContactServiceTest {
	
	private ContactService contactService;
	private Contact contact;


	@Test
	void testAddContact() {
		contactService = new ContactService();
		contact = new Contact("testid1", "Fred", "Smith", "1234567890", "123 Main St");
		assertTrue(contactService.addContact(contact));
		contact = new Contact("testid2", "Betty", "Davis", "6789012345", "46 South St");
		assertTrue(contactService.addContact(contact));
	}

  	@Test
	void testAddDuplicateContact() {
  		contactService = new ContactService();
		try{
			contact = new Contact("testid9", "Fred", "Smith", "1234567890", "123 Main St");
			contactService.addContact(contact);
			contactService.addContact(contact);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Duplicate ID".equals(e.getMessage()));
        }
    }

	@Test
	void testRemoveContactById() {
		// Setup for test
		contactService = new ContactService();
		contact = new Contact("testid1", "Fred", "Smith", "1234567890", "123 Main St");
		contactService.addContact(contact);
		contact = new Contact("testid2", "Betty", "Davis", "6789012345", "46 South St");
		contactService.addContact(contact);
		contact = new Contact("testid3", "Brenda", "French", "9012678345", "99 North St");
		contactService.addContact(contact);	
		// remove by ID
		contactService.removeContactById("testid3");
		
		// now re-add will fail if is a duplicate
        assertTrue(contactService.addContact(contact));
	}  	
	
	@Test
	void testSetFirstNameById() {
		contactService = new ContactService();
		contact = new Contact("testid1", "Fred", "Smith", "1234567890", "123 Main St");
		contactService.addContact(contact);
		assertTrue(contactService.setFirstNameById("testid1", "Frank"));
	}
	
	@Test
	void testSetLastNameById() {
		contactService = new ContactService();
		contact = new Contact("testid1", "Fred", "Smith", "1234567890", "123 Main St");
		contactService.addContact(contact);
		assertTrue(contactService.setLastNameById("testid1", "Jones"));
	}
		
	@Test
	void testSetPhoneById() {
		contactService = new ContactService();
		contact = new Contact("testid1", "Fred", "Smith", "1234567890", "123 Main St");
		contactService.addContact(contact);
		assertTrue(contactService.setPhoneById("testid1", "0987654321"));
	}
	
	@Test
	void testSetAddressById() {
		contactService = new ContactService();
		contact = new Contact("testid1", "Fred", "Smith", "1234567890", "123 Main St");
		contactService.addContact(contact);
		assertTrue(contactService.setAddressById("testid1", "92 Green St"));
	}
	
}