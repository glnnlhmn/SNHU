package snhu;

import java.util.HashMap;
import java.util.Map;


public class AppointmentService {
	
	private Map<String, Appointment> appointmentMap;
	
	public AppointmentService() {
		appointmentMap = new HashMap<String, Appointment>();
	}
	
	public boolean addAppointment(Appointment appointment) {
		boolean isSuccess = false;

		if(!appointmentMap.containsKey(appointment.getID())){ 

			appointmentMap.put(appointment.getID(), appointment); 
			isSuccess = true; 

		}

		else {
			throw new IllegalArgumentException("Duplicate ID");
			// ID already exists, so cannot add 
		}

		return isSuccess;
	}
		

	public void removeAppointmentById(String id) {
		appointmentMap.remove(id);
	}
}
