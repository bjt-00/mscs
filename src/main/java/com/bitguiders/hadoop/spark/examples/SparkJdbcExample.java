package com.bitguiders.hadoop.spark.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SparkJdbcExample {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	/**
	 * @param args
	 * @throws SQLException
	 */
	
	public void init(String tableName) throws SQLException{
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");
		Statement stmt = con.createStatement();
		stmt.execute("drop table if exists " + tableName);
		stmt.execute("create table if not exists " + tableName + " (user_id String, domain String, etl_job String,operation String) row format delimited fields terminated by ','");
		stmt.execute("delete from "+tableName);
		stmt.execute("insert into etl_log values('abdul','mapreduce','hybrid','add')");
	}
	
	public static void main(String[] args) throws SQLException {
		SparkJdbcExample e = new SparkJdbcExample();
		e.init("etl_log");
		String sql;
		// show tables
		/*
		String sql = "show tables '" + tableName + "'";
		System.out.println("Running: " + sql);
		ResultSet res = stmt.executeQuery(sql);
		if (res.next()) {
			System.out.println(res.getString(1));
		}
		// describe table
		sql = "describe " + tableName;
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1) + "\t" + res.getString(2)+ "\t" + res.getString(3));
		}
*/
		// load data into table
		// NOTE: filepath has to be local to the hive server
		/*
		String filepath = "/home/cloudera/Desktop/hadoop/hive/etl_log.txt";
		sql = "load data local inpath '" + filepath + "' into table "
				+ tableName;
		System.out.println("Running: " + sql);
		stmt.execute(sql);

		// select * query
		sql = "select * from " + tableName;
		System.out.println("Running: " + sql+"\n");
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(String.valueOf(res.getInt(1)) + "\t"
					+ res.getString(2)+ "\t" + res.getString(3));
		}
*/
	}
}