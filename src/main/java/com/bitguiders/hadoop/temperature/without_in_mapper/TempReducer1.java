package com.bitguiders.hadoop.temperature.without_in_mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TempReducer1 extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
      int sum = 0;
      int count=0;
      for (IntWritable value : values) {
        sum += value.get();
        count++;
      }
      context.write(key, new IntWritable(sum/count));
    }
  }

