package com.bitguiders.hadoop.spark.examples;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class EJTHdfsIoHandler {

	public static void main(String arg[]){
		//String filePath="/home/cloudera/workspace/hadoop/input/users.txt";
		String filePath="hdfs://quickstart.cloudera:8020/user/cloudera/input/users.txt";
		String outputPath="/home/cloudera/workspace/hadoop/output";

		SparkConf conf = new SparkConf().setAppName(EJTHdfsIoHandler.class.getName()).setMaster("local").set("spark.executor.memory","1g");
		JavaSparkContext context = new JavaSparkContext(conf);
		JavaRDD<String> lines = context.textFile(filePath).cache();
		
		List<String> list = lines.collect();
		
		for(String line:list){
			System.out.println(line);
		}
		
		lines.saveAsTextFile(outputPath);
	}
}
