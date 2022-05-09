package com.smartgrid.dto.pfwork;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.LoadTrend;

public class DataPfworkLoad {

	MWCellArray name;

	double[][] pl;

	double[][] ql;

	public MWStructArray toM() throws Exception {
		return MWStructArray.fromBean(this);
	}

	public DataPfworkLoad(List<LoadTrend> data) {

		pl = new double[data.size()][1];
		ql = new double[data.size()][1];
		String[] tmp_name = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			LoadTrend tmpObj = data.get(i);
			pl[i][0] = tmpObj.getPl().doubleValue();
			ql[i][0] = tmpObj.getQl().doubleValue();
			tmp_name[i] = tmpObj.getNode_name();

		}

		name = new MWCellArray(new int[] { tmp_name.length, 1 });
		int i = 1;
		for (String s : tmp_name) {
			int[] idx = new int[] { i++, 1 };
			name.set(idx, s);
		}

	}

	public MWCellArray getName() {
		return name;
	}

	public void setName(MWCellArray name) {
		this.name = name;
	}

	public double[][] getPl() {
		return pl;
	}

	public void setPl(double[][] pl) {
		this.pl = pl;
	}

	public double[][] getQl() {
		return ql;
	}

	public void setQl(double[][] ql) {
		this.ql = ql;
	}

}
