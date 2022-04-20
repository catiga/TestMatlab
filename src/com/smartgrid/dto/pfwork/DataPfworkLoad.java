 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkLoad {

     MWCellArray name;
     
     double[] PL;
     
     double[] QL;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkLoad() {
    	 
    	 String[] tmp_name = new String[]{"鄂红石坡110"};
    	 
         name = new MWCellArray(new int[]{tmp_name.length,1});
         int i = 1;
         for(String s : tmp_name) {
        	 int[] idx = new int[] {i++, 1};
        	 name.set(idx, s);
         }
        
    	 
    	 //name = new String[] {"鄂红石坡110"};
         PL = new double[] {1.0};
         QL = new double[] {1.0};
     }

    public MWCellArray getName() {
        return name;
    }

    public void setName(MWCellArray name) {
        this.name = name;
    }

    public double[] getPl() {
        return PL;
    }

    public void setPl(double[] PL) {
        this.PL = PL;
    }

    public double[] getQl() {
        return QL;
    }

    public void setQl(double[] QL) {
        this.QL = QL;
    }
     
}
