 package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBranch {

     MWCellArray Iname;
     
     MWCellArray Jname;
     
     double[] Rvalue;
     
     double[] Xvalue;
     
     double[] Bvalue;
     
     int[] Rateka;
     
     int[] uplimit;
     
     String[] type;
     
     int[] ID;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicBranch() {
         String[] tmp_Iname = new String[]{"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
         String[] tmp_Jname = new String[]{"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
    	 
         Iname = new MWCellArray(new int[]{tmp_Iname.length,1});
         int i = 1;
         for(String s : tmp_Iname) {
        	 int[] idx = new int[] {i++, 1};
        	 Iname.set(idx, s);
         }
         
         Jname = new MWCellArray(new int[]{tmp_Jname.length,1});
         i = 1;
         for(String s : tmp_Jname) {
        	 int[] idx = new int[] {i++, 1};
        	 Jname.set(idx, s);
         }
    	 //lname = new String[] {"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
         
    	 //jname = new String[] {"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
        
    	 Rvalue = new double[] {1.0,1.0,1.0,1.0,1.0,1.0,1.0};
         
         Xvalue = new double[] {1.0,1.0,1.0,1.0,1.0,1.0,1.0};
         
         Bvalue = new double[] {1.0,1.0,1.0,1.0,1.0,1.0,1.0};
         
         Rateka = new int[] {1,1,1,1,1,1,1};
         
         uplimit = new int[] {1,1,1,1,1,1,1};
         
         type = new String[] {"0","0","0","0","0","0","0"};
         
         ID = new int[] {1,2,3,4,5,6,7};
     }

    public MWCellArray getLname() {
        return Iname;
    }

    public void setLname(MWCellArray Iname) {
        this.Iname = Iname;
    }

    public MWCellArray getJname() {
        return Jname;
    }

    public void setJname(MWCellArray Jname) {
        this.Jname = Jname;
    }

    public double[] getRvalue() {
        return Rvalue;
    }

    public void setRvalue(double[] Rvalue) {
        this.Rvalue = Rvalue;
    }

    public double[] getXvalue() {
        return Xvalue;
    }

    public void setXvalue(double[] Xvalue) {
        this.Xvalue = Xvalue;
    }

    public double[] getBvalue() {
        return Bvalue;
    }

    public void setBvalue(double[] Bvalue) {
        this.Bvalue = Bvalue;
    }

    public int[] getRateka() {
        return Rateka;
    }

    public void setRateka(int[] Rateka) {
        this.Rateka = Rateka;
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
        return ID;
    }

    public void setId(int[] ID) {
        this.ID = ID;
    }
     
}
