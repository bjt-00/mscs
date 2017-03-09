package com.bitguiders.hadoop.projects.project1.stripes;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class StripesPartitioner extends Partitioner<Text,NeighborMap> 
{

	@Override
	public int getPartition(Text key, NeighborMap map, int numReduceTask) 
	{
		
		if(key.toString().equals("34") || key.toString().equals("12")){
			return 1%numReduceTask;
		}else{
			return 2%numReduceTask;
		}
	}

}

