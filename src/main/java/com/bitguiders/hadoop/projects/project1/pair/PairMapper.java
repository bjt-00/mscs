package com.bitguiders.hadoop.projects.project1.pair;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

	public class PairMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
		   @Override
		    public void map(LongWritable key, Text value,
		                    Mapper.Context context) throws IOException, InterruptedException {

		   }
		   @Override
		    public void cleanup(Context context) throws IOException, InterruptedException{
		    }

}
