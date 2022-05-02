 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkBranch {

     MWCellArray lname;
     
     MWCellArray jname;
     
     int[][] valid;
     
     int[][] ntype;
     
     int[][] id;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkBranch() {
    	 String[] tmp_Iname = new String[]{"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
         String[] tmp_Jname = new String[]{"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
         int[][] tmp_valid = new int[7][1];        
         int[][] tmp_ntype = new int[7][1];
         int[][] tmp_id = new int[7][1];
         
         
    	 for(int k = 0; k<7; k++) {
        	 tmp_valid[k][0] = 1;
        	}
    	 for(int k = 0; k<7; k++) {
        	 tmp_ntype[k][0] = 1;
        	}
    	 for(int k = 0; k<7; k++) {
        	 tmp_id[k][0] = k+1;
        	}
         
         
         lname = new MWCellArray(new int[]{tmp_Iname.length,1});
         int i = 1;
         for(String s : tmp_Iname) {
        	 int[] idx = new int[] {i++, 1};
        	 lname.set(idx, s);
         }
         
         jname = new MWCellArray(new int[]{tmp_Jname.length,1});
         i = 1;
         for(String s : tmp_Jname) {
        	 int[] idx = new int[] {i++, 1};
        	 jname.set(idx, s);
         }
    	 
    	 
    	 
    	 
    	 
    	 
    	// lname = new String[] {"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
        // jname = new String[] {"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
         valid = tmp_valid;
         ntype = tmp_ntype;
         id = tmp_id;
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

    public int[][] getValid() {
        return valid;
    }

    public void setValid(int[][] valid) {
        this.valid = valid;
    }

    public int[][] getNtype() {
        return ntype;
    }

    public void setNtype(int[][] ntype) {
        this.ntype = ntype;
    }

    public int[][] getId() {
        return id;
    }

    public void setId(int[][] id) {
        this.id = id;
    }
     
}
