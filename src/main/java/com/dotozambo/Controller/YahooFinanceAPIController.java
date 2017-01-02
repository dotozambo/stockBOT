package com.dotozambo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@RestController
@RequestMapping("/yahoofinanceapi")
public class YahooFinanceAPIController {

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String getCurrentStatus(
			@RequestBody Map<Object, Object> data,
			HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException 
	{
		log.info("Request Body : {}", data);
		
		String jsonStr = new ObjectMapper().writeValueAsString(data);
		return jsonStr;
	}
	
}
