package com.websystique.springboot.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.terzo.springboot.model.Status;
import com.terzo.springboot.model.Task;
import com.terzo.springboot.model.UserDetails;
import com.terzo.springboot.service.UserServiceImpl;
import com.terzo.springboot.util.UserServiceConstants;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
    JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Test
	public void testGetTaskTest() {
		String name = "mani";
		SqlRowSet sqlRowSet = Mockito.mock(SqlRowSet.class);
		when(jdbcTemplate.queryForRowSet(UserServiceConstants.GET_USER_BY_TASK, name)).thenReturn(sqlRowSet);
		when(sqlRowSet.next()).thenReturn(true).thenReturn(false);
		Task s = userServiceImpl.getUser(name);
		assertNotNull(s);
	}
	
	
	@Test
	public void testGetAllUsersTest() {
		SqlRowSet sqlRowSet = Mockito.mock(SqlRowSet.class);
		when(jdbcTemplate.queryForRowSet(UserServiceConstants.GET_ALL_USERS)).thenReturn(sqlRowSet);
		when(sqlRowSet.next()).thenReturn(true).thenReturn(false);
		Task s = userServiceImpl.getAllUsers();
		assertNotNull(s);
	}
	

	@Test
	public void testDeleteTaskTest() {
		String id = "mani";
		String actual = "User is removed from db successfully";
		int result = 1;
		when(jdbcTemplate.update(UserServiceConstants.DELETE_USER, id)).thenReturn(result);
		Task s = userServiceImpl.deleteTask(id);
		assertEquals(s.getMessage(), actual);
	}
	
	@Test
	public void testAddTaskTest() {
		int result = 1;
		String expected = "user added successfully";
		Task task = new Task();
		UserDetails userDetail = new UserDetails();
		List<UserDetails> userDetails = new ArrayList<>();
		userDetail.setName("mani");
		userDetail.setUser("manik@gmail.com");
		userDetail.setStatus("started");
		userDetail.setStartDate("2019");
		userDetail.setCompletionDate("2020");
		userDetails.add(userDetail);
		task.setUserDetails(userDetails);
		
		SqlRowSet sqlRowSet = Mockito.mock(SqlRowSet.class);
		when(jdbcTemplate.queryForRowSet(UserServiceConstants.GET_USER_BY_TASK, userDetail.getUser())).thenReturn(sqlRowSet);
		when(sqlRowSet.next()).thenReturn(true).thenReturn(false);
		
		when(jdbcTemplate.update(UserServiceConstants.ADD_TASK, userDetail.getName(), userDetail.getUser(),
				userDetail.getStartDate(), userDetail.getCompletionDate(), userDetail.getStatus())).thenReturn(result);
		Task s = userServiceImpl.addTask(task);
		assertEquals(s.getMessage(), expected);
	}
	
	@Test
	public void testUpdateTaskTest() {
		int result = 1;
		String expected = "user updated successfully";
		Task task = new Task();
		UserDetails userDetail = new UserDetails();
		List<UserDetails> userDetails = new ArrayList<>();
		userDetail.setName("mani");
		userDetail.setUser("manik@gmail.com");
		userDetail.setStatus("started");
		userDetail.setStartDate("2019");
		userDetail.setCompletionDate("2020");
		userDetails.add(userDetail);
		task.setUserDetails(userDetails);
		
		SqlRowSet sqlRowSet = Mockito.mock(SqlRowSet.class);
		when(jdbcTemplate.queryForRowSet(UserServiceConstants.GET_USER_BY_TASK, userDetail.getUser())).thenReturn(sqlRowSet);
		when(sqlRowSet.next()).thenReturn(true).thenReturn(false);
		
		when(jdbcTemplate.update(UserServiceConstants.UPDATE_TASK, userDetail.getStartDate(),
				userDetail.getCompletionDate(), userDetail.getStatus(), userDetail.getUser())).thenReturn(result);
		Task s = userServiceImpl.updateTask(task);
		assertEquals(s.getMessage(), expected);
	}
	
	@Test
	public void testGetStatusTest() {
		SqlRowSet sqlRowSet = Mockito.mock(SqlRowSet.class);
		when(jdbcTemplate.queryForRowSet(UserServiceConstants.GET_STATUS)).thenReturn(sqlRowSet);
		when(sqlRowSet.next()).thenReturn(true).thenReturn(false);
		Status s = userServiceImpl.getStatus();
		assertNotNull(s);
	}

}
