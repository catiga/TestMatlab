 package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBranch {

     MWCellArray lname;
     
     MWCellArray jname;
     
     Double[] rvalue;
     
     Double[] xvalue;
     
     Double[] bvalue;
     
     Double[] rateka;
     
     Double[] uplimit;
     
     MWCellArray type;
     
     Long[] id;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicBranch(List<String> tmp_Iname, List<String> tmp_Jname, List<String> tmp_type,  List<Double> tmp_uplimit, List<Double> tmp_rvalue, List<Double> tmp_xvalue, List<Double> tmp_bvalue, List<Double> tmp_rateka, List<Long> tmp_id) {
    	 this.bvalue = tmp_bvalue.toArray(new Double[tmp_bvalue.size()]);
    	 this.id = tmp_id.toArray(new Long[tmp_id.size()]);
    	 this.rateka = tmp_rateka.toArray(new Double[tmp_rateka.size()]);
    	 this.uplimit = tmp_uplimit.toArray(new Double[tmp_uplimit.size()]);
    	 this.rvalue = tmp_rvalue.toArray(new Double[tmp_rvalue.size()]);
    	 this.xvalue = tmp_xvalue.toArray(new Double[tmp_xvalue.size()]);
//    	 this.type = tmp_type.toArray(new Integer[tmp_type.size()]);
    	 
    	 
     	lname = new MWCellArray(new int[]{tmp_Iname.size(), 1});
         int i = 1;
         for(String s : tmp_Iname) {
             int[] idx = new int[] {i++, 1};
             lname.set(idx, s);
         }
         i = 1;
         jname = new MWCellArray(new int[] {tmp_Jname.size(), 1});
         for(String s : tmp_Jname) {
             int[] idx = new int[] {i++, 1};
             jname.set(idx, s);
         }
         type = new MWCellArray(new int[] {tmp_type.size(), 1});
         for(String s : tmp_type) {
             int[] idx = new int[] {i++, 1};
             type.set(idx, s);
         }
     
     
     
     }
  
     

		/*
		 * public DataBasicBranch() { // String[] tmp_Iname = new
		 * String[]{"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"}
		 * ; String[] tmp_Jname = new
		 * String[]{"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
		 * String[] tmp_type = new String[]{"0","0","0","0","0","0","0"}; //
		 * double[][] tmp_rvalue = new double[7][1]; // double[][] tmp_xvalue = new
		 * double[7][1]; // double[][] tmp_bvalue = new double[7][1]; // int[][]
		 * tmp_rateka = new int[7][1]; // int[][] tmp_uplimit = new int[7][1]; //
		 * int[][] tmp_id = new int[7][1]; //
		 * 
		 * for(int k = 0; k<7; k++) { tmp_rvalue[k][0] = k+1.0; } for(int k = 0; k<7;
		 * k++) { tmp_id[k][0] = k+1; } for(int k = 0; k<7; k++) { tmp_xvalue[k][0] =
		 * k+1.0; } for(int k = 0; k<7; k++) { tmp_bvalue[k][0] = k+1.0; } for(int k =
		 * 0; k<7; k++) { tmp_rateka[k][0] = k+1; } for(int k = 0; k<7; k++) {
		 * tmp_uplimit[k][0] = k+1; }
		 * 
		 * 
		 * lname = new MWCellArray(new int[]{tmp_Iname.length,1}); int i = 1; for(String
		 * s : tmp_Iname) { int[] idx = new int[] {i++, 1}; lname.set(idx, s); }
		 * 
		 * jname = new MWCellArray(new int[]{tmp_Jname.length,1}); i = 1; for(String s :
		 * tmp_Jname) { int[] idx = new int[] {i++, 1}; jname.set(idx, s); }
		 * 
		 * type = new MWCellArray(new int[]{tmp_type.length,1}); i = 1; for(String s :
		 * tmp_type) { int[] idx = new int[] {i++, 1}; type.set(idx, s); }
		 * 
		 * 
		 * 
		 * rvalue = tmp_rvalue;
		 * 
		 * 
		 * xvalue = tmp_xvalue;
		 * 
		 * bvalue = tmp_bvalue;
		 * 
		 * rateka = tmp_rateka;
		 * 
		 * uplimit = tmp_uplimit;
		 * 
		 * 
		 * 
		 * id = tmp_id; }
		 */

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

    public Double[] getRvalue() {
        return rvalue;
    }

    public void setRvalue(Double[] rvalue) {
        this.rvalue = rvalue;
    }

    public Double[] getXvalue() {
        return xvalue;
    }

    public void setXvalue(Double[] xvalue) {
        this.xvalue = xvalue;
    }

    public Double[] getBvalue() {
        return bvalue;
    }

    public void setBvalue(Double[] bvalue) {
        this.bvalue = bvalue;
    }

    public Double[] getRateka() {
        return rateka;
    }

    public void setRateka(Double[] rateka) {
        this.rateka = rateka;
    }

    public Double[] getUplimit() {
        return uplimit;
    }

    public void setUplimit(Double[] uplimit) {
        this.uplimit = uplimit;
    }

    public MWCellArray getType() {
        return type;
    }

    public void setType(MWCellArray type) {
        this.type = type;
    }

    public Long[] getId() {
        return id;
    }

    public void setId(Long[] id) {
        this.id = id;
    }
     
}
