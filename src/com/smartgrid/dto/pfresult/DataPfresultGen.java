 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresultGen {

     String[] name;
     
     String[] busname;
     
     String[] type;
     
     double[] p;
     
     double[] q;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultGen() {
         name = new String[] {"¶õ»ÆÊ¯210"};
         busname = new String[] {"¶õ»ÆÊ¯210"};
         type = new String[] {"PV-PQ"};
         p = new double[] {3.0};
         q = new double[] {1.0};
     }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String[] getBusname() {
        return busname;
    }

    public void setBusname(String[] busname) {
        this.busname = busname;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public double[] getP() {
        return p;
    }

    public void setP(double[] p) {
        this.p = p;
    }

    public double[] getQ() {
        return q;
    }

    public void setQ(double[] q) {
        this.q = q;
    }
     
}
