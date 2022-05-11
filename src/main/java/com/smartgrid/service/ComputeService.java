package com.smartgrid.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWException;
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
import com.smartgrid.entity.C1BranchLevelArea;
import com.smartgrid.entity.C1BusLevelArea;
import com.smartgrid.entity.C1GeneratorLevelArea;
import com.smartgrid.entity.C1TableNodeLevelProvince;
import com.smartgrid.response.ProtObj;

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
	
	public ProtObj computePf(Long projId, BigDecimal sBase) {
		List<C1BusLevelArea> busLevelAreaData = busLevelAreaDao.findByProjId(projId);
		List<C1BranchLevelArea> branchLevelAreaData = branchLevelAreaDao.findByProjId(projId);
		List<C1GeneratorLevelArea> generatorLevelAreaData = generatorLevelAreaDao.findByProjId(projId);
		List<C1TableNodeLevelProvince> tableNodeAreaData = tableNodeLevelProvinceDao.findByProjId(projId);
		
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
			Object [] result = pfComputer.calculatePf(10, sBase.doubleValue(), busLevelArray, branchLevelArray, generatorLevelArray, tableNodeArray);
			
			return ProtObj.success(result);
		} catch(MWException mex) {
			mex.printStackTrace();
			return ProtObj.fail(501, mex.toString());
		}
	}
	
}
