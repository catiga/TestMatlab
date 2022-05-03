package com.smartgrid.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.entity.RepaireTask;
import com.smartgrid.response.ProtObj;
import com.smartgrid.service.RepaireTaskService;

@RestController
public class TaskController {
	
	@Autowired
	RepaireTaskService taskService;
	
	@Autowired
	private RepaireTaskDao taskDao;

	@RequestMapping("/task/compute/{p}")
    public ProtObj task_compute(@PathVariable(name="id") Long id) {
		RepaireTask ee = taskDao.findById(id).orElse(null);

		if(ee==null) {
			return ProtObj.fail(404, "object not found");
		}
		
		BigDecimal baseKv = ee.getBaseKv();
		String name = ee.getName();
		String stationCode = ee.getStationCode();
		String stationName = ee.getStationName();
		Long projId = ee.getProjId();
		try {
			taskService.compute();
		}catch(Exception e) {
			e.printStackTrace();
		}
        return ProtObj.success(null);
    }
}

