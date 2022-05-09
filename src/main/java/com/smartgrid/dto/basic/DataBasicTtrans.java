 package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.Threew_transformer;
import com.smartgrid.entity.Tw_transformer;

public class DataBasicTtrans {

     MWCellArray onename;
     
     MWCellArray twoname;
     
     MWCellArray thrname;
     
     double[][] v1;
     
     double[][] v2;
     
     double[][] v3;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataBasicTtrans(List<Threew_transformer> data) {

    	 v1 = new double[data.size()][1];
       	 v2 = new double[data.size()][1];
       	 v3 = new double[data.size()][1];
       	 String[]tmp_onename = new String[data.size()];
       	 String[]tmp_twoname = new String[data.size()];
       	 String[]tmp_thrname = new String[data.size()];
       	 
       	 for(int i = 0; i < data.size(); i++) {
       		Threew_transformer tmpObj = data.get(i);
       		 v1[i][0] = tmpObj.getTap1().doubleValue();
       		 v2[i][0] = tmpObj.getTap2().doubleValue();
       		 v3[i][0] = tmpObj.getTap3().doubleValue();
       		 tmp_onename[i] = tmpObj.getName_1(); 
       		 tmp_twoname[i] = tmpObj.getName_2(); 
       		 tmp_thrname[i] = tmpObj.getName_3(); 
    		}
       	 
       	 onename = new MWCellArray(new int[]{tmp_onename.length, 1});
       	 twoname = new MWCellArray(new int[]{tmp_twoname.length, 1});
         thrname = new MWCellArray(new int[]{tmp_thrname.length, 1});
       	 
         int i = 1;
            for(String s : tmp_onename) {
                int[] idx = new int[] {i++, 1};
                onename.set(idx, s);
            }
            i = 1;
            for(String s : tmp_twoname) {
                int[] idx = new int[] {i++, 1};
                twoname.set(idx, s);
            }
            i = 1;
            for(String s : tmp_thrname) {
                int[] idx = new int[] {i++, 1};
                thrname.set(idx, s);
            }
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

	public double[][] getV1() {
		return v1;
	}

	public void setV1(double[][] v1) {
		this.v1 = v1;
	}

	public double[][] getV2() {
		return v2;
	}

	public void setV2(double[][] v2) {
		this.v2 = v2;
	}

	public double[][] getV3() {
		return v3;
	}

	public void setV3(double[][] v3) {
		this.v3 = v3;
	}

     
     
     
}
