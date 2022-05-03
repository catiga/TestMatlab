package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicDtrans {

    MWCellArray kname;

    MWCellArray jname;

    Double[] vi;

    Double[] vj;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    
    public DataBasicDtrans(List<String> tmp_Iname, List<String> tmp_Jname,List<Double> tmp_vi, List<Double> tmp_vj) {
    	
        kname = new MWCellArray(new int[]{tmp_Iname.size(),1});
        int i = 1;
        for(String s : tmp_Iname) {
       	 int[] idx = new int[] {i++, 1};
       	 kname.set(idx, s);
        }
        
        jname= new MWCellArray(new int[]{tmp_Jname.size(),1});
        i = 1;
        for(String s : tmp_Jname) {
       	 int[] idx = new int[] {i++, 1};
       	 jname.set(idx, s);
        }
    	
        this.vi = tmp_vi.toArray(new Double[tmp_vi.size()]);
        this.vj = tmp_vj.toArray(new Double[tmp_vj.size()]); 
    }
    
    
	/*
	 * public DataBasicDtrans() { String[] tmp_Iname = new String[]{"鄂黄石210"};
	 * String[] tmp_Jname = new String[]{"鄂黄新厂220"};
	 * 
	 * kname = new MWCellArray(new int[]{tmp_Iname.length,1}); int i = 1; for(String
	 * s : tmp_Iname) { int[] idx = new int[] {i++, 1}; kname.set(idx, s); }
	 * 
	 * jname= new MWCellArray(new int[]{tmp_Jname.length,1}); i = 1; for(String s :
	 * tmp_Jname) { int[] idx = new int[] {i++, 1}; jname.set(idx, s); } vi = new
	 * double[] {19.0}; vj = new double[] {230.0}; }
	 */

    public MWCellArray getLname() {
        return kname;
    }

    public void setLname(MWCellArray kname) {
        this.kname = kname;
    }

    public MWCellArray getJname() {
        return jname;
    }

    public void setJname(MWCellArray jname) {
        this.jname = jname;
    }

    public Double[] getVi() {
        return vi;
    }

    public void setVi(Double[] vi) {
        this.vi = vi;
    }

    public Double[] getVj() {
        return vj;
    }

    public void setVj(Double[] vj) {
        this.vj = vj;
    }

}
