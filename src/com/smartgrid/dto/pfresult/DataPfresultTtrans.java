 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultTtrans {

     MWCellArray transname;
     
     MWCellArray onename;
     
     MWCellArray twoname;
     
     MWCellArray thrname;
     
     double[] oneP;
     
     double[] oneQ;
     
     double[] twoP;
     
     double[] twoQ;
     
     double[] thrP;
     
     double[] thrQ;
     
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
         oneP = new double[] {1.0};
         oneQ = new double[] {1.0};
         twoP = new double[] {1.0};
         twoQ = new double[] {1.0};
         thrP = new double[] {1.0};
         thrQ = new double[] {1.0};
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
        return oneP;
    }

    public void setOnep(double[] oneP) {
        this.oneP = oneP;
    }

    public double[] getOneq() {
        return oneQ;
    }

    public void setOneq(double[] oneQ) {
        this.oneQ = oneQ;
    }

    public double[] getTwop() {
        return twoP;
    }

    public void setTwoP(double[] twoP) {
        this.twoP = twoP;
    }

    public double[] getTwoq() {
        return twoQ;
    }

    public void setTwoq(double[] twoQ) {
        this.twoQ = twoQ;
    }

    public double[] getThrp() {
        return thrP;
    }

    public void setThrp(double[] thrP) {
        this.thrP = thrP;
    }

    public double[] getThrQ() {
        return thrQ;
    }

    public void setThrq(double[] thrQ) {
        this.thrQ = thrQ;
    }
     
}
