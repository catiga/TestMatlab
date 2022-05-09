 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfwork {

     MWStructArray branch;
     
     MWStructArray gen;
     
     MWStructArray load;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfwork() throws Exception {
			/*
			 * branch = new DataPfworkBranch().toM(); gen = new DataPfworkGen().toM(); load
			 * = new DataPfworkLoad().toM();
			 */
     }

    public MWStructArray getBranch() {
        return branch;
    }

    public void setBranch(MWStructArray branch) {
        this.branch = branch;
    }

    public MWStructArray getGen() {
        return gen;
    }

    public void setGen(MWStructArray gen) {
        this.gen = gen;
    }

    public MWStructArray getLoad() {
        return load;
    }

    public void setLoad(MWStructArray load) {
        this.load = load;
    }
    
}
