 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultTtrans {

     MWCellArray transname;
     
     MWCellArray onename;
     
     MWCellArray twoname;
     
     MWCellArray thrname;
     
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
    	 String[] tmp_transname = new String[]{"鄂红石坡站主变"};
    	 String[] tmp_onename = new String[]{"鄂红石坡220"};
         String[] tmp_twoname = new String[]{"鄂红石坡110"};
         String[] tmp_thrname = new String[]{"鄂红石坡11-1"};
         transname = new MWCellArray(new int[]{tmp_transname.length,1});
         int i = 1;
         for(String s : tmp_transname) {
        	 int[] idx = new int[] {i++, 1};
        	 transname.set(idx, s);
         }
         
         onename = new MWCellArray(new int[]{tmp_onename.length,1});
         i = 1;
         for(String s : tmp_onename) {
        	 int[] idx = new int[] {i++, 1};
        	 onename.set(idx, s);
         }
         
         twoname = new MWCellArray(new int[]{tmp_twoname.length,1});
         i = 1;
         for(String s : tmp_twoname) {
        	 int[] idx = new int[] {i++, 1};
        	 twoname.set(idx, s);
         }
    	 
         thrname = new MWCellArray(new int[]{tmp_thrname.length,1});
         i = 1;
         for(String s : tmp_thrname) {
        	 int[] idx = new int[] {i++, 1};
        	 thrname.set(idx, s);
         }
    	 
    	 
    	 
    	 
    	 //transname = new String[] {"鄂红石坡站主变"};
         //onename = new String[] {"鄂红石坡220"};
         //twoname = new String[] {"鄂红石坡110"};
         //thrname = new String[] {"鄂红石坡11-1"};
         onep = new double[] {1.0};
         oneq = new double[] {1.0};
         twop = new double[] {1.0};
         twoq = new double[] {1.0};
         thrp = new double[] {1.0};
         thrq = new double[] {1.0};
     }

    public MWCellArray getTransname() {
        return transname;
    }

    public void setTransname(MWCellArray transname) {
        this.transname = transname;
    }

    public MWCellArray getOnename() {
        return onename;
    }

    public void setOnename(MWCellArray onename) {
        this.onename = onename;
    }

    public MWCellArray getTwoname() {
        return twoname;
    }

    public void setTwoname(MWCellArray twoname) {
        this.twoname = twoname;
    }

    public MWCellArray getThrname() {
        return thrname;
    }

    public void setThrname(MWCellArray thrname) {
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
