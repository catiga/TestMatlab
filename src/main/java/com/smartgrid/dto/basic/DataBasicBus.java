package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.Moline;

public class DataBasicBus {

    MWCellArray busname;

    double[][] busbase;

    MWCellArray stationname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }
    
    public DataBasicBus(List<Moline> data) {
    	 busbase = new double[data.size()][1];
    	 String[]tmp_busname = new String[data.size()];
    	 String[]tmp_stationname = new String[data.size()];
    	 
    	 for(int i = 0; i < data.size(); i++) {
    		 Moline tmpObj = data.get(i);
    		 busbase[i][0] = tmpObj.getBaseKv().doubleValue();
    		 tmp_busname[i] = tmpObj.getBusName(); 
    		 tmp_stationname[i] = tmpObj.getPsName(); 
 		}
    	 
    	 busname = new MWCellArray(new int[]{tmp_busname.length, 1});
    	 stationname = new MWCellArray(new int[]{tmp_stationname.length, 1});
    	 int i = 1;
         for(String s : tmp_busname) {
             int[] idx = new int[] {i++, 1};
             busname.set(idx, s);
         }
         i = 1;
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

	public double[][] getBusbase() {
		return busbase;
	}

	public void setBusbase(double[][] busbase) {
		this.busbase = busbase;
	}

	public MWCellArray getStationname() {
		return stationname;
	}

	public void setStationname(MWCellArray stationname) {
		this.stationname = stationname;
	}


    

}
