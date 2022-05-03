package com.smartgrid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

import com.smartgrid.dao.AclineDao;
import com.smartgrid.dao.AlternatorDao;
import com.smartgrid.dao.MolineDao;
import com.smartgrid.dao.Threew_transformerDao;
import com.smartgrid.dao.Tw_transformerDao;
import com.smartgrid.dao.RepaireTaskDao;

import com.smartgrid.dto.basic.DataBasic;
import com.smartgrid.dto.basic.DataBasicBranch;
import com.smartgrid.dto.basic.DataBasicBus;
import com.smartgrid.dto.basic.DataBasicDtrans;
import com.smartgrid.dto.basic.DataBasicGen;
import com.smartgrid.dto.basic.DataBasicTtrans;
import com.smartgrid.dto.maintancewire.branch;
import com.smartgrid.dto.original.Branch;
import com.smartgrid.dto.pfresult.DataPfresult;
import com.smartgrid.dto.pfwork.DataPfwork;
import com.smartgrid.entity.Acline;
import com.smartgrid.entity.Alternator;
import com.smartgrid.entity.Moline;
import com.smartgrid.entity.Threew_transformer;
import com.smartgrid.entity.Tw_transformer;

import calculate1.Calculate1;

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
	/**
	 *DataBasic
	 */
	public DataBasic buildDataBasic(Long projId) {
		List<Moline> projectMolineData = molineDao.findByProjId(projId);
		List<Acline> projectAclineData = aclineDao.findByProjId(projId);
		List<Alternator> projectAlternatorData = alternatorDao.findByProjId(projId);
		List<Threew_transformer> projectThreew_transformerData = threew_transformerDao.findByProjId(projId);
		List<Tw_transformer> projectTw_transformerData = tw_transformerDao.findByProjId(projId);
		
		
		
		List<String> busNameArrayList = new ArrayList<>();
		List<String> psNameArrayList = new ArrayList<>();
		List<Double> baseKvArrayList = new ArrayList<>();
		
		List<String> branchI_nameArrayList = new ArrayList<>();
		List<String> branchJ_nameArrayList = new ArrayList<>();
		List<Double> branchR1ArrayList = new ArrayList<>();
		List<Double> branchX1ArrayList = new ArrayList<>();
		List<Double> branchB1ArrayList = new ArrayList<>();
		List<Double> branchRatekaArrayList = new ArrayList<>();
		List<Double> branchUplimitArrayList = new ArrayList<>();
		List<String> branchTypeArrayList = new ArrayList<>();
		List<Long> branchIdno = new ArrayList<>();
		
		List<String> genId_nameArrayList = new ArrayList<>();
		
		List<String> ttransOnenameArrayList = new ArrayList<>();
		List<String> ttransTwonameArrayList = new ArrayList<>();
		List<String> ttransThrnameArrayList = new ArrayList<>();
		List<Double> ttransV1ArrayList = new ArrayList<>();
		List<Double> ttransV2ArrayList = new ArrayList<>();
		List<Double> ttransV3ArrayList = new ArrayList<>();
		
		List<String> dtransInameArrayList = new ArrayList<>();
		List<String> dtransJnameArrayList = new ArrayList<>();
		List<Double> dtransViArrayList = new ArrayList<>();
		List<Double> dtransVjArrayList = new ArrayList<>();
		
		for(Moline m : projectMolineData) {
			busNameArrayList.add(m.getBusName());
			psNameArrayList.add(m.getPsName());
			baseKvArrayList.add(m.getBaseKv().doubleValue());
		}
		
		for(Acline m : projectAclineData) {
			branchI_nameArrayList.add(m.getLname());
			branchJ_nameArrayList.add(m.getJ_name());
			branchR1ArrayList.add(m.getR1().doubleValue());
			branchX1ArrayList.add(m.getX1().doubleValue());
			branchB1ArrayList.add(m.getB1_half().doubleValue());
			branchRatekaArrayList.add(m.getRate_ka().doubleValue());
			branchUplimitArrayList.add(m.getUp_limit().doubleValue());
			branchTypeArrayList.add(m.getType());
			branchIdno.add(m.getId_no());
		}
		
		for(Alternator m : projectAlternatorData) {
			genId_nameArrayList.add(m.getId_name());
		}
		
		for(Threew_transformer m : projectThreew_transformerData) {
			ttransOnenameArrayList.add(m.getName_1());
			ttransTwonameArrayList.add(m.getName_2());
			ttransThrnameArrayList.add(m.getName_3());
			ttransV1ArrayList.add(m.getTap1().doubleValue());
			ttransV2ArrayList.add(m.getTap2().doubleValue());
			ttransV3ArrayList.add(m.getTap3().doubleValue());
		}
		
		for(Tw_transformer m : projectTw_transformerData) {
			dtransInameArrayList.add(m.getLname());
			dtransJnameArrayList.add(m.getJ_name());
			dtransViArrayList.add(m.getV0_tap1().doubleValue());
			dtransVjArrayList.add(m.getV0_tap2().doubleValue());
		}
		
		
		
		
		DataBasicBus basicBus = new DataBasicBus(busNameArrayList, baseKvArrayList, psNameArrayList);
		DataBasicBranch basicBranch = new DataBasicBranch(branchI_nameArrayList, branchJ_nameArrayList, branchTypeArrayList, branchUplimitArrayList, branchX1ArrayList, branchB1ArrayList, branchUplimitArrayList, branchRatekaArrayList, branchIdno);
		DataBasicGen basicGen = new DataBasicGen(genId_nameArrayList);
		DataBasicTtrans basicTtrans = new DataBasicTtrans(ttransOnenameArrayList, ttransTwonameArrayList, ttransThrnameArrayList, ttransV1ArrayList, ttransV2ArrayList, ttransV3ArrayList);
		DataBasicDtrans basicDtrans = new DataBasicDtrans(dtransInameArrayList, dtransJnameArrayList, dtransViArrayList, dtransVjArrayList);
				
		try {
			DataBasic basic = new DataBasic();
			basic.setBus(basicBranch.toM());
			basic.setBus(basicGen.toM());
			basic.setBus(basicTtrans.toM());
			basic.setBus(basicBus.toM());
			basic.setBus(basicDtrans.toM());

			return basic;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取busname数组数据方法
	 * @param projId
	 * @return
	 */
	
	
	/*
	 * public String[] buildBasicNameArray(Long projId) { List<Moline>
	 * projectMolineData = molineDao.findByProjId(projId); List<String> busNameArray
	 * = new ArrayList<String>(); for(Moline m : projectMolineData) {
	 * busNameArray.add(m.getBusName()); }
	 * 
	 * return busNameArray.toArray(new String[busNameArray.size()]); }
	 */
	
	
	public void compute() throws Exception {
		MWStructArray databasic = new DataBasic().toM();
        MWStructArray pfwork = new DataPfwork().toM();
        MWStructArray pfresult = new DataPfresult().toM();
        MWStructArray original = new Branch().toM();
        MWStructArray maintancewire = new branch().toM();
        
        System.out.println(databasic.toString());

        String[] maintancetarget = new String[] {"鄂红石坡220"};
        Double[][] reliability = {
        		{0.0,10.0,10.0},
        		{1.0,10.0,10.0},
        		{2.0,10.0,10.0},
        		{3.0,10.0,10.0},
        		{4.0,10.0,10.0},
        		{5.0,10.0,10.0},
        };
        
        // data for test CalculatePf
        double[][] case5_bus = {
        		{1.0 ,2.0 ,50.0 ,10.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{2.0 ,1.0 ,300.0 ,98.61 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{3.0 ,2.0 ,300.0 ,98.61 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{4.0 ,3.0 ,400.0 ,131.47 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{5.0 ,2.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9}
        };
        double[][] case5_branch = {
        		{1.0 ,2.0 ,0.00281 ,0.0281 ,0.00712 ,400.0 ,400.0 ,400.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{1.0 ,4.0 ,0.00304 ,0.0304 ,0.00658 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{1.0 ,5.0 ,0.00064 ,0.0064 ,0.03126 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{2.0 ,3.0 ,0.00108 ,0.0108 ,0.01852 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{3.0 ,4.0 ,0.00297 ,0.0297 ,0.00674 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{4.0 ,5.0 ,0.00297 ,0.0297 ,0.00674 ,240.0 ,240.0 ,240.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        };
        double[][] case5_generator = {
        		{1.0 ,40.0 ,0.0 ,30.0 ,-30.0 ,1.0 ,100.0 ,1.0 ,40.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{1.0 ,170.0 ,0.0 ,127.5 ,-127.5 ,1.0 ,100.0 ,1.0 ,170.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{3.0 ,323.49 ,0.0 ,390.0 ,-390.0 ,1.0 ,100.0 ,1.0 ,520.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{4.0 ,0.0 ,0.0 ,150.0 ,-150.0 ,1.0 ,100.0 ,1.0 ,200.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{5.0 ,466.51 ,0.0 ,450.0 ,-450.0 ,1.0 ,100.0 ,1.0 ,600.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		
        };
        // data for CalculateTopo
        int[] cdims = {5,3};
        MWCellArray case5_Tables_level = new MWCellArray(cdims);
        String[] tmp_name = new String[]{"鄂红石坡220","今天","明天","昨天","后天"};
        int i = 1;
        for(String s : tmp_name) {
       	 int[] idx1 = new int[] {i, 2};
       	 int[] idx2 = new int[] {i, 1};
       	 int[] idx3 = new int[] {i, 3};
       	case5_Tables_level.set(idx1, s);
       	case5_Tables_level.set(idx2, i);
       	case5_Tables_level.set(idx3, 1.0);
       	i = i+1;
        }
        
        
        String substation_target = "鄂红石坡220";
        
        int[] cdims1 = {3,2};
        MWCellArray exMatchIn = new MWCellArray(cdims1);
        exMatchIn.set(new int[]{1, 1},"今天");
        exMatchIn.set(new int[]{1, 2},1.0);
        exMatchIn.set(new int[]{2, 1},"昨天");
        exMatchIn.set(new int[]{2, 2},2.0);
        exMatchIn.set(new int[]{3, 1},"后天");
        exMatchIn.set(new int[]{3, 2},3.0);
        
        
        double[][] Table_mainwire = {
        		{0.0},{0.0},{0.0},{0.0},{0.0},{0.0},{0.0},{0.0},{0.0},{1.0},{1.0},{1.0},{1.0},{1.0}
        };
        
       // data for riskAssessSingle
        double[][] branch_numbers = {
        		{1.0},{2.0},{3.0},{4.0},{5.0},{6.0},{7.0},{8.0},{9.0},{10.0},{11.0},{12.0},{13.0},{14.0},{15.0},{16.0},{17.0},{18.0},{19.0},{20.0},{23.0}
        };
        double[][] branch_type = {
        		{0.0},{0.0},{0.0},{0.0},{0.0},{0.0},{1.0},{2.0},{1.0},{1.0},{2.0},{1.0},{1.0},{2.0},{1.0},{4.0},{1.0},{2.0},{1.0},{3.0},{0.0}
        };
        double[][] nodes_type = {
        		{0.0},{0.0},{0.0},{0.0},{0.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0},{1.0}
        };
        double[][] bus_maintance_set_one = {
        		{1.0 ,2.0 ,50.0 ,10.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{2.0 ,1.0 ,300.0 ,98.61 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{3.0 ,2.0 ,300.0 ,98.61 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{4.0 ,3.0 ,400.0 ,131.47 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{5.0 ,2.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{6.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{7.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{8.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{9.0 ,4.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{10.0 ,4.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{11.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{12.0 ,41.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{13.0 ,4.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{14.0 ,4.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{15.0 ,4.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{16.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{17.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{18.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{19.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        		{20.0 ,1.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,0.0 ,230.0 ,1.0 ,1.1 ,0.9},
        };
        double[][] branch_maintance_set_one = {
        		{6.0 ,2.0 ,0.00281 ,0.0281 ,0.00712 ,400.0 ,400.0 ,400.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{7.0 ,4.0 ,0.00304 ,0.0304 ,0.00658 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{8.0 ,5.0 ,0.00064 ,0.0064 ,0.03126 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{2.0 ,3.0 ,0.00108 ,0.0108 ,0.01852 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{3.0 ,4.0 ,0.00297 ,0.0297 ,0.00674 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{4.0 ,5.0 ,0.00297 ,0.0297 ,0.00674 ,240.0 ,240.0 ,240.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{6.0 ,9.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{9.0 ,10.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{10.0 ,11.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{7.0 ,12.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{12.0 ,13.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{13.0 ,11.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{8.0 ,14.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{14.0 ,15.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{15.0 ,11.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,0.0 ,-360.0 ,360.0},
        		{11.0 ,16.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{16.0 ,17.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{17.0 ,18.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{18.0 ,19.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{19.0 ,20.0 ,0.0 ,0.000001 ,0.0 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        		{7.0 ,8.0 ,0.0037 ,0.0378 ,0.0378 ,5000.0 ,5000.0 ,5000.0 ,0.0 ,0.0 ,1.0 ,-360.0 ,360.0},
        };
        double[][] generator_maintance_set_one = {
        		{1.0 ,40.0 ,0.0 ,30.0 ,-30.0 ,1.0 ,100.0 ,1.0 ,40.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{1.0 ,170.0 ,0.0 ,127.5 ,-127.5 ,1.0 ,100.0 ,1.0 ,170.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{3.0 ,323.49 ,0.0 ,390.0 ,-390.0 ,1.0 ,100.0 ,1.0 ,520.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{4.0 ,0.0 ,0.0 ,150.0 ,-150.0 ,1.0 ,100.0 ,1.0 ,200.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        		{5.0 ,466.51 ,0.0 ,450.0 ,-450.0 ,1.0 ,100.0 ,1.0 ,600.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0 ,0.0},
        };
        
        
      
        //Calculate1
        Calculate1 c = new Calculate1();
        Object [] results = c.calculate1(10, 100.0, 0.95, 1.05, 230, databasic, pfwork, pfresult,maintancetarget,reliability,original);
        for (int i1=0;i1<results.length;i1++) {
          System.out.println(results[i1]);
        }
	}
}
