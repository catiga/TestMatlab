package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicDtrans {

    String[] lname;

    String[] jname;

    double[] vi;

    double[] vj;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicDtrans() {
        lname = new String[] {"TEST LNAME"};
        jname = new String[] {"TEST JNAME"};
        vi = new double[] {1.0};
        vj = new double[] {1.0};
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

    public double[] getVi() {
        return vi;
    }

    public void setVi(double[] vi) {
        this.vi = vi;
    }

    public double[] getVj() {
        return vj;
    }

    public void setVj(double[] vj) {
        this.vj = vj;
    }

}
