package com.smartgrid.dto.basic;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataBasicGen {

    String[] genname;
    
    public MWStructArray toM() throws Exception {
        return MWStructArray.fromBean(this);
    }

    public DataBasicGen() {
        genname = new String[] {"TEST GENNAME"};
    }

    public String[] getGenname() {
        return genname;
    }

    public void setGenname(String[] genname) {
        this.genname = genname;
    }

}
