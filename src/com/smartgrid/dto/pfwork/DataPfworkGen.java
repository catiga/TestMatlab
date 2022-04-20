 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkGen {

     int[] valid;
     
     double[] V0;
     
     int[] angle;
     
     double[] Qmax;
     
     double[] Qmin;
     
     double[] Pmax;
     
     double[] Pmin;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkGen() {
         valid = new int[] {1};
         V0 = new double[] {1.0};
         angle = new int[] {1};
         Qmax = new double[] {1.0};
         Qmin = new double[] {1.0};
         Pmax = new double[] {1.0};
         Pmin = new double[] {1.0};
     }

    public int[] getValid() {
        return valid;
    }

    public void setValid(int[] valid) {
        this.valid = valid;
    }

    public double[] getV0() {
        return V0;
    }

    public void setV0(double[] V0) {
        this.V0 = V0;
    }

    public int[] getAngle() {
        return angle;
    }

    public void setAngle(int[] angle) {
        this.angle = angle;
    }

    public double[] getQmax() {
        return Qmax;
    }

    public void setQmax(double[] Qmax) {
        this.Qmax = Qmax;
    }

    public double[] getQmin() {
        return Qmin;
    }

    public void setQmin(double[] Qmin) {
        this.Qmin = Qmin;
    }

    public double[] getPmax() {
        return Pmax;
    }

    public void setPmax(double[] Pmax) {
        this.Pmax = Pmax;
    }

    public double[] getPmin() {
        return Pmin;
    }

    public void setPmin(double[] Pmin) {
        this.Pmin = Pmin;
    }
     
}
