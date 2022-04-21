 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkLoad {

     MWCellArray name;
     
     double[] pl;
     
     double[] ql;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkLoad() {
    	 
    	 String[] tmp_name = new String[]{"鄂红石坡220"};
    	 
         name = new MWCellArray(new int[]{tmp_name.length,1});
         int i = 1;
         for(String s : tmp_name) {
        	 int[] idx = new int[] {i++, 1};
        	 name.set(idx, s);
         }
        
    	 
    	 //name = new String[] {"鄂红石坡110"};
         pl = new double[] {1.0};
         ql = new double[] {1.0};
     }

    public MWCellArray getName() {
        return name;
    }

    public void setName(MWCellArray name) {
        this.name = name;
    }

    public double[] getPl() {
        return pl;
    }

    public void setPl(double[] pl) {
        this.pl = pl;
    }

    public double[] getQl() {
        return ql;
    }

    public void setQl(double[] ql) {
        this.ql = ql;
    }
     
}
