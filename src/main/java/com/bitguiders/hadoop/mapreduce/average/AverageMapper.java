/*package com.bitguiders.hadoop.mapreduce.average;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AverageMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
	    TreeMap<String,TreeMap> finalMap = new TreeMap<String,TreeMap>();
	    @Override
	    public void map(LongWritable key, Text value,
	                    Mapper.Context context) throws IOException, InterruptedException {
	    	TreeMap<String,Integer> subMap;
	    	StringTokenizer tokenizer = new StringTokenizer(value.toString()," ");
	    	int count=0;
	    	String c;
	    	String w;
	    	while(tokenizer.hasMoreTokens()){
	    		w = tokenizer.nextToken().toLowerCase();
	    		c = w.charAt(0)+"";
	    		subMap = (finalMap.containsKey(c)?finalMap.get(c):new TreeMap<String,Integer>());
	    		count  = (subMap.containsKey(w)?subMap.get(w):0);
	    		count +=1;
	    		subMap.put(w,count);
	    		finalMap.put(c,subMap);
	    	}
	    }
	    
	    @Override
	    public void cleanup(Context context) throws IOException, InterruptedException{
	    	
	    	for(String k:finalMap.keySet()){
	    		TreeMap<String,Integer> subMap = finalMap.get(k);
	    		double totalLength=0;
	    		for(String w:subMap.keySet()){
	    			totalLength += w.length();
	    		}
	    			double average = totalLength/subMap.size();
	    			context.write(new Text(k+"=> "+totalLength+"/"+subMap.size()+" = "), new DoubleWritable(average));	    			
	    	}
	    }
 }
*/