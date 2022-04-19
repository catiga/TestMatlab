package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBus {

    MWCellArray busname;

    double[] busbase;

    MWCellArray stationname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicBus() {
        String[] tmp_busname = new String[] {"鄂云梦220","鄂红石坡220","鄂孝感220","鄂孝感1B220","鄂姚家冲220","鄂黄石220","鄂黄新厂220","鄂红石坡110","鄂红石坡11-1"};
        busbase = new double[] {230.0,230.0,230.0,230.0,230.0,19.0,230.0,115,10.5};
        String[] tmp_stationname = new String[] {"鄂云梦220","鄂红石坡220","鄂孝感220","鄂孝感1B220","鄂姚家冲220","鄂黄石220","鄂黄新厂220","鄂红石坡110","鄂红石坡11-1"};
        
        busname = new MWCellArray(new int[]{tmp_busname.length, 1});
        int i = 1;
        for(String s : tmp_busname) {
            int[] idx = new int[] {i++, 1};
            busname.set(idx, s);
        }
        i = 1;
        stationname = new MWCellArray(new int[] {tmp_stationname.length, 1});
        for(String s : tmp_stationname) {
            int[] idx = new int[] {i++, 1};
            stationname.set(idx, s);
        }
    }

    public MWCellArray getBusname() {
        return busname;
    }

    public void setBusname(MWCellArray busname) {
        this.busname = busname;
    }

    public double[] getBusbase() {
        return busbase;
    }

    public void setBusbase(double[] busbase) {
        this.busbase = busbase;
    }

    public MWCellArray getStationname() {
        return stationname;
    }

    public void setStationname(MWCellArray stationname) {
        this.stationname = stationname;
    }

}
