 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultDtrans {

     MWCellArray transname;
     
     MWCellArray Jname;
     
     double[] JP;
     
     double[] JQ;
     
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
         
         Jname = new MWCellArray(new int[]{tmp_Jname.length,1});
         i = 1;
         for(String s : tmp_Jname) {
        	 int[] idx = new int[] {i++, 1};
        	 Jname.set(idx, s);
         }
    	 
    	 
    	 

         JP = new double[] {1.0};
         JQ = new double[] {1.0};
     }

    public MWCellArray getTransname() {
        return transname;
    }

    public void setTransname(MWCellArray transname) {
        this.transname = transname;
    }

    public MWCellArray getJname() {
        return Jname;
    }

    public void setJname(MWCellArray Jname) {
        this.Jname = Jname;
    }

    public double[] getJp() {
        return JP;
    }

    public void setJp(double[] JP) {
        this.JP = JP;
    }

    public double[] getJq() {
        return JQ;
    }

    public void setJq(double[] JQ) {
        this.JQ = JQ;
    }
     
}
