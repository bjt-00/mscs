package com.bitguiders.hadoop.spark.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

public class GenericSparkConfiguration {
	 public  final Encoder<ETLJobORM> encoder = Encoders.bean(ETLJobORM.class);
	 public  SparkSession spark;

	 public GenericSparkConfiguration(){
			SparkConf conf = new SparkConf().setAppName("ejt").setMaster("local[*]");
			spark = SparkSession
				      .builder()
				      .config(conf)
				     //.config("spark.sql.warehouse.dir", "hdfs://quickstart.cloudera:8020/user/hive/warehouse/etl_log")
				      .getOrCreate();

			init();
	 }

	 private void init(){
		 	
		 	//ShellHandler.execute("echo 'waqas,mapreduce,stripes,add' >> "+inputPath);
		 	//spark table create statemt function is not consistant
		 	//spark.sql("drop table if exists etl_log");
		    //spark.sql("create table etl_log (userId String,domain String,etlJob String,operation String) USING hive");
		    //spark.sql("DELETE FROM etl_log");
		    //spark.sql("LOAD DATA LOCAL INPATH '"+inputPath+"' INTO TABLE etl_log");
	 }
	 
	 
}
