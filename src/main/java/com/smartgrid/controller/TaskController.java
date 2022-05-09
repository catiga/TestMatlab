package com.smartgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
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
		Object[] retData = null;
		try {
			retData = taskService.compute(projId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(retData==null) {
			return ProtObj.fail(500, "compute failed");
		}
		//处理入库逻辑
		MWNumericArray busLevel = (MWNumericArray)retData[0];
		MWNumericArray branchLevel = (MWNumericArray)retData[1];
		MWNumericArray generatorLevel = (MWNumericArray)retData[2];
		
		MWStructArray nameShowLevelArea = (MWStructArray)retData[3];
		
		MWNumericArray busLevelArea = (MWNumericArray)retData[4];
		MWNumericArray branchLevelArea = (MWNumericArray)retData[5];
		MWNumericArray generatorLevelArea = (MWNumericArray)retData[6];
		
		MWCellArray tableNodesLevelProvinceArea = (MWCellArray)retData[7];
		
		MWNumericArray loadLevelArea = (MWNumericArray)retData[8];	// 这行数据为空
		MWNumericArray componentRelibility = (MWNumericArray)retData[9];
		
		int numberofe = busLevel.numberOfElements();
		int[] indexCol = busLevel.columnIndex();
		int[] diemsns = busLevel.getDimensions();
		int did = busLevel.numberOfDimensions();
		
		double[][] busleveldataarray = (double[][])busLevel.toDoubleArray();
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

