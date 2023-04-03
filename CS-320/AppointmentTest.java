package snhu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {

	private Appointment appointment;
	private String validId;
	private String longId;
	private String validDescription;
	private String validDescription2;
	private String longDescription;
	private Date futureDate;
	private Date futureDate2;
	private Date pastDate;

	@SuppressWarnings("deprecation")
	public AppointmentTest() {
		this.validId = "testid";
		this.longId = "testlongid1";
		this.validDescription = "This is a valid discription";
		this.validDescription2 = "This is a valid discription also";
		this.longDescription = "01234567890123456789012345678901234567890123456789Y";
		this.futureDate = new Date(124, 1,15);
		this.futureDate2 = new Date(123, 11,15);
		this.pastDate = new Date(121, 11,15);
	}

	@Test
	void testNewAppointment() {
		appointment = new Appointment(this.validId, this.futureDate, this.validDescription);
		assertTrue(this.validId.equals(appointment.getID())); 
		assertTrue(this.futureDate.compareTo(appointment.getDate())==0); 
		assertTrue(this.validDescription.equals(appointment.getDescription())); 
	}

	@Test
	void testNewAppointmentIdLong() {
		try{
			appointment = new Appointment(this.longId, this.futureDate, this.validDescription); 
			fail("Should throw an Exception");
		}
		catch(IllegalArgumentException e){
			//Good
			assertTrue("Invalid Argument".equals(e.getMessage()));
		}
	}

	@Test
	void testNewAppointmentBadDatePast() {
		try{
			appointment = new Appointment(this.validId, this.pastDate, this.validDescription);  
			fail("Should throw an Exception");
		}
		catch(IllegalArgumentException e){
			//Good
			assertTrue("Invalid Date".equals(e.getMessage()));
		}
	}

	@Test
	void testNewAppointmentDescriptionLong() {
		try{
			appointment = new Appointment(this.validId, this.futureDate, this.longDescription);  
			fail("Should throw an Exception");
		}
		catch(IllegalArgumentException e){
			//Good
			assertTrue("Invalid Argument".equals(e.getMessage()));
		}
	}


	@Test
	void testSetDate() {

		appointment = new Appointment(this.validId, this.futureDate, this.validDescription);
		appointment.setDate(this.futureDate2);
		assertTrue(this.futureDate2.compareTo(appointment.getDate())==0);

	}

	@Test
	void testSetDatePast() {

		appointment = new Appointment(this.validId, this.futureDate, this.validDescription);

		try {
			appointment.setDate(this.pastDate);
			fail("Should throw an Exception");
		}
		catch(IllegalArgumentException e){
			//Good
			assertTrue("Invalid Date".equals(e.getMessage()));

		}
	}

	@Test
	void testSetDateNull() {

		appointment = new Appointment(this.validId, this.futureDate, this.validDescription);

		try {
			appointment.setDate(null);
			fail("Should throw an Exception");
		}
		catch(IllegalArgumentException e){
			//Good
			assertTrue("Invalid Date".equals(e.getMessage()));

		}
	}

	@Test
	void testSetDescription() {

		appointment = new Appointment(this.validId, this.futureDate, this.validDescription);
		appointment.setDescription(this.validDescription2);
		assertTrue(this.validDescription2.equals(appointment.getDescription())); 

	}
	
	@Test
	void testSetDescriptionLong() {

		appointment = new Appointment(this.validId, this.futureDate, this.validDescription);

		try{
			appointment.setDescription(this.longDescription);
			fail("Should throw an Exception");
		}
		catch(IllegalArgumentException e){
			//Good
			assertTrue("Invalid Argument".equals(e.getMessage()));
		}
	}

	@Test
	void testSetDescriptionNull() {

		appointment = new Appointment(this.validId, this.futureDate, this.validDescription);

		try{
			appointment.setDescription(null);
			fail("Should throw an Exception");
		}
		catch(IllegalArgumentException e){
			//Good
			assertTrue("Invalid Argument".equals(e.getMessage()));
		}
	}


	//
	//  	@Test
	//	void testSetLastNameNull() {
	//		try{
	//        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
	//        	contact.setLastName(null);
	//          	fail("Should throw an Exception");
	//        }
	//      	catch(IllegalArgumentException e){
	//          //Good
	//           assertTrue("Invalid Last Name".equals(e.getMessage()));
	//        }
	//    }
	//  	
	//  	@Test
	//	void testSetPhoneLong() {
	//		try{
	//        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
	//        	contact.setPhone("12345678901");
	//          	fail("Should throw an Exception");
	//        }
	//      	catch(IllegalArgumentException e){
	//          //Good
	//           assertTrue("Invalid Phone Number".equals(e.getMessage()));
	//        }
	//    }
	//  	
	//  	@Test
	//	void testSetPhoneShort() {
	//		try{
	//        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
	//        	contact.setPhone("123456789");
	//          	fail("Should throw an Exception");
	//        }
	//      	catch(IllegalArgumentException e){
	//          //Good
	//           assertTrue("Invalid Phone Number".equals(e.getMessage()));
	//        }
	//    }
	//  	
	//  	@Test
	//	void testSetPhoneChar() {
	//		try{
	//        	contact = new Contact("testid", "Fred", "Smith", "1234a67890", "123 Main St");
	//        	contact.setPhone("12345678901");
	//          	fail("Should throw an Exception");
	//        }
	//      	catch(IllegalArgumentException e){
	//          //Good
	//           assertTrue("Invalid Phone Number".equals(e.getMessage()));
	//        }
	//    }
	//
	//  	@Test
	//	void testSetPhoneNull() {
	//		try{
	//        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
	//        	contact.setPhone(null);
	//          	fail("Should throw an Exception");
	//        }
	//      	catch(IllegalArgumentException e){
	//          //Good
	//           assertTrue("Invalid Phone Number".equals(e.getMessage()));
	//        }
	//    }
	//
	//  	@Test
	//	void testSetAddressLong() {
	//		try{
	//        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
	//        	contact.setAddress("123 Main St 123 Main St123 Main St");
	//          	fail("Should throw an Exception");
	//        }
	//      	catch(IllegalArgumentException e){
	//          //Good
	//           assertTrue("Invalid Address".equals(e.getMessage()));
	//        }
	//    }
	//
	//  	@Test
	//	void testSetPhoneAddressNull() {
	//		try{
	//        	contact = new Contact("testid", "Fred", "Smith", "1234567890", "123 Main St");
	//        	contact.setAddress(null);
	//          	fail("Should throw an Exception");
	//        }
	//      	catch(IllegalArgumentException e){
	//          //Good
	//           assertTrue("Invalid Address".equals(e.getMessage()));
	//        }
	//    }
}
