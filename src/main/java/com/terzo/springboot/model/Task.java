package com.terzo.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class Task {
	
	/**
	 * holds the userDetails
	 */
	@JsonProperty(value="task")
	private List<UserDetails> userDetails;
	/**
	 * holds the message
	 */
	private String message;

}
