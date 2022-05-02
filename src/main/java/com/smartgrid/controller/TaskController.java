package com.smartgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.entity.ProjectParam;
import com.smartgrid.entity.RepaireTask;
import com.smartgrid.service.RepaireTaskService;

@RestController
public class TaskController {
	
	@Autowired
	RepaireTaskService taskService;
	
	@Autowired
	private RepaireTaskDao taskDao;

	@RequestMapping("/index/{id}")
    public ProjectParam index(@PathVariable(name="id") Long id) {
		RepaireTask ee = taskDao.findById(id).orElse(null);

		if(ee==null) {
			return new ProjectParam();
		}
		try {
			taskService.compute();
		}catch(Exception e) {
			e.printStackTrace();
		}
        return null;
    }
}
