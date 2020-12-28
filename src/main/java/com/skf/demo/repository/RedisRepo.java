package com.skf.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skf.demo.model.RequestContent;

@Repository
public interface RedisRepo extends CrudRepository<RequestContent, String> {
	
}
