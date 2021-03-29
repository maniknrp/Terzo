package com.terzo.springboot.service;


import com.terzo.springboot.model.Status;
import com.terzo.springboot.model.Task;

public interface UserService {
	
	/**
	 * get a task from db
	 */
	Task getTask(String name);
	
	/**
	 * list all the users from db
	 */
	Task getAllUsers();
	
	/**
	 * delete a user in db
	 */
	Task deleteTask(String id);
	
	/**
	 * add a task into db
	 */
	Task addTask(Task task);
	
	/**
	 * update a task into db
	 */
	Task updateTask(Task task);
	
	/**
	 * get the status for all the users
	 */
	Status getStatus();

	
}
