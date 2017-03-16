package com.bitguiders.hadoop.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class HTableCreator {

	public static void main(String arg[]) throws IOException{
		System.out.println("Starting..");
		
		Configuration conf = HBaseConfiguration.create();
		System.out.println("Configured..");
		HTable htable = new HTable(conf,"userx");
		Put put = new Put(Bytes.toBytes("1"));
		put.add(Bytes.toBytes("Row Key"),Bytes.toBytes("Empid"),Bytes.toBytes("1"));
		put.add(Bytes.toBytes("Personal Data"),Bytes.toBytes("Name"),Bytes.toBytes("John"));
		put.add(Bytes.toBytes("Personal Data"),Bytes.toBytes("City"),Bytes.toBytes("Boston"));
		put.add(Bytes.toBytes("Professional Data"),Bytes.toBytes("Designation"),Bytes.toBytes("Manager"));
		put.add(Bytes.toBytes("Professional Data"),Bytes.toBytes("Salary"),Bytes.toBytes("150,000"));
		
		System.out.println("Put operation is about to start..");
		htable.put(put);
		System.out.println("data inserted");
		htable.close();
		System.out.println(" Done!");
	}
}
