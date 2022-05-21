package com.smartgrid.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.dao.C1BranchLevelAreaDao;
import com.smartgrid.dao.C1BranchLevelDao;
import com.smartgrid.dao.C1BusLevelAreaDao;
import com.smartgrid.dao.C1BusLevelDao;
import com.smartgrid.dao.C1GeneratorLevelAreaDao;
import com.smartgrid.dao.C1GeneratorLevelDao;
import com.smartgrid.dao.C1TableNodeLevelProvinceDao;
import com.smartgrid.dao.CRiskComputeResultDao;
import com.smartgrid.dao.CTopoComputeResultDao;
import com.smartgrid.dao.CWeakComputeResultDao;
import com.smartgrid.dao.ComponentReliabilityDao;
import com.smartgrid.dao.Component_branchDao;//add-LC
import com.smartgrid.dao.CpfComputeResultDao;
import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.dao.TaskLoadFlowDao;
import com.smartgrid.dao.TaskOverhaulDao;
import com.smartgrid.dao.TaskRiskAssessDao;
import com.smartgrid.dao.TaskStationTopoDao;
import com.smartgrid.dao.TaskWeakDao;
import com.smartgrid.dto.original.Branch;
import com.smartgrid.entity.C1BranchLevelArea;
import com.smartgrid.entity.C1BusLevelArea;
import com.smartgrid.entity.C1GeneratorLevelArea;
import com.smartgrid.entity.C1TableNodeLevelProvince;
import com.smartgrid.entity.CRiskComputeResult;
import com.smartgrid.entity.CTopoComputeResult;
import com.smartgrid.entity.CWeakComputeResult;
import com.smartgrid.entity.ComponentBranch;//add-LC
import com.smartgrid.entity.ComponentReliability;
import com.smartgrid.entity.CpfComputeResult;
import com.smartgrid.entity.RepaireTask;//add-LC
import com.smartgrid.entity.TaskLoadFlow;
import com.smartgrid.entity.TaskOverhaul;
import com.smartgrid.entity.TaskRiskAssess;
import com.smartgrid.entity.TaskStationTopo;
import com.smartgrid.entity.TaskWeak;
import com.smartgrid.response.ProtObj;
import com.smartgrid.util.JackSonBeanMapper;
import com.smartgrid.util.ToolKit;

import CalculateAssess.Calculate7;
import CalculteTopo.CalculateTopo;
import calculateAnalyze.CalculateAnalyze;
import calculatePf.CalculatePf;
import riskAssessment.RiskAssessment;

@Service
public class ComputeService {

	@Autowired
	private C1BusLevelDao busLevelDao;
	@Autowired
	private C1BranchLevelDao branchLevelDao;
	@Autowired
	private C1GeneratorLevelDao generatorLevelDao;
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
	
	@Autowired
	private CTopoComputeResultDao topoResultDao;
	
	@Autowired
	private TaskRiskAssessDao taskRiskDao;
	
	@Autowired
	private CRiskComputeResultDao riskResultDao;
	
	@Autowired
	private ComponentReliabilityDao componentReliabilityDao;
	
	@Autowired
	private TaskWeakDao taskWeakDao;
	
	@Autowired
	private CWeakComputeResultDao weakResultDao;
	
	@Autowired
	private TaskOverhaulDao overhaulDao;
	
