package com.smartgrid.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.dao.AclineDao;
import com.smartgrid.dao.AclineTrendDao;
import com.smartgrid.dao.AlternatorDao;
import com.smartgrid.dao.AlternatorResultDao;
import com.smartgrid.dao.AlternatorTrendDao;
import com.smartgrid.dao.ComponentReliabilityDao;
import com.smartgrid.dao.Component_branchDao;
import com.smartgrid.dao.LoadTrendDao;
import com.smartgrid.dao.MolineDao;
import com.smartgrid.dao.ProjectParamDao;
import com.smartgrid.dao.RepaireTaskDao;
import com.smartgrid.dao.ThreewTransformerResultDao;
import com.smartgrid.dao.Threew_transformerDao;
import com.smartgrid.dao.TwTransformerResultDao;
import com.smartgrid.dao.Tw_transformerDao;
import com.smartgrid.dao.C1BusLevelAreaDao;
import com.smartgrid.dto.basic.DataBasic;
import com.smartgrid.dto.basic.DataBasicBranch;
import com.smartgrid.dto.basic.DataBasicBus;
import com.smartgrid.dto.basic.DataBasicDtrans;
import com.smartgrid.dto.basic.DataBasicGen;
import com.smartgrid.dto.basic.DataBasicTtrans;
import com.smartgrid.dto.original.Branch;
import com.smartgrid.dto.pfresult.DataPfresult;
import com.smartgrid.dto.pfresult.DataPfresultDtrans;
import com.smartgrid.dto.pfresult.DataPfresultGen;
import com.smartgrid.dto.pfresult.DataPfresultTtrans;
import com.smartgrid.dto.pfwork.DataPfwork;
import com.smartgrid.dto.pfwork.DataPfworkBranch;
import com.smartgrid.dto.pfwork.DataPfworkGen;
import com.smartgrid.dto.pfwork.DataPfworkLoad;
import com.smartgrid.entity.Acline;
import com.smartgrid.entity.AclineTrend;
import com.smartgrid.entity.Alternator;
import com.smartgrid.entity.AlternatorResult;
import com.smartgrid.entity.AlternatorTrend;
import com.smartgrid.entity.ComponentBranch;
import com.smartgrid.entity.ComponentReliability;
import com.smartgrid.entity.LoadTrend;
import com.smartgrid.entity.Moline;
import com.smartgrid.entity.ProjectParam;
import com.smartgrid.entity.RepaireTask;
import com.smartgrid.entity.ThreewTransformerResult;
import com.smartgrid.entity.Threew_transformer;
import com.smartgrid.entity.TwTransformerResult;
import com.smartgrid.entity.Tw_transformer;
import com.smartgrid.entity.C1BusLevelArea;


import calculate1.Calculate1;
import calculatePf.CalculatePf;



@Service
public class RepaireTaskService {

	@Autowired
	private RepaireTaskDao taskDao;

	@Autowired
	private MolineDao molineDao;

	@Autowired
	private AclineDao aclineDao;

	@Autowired
	private AlternatorDao alternatorDao;

	@Autowired
	private Threew_transformerDao threew_transformerDao;

	@Autowired
	private Tw_transformerDao tw_transformerDao;

	@Autowired
	private Component_branchDao component_branchDao;

	@Autowired
	private AclineTrendDao aclineTrendDao;

	@Autowired
	private AlternatorTrendDao alternatorTrendDao;

	@Autowired
	private LoadTrendDao loadTrendDao;

	@Autowired
	private AlternatorResultDao alternatorResultDao;

	@Autowired
	private TwTransformerResultDao twTransformerResultDao;

	@Autowired
	private ThreewTransformerResultDao threewTransformerResultDao;

	@Autowired
	private ComponentReliabilityDao C1BusLevelAreaDao;

	@Autowired
	private ProjectParamDao projectParamDao;
	
	@Autowired
	private ComponentReliabilityDao componentReliabilityDao;
	
	
	public void updateTask(RepaireTask task) {
		taskDao.save(task);
	}

