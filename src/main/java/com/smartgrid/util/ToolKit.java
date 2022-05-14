package com.smartgrid.util;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;

public class ToolKit {
	
	private static final String _1level_ = ",";
	private static final String _2level_ = ";";
	private static final String _3level_ = "|";
	
	private static final String[] _dimentag_ = new String[] {",", ";", "|"};	//代表最多维度支持层数
	
	public static void main(String[] argc) {
//		double[][] d = new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		Object[][] d2 = new Object[][] {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
//		Object[] d1 = new Object[] {1, 2, 3};
//		Object[][][] d2 = new Object[][][] {{{1,2,3}, {4,5,6}}, {{7,8,9},{10,11,12}}, {{13,14,15},{16,17,18}}};
		
		StringBuilder buffer = new StringBuilder();
		objectArrayToString(buffer, 2, d2, 2);
		System.out.println(buffer.toString());
		
//		String ret = doubleArrayToString(d);
//		System.out.println(ret);
	}
	
	private static boolean endWithTag(StringBuilder buf) {
		for(String s : _dimentag_) {
			if(buf.toString().endsWith(s)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param buffer
	 * @param dtag 总维度，递减
	 * @param data
	 * @param total 总维度，不变
	 */
	public static void objectArrayToString(StringBuilder buffer, int dtag, Object data, int total) {
		if(data==null) return;
		if(data.getClass().isArray()) {
			dtag--;
			for(Object d : (Object[])data) {
				objectArrayToString(buffer, dtag, d, total);
			}
			if(endWithTag(buffer)) {
				buffer = buffer.deleteCharAt(buffer.length() - 1);
			}
			if(dtag+1 < total) {
				String split = _dimentag_[dtag +1];
				buffer.append(split);
			}
		} else {
			String split = _dimentag_[dtag];
			buffer.append(data + split);
		}
	}
	
	public static Object converArrayObject(double[][] array) {
		Object[][] data = new Object[array.length][array[0].length];
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				data[i][j] = array[i][j];
			}
		}
		return data;
	}
	
	public static Object converArrayObject(double[][][] array) {
		Object[][][] data = new Object[array.length][array[0].length][array[0][0].length];
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				for(int z=0; z<array[i][j].length; z++) {
					data[i][j][z] = array[i][j][z];
				}
			}
		}
		return data;
	}
	
	public static Object converArrayObject(int[][] array) {
		Object[][] data = new Object[array.length][array[0].length];
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				data[i][j] = array[i][j];
			}
		}
		return data;
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
	
	public static String cellArrayToString3(MWCellArray cellArray) {
		StringBuilder buffer = new StringBuilder();
		
		int[] dimen = cellArray.getDimensions();
		for(int i=0; i<dimen[0]; i++) {
			StringBuilder sb2 = new StringBuilder();
			for(int j=0; j<dimen[1]; j++) {
				StringBuilder sb1 = new StringBuilder();
				for(int z=0; z<dimen[2]; z++) {
					MWArray dierlie1 = cellArray.getCell(new int[] {i+1, j+1, z+1});
					
					Object v1 = dierlie1.getData();
					sb1.append(buildString(v1) + ",");
				}
				sb2.append(sb1.deleteCharAt(sb1.length() - 1) + ";");
			}
			buffer.append(sb2.deleteCharAt(sb2.length() - 1) + "|");
		}
		return buffer.substring(0, buffer.length() - 1);
	}
	
//	public static String intArrayToString(int[][] data) {
//		if(data==null) return "";
//		StringBuilder buffer = new StringBuilder();
//		
//		for(int[] row : data) {
//			StringBuilder r = new StringBuilder();
//			for(int col : row) {
//				r.append(col + _1level_);
//			}
//			buffer.append(r.substring(0, r.length() - 1) + _2level_);
//		}
//		
//		return buffer.substring(0, buffer.length() - 1);
//	}
//
//	public static String doubleArrayToString(double[][] data) {
//		if(data==null) return "";
//		
//		StringBuilder buffer = new StringBuilder();
//		for(double[] row : data) {
//			StringBuilder r = new StringBuilder();
//			for(double col : row) {
//				r.append(col + _1level_);
//			}
//			buffer.append(r.substring(0, r.length() - 1) + _2level_);
//		}
//		
//		return buffer.substring(0, buffer.length() - 1);
//	}
	
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
