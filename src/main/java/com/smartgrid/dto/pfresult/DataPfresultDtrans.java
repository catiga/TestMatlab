 package com.smartgrid.dto.pfresult;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.TwTransformerResult;

public class DataPfresultDtrans {

     MWCellArray transname;
     
     MWCellArray jname;
     
     double[][] jp;
     
     double[][] jq;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultDtrans(List<TwTransformerResult> data) {
    	 jp = new double[data.size()][1];
    	 jq = new double[data.size()][1];
    	 String[]tmp_transname = new String[data.size()];
    	 String[]tmp_jname = new String[data.size()];
    	 for(int i = 0; i < data.size(); i++) {
    		 TwTransformerResult tmpObj = data.get(i);
    		 jp[i][0] = tmpObj.getC_active_power_generation().doubleValue();
    		 jq[i][0] = tmpObj.getC_reactive_power_generation().doubleValue();
    		 tmp_transname[i] = tmpObj.getName();
    		 tmp_jname[i] = tmpObj.getJ_cmx();  
 		}
    	 
    	 transname = new MWCellArray(new int[]{tmp_transname.length, 1});
    	 jname = new MWCellArray(new int[]{tmp_jname.length, 1});
    	 int i = 1;
         for(String s : tmp_transname) {
             int[] idx = new int[] {i++, 1};
             transname.set(idx, s);
         }
         i = 1;
         for(String s : tmp_jname) {
             int[] idx = new int[] {i++, 1};
             jname.set(idx, s);
         }
         
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

	public double[][] getJp() {
		return jp;
	}

	public void setJp(double[][] jp) {
		this.jp = jp;
	}

	public double[][] getJq() {
		return jq;
	}

	public void setJq(double[][] jq) {
		this.jq = jq;
	}

    
}
