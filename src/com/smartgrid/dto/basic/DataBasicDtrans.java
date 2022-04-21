package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicDtrans {

    MWCellArray kname;

    MWCellArray jname;

    double[] vi;

    double[] vj;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicDtrans() {
    	String[] tmp_Iname = new String[]{"鄂黄石210"};
        String[] tmp_Jname = new String[]{"鄂黄新厂220"};
   	 
        kname = new MWCellArray(new int[]{tmp_Iname.length,1});
        int i = 1;
        for(String s : tmp_Iname) {
       	 int[] idx = new int[] {i++, 1};
       	 kname.set(idx, s);
        }
        
        jname= new MWCellArray(new int[]{tmp_Jname.length,1});
        i = 1;
        for(String s : tmp_Jname) {
       	 int[] idx = new int[] {i++, 1};
       	 jname.set(idx, s);
        }
    	
    	
    	//lname = new String[] {"鄂黄石210"};
        //jname = new String[] {"鄂黄新厂220"};
       
      
        vi = new double[] {19.0};
        vj = new double[] {230.0};
    }

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
