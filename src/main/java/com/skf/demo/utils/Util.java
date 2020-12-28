package com.skf.demo.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.TimeZone;

import com.skf.demo.model.DemoRequest;
import com.skf.demo.model.DemoResponse;
import com.skf.demo.model.RequestContent;

public class Util {
	
	public static DemoResponse convertContToResp(RequestContent cont) {
		DemoResponse resp = new DemoResponse();
		resp.setContent(cont.getContent());
		resp.setKey(cont.getKey());
		resp.setContentTimeStamp(cont.getContentTimeStamp());
		
		return resp;
	}

	public static RequestContent convertReqToCont(DemoRequest req) {
		RequestContent resp = new RequestContent();
		resp.setContent(req.getContent());
		resp.setKey(req.getKey());
		resp.setContentTimeStamp(Timestamp.from(Instant.now()));
		
		return resp;
	}
	
	public static Timestamp convertStringToTimestamp(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		return new Timestamp(sdf.parse(date).getTime());
	}
}
