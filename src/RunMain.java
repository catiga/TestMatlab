import java.io.InterruptedIOException;

import com.google.gson.Gson;
import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWComplexity;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.dto.basic.DataBasic;
import com.smartgrid.dto.pfresult.DataPfresult;
import com.smartgrid.dto.pfwork.DataPfwork;
import com.smartgrid.dto.original.Branch;




import calculate1.Calculate1;



public class RunMain {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        int[] dims = {1, 2};
        MWNumericArray ii = MWNumericArray.newInstance(dims, MWClassID.DOUBLE, MWComplexity.REAL);
        
        MWStructArray databasic = new DataBasic().toM();
        MWStructArray pfwork = new DataPfwork().toM();
        MWStructArray pfresult = new DataPfresult().toM();
        MWStructArray original = new Branch().toM();
        
        
        System.out.println(databasic.toString());
        Gson g = new Gson();


        String[] maintancetarget = new String[] {"鄂红石坡220"};
        Double[][] reliability = {
        		{0.0,10.0,10.0},
        		{1.0,10.0,10.0},
        		{2.0,10.0,10.0},
        		{3.0,10.0,10.0},
        		{4.0,10.0,10.0},
        		{5.0,10.0,10.0},
        };
        
        
      
        //Calculate jar1
        Calculate1 c = new Calculate1();
        Object [] results = c.calculate1(10, 100, 0.95, 1.05, 230, databasic, pfwork, pfresult,maintancetarget,reliability,original);
        for (int i=0;i<results.length;i++) {
          System.out.println(results[i]);
        }
        
        

    }

}
