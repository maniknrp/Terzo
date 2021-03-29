package com.terzo.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Status {
	
	/**
	 * holds the yetToStart
	 */
	@JsonProperty(value = "yet_to_start")
	private int yetToStart;
	/**
	 * holds the Inprogress
	 */
	@JsonProperty(value = "in_progress")
	private int inprogress;
	/**
	 * holds the review
	 */
	private int review;
	/**
	 * holds the completed
	 */
	private int completed;
	
}
