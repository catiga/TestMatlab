package com.smartgrid.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;

public class ToolKit {
	
	private static final String[] _dimentag_ = new String[] {",", ";", "|"};	//代表最多维度支持层数
	
	public static void main(String[] argc) {
		String caseOutPutStr = "方案1,方案2;鄂府河110,鄂府河210|鄂府河120,鄂府河220;鄂临空港130,鄂临空港230";
		String[] arrCaseOutPutStr = caseOutPutStr.split("\\|");
		String head_with_item = arrCaseOutPutStr[0];	// 方案1,方案2;鄂府河220,鄂府河220
		String head = head_with_item.split(";")[0];		// 方案名称列表
		String item = head_with_item.split(";")[1];		// 悬空节点列表
		
		List<List<String>> methods = new ArrayList<>();
		String[] arrHead = head.split(",");
		String[] arrItem = item.split(",");
		for(int i=0; i<arrHead.length; i++) {
			List<String> method_item = new ArrayList<>();	//格式：方案名称，悬空节点名称，方案明细一，方案明细二。。。。。。方案明细N
			method_item.add(arrHead[i]);
			method_item.add(arrItem[i]);
			
			for(int j=1; j<arrCaseOutPutStr.length; j++) { //格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220 | 鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				String[] arrMethodContents = arrCaseOutPutStr[j].split(";");	//格式：鄂府河220,鄂府河220;鄂临空港220,鄂临空港220
				for(String s : arrMethodContents) {	//格式：鄂府河220,鄂府河220
					method_item.add(s.split(",")[i]);
				}
			}
			methods.add(method_item);
		}
		int x = methods.size();
		int y = 2;
		int z = methods.get(0).size() / 2;
		MWCellArray caseOutPut = new MWCellArray(new int[] {x, y, z});
		for(int i=0; i<x; i++) {
			List<String> method = methods.get(i);	// [方案1, 鄂府河220, 鄂府河220, 鄂临空港220, 鄂府河220, 鄂临空港220]
			for(int j=0; j<y; j++) {
				for(int k=0; k<z; k++) {
					int [] idx = new int[] {i+1, j+1, k+1};
					int index = y*j +k;
					String value = method.get(index);
					caseOutPut.set(idx, value);
				}
			}
		}
		System.out.println(caseOutPut);
	}
	
	public static double[][][] convert3ArrayFromString(String data) {
		String[] arr_1 = data.split("\\|");
		String[] arr_2 = arr_1[0].split(";");
		String[] arr_3 = arr_2[0].split(",");
		
		int x = arr_1.length;
		int y = arr_2.length;
		int z = arr_3.length;
		
		double[][][] result = new double[x][y][z];
		
		for(int i=0; i<arr_1.length; i++) {
			String s1 = arr_1[i];
			String[] arr_s1 = s1.split(";");
			for(int j=0; j<arr_s1.length; j++) {
				String s2 = arr_s1[j];
				String[] arr_s2 = s2.split(",");
				for(int k=0; k<arr_s2.length; k++) {
					String s3 = arr_s2[k];
					result[i][j][k] = Double.valueOf(s3);
				}
			}
		}
		
		return result;
	}
	
	public static double[][] convert2ArrayFromString(String data) {
		String[] arr_1 = data.split(";");
		String[] arr_2 = arr_1[0].split(",");
		int x = arr_1.length;
		int y = arr_2.length;
		
		double[][] result = new double[x][y];
		for(int i=0; i<arr_1.length; i++) {
			String s1 = arr_1[i];
			String[] arr_s2 = s1.split(",");
			for(int j=0; j<arr_s2.length; j++) {
				String s2 = arr_s2[j];
				result[i][j] = Double.valueOf(s2);
			}
		}
		
		return result;
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
