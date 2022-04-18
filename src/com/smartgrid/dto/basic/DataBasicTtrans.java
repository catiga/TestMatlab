 package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicTtrans {

     String[] onename;
     
     String[] twoname;
     
     String[] thrname;
     
     double[] v1;
     
     double[] v2;
     
     double[] v3;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicTtrans() {
         onename = new String[] {"¶õºìÊ¯ÆÂ220"};
         twoname = new String[] {"¶õºìÊ¯ÆÂ110"};
         thrname = new String[] {"¶õºìÊ¯ÆÂ11-1"};
         
         v1 = new double[] {230.0};
         v2 = new double[] {121.0};
         v3 = new double[] {10.5};
     }

    public String[] getOnename() {
        return onename;
    }

    public void setOnename(String[] onename) {
        this.onename = onename;
    }

    public String[] getTwoname() {
        return twoname;
    }

    public void setTwoname(String[] twoname) {
        this.twoname = twoname;
    }

    public String[] getThrname() {
        return thrname;
    }

    public void setThrname(String[] thrname) {
        this.thrname = thrname;
    }

    public double[] getV1() {
        return v1;
    }

    public void setV1(double[] v1) {
        this.v1 = v1;
    }

    public double[] getV2() {
        return v2;
    }

    public void setV2(double[] v2) {
        this.v2 = v2;
    }

    public double[] getV3() {
        return v3;
    }

    public void setV3(double[] v3) {
        this.v3 = v3;
    }
     
}
