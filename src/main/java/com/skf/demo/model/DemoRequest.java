package com.skf.demo.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DemoRequest {
	
	@Getter
	@Setter
	@Id
	private String key;
	
	@Getter
	@Setter
	private String content;
	
}
