package com.skf.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@RedisHash("ReqCont")
public class RequestContent implements Serializable, Comparable<RequestContent> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5873114142403982263L;

	@Id
	@Getter
	@Setter
	private String key;

	@Getter
	@Setter
	private String content;
	
	@Getter
	@Setter
	private Timestamp contentTimeStamp;

	@Override
	public int compareTo(RequestContent o) {
		return getContentTimeStamp().compareTo(o.getContentTimeStamp());
	}
}
