import com.google.gson.Gson;
import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWComplexity;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.dto.basic.DataBasic;
import com.smartgrid.dto.pfresult.DataPfresult;
import com.smartgrid.dto.pfwork.DataPfwork;

import dataInput.Class1;
//import voltage2.Class2;
import dataInput_0419_01.Class3;
import dataInput_0419_02.Class4;
import dataInput_0419_03.Class5;
import dataInput_noncz.Class7;
import testfor_transname.Class8;
import testfor_transoneP.Class9;

public class RunMain {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        int[] dims = {1, 2};
        MWNumericArray ii = MWNumericArray.newInstance(dims, MWClassID.DOUBLE, MWComplexity.REAL);
        
        MWStructArray databasic = new DataBasic().toM();
        MWStructArray pfwork = new DataPfwork().toM();
        MWStructArray pfresult = new DataPfresult().toM();
        
        System.out.println(databasic.toString());
        Gson g = new Gson();
        System.out.println(g.toJson(databasic));
        System.out.println(g.toJson(pfwork));
        System.out.println(g.toJson(pfresult));
//        dataInput.jar for testing the data structure
//        Class1 c = new Class1();
//        Object[] results = c.dataInput(3, 100, 0.95, 1.05, 230, databasic, pfwork, pfresult);
//        System.out.println(results[0]);
        // dataInput_0419_01.jar for testing gbk or utf in Matlab : original
//        Class3 c1 = new Class3();
//        Object[] rs1 = c1.dataInput_0419_01(1, 230, databasic);
//        for (int i=0; i<rs1.length; i++) {
//        	 System.out.println(rs1[i]);
//        }
       // dataInput_0419_02.jar for testing gbk or utf in Matlab : try to change
//       Class4 c2 = new Class4();
//        Object[] rs2 = c2.dataInput_0419_02(1, 230, databasic);
//        for (int i=0; i<rs2.length; i++) {
//        	 System.out.println(rs2[i]);
//        }
       // dataInput_0419_03 try to change
//        Class5 c3 = new Class5();
//        Object[] rs3 = c3.dataInput_0419_03(1, 230, databasic);
//        for (int i=0; i<rs3.length; i++) {
//        	 System.out.println(rs3[i]);
//        }
        // dataInput_noncz: non Chinese
//        Class7 c7 = new Class7();
//        Object[] rs7 = c7.dataInput_noncz(3, 100, 0.95, 1.05, 230, databasic, pfwork, pfresult);
//        for (int i=0; i<rs7.length; i++) {
//        	 System.out.println(rs7[i]);
//       }
        // 0420-test if pfresults.ttrans.transname can be delivered :Yes
        Class8 c8 = new Class8();
        Object[] rs8 = c8.testfor_transname(1, pfresult);
        System.out.println(rs8[0]);
       // 0420-test if pfresults.ttrans.oneP can be delivered :
        Class9 c9 = new Class9();
        Object[] rs9 = c9.testfor_transoneP(1, pfresult);
        System.out.println(rs9[0]);
        
        
        
        
        
//       MWNumericArray para1 = MWNumericArray.newInstance(new int[] {1}, new int[] {1}, MWClassID.INT32);
//        MWCellArray para2 = new MWCellArray(new int[] {2, 2});
//        for(int i=0; i<2; i++) {
//            for(int j=0; j<2; j++) {
//                Object arg1 = null;
//                if(j==0) {
//                    arg1 = "测试" + i;
//                } else {
//                    arg1 = i;
//                }
//                int[] idx = {i+1, j+1};
//                para2.set(idx, arg1);
//            }
//        }
//        
//        Object[] objarray = (para2.toArray());
//        for(Object o : objarray) {
//            System.out.println(o);
//        }
//        
//        MWNumericArray para3 = MWNumericArray.newInstance(new int[] {2, 2}, MWClassID.INT64, MWComplexity.REAL);
//
//        Class1 c = new Class1();
//        Object result = c.Test0417_2(3, para1, para2, para3);
//        System.out.println(result);
    }

}
