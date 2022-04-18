package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBus {

    String[] busname;

    int[] busbase;

    String[] stationname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicBus() {
        busname = new String[] {"TEST BUSNAME"};
        busbase = new int[] {1};
        stationname = new String[] {"TEST STATIONNAME"};
    }

    public String[] getBusname() {
        return busname;
    }

    public void setBusname(String[] busname) {
        this.busname = busname;
    }

    public int[] getBusbase() {
        return busbase;
    }

    public void setBusbase(int[] busbase) {
        this.busbase = busbase;
    }

    public String[] getStationname() {
        return stationname;
    }

    public void setStationname(String[] stationname) {
        this.stationname = stationname;
    }

}
