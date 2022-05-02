package com.smartgrid.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.entity.RepaireTask;
import com.smartgrid.service.RepaireTaskService;

@RestController
public class HomeController {
	
	@Autowired
	RepaireTaskService taskService;
	
	@Autowired
	private RepaireTaskDao taskDao;

	@RequestMapping("/index")
    String index() {
		Optional<RepaireTask> ee = taskDao.findById(1l);
		RepaireTask rt = ee.get();
		try {
			taskService.compute();
		}catch(Exception e) {
			e.printStackTrace();
		}
        return "Hello World! - ken.io";
    }
}
