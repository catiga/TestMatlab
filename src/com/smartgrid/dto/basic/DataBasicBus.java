package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicBus {

    MWCellArray busname;

    double[] busbase;

    String[] stationname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicBus() {
        String[] tmp_busname = new String[] {"鄂云梦220","鄂红石坡220","鄂孝感220","鄂孝感1B220","鄂姚家冲220","鄂黄石210","鄂黄新厂220","鄂红石坡110","鄂红石坡11-1"};
        busbase = new double[] {230.0};
        stationname = new String[] {"鄂云梦220","鄂红石坡220","鄂孝感220","鄂孝感1B220","鄂姚家冲220","鄂黄石210","鄂黄新厂220","鄂红石坡110","鄂红石坡11-1"};
        
        MWCellArray cell = new MWCellArray(new int[]{1, tmp_busname.length});
        int i = 1;
        for(String s : tmp_busname) {
            int[] idx = new int[] {1, i++};
            cell.set(idx, s);
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

    public String[] getStationname() {
        return stationname;
    }

    public void setStationname(String[] stationname) {
        this.stationname = stationname;
    }

}
