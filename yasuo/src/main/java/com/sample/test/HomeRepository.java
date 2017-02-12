package com.sample.test;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sample.test.dto.TodoDto;

@Repository
public interface HomeRepository {
	public List<Map<String, Object>> selectTodo(TodoDto dto);
	public int insertTodo(TodoDto dto);
	public int updateTodo(TodoDto dto);
	public int deleteTodo(TodoDto dto);
	public List<Map<String, Object>> selectAllTodo();
}
