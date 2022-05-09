 package com.smartgrid.dto.pfresult;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.AclineTrend;
import com.smartgrid.entity.AlternatorResult;

public class DataPfresultGen {

     MWCellArray name;
     
     MWCellArray busname;
     
     MWCellArray type;
     
     double[][] p;
     
     double[][] q;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfresultGen(List<AlternatorResult> data) {
    	 p = new double[data.size()][1];
    	 q = new double[data.size()][1];
    	 String[]tmp_name = new String[data.size()];
    	 String[]tmp_busname = new String[data.size()];
    	 String[]tmp_type = new String[data.size()];
    	 
    	 for(int i = 0; i < data.size(); i++) {
    		 AlternatorResult tmpObj = data.get(i);
    		 p[i][0] = tmpObj.getActive_power_generation().doubleValue();
    		 q[i][0] = tmpObj.getReactive_power_generation().doubleValue();
    		 tmp_name[i] = tmpObj.getAlternator_name();
    		 tmp_busname[i] = tmpObj.getMoline_name(); 
    		 tmp_type[i] = tmpObj.getType(); 
 		}
    	 
    	 name = new MWCellArray(new int[]{tmp_name.length, 1});
    	 busname = new MWCellArray(new int[]{tmp_busname.length, 1});
    	 type = new MWCellArray(new int[]{tmp_type.length, 1});
    	 int i = 1;
         for(String s : tmp_name) {
             int[] idx = new int[] {i++, 1};
             name.set(idx, s);
         }
         i = 1;
         for(String s : tmp_busname) {
             int[] idx = new int[] {i++, 1};
             busname.set(idx, s);
         }
         i = 1;
         for(String s : tmp_type) {
             int[] idx = new int[] {i++, 1};
             type.set(idx, s);
         } 
    	 
     }

	public MWCellArray getName() {
		return name;
	}

	public void setName(MWCellArray name) {
		this.name = name;
	}

	public MWCellArray getBusname() {
		return busname;
	}

	public void setBusname(MWCellArray busname) {
		this.busname = busname;
	}

	public MWCellArray getType() {
		return type;
	}

	public void setType(MWCellArray type) {
		this.type = type;
	}

	public double[][] getP() {
		return p;
	}

	public void setP(double[][] p) {
		this.p = p;
	}

	public double[][] getQ() {
		return q;
	}

	public void setQ(double[][] q) {
		this.q = q;
	}
     
		
     
}
