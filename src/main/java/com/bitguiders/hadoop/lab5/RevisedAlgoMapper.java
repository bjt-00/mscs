package com.bitguiders.hadoop.lab5;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RevisedAlgoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    int counter=0;
    @Override
    public void map(LongWritable key, Text value,
                    Mapper.Context context) throws IOException, InterruptedException {
    	counter++;
      String line = value.toString();
      System.out.println("M-"+counter+" : <INPUT>\n <"+key+","+value+">");
      StringTokenizer tokenizer = new StringTokenizer(line);
      while (tokenizer.hasMoreTokens()) {
        word.set(tokenizer.nextToken()+"~"+counter+"01");
        System.out.println("<"+word+","+one+">");
        context.write(word, one);
      }
    }
  }
