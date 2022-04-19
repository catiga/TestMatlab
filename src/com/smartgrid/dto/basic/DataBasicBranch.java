 package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBranch {

     MWCellArray lname;
     
     MWCellArray jname;
     
     double[] rvalue;
     
     double[] xvalue;
     
     double[] bvalue;
     
     int[] rateka;
     
     int[] uplimit;
     
     String[] type;
     
     int[] id;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicBranch() {
         String[] tmp_Iname = new String[]{"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
         String[] tmp_Jname = new String[]{"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
    	 
         lname = new MWCellArray(new int[]{tmp_Iname.length,1});
         int i = 1;
         for(String s : tmp_Iname) {
        	 int[] idx = new int[] {i++, 1};
        	 lname.set(idx, s);
         }
         
         jname = new MWCellArray(new int[]{tmp_Jname.length,1});
         i = 1;
         for(String s : tmp_Jname) {
        	 int[] idx = new int[] {i++, 1};
        	 jname.set(idx, s);
         }
    	 //lname = new String[] {"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
         
    	 //jname = new String[] {"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
        
    	 rvalue = new double[] {1.0,1.0,1.0,1.0,1.0,1.0,1.0};
         
         xvalue = new double[] {1.0,1.0,1.0,1.0,1.0,1.0,1.0};
         
         bvalue = new double[] {1.0,1.0,1.0,1.0,1.0,1.0,1.0};
         
         rateka = new int[] {1,1,1,1,1,1,1};
         
         uplimit = new int[] {1,1,1,1,1,1,1};
         
         type = new String[] {"0","0","0","0","0","0","0"};
         
         id = new int[] {1,2,3,4,5,6,7};
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

    public double[] getRvalue() {
        return rvalue;
    }

    public void setRvalue(double[] rvalue) {
        this.rvalue = rvalue;
    }

    public double[] getXvalue() {
        return xvalue;
    }

    public void setXvalue(double[] xvalue) {
        this.xvalue = xvalue;
    }

    public double[] getBvalue() {
        return bvalue;
    }

    public void setBvalue(double[] bvalue) {
        this.bvalue = bvalue;
    }

    public int[] getRateka() {
        return rateka;
    }

    public void setRateka(int[] rateka) {
        this.rateka = rateka;
    }

    public int[] getUplimit() {
        return uplimit;
    }

    public void setUplimit(int[] uplimit) {
        this.uplimit = uplimit;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
     
}
