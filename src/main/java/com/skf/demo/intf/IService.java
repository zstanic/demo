package com.skf.demo.intf;

import java.text.ParseException;
import java.util.List;

import com.skf.demo.model.DemoRequest;
import com.skf.demo.model.DemoResponse;

public interface IService {
	
	public DemoResponse publish(DemoRequest req);
	
	public DemoResponse getLast();
	
	public List<DemoResponse> getByTime(String start, String end) throws ParseException;

}
