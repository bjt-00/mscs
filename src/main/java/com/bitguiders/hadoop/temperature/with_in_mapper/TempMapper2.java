package com.bitguiders.hadoop.temperature.with_in_mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TempMapper2 extends Mapper<LongWritable, Text, Text, IntWritable> {
	    private Text year = new Text();

	    String activeYear="";
	    int sum=0;
	    int count=0;
	    StringBuilder val = new StringBuilder();
	    
	    @Override
	    public void map(LongWritable key, Text value,
	                    Mapper.Context context) throws IOException, InterruptedException {
	      String line = value.toString();
	      String currentYear = parseDate(line);
	     
	      int temp = parseTemperature(line);
	      
	      //catch new entry
	      if(!currentYear.equals(activeYear)&& !activeYear.equals("")){
	    	  
	    	  year.set(activeYear+" ("+(val.toString()).substring(0,val.length()-1)+") => "+sum+"/"+count+" = ");
		      context.write(year, new IntWritable(sum/count));
		      
		      //reset
		      val.delete(0, val.length());
		      activeYear = currentYear;
		      sum=0;
		      count=0;
	      }
	    	  	 activeYear = currentYear;
		    	 sum += temp;
		    	 val.append(temp).append("+");
		    	 count++;
	    }
	    private String parseDate(String line){
	    	return line.substring(15,19);
	    }
	    private int parseTemperature(String line){
	    	return Integer.parseInt(line.substring(line.length()-18,line.length()-12));
	    }
	    
	    @Override
	    public void cleanup(Context context) throws IOException, InterruptedException{
	    	  year.set(activeYear+" ("+(val.toString()).substring(0,val.length()-1)+") => "+sum+"/"+count+" = ");
		      context.write(year, new IntWritable(sum/count));
	    }
 }
