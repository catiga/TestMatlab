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
import com.smartgrid.dto.basic.DataBasic;
import com.smartgrid.dto.basic.DataBasicBranch;
import com.smartgrid.dto.basic.DataBasicBus;
import com.smartgrid.dto.basic.DataBasicDtrans;
import com.smartgrid.dto.basic.DataBasicGen;
import com.smartgrid.dto.basic.DataBasicTtrans;
import com.smartgrid.dto.maintancewire.branch;
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

import calculate1.Calculate1;
import testDataInput.TestDataInput;
import testDataInputPfwork.TestDataInputPfwork;
import testDataInputPfresult.TestDataInputPfresult;
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
	private ComponentReliabilityDao componentReliabilityDao;

	@Autowired
	private ProjectParamDao projectParamDao;

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

	public void compute(Long projId) throws Exception {
		MWStructArray databasic = this.buildDataBasic(projId).toM();
		MWStructArray pfwork = this.buildDataPfwork(projId).toM();
		MWStructArray pfresult = this.buildDataPfresult(projId).toM();
		MWStructArray original = this.buildbranch(projId).toM();
		MWStructArray maintancewire = new branch().toM();

		System.out.println(databasic.toString());

		String[] maintancetarget = new String[] { "鄂木兰220" };
		/*
		 * Double[][] reliability = { {0.0,10.0,10.0}, {1.0,10.0,10.0}, {2.0,10.0,10.0},
		 * {3.0,10.0,10.0}, {4.0,10.0,10.0}, {5.0,10.0,10.0}, };
		 */

		// data for test CalculatePf
		double[][] case5_bus = { { 1.0, 2.0, 50.0, 10.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 2.0, 1.0, 300.0, 98.61, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 3.0, 2.0, 300.0, 98.61, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 4.0, 3.0, 400.0, 131.47, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 5.0, 2.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 } };
		double[][] case5_branch = {
				{ 1.0, 2.0, 0.00281, 0.0281, 0.00712, 400.0, 400.0, 400.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 1.0, 4.0, 0.00304, 0.0304, 0.00658, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 1.0, 5.0, 0.00064, 0.0064, 0.03126, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 2.0, 3.0, 0.00108, 0.0108, 0.01852, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 3.0, 4.0, 0.00297, 0.0297, 0.00674, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 4.0, 5.0, 0.00297, 0.0297, 0.00674, 240.0, 240.0, 240.0, 0.0, 0.0, 1.0, -360.0, 360.0 }, };
		double[][] case5_generator = {
				{ 1.0, 40.0, 0.0, 30.0, -30.0, 1.0, 100.0, 1.0, 40.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0 },
				{ 1.0, 170.0, 0.0, 127.5, -127.5, 1.0, 100.0, 1.0, 170.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 },
				{ 3.0, 323.49, 0.0, 390.0, -390.0, 1.0, 100.0, 1.0, 520.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 },
				{ 4.0, 0.0, 0.0, 150.0, -150.0, 1.0, 100.0, 1.0, 200.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 },
				{ 5.0, 466.51, 0.0, 450.0, -450.0, 1.0, 100.0, 1.0, 600.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 },

		};
		// data for CalculateTopo
		int[] cdims = { 5, 3 };
		MWCellArray case5_Tables_level = new MWCellArray(cdims);
		String[] tmp_name = new String[] { "鄂红石坡220", "今天", "明天", "昨天", "后天" };
		int i = 1;
		for (String s : tmp_name) {
			int[] idx1 = new int[] { i, 2 };
			int[] idx2 = new int[] { i, 1 };
			int[] idx3 = new int[] { i, 3 };
			case5_Tables_level.set(idx1, s);
			case5_Tables_level.set(idx2, i);
			case5_Tables_level.set(idx3, 1.0);
			i = i + 1;
		}

		String substation_target = "鄂红石坡220";

		int[] cdims1 = { 3, 2 };
		MWCellArray exMatchIn = new MWCellArray(cdims1);
		exMatchIn.set(new int[] { 1, 1 }, "今天");
		exMatchIn.set(new int[] { 1, 2 }, 1.0);
		exMatchIn.set(new int[] { 2, 1 }, "昨天");
		exMatchIn.set(new int[] { 2, 2 }, 2.0);
		exMatchIn.set(new int[] { 3, 1 }, "后天");
		exMatchIn.set(new int[] { 3, 2 }, 3.0);

		double[][] Table_mainwire = { { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 },
				{ 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 } };

		// data for riskAssessSingle
		double[][] branch_numbers = { { 1.0 }, { 2.0 }, { 3.0 }, { 4.0 }, { 5.0 }, { 6.0 }, { 7.0 }, { 8.0 }, { 9.0 },
				{ 10.0 }, { 11.0 }, { 12.0 }, { 13.0 }, { 14.0 }, { 15.0 }, { 16.0 }, { 17.0 }, { 18.0 }, { 19.0 },
				{ 20.0 }, { 23.0 } };
		double[][] branch_type = { { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 1.0 }, { 2.0 }, { 1.0 },
				{ 1.0 }, { 2.0 }, { 1.0 }, { 1.0 }, { 2.0 }, { 1.0 }, { 4.0 }, { 1.0 }, { 2.0 }, { 1.0 }, { 3.0 },
				{ 0.0 } };
		double[][] nodes_type = { { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 0.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 },
				{ 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 } };
		double[][] bus_maintance_set_one = { { 1.0, 2.0, 50.0, 10.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 2.0, 1.0, 300.0, 98.61, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 3.0, 2.0, 300.0, 98.61, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 4.0, 3.0, 400.0, 131.47, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 5.0, 2.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 6.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 7.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 8.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 9.0, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 10.0, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 11.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 12.0, 41.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 13.0, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 14.0, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 15.0, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 16.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 17.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 18.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 19.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 },
				{ 20.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 230.0, 1.0, 1.1, 0.9 }, };
		double[][] branch_maintance_set_one = {
				{ 6.0, 2.0, 0.00281, 0.0281, 0.00712, 400.0, 400.0, 400.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 7.0, 4.0, 0.00304, 0.0304, 0.00658, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 8.0, 5.0, 0.00064, 0.0064, 0.03126, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 2.0, 3.0, 0.00108, 0.0108, 0.01852, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 3.0, 4.0, 0.00297, 0.0297, 0.00674, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 4.0, 5.0, 0.00297, 0.0297, 0.00674, 240.0, 240.0, 240.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 6.0, 9.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 9.0, 10.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 10.0, 11.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 7.0, 12.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 12.0, 13.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 13.0, 11.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 8.0, 14.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 14.0, 15.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 15.0, 11.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 0.0, -360.0, 360.0 },
				{ 11.0, 16.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 16.0, 17.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 17.0, 18.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 18.0, 19.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 19.0, 20.0, 0.0, 0.000001, 0.0, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 1.0, -360.0, 360.0 },
				{ 7.0, 8.0, 0.0037, 0.0378, 0.0378, 5000.0, 5000.0, 5000.0, 0.0, 0.0, 1.0, -360.0, 360.0 }, };
		double[][] generator_maintance_set_one = {
				{ 1.0, 40.0, 0.0, 30.0, -30.0, 1.0, 100.0, 1.0, 40.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0 },
				{ 1.0, 170.0, 0.0, 127.5, -127.5, 1.0, 100.0, 1.0, 170.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 },
				{ 3.0, 323.49, 0.0, 390.0, -390.0, 1.0, 100.0, 1.0, 520.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 },
				{ 4.0, 0.0, 0.0, 150.0, -150.0, 1.0, 100.0, 1.0, 200.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 },
				{ 5.0, 466.51, 0.0, 450.0, -450.0, 1.0, 100.0, 1.0, 600.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0 }, };
		
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
		
//		TestDataInput c = new TestDataInput();
//		Object[] results = c.testDataInput(25,databasic);
//		for (int i1 = 0; i1 < results.length; i1++) {
//			System.out.println(results[i1]);
//		}
		
//		TestDataInputPfwork c1 = new TestDataInputPfwork();
//		Object[] result1 = c1.testDataInputPfwork(17,pfwork);
//		for (int i1 = 0; i1 < result1.length; i1++) {
//			System.out.println(result1[i1]);
//		}
		
//		TestDataInputPfresult c2 = new TestDataInputPfresult();
//		Object[] result2 = c2.testDataInputPfresult(19,pfresult);
//		for (int i1 = 0; i1 < result2.length; i1++) {
//			System.out.println(result2[0]);
//		}
		
		// Calculate1
		Object[] objects = pfwork.toArray();
		Calculate1 c = new Calculate1();
		Object[] results = c.calculate1(10, 100.0, 0.95, 1.05, 230.0, databasic, pfwork, pfresult, maintancetarget,
				relibilityDataArray, original);
		System.out.println(results[4]);
		System.out.println(results[3]);
		/*
		 * for (int i1 = 0; i1 < results.length; i1++) {
		 * System.out.println(results[i1]); }
		 */
	}
}
