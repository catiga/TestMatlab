 package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.Acline;
import com.smartgrid.entity.Moline;

public class DataBasicBranch {

     MWCellArray lname;
     
     MWCellArray jname;
     
     double[][] rvalue;
     
     double[][] xvalue;
     
     double[][] bvalue;
     
     double[][] rateka;
     
     double[][] uplimit;
     
     MWCellArray type;
     
     Long[][] id;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicBranch(List<Acline> data) {
    	 rvalue = new double[data.size()][1];
    	 xvalue = new double[data.size()][1];
    	 bvalue = new double[data.size()][1];
    	 rateka = new double[data.size()][1];
    	 uplimit = new double[data.size()][1];
    	 id = new Long[data.size()][1];
    	 String[]tmp_lname = new String[data.size()];
    	 String[]tmp_jname = new String[data.size()];
    	 String[]tmp_type = new String[data.size()];
    	 
    	 for(int i = 0; i < data.size(); i++) {
    		 Acline tmpObj = data.get(i);
    		 rvalue[i][0] = tmpObj.getR1().doubleValue();
    		 xvalue[i][0] = tmpObj.getX1().doubleValue();
    		 bvalue[i][0] = tmpObj.getB1_half().doubleValue();
    		 rateka[i][0] = tmpObj.getRate_ka().doubleValue();
    		 uplimit[i][0] = tmpObj.getUp_limit().doubleValue();
    		 id[i][0] = tmpObj.getId_no();
    		 tmp_lname[i] = tmpObj.getLname(); 
    		 tmp_jname[i] = tmpObj.getJ_name(); 
    		 tmp_type[i] = tmpObj.getType(); 
 		}
    	 
    	 lname = new MWCellArray(new int[]{tmp_lname.length, 1});
    	 jname = new MWCellArray(new int[]{tmp_jname.length, 1});
    	 type = new MWCellArray(new int[]{tmp_type.length, 1});
    	 int i = 1;
         for(String s : tmp_lname) {
             int[] idx = new int[] {i++, 1};
             lname.set(idx, s);
         }
         i = 1;
         for(String s : tmp_jname) {
             int[] idx = new int[] {i++, 1};
             jname.set(idx, s);
         }
         i = 1;
         for(String s : tmp_type) {
             int[] idx = new int[] {i++, 1};
             type.set(idx, s);
         }
         
     }

	public MWCellArray getLname() {
		return lname;
	}

	public void setLname(MWCellArray lname) {
		this.lname = lname;
	}

	public MWCellArray getJname() {
		return jname;
	}

	public void setJname(MWCellArray jname) {
		this.jname = jname;
	}

	public double[][] getRvalue() {
		return rvalue;
	}

	public void setRvalue(double[][] rvalue) {
		this.rvalue = rvalue;
	}

	public double[][] getXvalue() {
		return xvalue;
	}

	public void setXvalue(double[][] xvalue) {
		this.xvalue = xvalue;
	}

	public double[][] getBvalue() {
		return bvalue;
	}

	public void setBvalue(double[][] bvalue) {
		this.bvalue = bvalue;
	}

	public double[][] getRateka() {
		return rateka;
	}

	public void setRateka(double[][] rateka) {
		this.rateka = rateka;
	}

	public double[][] getUplimit() {
		return uplimit;
	}

	public void setUplimit(double[][] uplimit) {
		this.uplimit = uplimit;
	}

	public MWCellArray getType() {
		return type;
	}

	public void setType(MWCellArray type) {
		this.type = type;
	}

	public Long[][] getId() {
		return id;
	}

	public void setId(Long[][] id) {
		this.id = id;
	}
  
     

     
}
