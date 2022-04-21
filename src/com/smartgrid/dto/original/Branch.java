package com.smartgrid.dto.original;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class Branch {

	double[][] topo;
	
	MWCellArray name;
	
	public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }
	
	public Branch() {
		topo = new double[][]{{1, 1, 1}, {2, 1, 1}, {3, 1, 1}, {4, 1, 1}};
		
		String[] tmp_name = new String[] {"S1-新","S1-新","S1-新","S1-新","S1-新"};
		
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
