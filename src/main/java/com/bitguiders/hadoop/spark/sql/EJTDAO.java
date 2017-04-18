package com.bitguiders.hadoop.spark.sql;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;

import static com.bitguiders.hadoop.spark.util.EJTConstants.*;

public class EJTDAO extends GenericSparkConfiguration {

	public static void main(String[] args) {
		EJTDAO dao = new EJTDAO();
		
		System.out.println("Spark SQL");
		//dao.add();
		//dao.show();
		dao.showJobDetails("hybrid");
		//getList();
		
	}
	public void show(){
		 Dataset<Row> data = spark.read().csv(TABLE_PATH);
		 data.show();
	}
	public void add(){
		Dataset<Row> data = spark.read().csv(INPUT_PATH);
		
		data.createOrReplaceTempView(tableName);
		spark.sql("insert into etl_log values('kashif','mapreduce','hybrid','add')");
	}
	public List<ETLJobORM> getList(){
		 Dataset<ETLJobORM> data = spark.read().csv(TABLE_PATH).as(encoder);
		 //data.show();		
		 return data.collectAsList();
	}
	public void showJobDetails(String etlJob){
		Encoder<String> stringEncoder = Encoders.STRING();
		Dataset<String> data = spark.read().textFile(TABLE_PATH).as(stringEncoder);
		show();
		List<String> dl = data.collectAsList();
		for(String str: dl){
		    if(str.contains(etlJob)){
		    	System.out.println(str);
		    }
		}
	}
}