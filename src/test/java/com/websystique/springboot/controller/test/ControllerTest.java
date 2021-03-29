package com.websystique.springboot.controller.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.terzo.springboot.controller.Controller;
import com.terzo.springboot.model.Status;
import com.terzo.springboot.model.Task;
import com.terzo.springboot.model.UserDetails;
import com.terzo.springboot.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	
	@Mock
	UserService userService;
	
	@InjectMocks
	Controller controller;
	
	
	@Test
	public void testAddTask() {
		Task task = new Task();
		ResponseEntity<Task> s = controller.addTask(task);
		assertEquals(s.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testUpdateTask() {
		Task task = new Task();
		ResponseEntity<Task> s = controller.updateTask(task);
		assertEquals(s.getStatusCode(), HttpStatus.OK);
	}
	
	
	@Test
	public void testDeleteTask() {
		String id = "mani";
		Task task = new Task();
		task.setMessage("record deleted successfully");
		when(userService.deleteTask(Mockito.anyString())).thenReturn(task);
		ResponseEntity<Task> s = controller.deleteTask(id);
		assertEquals(s.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testDeleteTaskBusinessError() {
		String id = "mani";
		Task task = new Task();
		task.setMessage("");
		when(userService.deleteTask(Mockito.anyString())).thenReturn(task);
		ResponseEntity<Task> s = controller.deleteTask(id);
		assertEquals(s.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testGetTaskBusinessError() {
		String name = "mani";
		Task task = new Task();
		List<UserDetails> userDetails = new ArrayList<>();
		task.setUserDetails(userDetails);
		when(userService.getTask(Mockito.anyString())).thenReturn(task);
		ResponseEntity<Task> s = controller.getTask(name);
		assertEquals(s.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testGetTask() {
		String name = "mani";
		Task task = new Task();
		UserDetails userDetail = new UserDetails();
		List<UserDetails> userDetails = new ArrayList<>();
		userDetail.setUser("mani");
		userDetails.add(userDetail);
		task.setUserDetails(userDetails);
		when(userService.getTask(Mockito.anyString())).thenReturn(task);
		ResponseEntity<Task> s = controller.getTask(name);
		assertEquals(s.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testGetAllUsers() {
		Task task = new Task();
		task.setMessage("");
		when(userService.getAllUsers()).thenReturn(task);
		ResponseEntity<Task> s = controller.getAllUsers();
		assertEquals(s.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void testGetAllUsersBusinessError() {
		Task task = new Task();
		task.setMessage("error");
		when(userService.getAllUsers()).thenReturn(task);
		ResponseEntity<Task> s = controller.getAllUsers();
		assertEquals(s.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void testGetStatus() {
		Status status = new Status();
		when(userService.getStatus()).thenReturn(status);
		ResponseEntity<Status> s = controller.getStatus();
		assertEquals(s.getStatusCode(), HttpStatus.OK);
	}
}
