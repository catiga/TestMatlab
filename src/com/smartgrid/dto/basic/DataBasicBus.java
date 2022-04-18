package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBus {

    String[] busname;

    double[] busbase;

    String[] stationname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicBus() {
        busname = new String[] {"¶õÔÆÃÎ220","¶õºìÊ¯ÆÂ220","¶õÐ¢¸Ð220","¶õÐ¢¸Ð1B220","¶õÒ¦¼Ò³å220","¶õ»ÆÊ¯210","¶õ»ÆÐÂ³§220","¶õºìÊ¯ÆÂ110","¶õºìÊ¯ÆÂ11-1"};
        busbase = new double[] {230.0};
        stationname = new String[] {"¶õÔÆÃÎ220","¶õºìÊ¯ÆÂ220","¶õÐ¢¸Ð220","¶õÐ¢¸Ð1B220","¶õÒ¦¼Ò³å220","¶õ»ÆÊ¯210","¶õ»ÆÐÂ³§220","¶õºìÊ¯ÆÂ110","¶õºìÊ¯ÆÂ11-1"};
    }

    public String[] getBusname() {
        return busname;
    }

    public void setBusname(String[] busname) {
        this.busname = busname;
    }

    public double[] getBusbase() {
        return busbase;
    }

    public void setBusbase(double[] busbase) {
        this.busbase = busbase;
    }

    public String[] getStationname() {
        return stationname;
    }

    public void setStationname(String[] stationname) {
        this.stationname = stationname;
    }

}
