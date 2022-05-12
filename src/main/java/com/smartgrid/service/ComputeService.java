package com.smartgrid.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.smartgrid.dao.C1BranchLevelAreaDao;
import com.smartgrid.dao.C1BranchLevelDao;
import com.smartgrid.dao.C1BusLevelAreaDao;
import com.smartgrid.dao.C1BusLevelDao;
import com.smartgrid.dao.C1ComponentRelibilityDao;
import com.smartgrid.dao.C1GeneratorLevelAreaDao;
import com.smartgrid.dao.C1GeneratorLevelDao;
import com.smartgrid.dao.C1LoadLevelDao;
import com.smartgrid.dao.C1NameShowLevelDao;
import com.smartgrid.dao.C1TableNodeLevelProvinceDao;
import com.smartgrid.dao.CpfComputeResultDao;
import com.smartgrid.dao.TaskLoadFlowDao;
import com.smartgrid.entity.C1BranchLevelArea;
import com.smartgrid.entity.C1BusLevelArea;
import com.smartgrid.entity.C1GeneratorLevelArea;
import com.smartgrid.entity.C1TableNodeLevelProvince;
import com.smartgrid.entity.CpfComputeResult;
import com.smartgrid.entity.TaskLoadFlow;
import com.smartgrid.response.ProtObj;
import com.smartgrid.util.ToolKit;

import calculatePf.CalculatePf;

@Service
public class ComputeService {

	@Autowired
	private C1BusLevelDao busLevelDao;
	
	@Autowired
	private C1BusLevelAreaDao busLevelAreaDao;
	
	@Autowired
	private C1BranchLevelDao branchLevelDao;
	
	@Autowired
	private C1BranchLevelAreaDao branchLevelAreaDao;
	
	@Autowired
	private C1GeneratorLevelDao generatorLevelDao;
	
	@Autowired
	private C1GeneratorLevelAreaDao generatorLevelAreaDao;
	
	@Autowired
	private C1NameShowLevelDao nameShowLevelDao;
	
	@Autowired
	private C1LoadLevelDao loadLevelDao;
	
	@Autowired
	private C1TableNodeLevelProvinceDao tableNodeLevelProvinceDao;
	
	@Autowired
	private C1ComponentRelibilityDao componentRelibilityDao;
	
	@Autowired
	private CpfComputeResultDao pfResultDao;
	
	@Autowired
	private TaskLoadFlowDao loadFlowDao;
	
