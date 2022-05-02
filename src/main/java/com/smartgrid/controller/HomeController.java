package com.smartgrid.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/index")
    String index() {

        return "Hello Matlab! - smartgrid";
    }
}
