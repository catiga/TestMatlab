package com.smartgrid.dto.maintancewire;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class branch {
	double[][] topo;
	
	MWCellArray name;
	
	public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }
	
	public branch() {
		topo = new double[][]{
			{1, 1, 4, 1, 1}, 
			{2, 4, 5, 2, 1}, 
			{3, 5, 6, 1, 1}, 
			{4, 2, 7, 1, 1},
			{5, 7, 8, 2, 1},
			{6, 8, 6, 1, 1},
			{7, 3, 9, 1, 1},
			{8, 9, 10, 2, 1},
			{9, 10, 6, 1, 1},
			{10, 6, 11, 4, 1},
			{11, 11, 12, 1, 1},
			{12, 12, 13, 2, 1},
			{13, 13, 14, 1, 1},
			{14, 14, 15, 3, 1},
		};
		
		String[] tmp_name = new String[] {"S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新","S1-新"};
		
		name = new MWCellArray(new int[]{tmp_name.length, 1});
        int i = 1;
        for(String s : tmp_name) {
            int[] idx = new int[] {i++, 1};
            name.set(idx, s);
        }
	}

	public double[][] getTopo() {
		return topo;
	}

	public void setTopo(double[][] topo) {
		this.topo = topo;
	}

	public MWCellArray getName() {
		return name;
	}

	public void setName(MWCellArray name) {
		this.name = name;
	}

}
