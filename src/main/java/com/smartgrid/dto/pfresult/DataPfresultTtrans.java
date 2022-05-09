 package com.smartgrid.dto.pfresult;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.ThreewTransformerResult;
import com.smartgrid.entity.TwTransformerResult;

public class DataPfresultTtrans {

     MWCellArray transname;
     
     MWCellArray onename;
     
     MWCellArray twoname;
     
     MWCellArray thrname;
     
     double[][] onep;
     
     double[][] oneq;
     
     double[][] twop;
     
     double[][] twoq;
     
     double[][] thrp;
     
     double[][] thrq;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultTtrans(List<ThreewTransformerResult> data) {
    	 
    	 onep = new double[data.size()][1];
    	 twop = new double[data.size()][1];
    	 thrp = new double[data.size()][1];
    	 oneq = new double[data.size()][1];
    	 twoq = new double[data.size()][1];
    	 thrq = new double[data.size()][1];
    	 String[]tmp_transname = new String[data.size()];
    	 String[]tmp_onename = new String[data.size()];
    	 String[]tmp_twoname = new String[data.size()];
    	 String[]tmp_thrname = new String[data.size()];
    	 for(int i = 0; i < data.size(); i++) {
    		 ThreewTransformerResult tmpObj = data.get(i);
    		 onep[i][0] = tmpObj.getActive_power_generation1().doubleValue();
    		 twop[i][0] = tmpObj.getActive_power_generation2().doubleValue();
    		 thrp[i][0] = tmpObj.getActive_power_generation3().doubleValue();
    		 oneq[i][0] = tmpObj.getReactive_power_generation1().doubleValue();
    		 twoq[i][0] = tmpObj.getReactive_power_generation2().doubleValue();
    		 thrq[i][0] = tmpObj.getReactive_power_generation3().doubleValue();
    		 tmp_transname[i] = tmpObj.getName();
    		 tmp_onename[i] = tmpObj.getSide_bus1(); 
    		 tmp_twoname[i] = tmpObj.getSide_bus2(); 
    		 tmp_thrname[i] = tmpObj.getSide_bus3(); 
 		}
    	 
    	 transname = new MWCellArray(new int[]{tmp_transname.length, 1});
    	 onename = new MWCellArray(new int[]{tmp_onename.length, 1});
    	 twoname = new MWCellArray(new int[]{tmp_twoname.length, 1});
    	 thrname = new MWCellArray(new int[]{tmp_thrname.length, 1});
    	 int i = 1;
         for(String s : tmp_transname) {
             int[] idx = new int[] {i++, 1};
             transname.set(idx, s);
         }
         i = 1;
         for(String s : tmp_onename) {
             int[] idx = new int[] {i++, 1};
             onename.set(idx, s);
         }
         i = 1;
         for(String s : tmp_twoname) {
             int[] idx = new int[] {i++, 1};
             twoname.set(idx, s);
         }
         i = 1;
         for(String s : tmp_thrname) {
             int[] idx = new int[] {i++, 1};
             thrname.set(idx, s);
         }
    	 
    	 
    	 
     }

	public MWCellArray getTransname() {
		return transname;
	}

	public void setTransname(MWCellArray transname) {
		this.transname = transname;
	}

	public MWCellArray getOnename() {
		return onename;
	}

	public void setOnename(MWCellArray onename) {
		this.onename = onename;
	}

	public MWCellArray getTwoname() {
		return twoname;
	}

	public void setTwoname(MWCellArray twoname) {
		this.twoname = twoname;
	}

	public MWCellArray getThrname() {
		return thrname;
	}

	public void setThrname(MWCellArray thrname) {
		this.thrname = thrname;
	}

	public double[][] getOnep() {
		return onep;
	}

	public void setOnep(double[][] onep) {
		this.onep = onep;
	}

	public double[][] getOneq() {
		return oneq;
	}

	public void setOneq(double[][] oneq) {
		this.oneq = oneq;
	}

	public double[][] getTwop() {
		return twop;
	}

	public void setTwop(double[][] twop) {
		this.twop = twop;
	}

	public double[][] getTwoq() {
		return twoq;
	}

	public void setTwoq(double[][] twoq) {
		this.twoq = twoq;
	}

	public double[][] getThrp() {
		return thrp;
	}

	public void setThrp(double[][] thrp) {
		this.thrp = thrp;
	}

	public double[][] getThrq() {
		return thrq;
	}

	public void setThrq(double[][] thrq) {
		this.thrq = thrq;
	}

   
     
}
