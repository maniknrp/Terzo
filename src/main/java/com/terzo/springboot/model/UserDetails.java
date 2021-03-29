package com.terzo.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetails {
	/**
	 * holds the name
	 */
	private String name;
	/**
	 * holds the user
	 */
	private String user;
	/**
	 * holds the startDate
	 */
	private String startDate;
	/**
	 * holds the completionDate
	 */
	private String completionDate;
	/**
	 * holds the status
	 */
	private String status;
}
