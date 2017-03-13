package com.bitguiders.hadoop.mapreduce.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCount extends Configured implements Tool {

	  public static void main(String args[]) throws Exception {
	    int res = ToolRunner.run(new WordCount(), args);
	    System.exit(res);
	  }

	  public int run(String[] args) throws Exception {
	    Path inputPath = new Path(args[0]);
	    Path outputPath = new Path(args[1]);

	    Configuration conf = getConf();
	    conf.set("fs.file.impl","com.conga.services.hadoop.patch.HADOOP_7682.WinLocalFileSystem");
	    Job job = new Job(conf, this.getClass().toString());

	    FileInputFormat.setInputPaths(job, inputPath);
	    FileOutputFormat.setOutputPath(job, outputPath);

	    job.setJobName("WordCount");
	    job.setJarByClass(WordCount.class);
	    
	    job.setInputFormatClass(TextInputFormat.class);
	    job.setOutputFormatClass(TextOutputFormat.class);
	    
	    job.setMapOutputKeyClass(Text.class);
	    job.setMapOutputValueClass(IntWritable.class);
	    
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);

	    job.setMapperClass(MapClass.class);
	    job.setCombinerClass(CombinerClass.class);
	    job.setReducerClass(ReduceClass.class);

	    return job.waitForCompletion(true) ? 0 : 1;
	  }
}