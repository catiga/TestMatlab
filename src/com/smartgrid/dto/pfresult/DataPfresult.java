 package com.smartgrid.dto.pfresult;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfresult {

     MWStructArray gen;
     
     MWStructArray dtrans;
     
     MWStructArray ttrans;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresult() throws Exception {
         gen = new DataPfresultGen().toM();
         dtrans = new DataPfresultDtrans().toM();
         ttrans = new DataPfresultTtrans().toM();
     }

    public MWStructArray getGen() {
        return gen;
    }

    public void setGen(MWStructArray gen) {
        this.gen = gen;
    }

    public MWStructArray getDtrans() {
        return dtrans;
    }

    public void setDtrans(MWStructArray dtrans) {
        this.dtrans = dtrans;
    }

    public MWStructArray getTtrans() {
        return ttrans;
    }

    public void setTtrans(MWStructArray ttrans) {
        this.ttrans = ttrans;
    }

}
