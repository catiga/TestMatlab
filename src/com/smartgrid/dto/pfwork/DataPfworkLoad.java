 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkLoad {

     String[] name;
     
     double[] pl;
     
     double[] ql;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkLoad() {
         name = new String[] {"鄂红石坡110"};
         pl = new double[] {1.0};
         ql = new double[] {1.0};
     }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public double[] getPl() {
        return pl;
    }

    public void setPl(double[] pl) {
        this.pl = pl;
    }

    public double[] getQl() {
        return ql;
    }

    public void setQl(double[] ql) {
        this.ql = ql;
    }
     
}
