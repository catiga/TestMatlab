package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicDtrans {

    MWCellArray Iname;

    MWCellArray Jname;

    double[] Vi;

    double[] Vj;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicDtrans() {
    	String[] tmp_Iname = new String[]{"鄂黄石210"};
        String[] tmp_Jname = new String[]{"鄂黄新厂220"};
   	 
        Iname = new MWCellArray(new int[]{tmp_Iname.length,1});
        int i = 1;
        for(String s : tmp_Iname) {
       	 int[] idx = new int[] {i++, 1};
       	 Iname.set(idx, s);
        }
        
        Jname = new MWCellArray(new int[]{tmp_Jname.length,1});
        i = 1;
        for(String s : tmp_Jname) {
       	 int[] idx = new int[] {i++, 1};
       	 Jname.set(idx, s);
        }
    	
    	
    	//lname = new String[] {"鄂黄石210"};
        //jname = new String[] {"鄂黄新厂220"};
       
      
        Vi = new double[] {19.0};
        Vj = new double[] {230.0};
    }

    public MWCellArray getLname() {
        return Iname;
    }

    public void setLname(MWCellArray lname) {
        this.Iname = lname;
    }

    public MWCellArray getJname() {
        return Jname;
    }

    public void setJname(MWCellArray Jname) {
        this.Jname = Jname;
    }

    public double[] getVi() {
        return Vi;
    }

    public void setVi(double[] Vi) {
        this.Vi = Vi;
    }

    public double[] getVj() {
        return Vj;
    }

    public void setVj(double[] Vj) {
        this.Vj = Vj;
    }

}
