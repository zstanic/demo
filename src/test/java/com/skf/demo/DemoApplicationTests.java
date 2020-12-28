package com.skf.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skf.demo.model.DemoRequest;
import com.skf.demo.model.DemoResponse;
import com.skf.demo.services.DemoService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private DemoService srv;

	@Test
	void publishTest() {
		DemoRequest req = new DemoRequest();
		req.setContent("My Content Test");
		req.setKey("key100");
		
		DemoResponse resp = srv.publish(req);
		
		assertEquals(req.getKey(), resp.getKey());
	}
	
	@Test
	void getLastTest() {
		DemoRequest req = new DemoRequest();
		req.setContent("My Content Test");
		req.setKey("key100");
		
		DemoResponse resp = srv.getLast();
		
		assertEquals(req.getKey(), resp.getKey());
	}
	
	@Test
	void getByTimeTest() {
		String start = "28.12.2020 14:00:00";
		String end = "28.12.2020 15:00:00";
		
		
		try {
			List<DemoResponse> resp = srv.getByTime(start, end);
			assertEquals(resp.size(), 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
