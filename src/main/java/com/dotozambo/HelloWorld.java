package com.dotozambo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping("/")
    public @ResponseBody String root_test() throws Exception{
        return "Hello World";
    }
 
    @RequestMapping("/heart_beat")
    public @ResponseBody String demo_test() throws Exception{
        return "Still Alive..(stockBOT)";
    }

}
