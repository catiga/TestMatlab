 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultGen {

     MWCellArray name;
     
     MWCellArray busname;
     
     MWCellArray type;
     
     double[] P;
     
     double[] Q;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultGen() {
    	 String[] tmp_name = new String[]{"鄂黄石210"};
         String[] tmp_busname = new String[]{"鄂黄石210"};
         String[] tmp_type = new String[]{"PV-PQ"};
         
         name = new MWCellArray(new int[]{tmp_name.length,1});
         int i = 1;
         for(String s : tmp_name) {
        	 int[] idx = new int[] {i++, 1};
        	 name.set(idx, s);
         }
         
         busname = new MWCellArray(new int[]{tmp_busname.length,1});
         i = 1;
         for(String s : tmp_busname) {
        	 int[] idx = new int[] {i++, 1};
        	 busname.set(idx, s);
         }
         type = new MWCellArray(new int[]{tmp_type.length,1});
         i = 1;
         for(String s : tmp_type) {
        	 int[] idx = new int[] {i++, 1};
        	 type.set(idx, s);
         }
    	 
    	 
    	 //name = new String[] {"鄂黄石210"};
         //busname = new String[] {"鄂黄石210"};
         //type = new String[] {"PV-PQ"};
         P = new double[] {3.0};
         Q = new double[] {1.0};
     }

    public MWCellArray getName() {
        return name;
    }

    public void setName(MWCellArray name) {
        this.name = name;
    }

    public MWCellArray getBusname() {
        return busname;
    }

    public void setBusname(MWCellArray busname) {
        this.busname = busname;
    }

    public MWCellArray getType() {
        return type;
    }

    public void setType(MWCellArray type) {
        this.type = type;
    }

    public double[] getP() {
        return P;
    }

    public void setP(double[] P) {
        this.P = P;
    }

    public double[] getQ() {
        return Q;
    }

    public void setQ(double[] Q) {
        this.Q = Q;
    }
     
}
