package snhu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.*;

class ContactTest {
	
	private Contact contact;
    
	@Test
	void testNewContact() {
		
		contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
		assertTrue("testid".equals(contact.getID())); 
		assertTrue("Fred".equals(contact.getFirstName())); 
		assertTrue("Smith".equals(contact.getLastName())); 
		assertTrue("1234567890".equals(contact.getPhone()));
		assertTrue("123 Main St".equals(contact.getAddress()));
	}
	
  	@Test
	void testNewContactIdLong() {
		try{
        	contact = new Contact("testlongid1", "Fred", "Smith", "12345678901", "123 Main St");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid ID".equals(e.getMessage()));
        }
    }

  	@Test
	void testNewContactFirstNameLong() {
		try{
        	contact = new Contact("testid", "Fredtoolong", "Smith", "12345678901", "123 Main St");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid First Name".equals(e.getMessage()));
        }
    }
	
  	@Test
	void testNewContactLastNameLong() {
		try{
        	contact = new Contact("testid", "Fred", "Smithislong", "12345678901", "123 Main St");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Last Name".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testNewContactPhoneLong() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "12345678901", "123 Main St");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Phone Number".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testNewContactPhoneChar() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "123456789a", "123 Main St");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Phone Number".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testNewContactPhoneShort() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "123456789", "123 Main St");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Phone Number".equals(e.getMessage()));
        }
    }

  	@Test
	void testNewContactAddressLimit() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "1234567890123456789012345678901");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Address".equals(e.getMessage()));
        }
    }
 
	@Test
	void testSetFirstName() {
		
		contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
		contact.setFirstName("Mark");
		assertTrue("Mark".equals(contact.getFirstName())); 

	}

  	@Test
	void testSetFirstNameLong() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setFirstName("Marktoolong");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid First Name".equals(e.getMessage()));
        }
    }

  	@Test
	void testSetFirstNameNull() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setFirstName(null);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid First Name".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testSetLastNameLong() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setLastName("Smithislong");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Last Name".equals(e.getMessage()));
        }
    }

  	@Test
	void testSetLastNameNull() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setLastName(null);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Last Name".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testSetPhoneLong() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setPhone("12345678901");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Phone Number".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testSetPhoneShort() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setPhone("123456789");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Phone Number".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testSetPhoneChar() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234a67890", "123 Main St");
        	contact.setPhone("12345678901");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Phone Number".equals(e.getMessage()));
        }
    }

  	@Test
	void testSetPhoneNull() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setPhone(null);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Phone Number".equals(e.getMessage()));
        }
    }

  	@Test
	void testSetAddressLong() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setAddress("123 Main St 123 Main St123 Main St");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Address".equals(e.getMessage()));
        }
    }

  	@Test
	void testSetPhoneAddressNull() {
		try{
        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
        	contact.setAddress(null);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Address".equals(e.getMessage()));
        }
    }
}
