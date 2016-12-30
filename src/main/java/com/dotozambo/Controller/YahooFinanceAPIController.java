package com.dotozambo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dotozambo.Model.JSONData;

@RestController
@RequestMapping("/yahoofinanceapi")
public class YahooFinanceAPIController {

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String getCurrentStatus(
			@RequestBody JSONData data,
			HttpServletRequest request, HttpServletResponse response) 
	{
		return data.toString();
	}
	
}
