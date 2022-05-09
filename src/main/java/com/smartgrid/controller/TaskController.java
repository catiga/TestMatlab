package com.smartgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.dto.basic.DataBasic;
import com.smartgrid.entity.RepaireTask;
import com.smartgrid.response.ProtObj;
import com.smartgrid.service.RepaireTaskService;

@RestController
public class TaskController {
	
	@Autowired
	RepaireTaskService taskService;
	
	@Autowired
	private RepaireTaskDao taskDao;

	@ResponseBody
	@RequestMapping("/task/compute/{id}")
    public ProtObj task_compute(@PathVariable(name="id") Long id) {
		RepaireTask ee = taskDao.findById(id).orElse(null);

		if(ee==null) {
			return ProtObj.fail(404, "object not found");
		}
		
		Long projId = ee.getProjId();
		try {
			taskService.compute(projId);
		}catch(Exception e) {
			e.printStackTrace();
		}
        return ProtObj.success(null);
    }
	
	@ResponseBody
	@RequestMapping("/task/getBasicNameArray/{id}")
	public ProtObj getBasicNameArray(@PathVariable(name = "id") Long id) {
		RepaireTask ee = taskDao.findById(id).orElse(null);

		if(ee==null) {
			return ProtObj.fail(404, "object not found");
		}
		
		DataBasic data = taskService.buildDataBasic(ee.getProjId());
		return ProtObj.success(data);
	}
}

