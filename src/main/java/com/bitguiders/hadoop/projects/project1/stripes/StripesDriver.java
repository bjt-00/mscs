package com.bitguiders.hadoop.projects.project1.stripes;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class StripesDriver extends Configured implements Tool
{
	public static void main(String [] args) throws Exception
	{
		StripesDriver driver =new StripesDriver();
		int res=ToolRunner.run(driver, args);
		System.exit(res);
	}

	public int run(String[] args) throws  IOException, ClassNotFoundException, InterruptedException 
	{
		int NoRedTask ;
		try
		{
			NoRedTask=Integer.parseInt(args[2]);
		}
		catch(Exception e)
		{
			NoRedTask=2;
		}
	    Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "Stripe Algorithm Frequency Occurrence");
	    
	    job.setJarByClass(StripesDriver.class);
	    
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    
	    job.setMapperClass(StripesMapper.class);
	    job.setReducerClass(StripesReducer.class);
	    job.setMapOutputKeyClass(Text.class);
	    job.setMapOutputValueClass(NeighborMap.class);
	    job.setPartitionerClass(StripesPartitioner.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(NeighborMap.class); 
	    job.setNumReduceTasks(NoRedTask);
	   
	    return job.waitForCompletion(true) ? 0 : 1;
	}
}

