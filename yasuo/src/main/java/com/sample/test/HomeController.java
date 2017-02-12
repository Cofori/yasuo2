package com.sample.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.sample.test.dto.TodoDto;
import com.sample.test.form.TodoForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	HomeRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		TodoDto dto = new TodoDto();
		List<Map<String, Object>> result = repository.selectTodo(dto);
		model.addAttribute("data", result);
		
		return "home";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Locale locale, Model model, TodoForm from) {
		TodoDto dto = new TodoDto();
		BeanUtils.copyProperties(from, dto);
		int result = repository.updateTodo(dto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String delete(Locale locale, Model model, TodoForm from) {
		TodoDto dto = new TodoDto();
		BeanUtils.copyProperties(from, dto);
		List<Map<String, Object>> check = repository.selectTodo(dto);
		if(0 < check.size()) {
			return "error";
		}
		int result = repository.insertTodo(dto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String insert(Locale locale, Model model, TodoForm from) {
		TodoDto dto = new TodoDto();
		BeanUtils.copyProperties(from, dto);
		int result = repository.deleteTodo(dto);
		return "redirect:/";
	}
}
