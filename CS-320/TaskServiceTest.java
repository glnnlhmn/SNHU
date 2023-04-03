package snhu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskServiceTest {

	private TaskService taskService;
	private Task task;


	@Test
	void testAddTask() {
		taskService = new TaskService();
		task = new Task("taskid", "Task Name", "Description of task");
		assertTrue(taskService.addTask(task));
		task = new Task("taskid2", "Task Name 2", "Description of task 2");
		assertTrue(taskService.addTask(task));
	}

  	@Test
	void testAddDuplicateTask() {
  		taskService = new TaskService();
		try{
			task = new Task("taskid", "Task Name", "Description of task");
			taskService.addTask(task);
			taskService.addTask(task);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Duplicate ID".equals(e.getMessage()));
        }
    }

	@Test
	void testRemoveTaskById() {
		// Setup for test
		taskService = new TaskService();
		task = new Task("taskid1", "Task Name1", "Description of task1");
		taskService.addTask(task);
		task = new Task("taskid2", "Task Name2", "Description of task2");
		taskService.addTask(task);
		task = new Task("taskid3", "Task Name3", "Description of task3");
		taskService.addTask(task);	
		// remove by ID
		taskService.removeTaskById("taskid3");
		
		// now re-add will fail if is a duplicate
        assertTrue(taskService.addTask(task));
	}  	
	
	@Test
	void testSetTaskNameById() {
		taskService = new TaskService();
		task = new Task("taskid", "Task Name", "Description of task");
		taskService.addTask(task);
		assertTrue(taskService.setNameById("taskid", "Task Name Change"));
	}
	
	@Test
	void testSetLastNameDEscriptionById() {
		taskService = new TaskService();
		task = new Task("taskid", "Task Name", "Description of task");
		taskService.addTask(task);
		assertTrue(taskService.setDescriptionById("taskid", "Changed Description of task"));
	}
		
}