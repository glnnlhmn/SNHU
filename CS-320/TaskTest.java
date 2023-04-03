package snhu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	private Task task;
    
	@Test
	void testNewTask() {
		
		task = new Task("taskid", "Task Name", "Description of task");
		assertTrue("taskid".equals(task.getID())); 
		assertTrue("Task Name".equals(task.getName())); 
		assertTrue("Description of task".equals(task.getDescription())); 

	}
	
  	@Test
	void testNewTaskIdLong() {
		try{
        	task = new Task("tasklongid1", "Task Name", "Description of task");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Argument".equals(e.getMessage()));
        }
    }

  	@Test
	void testNewTaskNameLong() {
		try{
        	task = new Task("taskid", "Task Name is very very long", "Description of task");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Argument".equals(e.getMessage()));
        }
    }
	
  	@Test
	void testNewTaskNameDescriptionLong() {
		try{
        	task = new Task("taskid", "Task Name is very very long", "012345678901234567890123456789012345678901234567891");  
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Argument".equals(e.getMessage()));
        }
    }
  	
	@Test
	void testSetName() {
		
		task = new Task("taskid", "Task Name", "Description of task");
		task.setName("Mark");
		assertTrue("Mark".equals(task.getName())); 

	}

  	@Test
	void testSetNameLong() {
		try{
        	task = new Task("taskid", "Task Name is very very long", "Description of task");
        	task.setName("Marktoolong");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Argument".equals(e.getMessage()));
        }
    }

  	@Test
	void testSetNameNull() {
		try{
        	task = new Task("taskid", "Task Name", "Description of task");
        	task.setName(null);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Argument".equals(e.getMessage()));
        }
    }
  	
  	@Test
	void testSetDescription() {

    	task = new Task("taskid", "Task Name", "Description of task");
    	task.setDescription("new Description of task");
    	assertTrue("new Description of task".equals(task.getDescription())); 

    }
  	
  	@Test
	void testSetDescriptionLong() {
		try{
        	task = new Task("taskid", "Task Name", "Description of task");
        	task.setDescription("012345678901234567890123456789012345678901234567891");
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Argument".equals(e.getMessage()));
        }
    }

  	@Test
	void testSetDescriptionNull() {
		try{
        	task = new Task("taskid", "Task Name", "Description of task");;
        	task.setDescription(null);
          	fail("Should throw an Exception");
        }
      	catch(IllegalArgumentException e){
          //Good
           assertTrue("Invalid Argument".equals(e.getMessage()));
        }
    }

}
