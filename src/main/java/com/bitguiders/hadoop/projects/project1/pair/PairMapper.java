package com.bitguiders.hadoop.projects.project1.pair;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

import com.bitguiders.hadoop.projects.project1.hybrid.HybridMapper;
import com.bitguiders.hadoop.projects.util.Pair;

public class PairMapper extends Mapper<LongWritable, Text, Pair, IntWritable> {
	 private static Logger logger = Logger.getLogger(HybridMapper.class);
	IntWritable one = new IntWritable(1);   
	TreeMap<Pair,Integer> subMap = new TreeMap<Pair,Integer>();
	@Override
	    public void map(LongWritable key, Text value,
	                    Mapper.Context context) throws IOException, InterruptedException {
		   
		   String line = value.toString();
		   String[] tokens = line.split(" ");
		   String currentWord="";
		   for(int i=1;i<tokens.length;i++){
			   currentWord = tokens[i];
			   neighboursLoop:
			   for(int j=i+1;j<tokens.length;j++){
				   
				   if(tokens[i].equals(tokens[j])){
					   break neighboursLoop;
				   }
				   Pair pair = new Pair(currentWord,tokens[j]);
				   int count = (subMap.containsKey(pair)? subMap.get(pair):0);
				   count += one.get();
				   subMap.put(pair, count);
				    //context.write(pair, one);
			   }
		   }
		  
	   }
	   @Override
	    public void cleanup(Context context) throws IOException, InterruptedException{
		   
	    	for(Pair val :subMap.keySet()){
	    		context.write(val, new IntWritable(subMap.get(val)));
	    	}

	    }

}
