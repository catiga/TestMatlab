package com.smartgrid.dto.basic;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.Alternator;
import com.smartgrid.entity.Tw_transformer;

public class DataBasicGen {

    MWCellArray genname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicGen(List<Alternator> data) {
    	
       	 String[]tmp_genname = new String[data.size()];
       	 for(int i = 0; i < data.size(); i++) {
       		Alternator tmpObj = data.get(i);
       		tmp_genname[i] = tmpObj.getId_name(); 
     		}
       	 genname = new MWCellArray(new int[]{tmp_genname.length, 1});
       	 int i = 1;
            for(String s : tmp_genname) {
                int[] idx = new int[] {i++, 1};
                genname.set(idx, s);
            }
           
       
        
    	
    }

	public MWCellArray getGenname() {
		return genname;
	}

	public void setGenname(MWCellArray genname) {
		this.genname = genname;
	}
    
	

}
