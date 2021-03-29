package com.terzo.springboot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.terzo.springboot.model.Status;
import com.terzo.springboot.model.Task;
import com.terzo.springboot.model.UserDetails;
import com.terzo.springboot.util.UserServiceConstants;


@Service("userService")
public class UserServiceImpl implements UserService{
	/**
	 * jdbcTemplate
	 * 
	 */
	@Autowired
    JdbcTemplate jdbcTemplate;
	/**
	 * get a task from db
	 * 
	 */
	@Override
	public Task getTask(String name) {
		Task task = new Task();
		List<UserDetails> userDetails = new ArrayList<>();
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(UserServiceConstants.GET_USER_BY_TASK, name);
		while (sqlRowSet.next()) {
			UserDetails userDetail = new UserDetails();
			userDetail.setName(sqlRowSet.getString("name"));
			userDetail.setUser(sqlRowSet.getString("userid"));
			userDetail.setStartDate(sqlRowSet.getString("start_date"));
			userDetail.setCompletionDate(sqlRowSet.getString("completion_date"));
			userDetail.setStatus(sqlRowSet.getString("status"));
			userDetails.add(userDetail);
		}
		task.setUserDetails(userDetails);
		return task;
	}
	/**
	 * list all the users from db
	 * 
	 */
	@Override
	public Task getAllUsers() {
		Task task = new Task();
		List<UserDetails> userDetails = new ArrayList<>();
		UserDetails userDetail = null;
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(UserServiceConstants.GET_ALL_USERS);
		while (sqlRowSet.next()) {
			userDetail = new UserDetails();
			userDetail.setName(sqlRowSet.getString("name"));
			userDetail.setUser(sqlRowSet.getString("userid"));
			userDetail.setStartDate(sqlRowSet.getString("start_date"));
			userDetail.setCompletionDate(sqlRowSet.getString("completion_date"));
			userDetail.setStatus(sqlRowSet.getString("status"));
			userDetails.add(userDetail);
		}
		if (userDetail == null) {
			task.setMessage("No data found");
		} else {
			task.setUserDetails(userDetails);
		}
		return task;
	}
	/**
	 * delete a user in db
	 * 
	 */
	@Override
	public Task deleteTask(String id) {
		Task task = new Task();
		int result = jdbcTemplate.update(UserServiceConstants.DELETE_USER, id);
		if (result == 0) {
			task.setMessage("User is not found in db");
		} else {
			task.setMessage("User is removed from db successfully");
		}
		return task;
	}
	/**
	 * add a task into db
	 * 
	 */
	@Override
	public Task addTask(Task task) {
		int result = 0;
		Task response = new Task();
		List<UserDetails> userDetails = task.getUserDetails();
		for (UserDetails details : userDetails) {
			UserDetails userDetail = getUserId(details);
			if (userDetail == null || userDetail.getUser() == null) {
				result = jdbcTemplate.update(UserServiceConstants.ADD_TASK, details.getName(), details.getUser(),
						details.getStartDate(), details.getCompletionDate(), details.getStatus());
				if (result == 0) {
					response.setMessage("Error in db");
				} else {
					response.setMessage("user added successfully");
				}
			} else {
				response.setMessage("User is already exists");
			}
		}

		return response;
	}
	/**
	 * get the user id from db
	 * 
	 */
	private UserDetails getUserId(UserDetails details) {
		UserDetails userDetail = null;
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(UserServiceConstants.GET_USER_BY_TASK, details.getUser().toLowerCase());
		while (sqlRowSet.next()) {
			userDetail = new UserDetails();
			userDetail.setUser(sqlRowSet.getString("userid"));
		}
		return userDetail;
	}
	/**
	 * update a task into db
	 * 
	 */
	@Override
	public Task updateTask(Task task) {
		int result = 0;
		Task response = new Task();
		List<UserDetails> userDetails = task.getUserDetails();
		for (UserDetails details : userDetails) {
			UserDetails userDetail = getUserId(details);
			if (userDetail != null) {
				result = jdbcTemplate.update(UserServiceConstants.UPDATE_TASK, details.getStartDate(),
						details.getCompletionDate(), details.getStatus(), details.getUser());
				if (result == 0) {
					response.setMessage("Error in db");
				} else {
					response.setMessage("user updated successfully");
				}

			} else {
				response.setMessage("User is already exists");
			}
		}
		return response;
	}
	/**
	 * get the status for all the users
	 * 
	 */
	@Override
	public Status getStatus() {
		Status status = new Status();
		List<String> statusList = new ArrayList<>();
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(UserServiceConstants.GET_STATUS);
		while (sqlRowSet.next()) {
			String statues = sqlRowSet.getString("status");
			statusList.add(statues);
		}
		status.setInprogress(Collections.frequency(statusList, "in_progress"));
		status.setYetToStart(Collections.frequency(statusList, "started"));
		status.setReview(Collections.frequency(statusList, "review"));
		status.setCompleted(Collections.frequency(statusList, "completed"));
		return status;
	}
}
