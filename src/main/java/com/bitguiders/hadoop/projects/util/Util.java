package com.bitguiders.hadoop.projects.util;

import java.text.DecimalFormat;

public class Util {

	public static String format(double number){
	DecimalFormat df = new DecimalFormat("###.##");
	return df.format(number)+"%";
	}
}
