package com.smartgrid.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartgrid.dao.C1BranchLevelDao;
import com.smartgrid.dao.C1BusLevelDao;
import com.smartgrid.dao.C1GeneratorLevelDao;
import com.smartgrid.dao.C1TableProvinceAreaDao;
import com.smartgrid.entity.C1BranchLevel;
import com.smartgrid.entity.C1BusLevel;

@Service
public class C1Service {

	@Autowired
	private C1BusLevelDao busLevelDao;
	
	@Autowired
	private C1BranchLevelDao branchLevelDao;
	
	@Autowired
	private C1GeneratorLevelDao generatorLevelDao;
	
	@Autowired
	private C1TableProvinceAreaDao provinceAreaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public void saveRepaireTaskComputeData(double[][] busLevelData, double[][] branchLevelData, double[][] generatorLevelData,
			Map<String, List<String>> nameShowLevelArray,
			double[][] busLevelAreaArray, double[][] branchLevelAreaArray, double[][] generatorLevelAreaArray,
			List<Object[]> provinceDataArray,
			double[][] loadLevelAreaArray, double[][] componentRelibilityArray,
			Long projId) {
		//首先删除这个项目对应的工程数据
		busLevelDao.deleteByProjId(projId);
		List<C1BusLevel> allData = new LinkedList<>();
		for(double[] x : busLevelData) {
			System.out.println(x);
			C1BusLevel c1 = new C1BusLevel(x, projId);
			allData.add(c1);
		}
		
		busLevelDao.saveAll(allData);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void saveBranchLevel(double[][] busLevelData, Long projId) {
		//首先删除这个项目对应的工程数据
		branchLevelDao.deleteByProjId(projId);
		List<C1BranchLevel> allData = new LinkedList<>();
		for(double[] x : busLevelData) {
			System.out.println(x);
			C1BranchLevel c1 = new C1BranchLevel(x, projId);
			allData.add(c1);
		}
		
		branchLevelDao.saveAll(allData);
	}
}
