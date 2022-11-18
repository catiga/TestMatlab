package com.smartgrid.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.smartgrid.response.ProtObj;

import CalculteTopo.CalculateTopo;

@CrossOrigin
@RestController
public class HomeController {
	
	@ResponseBody
	@RequestMapping("/index")
    public ProtObj index() throws Exception {
		MWCellArray tableNodeArray = new MWCellArray(new int[] {3, 3});
		CalculateTopo topoComputer = new CalculateTopo();
		System.out.println(tableNodeArray);
		System.out.println(topoComputer);
        return ProtObj.success("Hello Matlab! - smartgrid");
    }
}
