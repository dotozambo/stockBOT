package com.dotozambo.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@RestController
@RequestMapping("/yahoofinanceapi")
public class YahooFinanceAPIController {

	@Autowired
	SendMesageController sendMessageController;
	
	@RequestMapping(value = "/search", 
			method = RequestMethod.POST,
			produces = "application/json; charset=utf-8")
	public String getCurrentStatus(
			@RequestBody Map<Object, Object> data,
			HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		log.info("Request Body : {}", data);
		
		ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(data);
        
        /* Send POST */
        
        String sResult = "";
        String sTargetUrl = "http://localhost/YahooFinanceAPI.php";
        URL url = new URL(sTargetUrl);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setDoInput (true);
        urlConn.setDoOutput (true);
        urlConn.setRequestMethod("POST");
        urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
        urlConn.setRequestProperty("Content-Type", "application/json");
        urlConn.connect();

        OutputStreamWriter osw = new OutputStreamWriter(urlConn.getOutputStream(), "UTF-8");
        osw.write(jsonStr);
        osw.flush();
        
        /* Get response data.*/
               
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
        String line = null;
        while ((line = br.readLine()) != null){
        	sResult += line;
        }
		log.info("Results : {}", sResult);
        sendMessageController.pushMessage("id", sResult);
        return sResult;

	}
	
}
