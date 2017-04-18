package com.bitguiders.hadoop.projects.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

	public class GenericConfigurations  extends Configured {
			
			  public Job getJob(String[] args,String jobName) throws Exception {
			    Path inputPath = new Path(args[0]);
			    Path outputPath = new Path(args[1]);

			    Configuration conf = getConf();
			    conf.set("fs.file.impl","com.conga.services.hadoop.patch.HADOOP_7682.WinLocalFileSystem");
			    conf.set("mapreduce.output.basename", jobName);
			    Job job = new Job(conf, this.getClass().toString());
			    
			    FileInputFormat.setInputPaths(job, inputPath);
			    FileOutputFormat.setOutputPath(job, outputPath);

			    job.setJobName(jobName);
			    job.setJarByClass(GenericConfigurations.class);
			    
			    job.setNumReduceTasks(2);
			    job.setPartitionerClass(GenericPartitioner.class);
			    return job;
			  }

	}
