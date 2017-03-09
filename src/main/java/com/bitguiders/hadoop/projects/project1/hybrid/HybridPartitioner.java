package com.bitguiders.hadoop.projects.project1.hybrid;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

import com.bitguiders.hadoop.projects.util.Pair;

public class HybridPartitioner extends Partitioner<Pair, IntWritable> 
{

	@Override
	public int getPartition(Pair key, IntWritable value, int numReduceTask) 
	{
		if(key.getKey().equals("34") || key.getKey().equals("12")){
			return 1%numReduceTask;
		}else{
			return 2%numReduceTask;
		}
	}

}

