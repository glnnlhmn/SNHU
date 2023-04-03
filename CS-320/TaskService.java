package snhu;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	// private ArrayList<Task> taskList;

	private Map<String, Task> taskMap;

	public TaskService() {
		taskMap = new HashMap<String, Task>();
	}

	public boolean addTask(Task task) {
		boolean isSuccess = false;

		if(!taskMap.containsKey(task.getID())){ 

			taskMap.put(task.getID(), task); 
			isSuccess = true; 

		}

		else {
			throw new IllegalArgumentException("Duplicate ID");
			// ID already exists, so cannot add 
		}

		return isSuccess;
	}



	public void removeTaskById(String id) {
		taskMap.remove(id);

	}

	public boolean setNameById(String id, String name) {

		if (taskMap.containsKey(id)) {
			Task task = taskMap.get(id);
			task.setName(name);
			return true; // Task name updated successfully
		}

		return false; // Task with given ID not found
	}


	public boolean setDescriptionById(String id, String description) {
		if (taskMap.containsKey(id)) {
			Task task = taskMap.get(id);
			task.setDescription(description);
			return true; // Description updated successfully
		}
		return false; // Description with given ID not found
	}

}