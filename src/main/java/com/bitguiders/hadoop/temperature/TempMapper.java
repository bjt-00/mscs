package com.bitguiders.hadoop.temperature;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TempMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	    private Text date = new Text();
	    private IntWritable temp = new IntWritable();

	    @Override
	    public void map(LongWritable key, Text value,
	                    Mapper.Context context) throws IOException, InterruptedException {
	      String line = value.toString();
	      
	        date.set( parseDate(line));
	        temp.set(parseTemperature(line));
	        context.write(date, temp);
	    }
	    private String parseDate(String line){
	    	return line.substring(15,19);
	    }
	    private int parseTemperature(String line){
	    	return Integer.parseInt(line.substring(line.length()-18,line.length()-12));
	    }
 }
