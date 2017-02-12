package com.sample.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.test.HomeRepository;

@RestController
public class RestApiController {
	
	@Autowired
	HomeRepository repository;
	
	@RequestMapping(value = "/todo/all", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> home() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> obj = repository.selectAllTodo();
		//return mapper.writeValueAsString(obj);
		return obj;
	}
}
