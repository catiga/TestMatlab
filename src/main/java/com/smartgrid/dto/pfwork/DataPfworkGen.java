 package com.smartgrid.dto.pfwork;

import com.mathworks.toolbox.javabuilder.MWStructArray;

public class DataPfworkGen {

     int[] valid;
     
     double[] v0;
     
     int[] angle;
     
     double[] qmax;
     
     double[] qmin;
     
     double[] pmax;
     
     double[] pmin;
     
     public MWStructArray toM() throws Exception {
         return MWStructArray.fromBean(this);
     }
     
     public DataPfworkGen() {
         valid = new int[] {1};
         v0 = new double[] {1.0};
         angle = new int[] {1};
         qmax = new double[] {1.0};
         qmin = new double[] {1.0};
         pmax = new double[] {1.0};
         pmin = new double[] {1.0};
     }

    public int[] getValid() {
        return valid;
    }

    public void setValid(int[] valid) {
        this.valid = valid;
    }

    public double[] getV0() {
        return v0;
    }

    public void setV0(double[] v0) {
        this.v0 = v0;
    }

    public int[] getAngle() {
        return angle;
    }

    public void setAngle(int[] angle) {
        this.angle = angle;
    }

    public double[] getQmax() {
        return qmax;
    }

    public void setQmax(double[] qmax) {
        this.qmax = qmax;
    }

    public double[] getQmin() {
        return qmin;
    }

    public void setQmin(double[] qmin) {
        this.qmin = qmin;
    }

    public double[] getPmax() {
        return pmax;
    }

    public void setPmax(double[] pmax) {
        this.pmax = pmax;
    }

    public double[] getPmin() {
        return pmin;
    }

    public void setPmin(double[] pmin) {
        this.pmin = pmin;
    }
     
}
