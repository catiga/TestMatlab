package com.smartgrid.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartgrid.response.ProtObj;

@CrossOrigin
@RestController
public class HomeController {
	
	@ResponseBody
	@RequestMapping("/index")
    public ProtObj index() {

        return ProtObj.success("Hello Matlab! - smartgrid");
    }
}
