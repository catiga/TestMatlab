package com.smartgrid.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.controller.api.wrapper.WrapperController;
import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.entity.RepaireTask;
import com.smartgrid.entity.SysProject;
import com.smartgrid.response.ProtObj;
import com.smartgrid.service.C1Service;
import com.smartgrid.service.RepaireTaskService;
import com.smartgrid.service.SysService;

@RestController
public class ComputeController extends WrapperController {
	
	@Autowired
	private RepaireTaskDao taskDao;
	
	@Autowired
	private SysService sysService;
	
	@Autowired
	private RepaireTaskService taskService;
	
	@Autowired
	private C1Service c1Service;

	@ResponseBody
	@RequestMapping("/api/task/compute/{task_id}")
    public ProtObj task_compute(@PathVariable(name="task_id") Long id) {
		RepaireTask ee = taskDao.findById(id).orElse(null);

		if(ee==null) {
			return ProtObj.fail(404, "repaire task not defined");
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
		//变更计算状态
		ee.setComputing(1);
		taskService.updateTask(ee);
		
		//处理入库逻辑
		try {
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
			
			double[][] busLevelArray = (double[][])busLevel.toDoubleArray();
			double[][] branchLevelArray = (double[][])branchLevel.toDoubleArray();
			double[][] generatorLevelArray = (double[][])generatorLevel.toDoubleArray();
			
			Map<String, List<String>> nameShowLevelArray = this.buildStringFromStructArray(nameShowLevelArea);
			double[][] busLevelAreaArray = (double[][])busLevelArea.toDoubleArray();
			double[][] branchLevelAreaArray = (double[][])branchLevelArea.toDoubleArray();
			double[][] generatorLevelAreaArray = (double[][])generatorLevelArea.toDoubleArray();
			
			List<Object[]> provinceDataArray = this.buildDataFromCellArray(tableNodesLevelProvinceArea);
			double[][] loadLevelAreaArray = (double[][])loadLevelArea.toDoubleArray();
			double[][] componentRelibilityArray = (double[][])componentRelibility.toDoubleArray();
			
			c1Service.saveRepaireTaskComputeData(busLevelArray, branchLevelArray, generatorLevelArray, 
					nameShowLevelArray,
					busLevelAreaArray, branchLevelAreaArray, generatorLevelAreaArray,
					provinceDataArray,
					loadLevelAreaArray, componentRelibilityArray,
					projId);
			ee.setComputing(2);
			taskService.updateTask(ee);
			
	        return ProtObj.success(null);
		} catch(Exception e) {
			e.printStackTrace();
			ee.setComputing(3);	//返回计算失败
			taskService.updateTask(ee);
			return ProtObj.fail(500, e.toString());
		}
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
