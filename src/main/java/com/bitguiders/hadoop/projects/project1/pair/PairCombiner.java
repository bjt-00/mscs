package com.bitguiders.hadoop.projects.project1.pair;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import com.bitguiders.hadoop.projects.util.Pair;

public class PairCombiner extends Reducer<Pair, IntWritable, Pair, IntWritable> {

    @Override
    public void reduce(Pair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

    	int count=0;
    	for(IntWritable val :values){
    		count +=val.get();
    	}
    	context.write(key,new IntWritable(count));
    }
    @Override
    public void cleanup(Context context) throws IOException, InterruptedException{
    }

  }