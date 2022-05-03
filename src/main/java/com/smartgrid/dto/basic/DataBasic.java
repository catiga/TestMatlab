package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasic {

    MWStructArray bus;

    MWStructArray branch;

    MWStructArray dtrans;

    MWStructArray ttrans;

    MWStructArray gen;

    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasic() throws Exception {
//        bus = new DataBasicBus().toM();
//        branch = new DataBasicBranch().toM();
//        dtrans = new DataBasicDtrans().toM();
//        ttrans = new DataBasicTtrans().toM();
//        gen = new DataBasicGen().toM();
    }

    public MWStructArray getBus() {
        return bus;
    }

    public void setBus(MWStructArray bus) {
        this.bus = bus;
    }

    public MWStructArray getBranch() {
        return branch;
    }

    public void setBranch(MWStructArray branch) {
        this.branch = branch;
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

    public MWStructArray getGen() {
        return gen;
    }

    public void setGen(MWStructArray gen) {
        this.gen = gen;
    }

}
