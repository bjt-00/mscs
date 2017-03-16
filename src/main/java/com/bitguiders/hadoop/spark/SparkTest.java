package com.bitguiders.hadoop.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkTest {
	static{System.out.println("outer block");}
	public static void main(String arg[]){
		//String filePath="/home/cloudera/Desktop/hadoop/spark/spark.txt";
		String filePath="D:\\workspaces\\bitguiders\\java\\hadoop\\input\\input.txt";
		System.out.println(filePath);
		
		SparkConf conf = new SparkConf().setAppName("sparkTest");
		JavaSparkContext context = new JavaSparkContext(conf);
		JavaRDD<String> lines = context.textFile(filePath).cache();
		
		for(int i=0;i<lines.count();i++){
			System.out.println(lines.toString());
		}
	}
}
