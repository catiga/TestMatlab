 package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBranch {

     String[] lname;
     
     String[] jname;
     
     double[] rvalue;
     
     double[] xvalue;
     
     double[] bvalue;
     
     int[] rateka;
     
     int[] uplimit;
     
     int[] type;
     
     int[] id;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicBranch() {
         lname = new String[] {"TEST LNAME"};
         jname = new String[] {"TEST JNAME"};
         rvalue = new double[] {1.0};
         
         xvalue = new double[] {1.0};
         
         bvalue = new double[] {1.0};
         
         rateka = new int[] {1};
         
         uplimit = new int[] {1};
         
         type = new int[] {1};
         
         id = new int[] {1};
     }

    public String[] getLname() {
        return lname;
    }

    public void setLname(String[] lname) {
        this.lname = lname;
    }

    public String[] getJname() {
        return jname;
    }

    public void setJname(String[] jname) {
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

    public int[] getType() {
        return type;
    }

    public void setType(int[] type) {
        this.type = type;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
     
}
