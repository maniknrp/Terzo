package com.terzo.springboot.util;

public class UserServiceConstants {
	/**
	 * GET_USER_BY_TASK
	 */
	public static final String GET_USER_BY_TASK = "select * from task where lower(userid) = ? ";
	/**
	 * GET_ALL_USERS
	 */
	public static final String GET_ALL_USERS = "select * from task";
	/**
	 * DELETE_USER
	 */
	public static final String DELETE_USER = "delete from task where userid = ?";
	/**
	 * ADD_TASK
	 */
	public static final String ADD_TASK = "insert into task (name, userid, start_date, completion_date, status) values (?, ?, ?, ?, ?)";
	/**
	 * UPDATE_TASK
	 */
	public static final String UPDATE_TASK = "update task set start_date = ?, completion_date = ?, status = ? where userid = ?";
	/**
	 * GET_STATUS
	 */
	public static final String GET_STATUS = "select status from task";

}
