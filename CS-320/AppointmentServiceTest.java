package snhu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	private AppointmentService appointmentService;
	
	private String validId;
	private String validId2;
	private String validDescription;
	private String validDescription2;
	private Date futureDate;
	private Date futureDate2;


	
	@SuppressWarnings("deprecation")
	public AppointmentServiceTest() {
		this.validId = "testid";
		this.validId2 = "testid2";
		this.validDescription = "This is a valid discription";
		this.validDescription2 = "This is a valid discription also";
		this.futureDate = new Date(124, 1,15);
		this.futureDate2 = new Date(123, 11,15);

		
	}

	@Test
	void testAddAppointment() {
		appointmentService = new AppointmentService();
		Appointment appointment1;
		Appointment appointment2;
		appointment1 = new Appointment(this.validId, this.futureDate, this.validDescription);
		appointment2 = new Appointment(this.validId2, this.futureDate2, this.validDescription2);
		assertTrue(appointmentService.addAppointment(appointment1));
		assertTrue(appointmentService.addAppointment(appointment2));
	}


	@Test
	void testRemoveContactById() {
		// Setup for test
		appointmentService = new AppointmentService();
		Appointment appointment1;
		Appointment appointment2;
		appointment1 = new Appointment(this.validId, this.futureDate, this.validDescription);
		appointment2 = new Appointment(this.validId2, this.futureDate2, this.validDescription2);
		appointmentService.addAppointment(appointment1);
		appointmentService.addAppointment(appointment2);
		// remove by ID
		appointmentService.removeAppointmentById(this.validId);
		
		// now re-add will fail if is a duplicate
        assertTrue(appointmentService.addAppointment(appointment1));
	}  

}
