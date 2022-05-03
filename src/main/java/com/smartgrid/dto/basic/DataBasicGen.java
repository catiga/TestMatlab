package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicGen {

    MWCellArray genname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicGen(List<String> tmp_genname) {
       	genname = new MWCellArray(new int[]{tmp_genname.size(), 1});
        int i = 1;
        for(String s : tmp_genname) {
            int[] idx = new int[] {i++, 1};
            genname.set(idx, s);
        }
        
    	
    }
    
	/*
	 * public DataBasicGen() { String[] tmp_genname = new String[]{"鄂黄石210"};
	 * 
	 * genname = new MWCellArray(new int[]{tmp_genname.length,1}); int i = 1;
	 * for(String s : tmp_genname) { int[] idx = new int[] {i++, 1};
	 * genname.set(idx, s); }
	 * 
	 * }
	 */

    public MWCellArray getGenname() {
        return genname;
    }

    public void setGenname(MWCellArray genname) {
        this.genname = genname;
    }

}
