 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultTtrans {

     String[] transname;
     
     String[] onename;
     
     String[] twoname;
     
     String[] thrname;
     
     double[] onep;
     
     double[] oneq;
     
     double[] twop;
     
     double[] twoq;
     
     double[] thrp;
     
     double[] thrq;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultTtrans() {
         transname = new String[] {"鄂红石坡站主变"};
         onename = new String[] {"鄂红石坡220"};
         twoname = new String[] {"鄂红石坡110"};
         thrname = new String[] {"鄂红石坡11-1"};
         onep = new double[] {1.0};
         oneq = new double[] {1.0};
         twop = new double[] {1.0};
         twoq = new double[] {1.0};
         thrp = new double[] {1.0};
         thrq = new double[] {1.0};
     }

    public String[] getTransname() {
        return transname;
    }

    public void setTransname(String[] transname) {
        this.transname = transname;
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

    public double[] getOnep() {
        return onep;
    }

    public void setOnep(double[] onep) {
        this.onep = onep;
    }

    public double[] getOneq() {
        return oneq;
    }

    public void setOneq(double[] oneq) {
        this.oneq = oneq;
    }

    public double[] getTwop() {
        return twop;
    }

    public void setTwop(double[] twop) {
        this.twop = twop;
    }

    public double[] getTwoq() {
        return twoq;
    }

    public void setTwoq(double[] twoq) {
        this.twoq = twoq;
    }

    public double[] getThrp() {
        return thrp;
    }

    public void setThrp(double[] thrp) {
        this.thrp = thrp;
    }

    public double[] getThrq() {
        return thrq;
    }

    public void setThrq(double[] thrq) {
        this.thrq = thrq;
    }
     
}
