
/*package com.bitguiders.hadoop.mapreduce.average;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class AverageJob  extends Configured implements Tool {
	  public static void main(String args[]) throws Exception {
		    int res = ToolRunner.run(new AverageJob(), args);
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

		    job.setJobName("AverageJob");
		    job.setJarByClass(AverageJob.class);
		    
		    job.setInputFormatClass(TextInputFormat.class);
		    job.setOutputFormatClass(TextOutputFormat.class);
		    
		    job.setMapOutputKeyClass(Text.class);
		    job.setMapOutputValueClass(DoubleWritable.class);
		    
		    //job.setOutputKeyClass(Text.class);
		    //job.setOutputValueClass(IntWritable.class);

		    job.setMapperClass(AverageMapper.class);

		    return job.waitForCompletion(true) ? 0 : 1;
		  }

}
*/