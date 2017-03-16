package com.bitguiders.hadoop.spark;

public class SparkTest {
	static{System.out.println("outer block");}
	public static void main(String arg[]){
		String filePath="/home/cloudera/Desktop/hadoop/spark/spark.txt";
		System.out.println(filePath);
	}
}
