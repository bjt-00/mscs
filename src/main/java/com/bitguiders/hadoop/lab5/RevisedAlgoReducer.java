package com.bitguiders.hadoop.lab5;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RevisedAlgoReducer extends Reducer<Text, IntWritable, Text, Text> {

	String activeKey="";
	String currentKey="";
	StringBuilder output = new StringBuilder();
	String currentDocId="";
	String activeDocId="";
	 int sum = 0;
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
     
     String data[] = key.toString().split("~");
     currentKey = data[0];
     currentDocId = data[1];
    

      if(!activeKey.equals(currentKey) && !activeKey.equals("")){
    	  context.write(new Text(activeKey+" "), new Text(format(output.toString())));
	      //reset
    	   activeKey = currentKey;
	       sum=0;
	       output.delete(0,output.length());
    	}
      for (IntWritable value : values) {
    	  sum += value.get();
      }
      
      activeKey = currentKey;
    	  output.append("(").append(currentDocId).append(",").append(sum).append(")-->");
	       sum=0;
	       activeDocId = currentDocId;
    }
    @Override
    public void cleanup(Context context) throws IOException, InterruptedException{
  	  context.write(new Text(activeKey+" "), new Text(format(output.toString())));

    }
    private String format(String output){
    	
    	return output.substring(0,output.lastIndexOf("-->"));
    }
}
