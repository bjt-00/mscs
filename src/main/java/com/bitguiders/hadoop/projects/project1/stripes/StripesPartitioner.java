package com.bitguiders.hadoop.projects.project1.stripes;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class StripesPartitioner extends Partitioner<Text,NeighborMap> 
{

	@Override
	public int getPartition(Text keyWord, NeighborMap map, int numReduceTask) 
	{
		int start=keyWord.toString().charAt(0);
		return (start & Integer.MAX_VALUE)%numReduceTask;
	}

}

