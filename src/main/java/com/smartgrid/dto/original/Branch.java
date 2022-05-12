package com.smartgrid.dto.original;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.ComponentBranch;

public class Branch {

	Double[][] topo ;
	
	MWCellArray name;
	
	public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }
	
	public Branch(List<ComponentBranch> data) {
		topo = new Double[data.size()][5]; 
		Double[][] tmp_topo = new Double[data.size()][5]; 
		for(int i = 0; i < data.size(); i++) {
			ComponentBranch tmpObj = data.get(i);
			tmp_topo[i][0] = (double)tmpObj.getSerial_number();
			tmp_topo[i][1] = (double)tmpObj.getFirst_node();
			tmp_topo[i][2] = (double)tmpObj.getLast_node();
			tmp_topo[i][3] = (double)tmpObj.getType();
			tmp_topo[i][4] = (double)tmpObj.getRun_state();
		}
		this.topo = tmp_topo;
		
		String[]tmp_name = new String[data.size()];
		for(int i = 0; i < data.size(); i++) {
			ComponentBranch tmpObj = data.get(i);
			tmp_name[i] = tmpObj.getName();
		}
		name = new MWCellArray(new int[]{tmp_name.length, 1});
        int i = 1;
        for(String s : tmp_name) {
            int[] idx = new int[] {i++, 1};
            name.set(idx, s);
        }
	}

	public Double[][] getTopo() {
		return topo;
	}

	public void setTopo(Double[][] topo) {
		this.topo = topo;
	}

	public MWCellArray getName() {
		return name;
	}

	public void setName(MWCellArray name) {
		this.name = name;
	}

	
	/*
	 * public Branch() { topo = new double[][]{{1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1,
	 * 1}, {4, 1, 1, 1}};
	 * 
	 * String[] tmp_name = new String[] {"S1-新","S1-新","S1-新","S1-新","S1-新"};
	 * 
	 * name = new MWCellArray(new int[]{tmp_name.length, 1}); int i = 1; for(String
	 * s : tmp_name) { int[] idx = new int[] {i++, 1}; name.set(idx, s); } }
	 */

	
}
