package com.bitguiders.hadoop.mapreduce.sorting;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Emp> {
	    @Override
	    public void map(LongWritable key, Text value,
	                    Mapper.Context context) throws IOException, InterruptedException {
	    	String words[] = (value.toString()).split(" ");
	    	context.write(new Text(words[0]), new Emp(words));
	    }
	    
	    @Override
	    public void cleanup(Context context) throws IOException, InterruptedException{
	    }
 }
