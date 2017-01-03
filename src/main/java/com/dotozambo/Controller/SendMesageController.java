package com.dotozambo.Controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linecorp.bot.client.LineMessagingService;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;

@Slf4j
@RestController
@ComponentScan("com")
@RequestMapping("/send")
public class SendMesageController {

	@Autowired
    private LineMessagingService lineMessagingService;
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public void pushMessage(
			@RequestParam String to,
			@RequestParam String msg)
	{
		to = "U789c2cb0b36adc9edb75389015eaeef5";
		TextMessage message = new TextMessage(msg);
		PushMessage pushMessage = new PushMessage(to, message);
		
		log.info("Push Message : {}", pushMessage);
		lineMessagingService.pushMessage(pushMessage);
	}
}
