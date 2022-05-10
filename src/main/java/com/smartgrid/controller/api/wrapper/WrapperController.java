package com.smartgrid.controller.api.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;

public class WrapperController {

	public Map<String, List<String>> buildStringFromStructArray(MWStructArray data) {
		Map<String, Integer> fieldsMap = new HashMap<String, Integer>();
		String[] names = data.fieldNames();
		for(int i=0; i<names.length; i++) {
			fieldsMap.put(names[i], i + 1);
		}
		
		Map<String, List<String>> retData = new HashMap<>();
		
		for(String k : fieldsMap.keySet()) {
			Object tmpObj = data.get(fieldsMap.get(k));
			List<String> resultSet = new ArrayList<>();
			try {
				Object[][] tmpData = (Object[][])tmpObj;
				for(int i=0; i<tmpData.length; i++) {
					Object[] chars = (Object[])tmpData[i][0];
					for(Object t : chars) {
						System.out.println(t.getClass());
						String s = this.buildString((char[])t);
						resultSet.add(s);
						System.out.println(t);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
				//这里要想一下如何处理，先跳过
			}
			retData.put(k, resultSet);
		}
		return retData;
	}
	
	public List<Object[]> buildDataFromCellArray(MWCellArray tableNodesLevelProvinceArea) {
		List<Object[]> retData = new ArrayList<>();
		
		int[] dimen = tableNodesLevelProvinceArea.getDimensions();
		
		int row = dimen[0];
		for(int i=0; i<row; i++) {
			MWArray dierlie1 = tableNodesLevelProvinceArea.getCell(new int[] {i+1, 1});
			MWArray dierlie2 = tableNodesLevelProvinceArea.getCell(new int[] {i+1, 2});
			MWArray dierlie3 = tableNodesLevelProvinceArea.getCell(new int[] {i+1, 3});
			
			Object v1 = dierlie1.get(1);
			char[] v2 = (char[])dierlie2.getData();
			Object v3 = dierlie3.get(1);
			
			retData.add(new Object[] {v1, buildString(v2), v3});
		}
		return retData;
	}
	
	private String buildString(char[] array) {
		StringBuilder sb = new StringBuilder();
		for(char t : array) {
			sb.append(t);
		}
		return sb.toString();
	}
}