	/**
	 * DataBasic
	 */
	public DataBasic buildDataBasic(Long projId) {
		List<Moline> projectMolineData = molineDao.findByProjId(projId);
		List<Acline> projectAclineData = aclineDao.findByProjId(projId);
		List<Alternator> projectAlternatorData = alternatorDao.findByProjId(projId);
		List<Threew_transformer> projectThreew_transformerData = threew_transformerDao.findByProjId(projId);
		List<Tw_transformer> projectTw_transformerData = tw_transformerDao.findByProjId(projId);

		DataBasicBus basicBus = new DataBasicBus(projectMolineData);
		DataBasicBranch basicBranch = new DataBasicBranch(projectAclineData);
		DataBasicGen basicGen = new DataBasicGen(projectAlternatorData);
		DataBasicTtrans basicTtrans = new DataBasicTtrans(projectThreew_transformerData);
		DataBasicDtrans basicDtrans = new DataBasicDtrans(projectTw_transformerData);

		try {
			DataBasic basic = new DataBasic();
			basic.setBranch(basicBranch.toM());
			basic.setGen(basicGen.toM());
			basic.setTtrans(basicTtrans.toM());
			basic.setBus(basicBus.toM());
			basic.setDtrans(basicDtrans.toM());

			return basic;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * original
	 */
	public Branch buildbranch(Long projId) {
		List<ComponentBranch> projectComponentBranchData = component_branchDao.findByProjId(projId);
		Branch original = new Branch(projectComponentBranchData);
		return original;
	}

	/**
	 * DataPfwork
	 */
	public DataPfwork buildDataPfwork(Long projId) {
		List<AclineTrend> projectAclineTrendData = aclineTrendDao.findByProjId(projId);
		List<AlternatorTrend> projectAlternatorTrendData = alternatorTrendDao.findByProjId(projId);
		List<LoadTrend> projectLoadTrendData = loadTrendDao.findByProjId(projId);

		DataPfworkBranch branch = new DataPfworkBranch(projectAclineTrendData);
		DataPfworkGen gen = new DataPfworkGen(projectAlternatorTrendData);
		DataPfworkLoad load = new DataPfworkLoad(projectLoadTrendData);

		try {
			DataPfwork pfwork = new DataPfwork();
			pfwork.setBranch(branch.toM());
			pfwork.setGen(gen.toM());
			pfwork.setLoad(load.toM());

			return pfwork;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * DataPfresult
	 */
	public DataPfresult buildDataPfresult(Long projId) {
		List<AlternatorResult> projectAlternatorResultData = alternatorResultDao.findByProjId(projId);
		List<TwTransformerResult> projectTwTransformerResultData = twTransformerResultDao.findByProjId(projId);
		List<ThreewTransformerResult> projectThreewTransformerResultData = threewTransformerResultDao
				.findByProjId(projId);

		DataPfresultDtrans dtrans = new DataPfresultDtrans(projectTwTransformerResultData);
		DataPfresultTtrans ttrans = new DataPfresultTtrans(projectThreewTransformerResultData);
		DataPfresultGen gen = new DataPfresultGen(projectAlternatorResultData);

		try {
			DataPfresult pfresult = new DataPfresult();
			pfresult.setDtrans(dtrans.toM());
			pfresult.setGen(gen.toM());
			pfresult.setTtrans(ttrans.toM());

			return pfresult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * reliability
	 */

	public Object[] compute(Long projId) throws Exception {
		MWStructArray databasic = this.buildDataBasic(projId).toM();
		MWStructArray pfwork = this.buildDataPfwork(projId).toM();
		MWStructArray pfresult = this.buildDataPfresult(projId).toM();
		MWStructArray original = this.buildbranch(projId).toM();
//		MWStructArray maintancewire = new branch().toM();

		//讀取reliability
		List<ComponentReliability> relibilityData = componentReliabilityDao.findByProjId(projId);
		double[][] relibilityDataArray = new double[relibilityData.size()][3];
		int index = 0;
		for(ComponentReliability c : relibilityData) {
			
			relibilityDataArray[index][0] = new BigDecimal(c.getBranchType()).doubleValue();
			relibilityDataArray[index][1] = c.getFailureRate().doubleValue();
			relibilityDataArray[index][2] = c.getRepairTime().doubleValue();
			index++;
		}

		// 基準值數據
		List<ProjectParam> projectParams = projectParamDao.findByProjId(projId);
		List<RepaireTask> taskData = taskDao.findByProjId(projId);
		
		RepaireTask task = taskData.get(0);
		
		String[] maintancetarget = new String[] {task.getStationName()};
		
		BigDecimal benchValue = BigDecimal.valueOf(0.0);
		BigDecimal vminValue = BigDecimal.valueOf(0.0);
		BigDecimal vmaxValue = BigDecimal.valueOf(0.0);
		
		for(ProjectParam pp : projectParams) {
			if(pp.getParamK().equals("bench_value")) {
				benchValue = pp.getParamV();
			} else if(pp.getParamK().equals("vmin_value")) {
				vminValue = pp.getParamV();
			} else if(pp.getParamK().equals("vmax_value")) {
				vmaxValue = pp.getParamV();
			}
		}
	
		// Calculate1
		Calculate1 c = new Calculate1();
		Object[] results = c.calculate1(10, benchValue.doubleValue(), vminValue.doubleValue(), vmaxValue.doubleValue(), task.getBaseKv().doubleValue(), databasic, pfwork, pfresult, maintancetarget,
				relibilityDataArray, original);
		
//		return results;
		
		/**
		 * 测试calculatepf
		 * 从数据库读取bus_level_area、branch_level_area、generator_level_area
		 */
//		List<C1BusLevelArea> c1BusLevelArea = C1BusLevelAreaDao.findByProjId(projId);
//		double[][] relibilityDataArray = new double[relibilityData.size()][3];
//		int index = 0;
//		for(ComponentReliability c : relibilityData) {
			
//			relibilityDataArray[index][0] = new BigDecimal(c.getBranchType()).doubleValue();
//			relibilityDataArray[index][1] = c.getFailureRate().doubleValue();
//			relibilityDataArray[index][2] = c.getRepairTime().doubleValue();
//			index++;
//		}
		
		
		
		
		// CalculatePf
		CalculatePf cpf = new CalculatePf();
		Object[] result1 = cpf.calculatePf(10,benchValue.doubleValue(),results[4],results[5] ,results[6],results[7]);
		
		MWCellArray busname = (MWCellArray)result1[6];
		
		return results;
	}
}
