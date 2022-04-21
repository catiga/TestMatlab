 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultDtrans {

     MWCellArray transname;
     
     MWCellArray jname;
     
     double[] jp;
     
     double[] jq;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultDtrans() {
    	 String[] tmp_transname = new String[]{"鄂黄新厂#9主变"};
         String[] tmp_Jname = new String[]{"鄂黄新厂220"};
    	 
         
         transname = new MWCellArray(new int[]{tmp_transname.length,1});
         int i = 1;
         for(String s : tmp_transname) {
        	 int[] idx = new int[] {i++, 1};
        	 transname.set(idx, s);
         }
         
         jname = new MWCellArray(new int[]{tmp_Jname.length,1});
         i = 1;
         for(String s : tmp_Jname) {
        	 int[] idx = new int[] {i++, 1};
        	 jname.set(idx, s);
         }
    	 
    	 
    	 

         jp = new double[] {1.0};
         jq = new double[] {1.0};
     }

    public MWCellArray getTransname() {
        return transname;
    }

    public void setTransname(MWCellArray transname) {
        this.transname = transname;
    }

    public MWCellArray getJname() {
        return jname;
    }

    public void setJname(MWCellArray jname) {
        this.jname = jname;
    }

    public double[] getJp() {
        return jp;
    }

    public void setJp(double[] jp) {
        this.jp = jp;
    }

    public double[] getJq() {
        return jq;
    }

    public void setJq(double[] jq) {
        this.jq = jq;
    }
     
}