	public TaskOverhaul getOverhaulTask(Long id) {
		return overhaulDao.getOne(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateOverhaulTask(TaskOverhaul task) {
		overhaulDao.save(task);
	}
	
	public TaskWeak getWeakTask(Long id) {
		return taskWeakDao.getOne(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateWeakTask(TaskWeak task) {
		taskWeakDao.save(task);
	}
	
	public TaskRiskAssess getRiskTask(Long id) {
		return taskRiskDao.getOne(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateRiskTask(TaskRiskAssess task) {
		taskRiskDao.save(task);
	}
	
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
	
	@Transactional(rollbackFor = Exception.class)
	public ProtObj computeTopo(TaskStationTopo task) {
        List<RepaireTask> taskData = taskDao.findByProjId(task.getProjId());//add-LC
		if(taskData==null || taskData.isEmpty()) {
			return ProtObj.fail(403, "Task Data empty");//add-LC
		}
		String[] miantance_Target = new String[] {taskData.get(0).getStationName()};
        
        
        //bus_level_area、branch_level_area、generator_level_area、table_nodes_level_province
        List<C1BusLevelArea> busLevelAreaData = busLevelAreaDao.findByProjId(task.getProjId());
		List<C1BranchLevelArea> branchLevelAreaData = branchLevelAreaDao.findByProjId(task.getProjId());
		List<C1GeneratorLevelArea> generatorLevelAreaData = generatorLevelAreaDao.findByProjId(task.getProjId());
		List<C1TableNodeLevelProvince> tableNodeAreaData = tableNodeLevelProvinceDao.findByProjId(task.getProjId());
		
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
        
        // exMatchIn
		String nodeListData = task.getNodeList();
		String[] arrNodeListData = nodeListData.split(";");
		MWCellArray exMatchIn = new MWCellArray(new int[]{arrNodeListData.length, 2});
		for(int i=0; i<arrNodeListData.length; i++) {
			String[] oneNode = arrNodeListData[i].split(",");
			int[] idx1 = new int[] {i+1, 1};
			int[] idx2 = new int[] {i+1, 2};
			exMatchIn.set(idx1, Double.valueOf(oneNode[0]).doubleValue());
			exMatchIn.set(idx2, oneNode[1]);
		}
		
		//maintance_branch_original
		List<ComponentBranch> projectComponentBranchData = component_branchDao.findByProjId(task.getProjId());//add-LC
        if(projectComponentBranchData==null || projectComponentBranchData.isEmpty()) {
        	return ProtObj.fail(403, "Branch Data empty");
        }
		
		Branch branch = new Branch(projectComponentBranchData);//add-LC
		MWStructArray mainwire_original_branch = branch.toM();//add-LC
		
		//Table_mainwire_maintance_elements
		String topoListData = task.getTopoList();
		String[] arrTopoListData = topoListData.split(";");
		MWCellArray Table_mainwire_maintance_elements = new MWCellArray(new int[] {arrTopoListData.length, 1});
		for(int i=0; i<arrTopoListData.length; i++) {
			int[] idx = new int[] {i+1, 1};
			Table_mainwire_maintance_elements.set(idx, arrTopoListData[i]);
		}
		
		try {
			CalculateTopo topoComputer = new CalculateTopo();
			Object [] topoData = topoComputer.CalculteTopo(9, tableNodeArray, busLevelArray, generatorLevelArray,branchLevelArray, miantance_Target, exMatchIn, mainwire_original_branch, Table_mainwire_maintance_elements);
			
			MWNumericArray t1 = (MWNumericArray)topoData[0];
			MWNumericArray t2 = (MWNumericArray)topoData[1];
			MWNumericArray t3 = (MWNumericArray)topoData[2];
			MWNumericArray t4 = (MWNumericArray)topoData[3];
			MWNumericArray t5 = (MWNumericArray)topoData[4];
			MWNumericArray t6 = (MWNumericArray)topoData[5];
			MWNumericArray t7 = (MWNumericArray)topoData[6];
			MWNumericArray t8 = (MWNumericArray)topoData[7];
			MWCellArray t9 = (MWCellArray)topoData[8];
			
			int[][] nodes_type = (int[][])t1.toIntArray();
			double[][][] bus_maintance_sets_3D = (double[][][])t2.toDoubleArray();
			double[][][] branch_maintance_sets_3D = (double[][][])t3.toDoubleArray();
			double[][][] gen_maintance_sets_3D = (double[][][])t4.toDoubleArray();
			int[][] branch_Type = (int[][])t5.toIntArray();
			double[][] branch_numbers = (double[][])t6.toDoubleArray();
			int num_topo_maintance = t7.getInt();
			int flag_connect = t8.getInt();
			MWCellArray caseOutput = t9;
			
			StringBuilder nodesTypeStr = new StringBuilder();
			ToolKit.objectArrayToString(nodesTypeStr, 2, ToolKit.converArrayObject(nodes_type), 2);
			
			StringBuilder bus_maintance_sets_3DStr = new StringBuilder();
			ToolKit.objectArrayToString(bus_maintance_sets_3DStr, 3, ToolKit.converArrayObject(bus_maintance_sets_3D), 3);
			
			StringBuilder branch_maintance_sets_3DStr = new StringBuilder();
			ToolKit.objectArrayToString(branch_maintance_sets_3DStr, 3, ToolKit.converArrayObject(branch_maintance_sets_3D), 3);
			
			StringBuilder gen_maintance_sets_3DStr = new StringBuilder();
			ToolKit.objectArrayToString(gen_maintance_sets_3DStr, 3, ToolKit.converArrayObject(gen_maintance_sets_3D), 3);
			
			StringBuilder branch_TypeStr = new StringBuilder();
			ToolKit.objectArrayToString(branch_TypeStr, 2, ToolKit.converArrayObject(branch_Type), 2);
			
			StringBuilder branch_numbersStr = new StringBuilder();
			ToolKit.objectArrayToString(branch_numbersStr, 2, ToolKit.converArrayObject(branch_numbers), 2);
			
			String caseOutputStr = ToolKit.cellArrayToString3(caseOutput);
			
			CTopoComputeResult result = new CTopoComputeResult();
			result.setBranchMaintanceSets3d(branch_maintance_sets_3DStr.toString());
			result.setBranchNumbers(branch_numbersStr.toString());
			result.setBranchType(branch_TypeStr.toString());
			result.setBusMaintanceSets3d(bus_maintance_sets_3DStr.toString());
			result.setFlagConnect(flag_connect);
			result.setGenMaintanceSets3d(gen_maintance_sets_3DStr.toString());
			result.setNodesType(nodesTypeStr.toString());
			result.setNumTopoMaintance(num_topo_maintance);
			result.setProjId(task.getProjId());
			result.setTaskId(task.getId());
			result.setCaseOutput(caseOutputStr);
			
			topoResultDao.deleteByTaskId(task.getId());
			topoResultDao.save(result);
			
			task.setComputing(2);
			topoDao.save(task);
			
			return ProtObj.success(result);
		} catch(MWException mex) {
			mex.printStackTrace();
			task.setComputing(3);
			topoDao.save(task);
			return ProtObj.fail(501, mex.toString());
		}
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
//			String busStr = ToolKit.doubleArrayToString(busArray);
//			String branchStr = ToolKit.doubleArrayToString(branchArray);
//			String genStr = ToolKit.doubleArrayToString(genArray);
			
			StringBuilder busStrBuilder = new StringBuilder();
			ToolKit.objectArrayToString(busStrBuilder, 2, ToolKit.converArrayObject(busArray), 2);
			String busStr = busStrBuilder.toString();
			
			StringBuilder branchStrBuilder = new StringBuilder();
			ToolKit.objectArrayToString(branchStrBuilder, 2, ToolKit.converArrayObject(branchArray), 2);
			String branchStr = branchStrBuilder.toString();
			
			StringBuilder genStrBuilder = new StringBuilder();
			ToolKit.objectArrayToString(genStrBuilder, 2, ToolKit.converArrayObject(genArray), 2);
			String genStr = genStrBuilder.toString();
			
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
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public ProtObj computeRisk(TaskRiskAssess task) {
		CTopoComputeResult topoResult = topoResultDao.getOne(task.getTopoId());
		if(topoResult==null) {
			return ProtObj.fail(401, "topo compute result empty");
		}
		//开始组织数据
		String bus_maintance_sets_3d_str = topoResult.getBusMaintanceSets3d();
		String branch_maintance_sets_3d_str = topoResult.getBranchMaintanceSets3d();
		String gen_maintance_sets_3d_str = topoResult.getGenMaintanceSets3d();
		
		String branch_type_str = topoResult.getBranchType();
		String nodes_type_str = topoResult.getNodesType();
		String caseOutPutStr = topoResult.getCaseOutput();
		String caseNameStr = task.getTopoMethod();	//这里要取json里面的head的name
		String branch_numbers_str = topoResult.getBranchNumbers();
		
		//输入数据
		double[][][] bus_maintance_sets_3d = ToolKit.convert3ArrayFromString(bus_maintance_sets_3d_str);
		double[][][] branch_maintance_sets_3d = ToolKit.convert3ArrayFromString(branch_maintance_sets_3d_str);
		double[][][] gen_maintance_sets_3d = ToolKit.convert3ArrayFromString(gen_maintance_sets_3d_str);
		double[][] branch_numbers = ToolKit.convert2ArrayFromString(branch_numbers_str);
		double[][] branch_type = ToolKit.convert2ArrayFromString(branch_type_str);
		double[][] nodes_type = ToolKit.convert2ArrayFromString(nodes_type_str);
		
		String[] arrCaseOutPutStr = caseOutPutStr.split("\\|");
		String head_with_item = arrCaseOutPutStr[0];	// 方案1,方案2;鄂府河220,鄂府河220
		String head = head_with_item.split(";")[0];		// 方案名称列表
		String item = head_with_item.split(";")[1];		// 悬空节点列表
		
		List<List<String>> methods = new ArrayList<>();
		String[] arrHead = head.split(",");
		String[] arrItem = item.split(",");
		for(int i=0; i<arrHead.length; i++) {
			List<String> method_item = new ArrayList<>();	//格式：方案名称，悬空节点名称，方案明细一，方案明细二。。。。。。方案明细N
			method_item.add(arrHead[i]);
			method_item.add(arrItem[i]);
			
			for(int j=1; j<arrCaseOutPutStr.length; j++) { //格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				String[] arrMethodContents = arrCaseOutPutStr[j].split(";");	//格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				for(String s : arrMethodContents) {	//格式：鄂府河220,鄂府河220
					method_item.add(s.split(",")[i]);
				}
			}
			methods.add(method_item);
		}
		
		//caseOutput在matalb里为z*x*y
		int x = methods.size();//caseOutput在matalb里为
		int y = 2;
		int z = methods.get(0).size() / 2;
		MWCellArray caseOutPut = new MWCellArray(new int[] {x, y, z});
		for(int i=0; i<x; i++) {
			List<String> method = methods.get(i);	// [方案1, 鄂府河220, 鄂府河220, 鄂临空港220, 鄂府河220, 鄂临空港220]
			for(int j=0; j<z; j++) {      //caseoutput第j行
				for(int k=0; k<y; k++) {  //caseoutput第k列
					int [] idx = new int[] {j+1, k+1, i+1};
					int index = y*j +k;
					String value = method.get(index);
					caseOutPut.set(idx, value);
				}
			}
		}
		
		List<Map<String, Object>> caseNameList = JackSonBeanMapper.jsonToList(caseNameStr);
		Map<String, Object> tmp = (Map<String, Object>)caseNameList.get(0).get("head");
		String caseName = tmp.get("name").toString();
		
		List<ComponentReliability> relibilityData = componentReliabilityDao.findByProjId(task.getProjId());
		double[][] relibilityDataArray = new double[relibilityData.size()][3];
		
		int index = 0;
		for(ComponentReliability c : relibilityData) {
			relibilityDataArray[index][0] = new BigDecimal(c.getBranchType()).doubleValue();
			relibilityDataArray[index][1] = c.getFailureRate().doubleValue();
			relibilityDataArray[index][2] = c.getRepairTime().doubleValue();
			index++;
		}
		
		try {
			RiskAssessment calRiskAssess = new RiskAssessment();
			Object[] objects = calRiskAssess.riskAssessment(6, bus_maintance_sets_3d, branch_maintance_sets_3d, gen_maintance_sets_3d, branch_numbers, branch_type, relibilityDataArray, nodes_type, caseOutPut, caseName);
			MWNumericArray t0 = (MWNumericArray)objects[0];
			MWNumericArray t1 = (MWNumericArray)objects[1];
			MWNumericArray t2 = (MWNumericArray)objects[2];
			MWNumericArray t3 = (MWNumericArray)objects[3];
			MWNumericArray t4 = (MWNumericArray)objects[4];
			MWNumericArray t5 = (MWNumericArray)objects[5];
			
			CRiskComputeResult result = new CRiskComputeResult();
			result.setProjId(task.getProjId());
			result.setTaskId(task.getId());
			result.setMfs(BigDecimal.valueOf(t0.getDouble()));
			result.setEo(BigDecimal.valueOf(t1.getDouble()));
			result.setMhvs(BigDecimal.valueOf(t2.getDouble()));
			result.setMlvs(BigDecimal.valueOf(t3.getDouble()));
			result.setEhvv(BigDecimal.valueOf(t4.getDouble()));
			result.setElvv(BigDecimal.valueOf(t5.getDouble()));
			
			riskResultDao.deleteByTaskId(task.getId());
			riskResultDao.save(result);
			
			task.setComputing(2);
			taskRiskDao.save(task);
			
			return ProtObj.success(result);
		} catch(Exception e) {
			e.printStackTrace();
			task.setComputing(3);
			taskRiskDao.save(task);
			return ProtObj.fail(501, e.toString());
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ProtObj computeWeak(TaskWeak task) {

		CTopoComputeResult topoResult = topoResultDao.getOne(task.getTopoId());
		if(topoResult==null) {
			return ProtObj.fail(401, "topo compute result empty");
		}
		//开始组织数据
		String bus_maintance_sets_3d_str = topoResult.getBusMaintanceSets3d();
		String branch_maintance_sets_3d_str = topoResult.getBranchMaintanceSets3d();
		String gen_maintance_sets_3d_str = topoResult.getGenMaintanceSets3d();
		
		String branch_numbers_str = topoResult.getBranchNumbers();
		String branch_type_str = topoResult.getBranchType();
		List<ComponentReliability> relibilityData = componentReliabilityDao.findByProjId(task.getProjId());
		String nodes_type_str = topoResult.getNodesType();
		String caseOutPutStr = topoResult.getCaseOutput();
		
		String raCase = task.getTitle();	//用户输入的方案title
		// mainwire_original_branch 差这三个参数
		
		//获取潮流计算的bus_name
		List<CpfComputeResult> pfResults = pfResultDao.findByProjId(task.getProjId());
		CpfComputeResult pfResult = pfResults.get(0);
		String[] bus_name_array = pfResult.getBusName().split(",");
		MWCellArray bus_name = new MWCellArray(new int[] {bus_name_array.length + 1, 1});
		for(int i=0; i<bus_name_array.length; i++) {
			int[] idx = new int[] {i+1, 1};
			bus_name.set(idx, bus_name_array[i]);
		}
		
		//maintance_branch_original
		List<ComponentBranch> projectComponentBranchData = component_branchDao.findByProjId(task.getProjId());//add-LC
        if(projectComponentBranchData==null || projectComponentBranchData.isEmpty()) {
        	return ProtObj.fail(403, "Branch Data empty");
        }
		
		Branch branch = new Branch(projectComponentBranchData);//add-LC
		MWStructArray mainwire_original_branch = branch.toM();//add-LC
		
		List<RepaireTask> taskData = taskDao.findByProjId(task.getProjId());
		String[] maintance_Target = new String[] {taskData.get(0).getStationName()};
		
		List<C1BusLevelArea> busLevelAreaData = busLevelAreaDao.findByProjId(task.getProjId());
		double[][] bus_level_area = new double[busLevelAreaData.size()][13];
		for(int index=0; index<busLevelAreaData.size(); index++) {
			C1BusLevelArea d = busLevelAreaData.get(index);
        	bus_level_area[index][0] = d.getBla1().doubleValue();
        	bus_level_area[index][1] = d.getBla2().doubleValue();
        	bus_level_area[index][2] = d.getBla3().doubleValue();
        	bus_level_area[index][3] = d.getBla4().doubleValue();
        	bus_level_area[index][4] = d.getBla5().doubleValue();
        	bus_level_area[index][5] = d.getBla6().doubleValue();
        	bus_level_area[index][6] = d.getBla7().doubleValue();
        	bus_level_area[index][7] = d.getBla8().doubleValue();
        	bus_level_area[index][8] = d.getBla9().doubleValue();
        	bus_level_area[index][9] = d.getBla10().doubleValue();
        	bus_level_area[index][10] = d.getBla11().doubleValue();
        	bus_level_area[index][11] = d.getBla12().doubleValue();
        	bus_level_area[index][12] = d.getBla13().doubleValue();
        }
		
		//输入数据
		double[][][] bus_maintance_sets_3d = ToolKit.convert3ArrayFromString(bus_maintance_sets_3d_str);
		double[][][] branch_maintance_sets_3d = ToolKit.convert3ArrayFromString(branch_maintance_sets_3d_str);
		double[][][] gen_maintance_sets_3d = ToolKit.convert3ArrayFromString(gen_maintance_sets_3d_str);
//		double num_topo_maintance = 2d;	//方案数目
		
		double[][] branch_numbers = ToolKit.convert2ArrayFromString(branch_numbers_str);
		
		double[][] branch_type = ToolKit.convert2ArrayFromString(branch_type_str);
		
		double[][] nodes_type = ToolKit.convert2ArrayFromString(nodes_type_str);
		
		String[] arrCaseOutPutStr = caseOutPutStr.split("\\|");
		String head_with_item = arrCaseOutPutStr[0];	// 方案1,方案2;鄂府河220,鄂府河220
		String head = head_with_item.split(";")[0];		// 方案名称列表
		String item = head_with_item.split(";")[1];		// 悬空节点列表
		
		List<List<String>> methods = new ArrayList<>();
		String[] arrHead = head.split(",");
		String[] arrItem = item.split(",");
		for(int i=0; i<arrHead.length; i++) {
			List<String> method_item = new ArrayList<>();	//格式：方案名称，悬空节点名称，方案明细一，方案明细二。。。。。。方案明细N
			method_item.add(arrHead[i]);
			method_item.add(arrItem[i]);
			
			for(int j=1; j<arrCaseOutPutStr.length; j++) { //格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				String[] arrMethodContents = arrCaseOutPutStr[j].split(";");	//格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				for(String s : arrMethodContents) {	//格式：鄂府河220,鄂府河220
					method_item.add(s.split(",")[i]);
				}
			}
			methods.add(method_item);
		}
		
		//caseOutput在matalb里为z*x*y
		int x = methods.size();//caseOutput在matalb里为
		int y = 2;
		int z = methods.get(0).size() / 2;
		MWCellArray caseOutPut = new MWCellArray(new int[] {x, y, z});
		for(int i=0; i<x; i++) {
			List<String> method = methods.get(i);	// [方案1, 鄂府河220, 鄂府河220, 鄂临空港220, 鄂府河220, 鄂临空港220]
			for(int j=0; j<z; j++) {      //caseoutput第j行
				for(int k=0; k<y; k++) {  //caseoutput第k列
					int [] idx = new int[] {j+1, k+1, i+1};
					int index = y*j +k;
					String value = method.get(index);
					caseOutPut.set(idx, value);
				}
			}
		}
		
		double[][] relibilityDataArray = new double[relibilityData.size()][3];
		int index = 0;
		for(ComponentReliability c : relibilityData) {
			relibilityDataArray[index][0] = new BigDecimal(c.getBranchType()).doubleValue();
			relibilityDataArray[index][1] = c.getFailureRate().doubleValue();
			relibilityDataArray[index][2] = c.getRepairTime().doubleValue();
			index++;
		}
		
		try {
			CalculateAnalyze calAnalyze = new CalculateAnalyze();
			
			Object[] objects = calAnalyze.calculateAnalyze(2, bus_maintance_sets_3d, branch_maintance_sets_3d, gen_maintance_sets_3d, branch_numbers, branch_type, relibilityDataArray, nodes_type, caseOutPut, raCase, bus_name, mainwire_original_branch, maintance_Target, bus_level_area);
			MWCellArray t0 = (MWCellArray)objects[0];
			MWCellArray t1 = (MWCellArray)objects[1];
			
			CWeakComputeResult result = new CWeakComputeResult();
			result.setProjId(task.getProjId());
			result.setTaskId(task.getId());
			result.setWeakLoad(ToolKit.cellArrayToString2(t0));
			result.setWeakVoltage(ToolKit.cellArrayToString2(t1));
			
			weakResultDao.deleteByTaskId(task.getId());
			weakResultDao.save(result);
			
			task.setComputing(2);
			taskWeakDao.save(task);
			
			return ProtObj.success(1);
		} catch(Exception e) {
			e.printStackTrace();
			task.setComputing(3);
			taskWeakDao.save(task);
			return ProtObj.fail(501, e.toString());
		}
	}
	
	
	
	
	
	
	
	
	@Transactional(rollbackFor = Exception.class)
	public ProtObj computeOverhaul(TaskOverhaul task) {

		CTopoComputeResult topoResult = topoResultDao.getOne(task.getTopoId());
		if(topoResult==null) {
			return ProtObj.fail(401, "topo compute result empty");
		}
		//开始组织数据
		String bus_maintance_sets_3d_str = topoResult.getBusMaintanceSets3d();
		String branch_maintance_sets_3d_str = topoResult.getBranchMaintanceSets3d();
		String gen_maintance_sets_3d_str = topoResult.getGenMaintanceSets3d();
		
		String branch_numbers_str = topoResult.getBranchNumbers();
		String branch_type_str = topoResult.getBranchType();
		List<ComponentReliability> relibilityData = componentReliabilityDao.findByProjId(task.getProjId());
		String nodes_type_str = topoResult.getNodesType();
		String caseOutPutStr = topoResult.getCaseOutput();
		
		//maintance_branch_original
		List<ComponentBranch> projectComponentBranchData = component_branchDao.findByProjId(task.getProjId());//add-LC
        if(projectComponentBranchData==null || projectComponentBranchData.isEmpty()) {
        	return ProtObj.fail(403, "Branch Data empty");
        }
		
		//输入数据
		double[][][] bus_maintance_sets_3d = ToolKit.convert3ArrayFromString(bus_maintance_sets_3d_str);
		double[][][] branch_maintance_sets_3d = ToolKit.convert3ArrayFromString(branch_maintance_sets_3d_str);
		double[][][] gen_maintance_sets_3d = ToolKit.convert3ArrayFromString(gen_maintance_sets_3d_str);
//		double num_topo_maintance = 2d;	//方案数目
		
		double[][] branch_numbers = ToolKit.convert2ArrayFromString(branch_numbers_str);
		
		double[][] branch_type = ToolKit.convert2ArrayFromString(branch_type_str);
		
		double[][] nodes_type = ToolKit.convert2ArrayFromString(nodes_type_str);
		
		String[] arrCaseOutPutStr = caseOutPutStr.split("\\|");
		String head_with_item = arrCaseOutPutStr[0];	// 方案1,方案2;鄂府河220,鄂府河220
		String head = head_with_item.split(";")[0];		// 方案名称列表
		String item = head_with_item.split(";")[1];		// 悬空节点列表
		
		List<List<String>> methods = new ArrayList<>();
		String[] arrHead = head.split(",");
		String[] arrItem = item.split(",");
		for(int i=0; i<arrHead.length; i++) {
			List<String> method_item = new ArrayList<>();	//格式：方案名称，悬空节点名称，方案明细一，方案明细二。。。。。。方案明细N
			method_item.add(arrHead[i]);
			method_item.add(arrItem[i]);
			
			for(int j=1; j<arrCaseOutPutStr.length; j++) { //格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				String[] arrMethodContents = arrCaseOutPutStr[j].split(";");	//格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				for(String s : arrMethodContents) {	//格式：鄂府河220,鄂府河220
					method_item.add(s.split(",")[i]);
				}
			}
			methods.add(method_item);
		}
		
		MWCellArray caseSet = new MWCellArray(new int[] {arrHead.length, 1});
		for(int i=0 ;i<arrHead.length; i++) {
			int[] idx = new int[] {i+1, 1};
			caseSet.set(idx, arrHead[i]);
		}
		
		//caseOutput在matalb里为z*x*y
		int x = methods.size();//caseOutput在matalb里为
		int y = 2;
		int z = methods.get(0).size() / 2;
		MWCellArray caseOutPut = new MWCellArray(new int[] {x, y, z});
		for(int i=0; i<x; i++) {
			List<String> method = methods.get(i);	// [方案1, 鄂府河220, 鄂府河220, 鄂临空港220, 鄂府河220, 鄂临空港220]
			for(int j=0; j<z; j++) {      //caseoutput第j行
				for(int k=0; k<y; k++) {  //caseoutput第k列
					int [] idx = new int[] {j+1, k+1, i+1};
					int index = y*j +k;
					String value = method.get(index);
					caseOutPut.set(idx, value);
				}
			}
		}
		
		double[][] relibilityDataArray = new double[relibilityData.size()][3];
		int index = 0;
		for(ComponentReliability c : relibilityData) {
			relibilityDataArray[index][0] = new BigDecimal(c.getBranchType()).doubleValue();
			relibilityDataArray[index][1] = c.getFailureRate().doubleValue();
			relibilityDataArray[index][2] = c.getRepairTime().doubleValue();
			index++;
		}
		
		try {
			Calculate7 calAnalyze = new Calculate7();
			
			Object[] objects = calAnalyze.CalculateAssess(3, bus_maintance_sets_3d, branch_maintance_sets_3d, gen_maintance_sets_3d, 
					branch_numbers, branch_type, relibilityDataArray, nodes_type, 
					caseSet, caseOutPut);
			
//			MWCellArray t0 = (MWCellArray)objects[0];
//			MWCellArray t1 = (MWCellArray)objects[1];
//			
//			CWeakComputeResult result = new CWeakComputeResult();
//			result.setProjId(task.getProjId());
//			result.setTaskId(task.getId());
//			result.setWeakLoad(ToolKit.cellArrayToString2(t0));
//			result.setWeakVoltage(ToolKit.cellArrayToString2(t1));
//			
//			weakResultDao.deleteByTaskId(task.getId());
//			weakResultDao.save(result);
//			
//			task.setComputing(2);
//			taskWeakDao.save(task);
			
			return ProtObj.success(1);
		} catch(Exception e) {
			e.printStackTrace();
			task.setComputing(3);
			overhaulDao.save(task);
			return ProtObj.fail(501, e.toString());
		}
	}
}


























