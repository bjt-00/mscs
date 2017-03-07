package com.bitguiders.hadoop.temperature.with_in_mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TempReducer2 extends Reducer<Text, Text, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
      int sum = 0;
      int count=0;
      for (Text value : values) {
    	String data[] = value.toString().split("~");
        sum  += Integer.parseInt(data[0]);
        count+= Integer.parseInt(data[1]);
      }
      context.write(key, new IntWritable(sum/count));
    }
  }

