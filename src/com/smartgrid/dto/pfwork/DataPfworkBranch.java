 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkBranch {

     MWCellArray Iname;
     
     MWCellArray Jname;
     
     int[] valid;
     
     int[] Ntype;
     
     int[] ID;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkBranch() {
    	 String[] tmp_Iname = new String[]{"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
         String[] tmp_Jname = new String[]{"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
    	 
         Iname = new MWCellArray(new int[]{tmp_Iname.length,1});
         int i = 1;
         for(String s : tmp_Iname) {
        	 int[] idx = new int[] {i++, 1};
        	 Iname.set(idx, s);
         }
         
         Jname = new MWCellArray(new int[]{tmp_Jname.length,1});
         i = 1;
         for(String s : tmp_Jname) {
        	 int[] idx = new int[] {i++, 1};
        	 Jname.set(idx, s);
         }
    	 
    	 
    	 
    	 
    	 
    	 
    	// lname = new String[] {"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
        // jname = new String[] {"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
         valid = new int[] {1,1,1,1,1,1,1};
         Ntype = new int[] {1,1,1,1,1,1,1};
         ID = new int[] {1,2,3,4,5,6,7};
     }

    public MWCellArray getLname() {
        return Iname;
    }

    public void setLname(MWCellArray Iname) {
        this.Iname = Iname;
    }

    public MWCellArray getJname() {
        return Jname;
    }

    public void setJname(MWCellArray Jname) {
        this.Jname = Jname;
    }

    public int[] getValid() {
        return valid;
    }

    public void setValid(int[] valid) {
        this.valid = valid;
    }

    public int[] getNtype() {
        return Ntype;
    }

    public void setNtype(int[] Ntype) {
        this.Ntype = Ntype;
    }

    public int[] getId() {
        return ID;
    }

    public void setId(int[] ID) {
        this.ID = ID;
    }
     
}
