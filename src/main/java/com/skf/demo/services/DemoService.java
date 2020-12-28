package com.skf.demo.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.demo.intf.IService;
import com.skf.demo.model.DemoRequest;
import com.skf.demo.model.DemoResponse;
import com.skf.demo.model.RequestContent;
import com.skf.demo.repository.RedisRepo;
import com.skf.demo.utils.Util;

@Service
public class DemoService implements IService {
		
	@Autowired
	private RedisRepo repo;

	@Override
	public DemoResponse publish(DemoRequest req) {
		
		RequestContent dr = repo.save(Util.convertReqToCont(req));
		DemoResponse resp = Util.convertContToResp(dr);
		
		return resp;
	}

	@Override
	public DemoResponse getLast() {
				
		List<RequestContent> lstDr = new ArrayList<>();
		
		repo.findAll().forEach(lstDr::add);
		
		Collections.sort(lstDr);
		
		repo.findAll().forEach(cnt -> {
			
			System.out.println(cnt);
			
		});
		
		RequestContent dr = lstDr.get(lstDr.size()-1);
		DemoResponse resp = Util.convertContToResp(dr);
		
		return resp;
	}

	@Override
	public List<DemoResponse> getByTime(String start, String end) throws ParseException {
		
		List<DemoResponse> lstResp = new ArrayList<DemoResponse>();
		
		Timestamp contentTimeStampStart = Util.convertStringToTimestamp(start);
		Timestamp contentTimeStampEnd = !StringUtils.isEmpty(end) ? Util.convertStringToTimestamp(end) : new Timestamp(Instant.now().getEpochSecond());
			
		repo.findAll().forEach(rc -> {
			if(rc.getContentTimeStamp().after(contentTimeStampStart) && rc.getContentTimeStamp().before(contentTimeStampEnd)) {
				System.out.println(rc);
				
				lstResp.add(Util.convertContToResp(rc));
			}
		});
		
		return lstResp;
	}

}
