package com.skf.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skf.demo.model.DemoRequest;
import com.skf.demo.model.DemoResponse;
import com.skf.demo.services.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService srv;
	
	@PostMapping(path = "/publish", consumes = "application/json")
	public ResponseEntity<DemoResponse> publish(@RequestBody DemoRequest req) throws ParseException {
		
		DemoResponse resp = srv.publish(req);
		
		return new ResponseEntity<DemoResponse>(resp, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getLast", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DemoResponse> getLast() {
		
		DemoResponse resp = srv.getLast();
		
		return new ResponseEntity<DemoResponse>(resp, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getByTime/{start}/{end}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<DemoResponse>> getByTime(@PathVariable(required = true) String start, @PathVariable(required = false) String end) throws ParseException {
		
		List<DemoResponse> resp = srv.getByTime(start, end);
		
		return new ResponseEntity<List<DemoResponse>>(resp, HttpStatus.OK);
	}
}
