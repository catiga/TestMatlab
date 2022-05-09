 package com.smartgrid.dto.pfwork;

import java.util.List;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import com.smartgrid.entity.AclineTrend;

public class DataPfworkBranch {

     MWCellArray lname;
     
     MWCellArray jname;
     
     Integer[][] valid;
     
     Integer[][] ntype;
     
     Long[][] id;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkBranch(List<AclineTrend> data ) {
    	 valid = new Integer[data.size()][1];
    	 ntype = new Integer[data.size()][1];
    	 id = new Long[data.size()][1];
    	 String[]tmp_Iname = new String[data.size()];
    	 String[]tmp_Jname = new String[data.size()];
    	 
    	 for(int i = 0; i < data.size(); i++) {
    		 AclineTrend tmpObj = data.get(i);
    		 valid[i][0] = tmpObj.getValid();
    		 ntype[i][0] = tmpObj.getType();
    		 id[i][0] = tmpObj.getId_no(); 
    		 tmp_Iname[i] = tmpObj.getLname();
    		 tmp_Jname[i]= tmpObj.getJ_name(); 
 		}
    	 
    	 lname = new MWCellArray(new int[]{tmp_Iname.length, 1});
    	 jname = new MWCellArray(new int[]{tmp_Jname.length, 1});
    	 int i = 1;
         for(String s : tmp_Iname) {
             int[] idx = new int[] {i++, 1};
             lname.set(idx, s);
         }
         i = 1;
         for(String s : tmp_Jname) {
             int[] idx = new int[] {i++, 1};
             jname.set(idx, s);
         }
    	  
    

    
    }

	public MWCellArray getLname() {
		return lname;
	}

	public void setLname(MWCellArray lname) {
		this.lname = lname;
	}

	public MWCellArray getJname() {
		return jname;
	}

	public void setJname(MWCellArray jname) {
		this.jname = jname;
	}

	public Integer[][] getValid() {
		return valid;
	}

	public void setValid(Integer[][] valid) {
		this.valid = valid;
	}

	public Integer[][] getNtype() {
		return ntype;
	}

	public void setNtype(Integer[][] ntype) {
		this.ntype = ntype;
	}

	public Long[][] getId() {
		return id;
	}

	public void setId(Long[][] id) {
		this.id = id;
	}
     
}
