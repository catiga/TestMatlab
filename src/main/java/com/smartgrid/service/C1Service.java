package com.smartgrid.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.smartgrid.entity.C1BranchLevel;
import com.smartgrid.entity.C1BranchLevelArea;
import com.smartgrid.entity.C1BusLevel;
import com.smartgrid.entity.C1BusLevelArea;
import com.smartgrid.entity.C1ComponentRelibility;
import com.smartgrid.entity.C1GeneratorLevel;
import com.smartgrid.entity.C1GeneratorLevelArea;
import com.smartgrid.entity.C1LoadLevel;
import com.smartgrid.entity.C1NameShowLevel;
import com.smartgrid.entity.C1TableNodeLevelProvince;

@Service
public class C1Service {

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
	
	@Transactional(rollbackFor = Exception.class)
	public void removeBatchData(Long projId) {
		busLevelDao.deleteByProjId(projId);
		busLevelAreaDao.deleteByProjId(projId);
		branchLevelDao.deleteByProjId(projId);
		branchLevelAreaDao.deleteByProjId(projId);
		generatorLevelDao.deleteByProjId(projId);
		generatorLevelAreaDao.deleteByProjId(projId);
		nameShowLevelDao.deleteByProjId(projId);
		loadLevelDao.deleteByProjId(projId);
		tableNodeLevelProvinceDao.deleteByProjId(projId);
		componentRelibilityDao.deleteByProjId(projId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveRepaireTaskComputeData(double[][] busLevelData, double[][] branchLevelData, double[][] generatorLevelData,
			Map<String, List<String>> nameShowLevelArray,
			double[][] busLevelAreaArray, double[][] branchLevelAreaArray, double[][] generatorLevelAreaArray,
			List<Object[]> provinceDataArray,
			double[][] loadLevelAreaArray, double[][] componentRelibilityArray,
			Long projId) {
		//首先删除这个项目对应的工程数据
		this.removeBatchData(projId);
		
		this.saveBusLevel(busLevelData, projId);
		this.saveBusLevelArea(busLevelAreaArray, projId);
		this.saveBranchLevel(branchLevelData, projId);
		this.saveBranchLevelArea(branchLevelAreaArray, projId);
		this.saveGeneratorLevel(generatorLevelAreaArray, projId);
		this.saveGeneratorLevelArea(generatorLevelAreaArray, projId);
		this.saveNameShowLevel(nameShowLevelArray, projId);
		this.saveProvinceArea(provinceDataArray, projId);
		this.saveLoadLevel(loadLevelAreaArray, projId);
		this.saveComponentReliability(componentRelibilityArray, projId);
	}
	
	/********************************************************************************/
	@Transactional(rollbackFor = Exception.class)
	public void saveBusLevel(double[][] busLevelData, Long projId) {
		List<C1BusLevel> allData = new LinkedList<>();
		for(double[] x : busLevelData) {
			C1BusLevel c1 = new C1BusLevel(x, projId);
			allData.add(c1);
		}
		
		busLevelDao.saveAll(allData);
	}
	@Transactional(rollbackFor = Exception.class)
	public void saveBusLevelArea(double[][] busLevelAreaData, Long projId) {
		List<C1BusLevelArea> allData = new LinkedList<>();
		for(double[] x : busLevelAreaData) {
			C1BusLevelArea c1 = new C1BusLevelArea(x, projId);
			allData.add(c1);
		}
		
		busLevelAreaDao.saveAll(allData);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveBranchLevel(double[][] branchLevelData, Long projId) {
		List<C1BranchLevel> allData = new LinkedList<>();
		for(double[] x : branchLevelData) {
			C1BranchLevel c1 = new C1BranchLevel(x, projId);
			allData.add(c1);
		}
		
		branchLevelDao.saveAll(allData);
	}
	@Transactional(rollbackFor = Exception.class)
	public void saveBranchLevelArea(double[][] branchLevelAreaData, Long projId) {
		List<C1BranchLevelArea> allData = new LinkedList<>();
		for(double[] x : branchLevelAreaData) {
			C1BranchLevelArea c1 = new C1BranchLevelArea(x, projId);
			allData.add(c1);
		}
		
		branchLevelAreaDao.saveAll(allData);
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public void saveGeneratorLevel(double[][] generatorLevel, Long projId) {
		List<C1GeneratorLevel> allData = new LinkedList<>();
		for(double[] x : generatorLevel) {
			C1GeneratorLevel c1 = new C1GeneratorLevel(x, projId);
			allData.add(c1);
		}
		
		generatorLevelDao.saveAll(allData);
	}
	@Transactional(rollbackFor = Exception.class)
	public void saveGeneratorLevelArea(double[][] generatorLevelArea, Long projId) {
		List<C1GeneratorLevelArea> allData = new LinkedList<>();
		for(double[] x : generatorLevelArea) {
			C1GeneratorLevelArea c1 = new C1GeneratorLevelArea(x, projId);
			allData.add(c1);
		}
		
		generatorLevelAreaDao.saveAll(allData);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveLoadLevel(double[][] loadLevel, Long projId) {
		List<C1LoadLevel> allData = new LinkedList<>();
		for(double[] x : loadLevel) {
			C1LoadLevel c1 = new C1LoadLevel(x, projId);
			allData.add(c1);
		}
		
		loadLevelDao.saveAll(allData);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveNameShowLevel(Map<String, List<String>> nameShowLevelArray, Long projId) {
		List<C1NameShowLevel> allData = new LinkedList<>();
		for(String k : nameShowLevelArray.keySet()) {
			List<String> resultSet = nameShowLevelArray.get(k);
			int index = 0;
			for(String s : resultSet) {
				C1NameShowLevel c1 = new C1NameShowLevel(k, s, ++index, projId);
				allData.add(c1);
			}
		}
		nameShowLevelDao.saveAll(allData);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveComponentReliability(double[][] componentReli, Long projId) {
		List<C1ComponentRelibility> allData = new LinkedList<>();
		for(double[] x : componentReli) {
			C1ComponentRelibility c1 = new C1ComponentRelibility(x, projId);
			allData.add(c1);
		}
		componentRelibilityDao.saveAll(allData);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveProvinceArea(List<Object[]> provinceDataArray, Long projId) {
		List<C1TableNodeLevelProvince> allData = new LinkedList<>();
		for(Object[] x : provinceDataArray) {
			BigDecimal v1 = new BigDecimal(x[0].toString());
			String v2 = x[1].toString();
			BigDecimal v3 = new BigDecimal(x[2].toString());
			C1TableNodeLevelProvince c1 = new C1TableNodeLevelProvince(v1, v2, v3 , projId);
			allData.add(c1);
		}
		tableNodeLevelProvinceDao.saveAll(allData);
	}
}
