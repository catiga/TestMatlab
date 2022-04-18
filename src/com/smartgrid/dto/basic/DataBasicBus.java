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
        busname = new String[] {"������220","����ʯ��220","��Т��220","��Т��1B220","��Ҧ�ҳ�220","����ʯ210","�����³�220","����ʯ��110","����ʯ��11-1"};
        busbase = new double[] {230.0};
        stationname = new String[] {"������220","����ʯ��220","��Т��220","��Т��1B220","��Ҧ�ҳ�220","����ʯ210","�����³�220","����ʯ��110","����ʯ��11-1"};
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
