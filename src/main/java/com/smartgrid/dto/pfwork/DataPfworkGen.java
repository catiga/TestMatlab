 package com.smartgrid.dto.pfwork;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.AlternatorTrend;

public class DataPfworkGen {

     Integer[][] valid;
     
     double[][] v0;
     
     double[][] angle;
     
     double[][] qmax;
     
     double[][] qmin;
     
     double[][] pmax;
     
     double[][] pmin;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkGen(List<AlternatorTrend> data) {
    	 valid = new Integer[data.size()][1];
    	 v0 = new double[data.size()][1];
    	 angle = new double[data.size()][1];
    	 qmax = new double[data.size()][1];
    	 qmin = new double[data.size()][1];
    	 pmax = new double[data.size()][1];
    	 pmin = new double[data.size()][1];

    	 
    	 for(int i = 0; i < data.size(); i++) {
    		 AlternatorTrend tmpObj = data.get(i);
    		 valid[i][0] = tmpObj.getValid();
    		 v0[i][0] = tmpObj.getV0().doubleValue();
    		 angle[i][0] = tmpObj.getAngle().doubleValue(); 
    		 qmax[i][0] = tmpObj.getQmax().doubleValue();
    		 qmin[i][0] = tmpObj.getQmin().doubleValue(); 
    		 pmax[i][0] = tmpObj.getPmax().doubleValue();
    		 pmin[i][0] = tmpObj.getPmin().doubleValue(); 
 		}
    	 
    	 
    	 
    
     
    
     
}

	public Integer[][] getValid() {
		return valid;
	}

	public void setValid(Integer[][] valid) {
		this.valid = valid;
	}

	public double[][] getV0() {
		return v0;
	}

	public void setV0(double[][] v0) {
		this.v0 = v0;
	}

	public double[][] getAngle() {
		return angle;
	}

	public void setAngle(double[][] angle) {
		this.angle = angle;
	}

	public double[][] getQmax() {
		return qmax;
	}

	public void setQmax(double[][] qmax) {
		this.qmax = qmax;
	}

	public double[][] getQmin() {
		return qmin;
	}

	public void setQmin(double[][] qmin) {
		this.qmin = qmin;
	}

	public double[][] getPmax() {
		return pmax;
	}

	public void setPmax(double[][] pmax) {
		this.pmax = pmax;
	}

	public double[][] getPmin() {
		return pmin;
	}

	public void setPmin(double[][] pmin) {
		this.pmin = pmin;
	}
}