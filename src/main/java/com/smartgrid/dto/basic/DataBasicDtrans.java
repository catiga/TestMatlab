package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.Acline;
import com.smartgrid.entity.Tw_transformer;

public class DataBasicDtrans {

    MWCellArray kname;

    MWCellArray jname;

    double[][] vi;

    double[][] vj;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    
    public DataBasicDtrans(List<Tw_transformer> data) {
     vi = new double[data.size()][1];
   	 vj = new double[data.size()][1];
   	 String[]tmp_kname = new String[data.size()];
   	 String[]tmp_jname = new String[data.size()];

   	 for(int i = 0; i < data.size(); i++) {
   		Tw_transformer tmpObj = data.get(i);
   		 vi[i][0] = tmpObj.getV0_tap1().doubleValue();
   		 vj[i][0] = tmpObj.getV0_tap2().doubleValue();
   		 tmp_kname[i] = tmpObj.getLname(); 
   		 tmp_jname[i] = tmpObj.getJ_name(); 
		}
   	 
   	 kname = new MWCellArray(new int[]{tmp_kname.length, 1});
   	 jname = new MWCellArray(new int[]{tmp_jname.length, 1});
   	 int i = 1;
        for(String s : tmp_kname) {
            int[] idx = new int[] {i++, 1};
            kname.set(idx, s);
        }
        i = 1;
        for(String s : tmp_jname) {
            int[] idx = new int[] {i++, 1};
            jname.set(idx, s);
        }
        
    }


	public MWCellArray getKname() {
		return kname;
	}


	public void setKname(MWCellArray kname) {
		this.kname = kname;
	}


	public MWCellArray getJname() {
		return jname;
	}


	public void setJname(MWCellArray jname) {
		this.jname = jname;
	}


	public double[][] getVi() {
		return vi;
	}


	public void setVi(double[][] vi) {
		this.vi = vi;
	}


	public double[][] getVj() {
		return vj;
	}


	public void setVj(double[][] vj) {
		this.vj = vj;
	}
    
    
}