	public TaskLoadFlow getPfTask(Long id) {
		return loadFlowDao.getOne(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ProtObj computePf(TaskLoadFlow task, BigDecimal sBase) {
		List<C1BusLevelArea> busLevelAreaData = busLevelAreaDao.findByProjId(task.getProjId());
		List<C1BranchLevelArea> branchLevelAreaData = branchLevelAreaDao.findByProjId(task.getProjId());
		List<C1GeneratorLevelArea> generatorLevelAreaData = generatorLevelAreaDao.findByProjId(task.getProjId());
		List<C1TableNodeLevelProvince> tableNodeAreaData = tableNodeLevelProvinceDao.findByProjId(task.getProjId());
		
		//检查数据
		if(busLevelAreaData==null || busLevelAreaData.isEmpty()) {
			return ProtObj.fail(401, "bus level area data empty");
		}
		
		if(branchLevelAreaData==null || branchLevelAreaData.isEmpty()) {
			return ProtObj.fail(402, "branch level area data empty");
		}
		
		if(generatorLevelAreaData==null || generatorLevelAreaData.isEmpty()) {
			return ProtObj.fail(403, "generator level area data empty");
		}
		
		if(tableNodeAreaData==null || tableNodeAreaData.isEmpty()) {
			return ProtObj.fail(403, "table node level area data empty");
		}
		
		//开始封装数据转换
		double[][] busLevelArray = new double[busLevelAreaData.size()][13];
		double[][] branchLevelArray = new double[branchLevelAreaData.size()][13];
		double[][] generatorLevelArray = new double[generatorLevelAreaData.size()][21];
		MWCellArray tableNodeArray = new MWCellArray(new int[] {tableNodeAreaData.size(), 3});
		
		int index = 0;
		for(C1BusLevelArea d : busLevelAreaData) {
			busLevelArray[index][0] = d.getBla1().doubleValue();
			busLevelArray[index][1] = d.getBla2().doubleValue();
			busLevelArray[index][2] = d.getBla3().doubleValue();
			busLevelArray[index][3] = d.getBla4().doubleValue();
			busLevelArray[index][4] = d.getBla5().doubleValue();
			busLevelArray[index][5] = d.getBla6().doubleValue();
			busLevelArray[index][6] = d.getBla7().doubleValue();
			busLevelArray[index][7] = d.getBla8().doubleValue();
			busLevelArray[index][8] = d.getBla9().doubleValue();
			busLevelArray[index][9] = d.getBla10().doubleValue();
			busLevelArray[index][10] = d.getBla11().doubleValue();
			busLevelArray[index][11] = d.getBla12().doubleValue();
			busLevelArray[index][12] = d.getBla13().doubleValue();
			index++;
		}
		index = 0;
		for(C1BranchLevelArea d : branchLevelAreaData) {
			branchLevelArray[index][0] = d.getBla1().doubleValue();
			branchLevelArray[index][1] = d.getBla2().doubleValue();
			branchLevelArray[index][2] = d.getBla3().doubleValue();
			branchLevelArray[index][3] = d.getBla4().doubleValue();
			branchLevelArray[index][4] = d.getBla5().doubleValue();
			branchLevelArray[index][5] = d.getBla6().doubleValue();
			branchLevelArray[index][6] = d.getBla7().doubleValue();
			branchLevelArray[index][7] = d.getBla8().doubleValue();
			branchLevelArray[index][8] = d.getBla9().doubleValue();
			branchLevelArray[index][9] = d.getBla10().doubleValue();
			branchLevelArray[index][10] = d.getBla11().doubleValue();
			branchLevelArray[index][11] = d.getBla12().doubleValue();
			branchLevelArray[index][12] = d.getBla13().doubleValue();
			index++;
		}
		index = 0;
		for(C1GeneratorLevelArea d : generatorLevelAreaData) {
			generatorLevelArray[index][0] = d.getGla1().doubleValue();
			generatorLevelArray[index][1] = d.getGla2().doubleValue();
			generatorLevelArray[index][2] = d.getGla3().doubleValue();
			generatorLevelArray[index][3] = d.getGla4().doubleValue();
			generatorLevelArray[index][4] = d.getGla5().doubleValue();
			generatorLevelArray[index][5] = d.getGla6().doubleValue();
			generatorLevelArray[index][6] = d.getGla7().doubleValue();
			generatorLevelArray[index][7] = d.getGla8().doubleValue();
			generatorLevelArray[index][8] = d.getGla9().doubleValue();
			generatorLevelArray[index][9] = d.getGla10().doubleValue();
			generatorLevelArray[index][10] = d.getGla11().doubleValue();
			generatorLevelArray[index][11] = d.getGla12().doubleValue();
			generatorLevelArray[index][12] = d.getGla13().doubleValue();
			generatorLevelArray[index][13] = d.getGla14().doubleValue();
			generatorLevelArray[index][14] = d.getGla15().doubleValue();
			generatorLevelArray[index][15] = d.getGla16().doubleValue();
			generatorLevelArray[index][16] = d.getGla17().doubleValue();
			generatorLevelArray[index][17] = d.getGla18().doubleValue();
			generatorLevelArray[index][18] = d.getGla19().doubleValue();
			generatorLevelArray[index][19] = d.getGla20().doubleValue();
			generatorLevelArray[index][20] = d.getGla21().doubleValue();
			index++;
		}
		
		index = 1;
		for(C1TableNodeLevelProvince d : tableNodeAreaData) {
			int[] idx1 = new int[] {index, 1};
			int[] idx2 = new int[] {index, 2};
			int[] idx3 = new int[] {index, 3};
			tableNodeArray.set(idx1, d.getV1().doubleValue());
			tableNodeArray.set(idx2, d.getV2());
			tableNodeArray.set(idx3, d.getV3().doubleValue());
			index++;
		}
		try {
			CalculatePf pfComputer = new CalculatePf();
			Object [] realData = pfComputer.calculatePf(10, sBase.doubleValue(), busLevelArray, branchLevelArray, generatorLevelArray, tableNodeArray);
			
			//处理数据
			MWNumericArray d1 = (MWNumericArray)realData[0];
			MWNumericArray d2 = (MWNumericArray)realData[1];
			MWNumericArray d3 = (MWNumericArray)realData[2];
			MWNumericArray d4 = (MWNumericArray)realData[3];
			MWNumericArray d5 = (MWNumericArray)realData[4];
			MWNumericArray d6 = (MWNumericArray)realData[5];
			
			MWCellArray d7 = (MWCellArray)realData[6];
			MWCellArray d8 = (MWCellArray)realData[7];
			MWCellArray d9 = (MWCellArray)realData[8];
			MWCellArray d10 = (MWCellArray)realData[9];
			
			//开始处理数据
			double baseMVA = d1.getDouble();
			double[][] busArray = (double[][])d2.toDoubleArray();
			double[][] genArray = (double[][])d3.toDoubleArray();
			double[][] branchArray = (double[][])d4.toDoubleArray();
			int success = d5.getInt();
			double et = d6.getDouble();
			
			//处理剩余四个
			String busStr = ToolKit.doubleArrayToString(busArray);
			String branchStr = ToolKit.doubleArrayToString(branchArray);
			String genStr = ToolKit.doubleArrayToString(genArray);
			
			String busNameStr = ToolKit.cellArrayToString(d7);
			String branchFnameStr = ToolKit.cellArrayToString(d8);
			String branchTnameStr = ToolKit.cellArrayToString(d9);
			String genNameStr = ToolKit.cellArrayToString(d10);
			
			CpfComputeResult compute = new CpfComputeResult();
			compute.setBaseMva(new BigDecimal(baseMVA));
			compute.setBranch(branchStr);
			compute.setBranchFname(branchFnameStr);
			compute.setBranchTname(branchTnameStr);
			compute.setBus(busStr);
			compute.setBusName(busNameStr);
			compute.setEt(new BigDecimal(et));
			compute.setGen(genStr);
			compute.setGenName(genNameStr);
			compute.setProjId(task.getProjId());
			compute.setTaskId(task.getId());
			compute.setSuccess(success);
			
			pfResultDao.deleteByTaskId(task.getId());
			pfResultDao.save(compute);
			
			return ProtObj.success(compute);
		} catch(MWException mex) {
			mex.printStackTrace();
			return ProtObj.fail(501, mex.toString());
		}
	}
	
}
