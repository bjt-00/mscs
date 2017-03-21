package com.bitguiders.hadoop.spark.sql;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static com.bitguiders.hadoop.spark.EJTConstants.*;

public class EJTDAO extends GenericSparkConfiguration {

	public static void main(String[] args) {
		EJTDAO dao = new EJTDAO();
		
		System.out.println("Spark SQL");
		//dao.add();
		dao.show();
		//getList();
		
	}
	public void show(){
		 Dataset<Row> data = spark.read().csv(TABLE_PATH);
		 data.show();
	}
	public void add(){
		Dataset<Row> data = spark.read().csv(TABLE_PATH);
		data.createOrReplaceTempView(tableName);
		spark.sql("insert into etl_job values('kashif','mapreduce','hybrid','add')");
	}

	public Dataset<Row> getDataset(){
	    Dataset<Row> data = spark.read().csv(TABLE_PATH); 
	    
	    return data;
	}
	public List<ETLJobORM> getList(){
		 Dataset<ETLJobORM> data = spark.read().csv(TABLE_PATH).as(encoder);
		 //data.show();		
		 return data.collectAsList();
	}
}