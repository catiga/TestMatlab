package com.smartgrid.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.dao.C1BranchLevelAreaDao;
import com.smartgrid.dao.C1BusLevelAreaDao;
import com.smartgrid.dao.C1GeneratorLevelAreaDao;
import com.smartgrid.dao.C1TableNodeLevelProvinceDao;
import com.smartgrid.dao.Component_branchDao;//add-LC
import com.smartgrid.dao.CpfComputeResultDao;
import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.dao.TaskLoadFlowDao;
import com.smartgrid.dao.TaskStationTopoDao;
import com.smartgrid.dto.original.Branch;
import com.smartgrid.entity.C1BranchLevelArea;
import com.smartgrid.entity.C1BusLevelArea;
import com.smartgrid.entity.C1GeneratorLevelArea;
import com.smartgrid.entity.C1TableNodeLevelProvince;
import com.smartgrid.entity.ComponentBranch;//add-LC
import com.smartgrid.entity.CpfComputeResult;
import com.smartgrid.entity.RepaireTask;//add-LC
import com.smartgrid.entity.TaskLoadFlow;
import com.smartgrid.entity.TaskStationTopo;
import com.smartgrid.response.ProtObj;
import com.smartgrid.util.ToolKit;

import calculatePf.CalculatePf;

@Service
public class ComputeService {

//	@Autowired
//	private C1BusLevelDao busLevelDao;
//	@Autowired
//	private C1BranchLevelDao branchLevelDao;
//	@Autowired
//	private C1GeneratorLevelDao generatorLevelDao;
//	@Autowired
//	private C1NameShowLevelDao nameShowLevelDao;
//	@Autowired
//	private C1LoadLevelDao loadLevelDao;
//	@Autowired
//	private C1ComponentRelibilityDao componentRelibilityDao;

	@Autowired
	private C1BranchLevelAreaDao branchLevelAreaDao;
	
	@Autowired
	private C1TableNodeLevelProvinceDao tableNodeLevelProvinceDao;
	
	@Autowired
	private C1BusLevelAreaDao busLevelAreaDao;
	
	@Autowired
	private C1GeneratorLevelAreaDao generatorLevelAreaDao;
	
	@Autowired
	private CpfComputeResultDao pfResultDao;
	
	@Autowired
	private TaskLoadFlowDao loadFlowDao;
	
	@Autowired
	private TaskStationTopoDao topoDao;
	
	@Autowired
	private Component_branchDao component_branchDao;//add-LC
	
	@Autowired
	private RepaireTaskDao taskDao;//add-LC
	
	public TaskStationTopo getTopoTask(Long id) {
		return topoDao.getOne(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateTopoTask(TaskStationTopo task) {
		topoDao.save(task);
	}

	public TaskLoadFlow getPfTask(Long id) {
		return loadFlowDao.getOne(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updatePfTask(TaskLoadFlow task) {
		loadFlowDao.save(task);
	}
	
	public ProtObj computeTopo(TaskStationTopo task) throws Exception {
		List<ComponentBranch> projectComponentBranchData = component_branchDao.findByProjId(task.getProjId());//add-LC
        List<RepaireTask> taskData = taskDao.findByProjId(task.getProjId());//add-LC
        
        if(projectComponentBranchData==null || projectComponentBranchData.isEmpty()) {
			return ProtObj.fail(403, "Component Branch Data empty");//add-LC
		}
		if(taskData==null || taskData.isEmpty()) {
			return ProtObj.fail(403, "Task Data");//add-LC
		}
		
		//add-LC- build the data structure of exMatchIn and TableMainwireElements
		
		Branch branch = new Branch(projectComponentBranchData);//add-LC
		MWStructArray original = branch.toM();//add-LC
		
		
		RepaireTask taskdata = taskData.get(0);//add-LC
		String[] maintanceTarget = new String[] {taskdata.getStationName()};//add-LC
		
		double[][]tmp_exMatchIn_num = new double[12][1];
		for(int i = 0; i<tmp_exMatchIn_num.length; i++) {
			tmp_exMatchIn_num[i][0] = i+1.0;
		}
		tmp_exMatchIn_num[10][0] = 44.0;
		tmp_exMatchIn_num[11][0] = 48.0;
		String[][]tmp_exMatchIn_str = {
				{"鄂府河220"},{"鄂府河220"},{"鄂临空港220"},{"鄂环城220"},{"鄂环城220"},
				{"鄂李家墩220"},{"鄂李家墩220"},{"鄂德胜堂220-2"},{"鄂江滩220"},{"鄂岱家山220"},
				{"鄂木兰1B220"},{"鄂木兰2B220"}
		};
		
		MWCellArray exMatchIn = new MWCellArray(new int[]{tmp_exMatchIn_num.length, 2});
		int j = 1;
		int k = 1;
		for(int i = 0; i<tmp_exMatchIn_num.length; i++) {
			int[] idx1 = new int[] {j++, 1};
			int[] idx2 = new int[] {k++, 2};
			exMatchIn.set(idx1, tmp_exMatchIn_num[i][0]);
			exMatchIn.set(idx2, tmp_exMatchIn_str[i][0]);
		}
		
		String[]tmp_TableMainwireElements = {
				"S1-1","进线B1","S1-2","S1-3",
				"S2-1","进线B2","S2-2","S2-3",
				"S3-1","进线B3","S3-2","S3-3",
				"S4-1","进线B4","S4-2","S4-3"
		};
		MWCellArray TableMainwireElements = new MWCellArray(new int[]{tmp_TableMainwireElements.length, 1});
		int i = 1;
		for(String t : tmp_TableMainwireElements) {
			int[] idx = new int[] {i++, 1};
			TableMainwireElements.set(idx, t);
		}
		//add-LC
		
//		CalculateTopo topoComputer = new CalculateTopo();//
//		Object [] topoData = topoComputer.CalculteTopo(9, tableNodeArray, busLevelArray, generatorLevelArray, branchLevelArray, maintanceTarget,exMatchIn ,original,TableMainwireElements);//add-LC
//		
//		//add LC-处理数据
//		MWNumericArray t1 = (MWNumericArray)topoData[0];
//		MWNumericArray t2 = (MWNumericArray)topoData[1];
//		MWNumericArray t3 = (MWNumericArray)topoData[2];
//		MWNumericArray t4 = (MWNumericArray)topoData[3];
//		MWNumericArray t5 = (MWNumericArray)topoData[4];
//		MWNumericArray t6 = (MWNumericArray)topoData[5];
//		MWNumericArray t7 = (MWNumericArray)topoData[6];
//		MWNumericArray t8 = (MWNumericArray)topoData[7];
//		
//		MWCellArray t9 = (MWCellArray)realData[8];// add LC
		
		return null;
		
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
			
			task.setComputing(2);
			loadFlowDao.save(task);
			return ProtObj.success(compute);
		} catch(MWException mex) {
			mex.printStackTrace();
			task.setComputing(3);
			loadFlowDao.save(task);
			return ProtObj.fail(501, mex.toString());
		}
	}
	
}
