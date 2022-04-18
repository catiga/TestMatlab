 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkBranch {

     String[] lname;
     
     String[] jname;
     
     int[] valid;
     
     int[] ntype;
     
     int[] id;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkBranch() {
         lname = new String[] {"鄂红石坡220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂姚家冲220","鄂姚家冲220","鄂姚家冲220"};
         jname = new String[] {"鄂云梦220","鄂云梦220","鄂孝感1B220","鄂红石坡220","鄂孝感220","鄂孝感220","鄂红石坡220"};
         valid = new int[] {1,1,1,1,1,1,1};
         ntype = new int[] {1,1,1,1,1,1,1};
         id = new int[] {1,2,3,4,5,6,7};
     }

    public String[] getLname() {
        return lname;
    }

    public void setLname(String[] lname) {
        this.lname = lname;
    }

    public String[] getJname() {
        return jname;
    }

    public void setJname(String[] jname) {
        this.jname = jname;
    }

    public int[] getValid() {
        return valid;
    }

    public void setValid(int[] valid) {
        this.valid = valid;
    }

    public int[] getNtype() {
        return ntype;
    }

    public void setNtype(int[] ntype) {
        this.ntype = ntype;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
     
}
