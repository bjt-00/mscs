package com.bitguiders.hadoop.spark.util;

public class EJTConstants {
	 public static final String tableName = "etl_log";
	 
	
	 public static String INPUT_PATH="hdfs://quickstart.cloudera:8020/user/cloudera/input";
	 public static String OUTPUT_PATH="hdfs://quickstart.cloudera:8020/user/cloudera/output";
	 public static String TABLE_PATH =INPUT_PATH+"/ejt/etl_log/etl_log.csv";
	 public static String DATA_SOURCE_PATH =INPUT_PATH+"/ejt/data.txt";
	 
	 public static String CMD_LIST="curl http://bitguiders.com/rest/ejt/?s=el&a=list";
	 public static String CMD_UPDATE="curl http://bitguiders.com/rest/ejt/?s=el&a=update&jid=";
	 public static String CMD_ADD="curl http://bitguiders.com/rest/ejt/?s=el&a=add";
	 
}
