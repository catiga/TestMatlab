import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.dto.basic.DataBasic;
import com.smartgrid.dto.maintancewire.branch;
import com.smartgrid.dto.original.Branch;
import com.smartgrid.dto.pfresult.DataPfresult;
import com.smartgrid.dto.pfwork.DataPfwork;

import CalculateAnalyze.Calculate6;
import CalculateAssess.Calculate7;
import calculatePf.CalculatePf;
//import CalculteTopo.Class4;
import calculate1.Calculate1;

public class RunMain {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        MWStructArray databasic = new DataBasic().toM();
        MWStructArray pfwork = new DataPfwork().toM();
        MWStructArray pfresult = new DataPfresult().toM();
        MWStructArray original = new Branch(null).toM();
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
        
        //CalculatePf
		/*
		 * // Calculate3 c3 = new Calculate3(); Object [] results3 = c3.CalculatePf(2,
		 * 100.0, case5_bus,case5_branch,case5_generator); for (int
		 * i2=0;i2<results3.length;i2++) { System.out.println(results3[i2]); }
		 */
        //CalculateTopo
		/*
		 * Class4 c4 = new Class4(); Object [] results4 =
		 * c4.CalculteTopo(7,case5_Tables_level,case5_bus,case5_generator,case5_branch,
		 * substation_target,exMatchIn,original,Table_mainwire); for (int
		 * i4=0;i4<results4.length;i4++) { System.out.println(results4[i4]); }
		 */
        
        //riskAssessmentSingle
//        riskass c5 = new Calculate5();
//        Object [] results5 = c5.riskAssessmentSingle(9,bus_maintance_set_one,branch_maintance_set_one,generator_maintance_set_one,branch_numbers,branch_type,reliability,nodes_type);
//        for (int i5=0;i5<results5.length;i5++) {
//          System.out.println(results5[i5]);
//        }
        
        //CalculateAnalyze
        Calculate6 c6 = new Calculate6();
        Object [] results6 = c6.CalculateAnalyze(5,bus_maintance_set_one,branch_maintance_set_one,generator_maintance_set_one,1.0,branch_numbers,branch_type,reliability,nodes_type);
        for (int i6=0;i6<results6.length;i6++) {
          System.out.println(results6[i6]);
        }
       
        //CalculateAssess-"defective jar"
        Calculate7 c7 = new Calculate7();
        Object [] results7 = c7.CalculateAssess(1,bus_maintance_set_one,branch_maintance_set_one,generator_maintance_set_one,1.0,branch_numbers,branch_type,reliability,nodes_type);
        System.out.println(results7);
    }

}
