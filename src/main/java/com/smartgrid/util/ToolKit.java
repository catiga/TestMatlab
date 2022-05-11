package com.smartgrid.util;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;

public class ToolKit {

	public static String doubleArrayToString(double[][] data) {
		StringBuilder buffer = new StringBuilder();
		if(data!=null && data.length>0) {
			for(double[] row : data) {
				StringBuilder r = new StringBuilder();
				for(double col : row) {
					r.append(col + ",");
				}
				buffer.append(r.substring(0, r.length() - 1) + ";");
			}
		}
		
		return buffer.substring(0, buffer.length() - 1);
	}
	
	public static String cellArrayToString(MWCellArray cellArray) {
		StringBuilder buffer = new StringBuilder();
		
		int[] dimen = cellArray.getDimensions();
		
		int row = dimen[0];
		for(int i=0; i<row; i++) {
			MWArray dierlie1 = cellArray.getCell(new int[] {i+1, 1});
			
			Object v1 = dierlie1.getData();
			
			buffer.append(buildString(v1) + ",");
		}
		return buffer.substring(0, buffer.length() - 1);
	}
	
	private static String buildString(Object data) {
		if(data==null || !data.getClass().isArray()) {
			return null;
		}
		char[] array = (char[])data;
		StringBuilder sb = new StringBuilder();
		for(char t : array) {
			sb.append(t);
		}
		return sb.toString();
	}
}
