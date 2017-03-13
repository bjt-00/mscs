package com.bitguiders.hadoop.mapreduce.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CombinerClass extends Reducer<Text, IntWritable, Text, IntWritable> {

	    @Override
	    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
	      int sum = 0;
	      for (IntWritable value : values) {
	        sum += value.get();
	      }
	      
	      System.out.println("Combiner values = <"+key+","+sum+">");
	      context.write(key, new IntWritable(sum));
	    }
 }

