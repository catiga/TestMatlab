package com.smartgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartgrid.service.RepaireTaskService;

@RestController
public class HomeController {
	
	@Autowired
	RepaireTaskService taskService;

	@RequestMapping("/index")
    String index() {
		try {
			taskService.compute();
		}catch(Exception e) {
			e.printStackTrace();
		}
        return "Hello World! - ken.io";
    }
}
