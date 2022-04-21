 package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicTtrans {

     MWCellArray onename;
     
     MWCellArray twoname;
     
     MWCellArray thrname;
     
     double[] v1;
     
     double[] v2;
     
     double[] v3;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicTtrans() {
    	 String[] tmp_onename = new String[]{"鄂红石坡220"};
         String[] tmp_twoname = new String[]{"鄂红石坡110"};
         String[] tmp_thrname = new String[]{"鄂红石坡11-1"};
         onename = new MWCellArray(new int[]{tmp_onename.length,1});
         int i = 1;
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
         
    	 //onename = new String[] {"鄂红石坡220"};
         //twoname = new String[] {"鄂红石坡110"};
         //thrname = new String[] {"鄂红石坡11-1"};
         
         v1 = new double[] {230.0};
         v2 = new double[] {121.0};
         v3 = new double[] {10.5};
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
