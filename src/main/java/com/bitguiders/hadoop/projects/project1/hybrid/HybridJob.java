package com.bitguiders.hadoop.projects.project1.hybrid;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;

import com.bitguiders.hadoop.projects.util.GenericConfigurations;
import com.bitguiders.hadoop.projects.util.Pair;

	public class HybridJob  extends GenericConfigurations implements Tool {

			  public int run(String[] args) throws Exception {
			    
				Job job = getJob(args, "hybrid");
			    job.setInputFormatClass(TextInputFormat.class);
			    job.setOutputFormatClass(TextOutputFormat.class);
			    
			    job.setMapOutputKeyClass(Pair.class);
			    job.setMapOutputValueClass(IntWritable.class);
			    
			    job.setOutputKeyClass(Text.class);
			    job.setOutputValueClass(Text.class);
			    
			    job.setMapperClass(HybridMapper.class);
			    job.setReducerClass(HybridReducer.class);
			    	    
			    return job.waitForCompletion(true) ? 0 : 1;
			  }

	}
