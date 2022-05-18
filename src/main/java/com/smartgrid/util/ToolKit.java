package com.smartgrid.util;

import java.util.List;
import java.util.Map;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;

public class ToolKit {
	
	private static final String[] _dimentag_ = new String[] {",", ";", "|"};	//代表最多维度支持层数
	
	public static void main(String[] argc) {
//		double[][] d = new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		Object[][] d2 = new Object[][] {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
		Object[][] d3 = new Object[][] {{1.0, 2.0}, {4.0, 5.0}, {7.0, 8.0}};
//		Object[] d1 = new Object[] {1, 2, 3};
//		Object[][][] d2 = new Object[][][] {{{1,2,3}, {4,5,6}}, {{7,8,9},{10,11,12}}, {{13,14,15},{16,17,18}}};
		
		StringBuilder buffer = new StringBuilder();
		objectArrayToString(buffer, 2, d3, 2);
		System.out.println(buffer.toString());
		
//		String ret = doubleArrayToString(d);
//		System.out.println(ret);
		
		String data = "1.0,1.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|2.0,2.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|3.0,3.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|4.0,4.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|5.0,5.0;1.0,1.0;181.01,181.01;43.99,43.99;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|6.0,6.0;1.0,1.0;230.49,230.49;55.47,55.47;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|7.0,7.0;1.0,1.0;242.14,242.14;70.86,70.86;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|8.0,8.0;1.0,1.0;361.31,361.31;146.51,146.51;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|9.0,9.0;1.0,1.0;191.21,191.21;46.95,46.95;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|10.0,10.0;1.0,1.0;202.4,202.4;51.0,51.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|11.0,11.0;1.0,1.0;213.94,213.94;91.99,91.99;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|12.0,12.0;1.0,1.0;502.73,502.73;152.1,152.1;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|13.0,13.0;1.0,1.0;154.92,154.92;28.06,28.06;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|14.0,14.0;1.0,1.0;140.52,140.52;42.32,42.32;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|15.0,15.0;1.0,1.0;106.32,106.32;33.83,33.83;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|16.0,16.0;4.0,4.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|17.0,17.0;4.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|18.0,18.0;4.0,4.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|19.0,19.0;1.0,1.0;189.02,189.02;6.33,6.33;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|20.0,20.0;1.0,1.0;86.07,86.07;5.66,5.66;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|21.0,21.0;1.0,1.0;79.08,79.08;-0.43,-0.43;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|22.0,22.0;1.0,1.0;92.65,92.65;22.87,22.87;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|23.0,23.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|24.0,24.0;1.0,1.0;134.96,134.96;-15.89,-15.89;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|25.0,25.0;1.0,1.0;215.62,215.62;11.15,11.15;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|26.0,26.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|27.0,27.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|28.0,28.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|29.0,29.0;1.0,1.0;190.67,190.67;36.17,36.17;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|30.0,30.0;1.0,1.0;282.38,282.38;76.0,76.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|31.0,31.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|32.0,32.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|33.0,33.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|34.0,34.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|35.0,35.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|36.0,36.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|37.0,37.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|38.0,38.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|39.0,39.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|40.0,40.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|41.0,41.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|42.0,42.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|43.0,43.0;4.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|44.0,44.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|45.0,45.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|46.0,46.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|47.0,47.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|48.0,48.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|49.0,49.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|50.0,50.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|51.0,51.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|52.0,52.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|53.0,53.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|54.0,54.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|55.0,55.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|56.0,56.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|57.0,57.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|58.0,58.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|59.0,59.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|60.0,60.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|61.0,61.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|62.0,62.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|63.0,63.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|64.0,64.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|65.0,65.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|66.0,66.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|67.0,67.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|68.0,68.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|69.0,69.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|70.0,70.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|71.0,71.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|72.0,72.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|73.0,73.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|74.0,74.0;3.0,3.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|75.0,75.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|76.0,76.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|77.0,77.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|78.0,78.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|79.0,79.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5|80.0,80.0;1.0,1.0;0.0,0.0;0.0,0.0;0.0,0.0;0.0,0.0;1.0,1.0;1.0,1.0;0.0,0.0;230.0,230.0;1.0,1.0;241.5,241.5;218.5,218.5";
		double[][][] res = convert3ArrayFromString(data);
		
		System.out.println("hello world");
		System.out.println(res.length);
		
		try {
			String caseNameStr = "[{\"head\":{\"index\":\"1\",\"name\":\"方案2\"}},{\"item\":{\"index\":\"1\",\"name\":\"鄂府河220\"}},{\"body\":{\"index\":\"1\",\"name\":\"鄂府河220\"}},{\"body\":{\"index\":\"1\",\"name\":\"鄂临空港220\"}}]";
			List<Map<String, Object>> result = JackSonBeanMapper.jsonToList(caseNameStr);
			Map<String, Object> tmp = (Map<String, Object>)result.get(0).get("head");
			System.out.println(tmp.get("name"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
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
