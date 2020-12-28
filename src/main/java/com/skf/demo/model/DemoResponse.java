package com.skf.demo.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DemoResponse {
	
	@Getter
	@Setter
	private String key;
	
	@Getter
	@Setter
	private String content;
	
	@Getter
	@Setter
	private Timestamp contentTimeStamp;
}
