 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultDtrans {

     String[] transname;
     
     String[] jname;
     
     double[] jp;
     
     double[] jq;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultDtrans() {
         transname = new String[] {"TEST TRANSNAME"};
         jname = new String[] {"TEST JNAME"};
         jp = new double[] {1.0};
         jq = new double[] {1.0};
     }

    public String[] getTransname() {
        return transname;
    }

    public void setTransname(String[] transname) {
        this.transname = transname;
    }

    public String[] getJname() {
        return jname;
    }

    public void setJname(String[] jname) {
        this.jname = jname;
    }

    public double[] getJp() {
        return jp;
    }

    public void setJp(double[] jp) {
        this.jp = jp;
    }

    public double[] getJq() {
        return jq;
    }

    public void setJq(double[] jq) {
        this.jq = jq;
    }
     
}
