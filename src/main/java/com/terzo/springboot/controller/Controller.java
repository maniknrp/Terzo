package com.terzo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.terzo.springboot.model.Status;
import com.terzo.springboot.model.Task;
import com.terzo.springboot.service.UserService;

@RestController
@RequestMapping("/task")
public class Controller {
	/**
	 * holds the userService
	 */
	@Autowired
	UserService userService; // Service which will do all data retrieval/manipulation work
	/**
	 * add a task into db
	 */
	@PostMapping(value = "/user")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		Task users = userService.addTask(task);
		return new ResponseEntity<Task>(users, HttpStatus.OK);
	}
	/**
	 * update a task into db
	 */
	@PutMapping(value = "/user")
	public ResponseEntity<Task> updateTask(@RequestBody Task task) {
		Task users = userService.updateTask(task);
		return new ResponseEntity<Task>(users, HttpStatus.OK);
	}
	/**
	 * delete a user in db
	 */
	@DeleteMapping(value = "/user/{id:.+}")
	public ResponseEntity<Task> deleteTask(@PathVariable("id") String id) {
		Task users = userService.deleteTask(id);
		if (users.getMessage().isEmpty()) {
			return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Task>(users, HttpStatus.OK);
	}
	/**
	 * get a task from db
	 */
	@GetMapping(value = "/user")
	public ResponseEntity<Task> getTask(@RequestParam(value = "name") String name) {
		Task users = userService.getTask(name);
		if (users.getUserDetails().isEmpty()) {
			return new ResponseEntity<Task>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Task>(users, HttpStatus.OK);
	}
	/**
	 * list all the users from db
	 */
	@GetMapping(value = "/users")
	public ResponseEntity<Task> getAllUsers() {
		Task users = userService.getAllUsers();
		if (users.getMessage() != null) {
			return new ResponseEntity<Task>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Task>(users, HttpStatus.OK);
	}
	/**
	 * get the status for all the users
	 */
	@GetMapping(value = "/status")
	public ResponseEntity<Status> getStatus() {
		Status users = userService.getStatus();
		return new ResponseEntity<Status>(users, HttpStatus.OK);
	}
}