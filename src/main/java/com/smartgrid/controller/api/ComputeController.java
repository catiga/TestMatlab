package com.smartgrid.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.entity.RepaireTask;
import com.smartgrid.entity.SysProject;
import com.smartgrid.response.ProtObj;
import com.smartgrid.service.SysService;

@RestController
public class ComputeController {
	
	@Autowired
	private RepaireTaskDao taskDao;
	
	@Autowired
	private SysService sysService;

	@ResponseBody
	@RequestMapping("/api/task/compute/{task_id}")
    public ProtObj task_compute(@PathVariable(name="task_id") Long id) {
		RepaireTask ee = taskDao.findById(id).orElse(null);

		if(ee==null) {
			return ProtObj.fail(404, "repaire task not defined");
		}
		
		//TODO 这里执行计算和入库逻辑
		return ProtObj.success(1);
	}
	
	/**
	 * 潮流计算
	 * @param proj_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/api/tide/compute/{proj_id}")
	public ProtObj tide_compute(@PathVariable(name="proj_id") Long proj_id) {
		SysProject project = sysService.getSysProject(proj_id);
		if(project==null) {
			return ProtObj.fail(404, "project not found");
		}
		//TODO 这里执行潮流计算和结果入库逻辑
		return ProtObj.success(1);
	}
}
