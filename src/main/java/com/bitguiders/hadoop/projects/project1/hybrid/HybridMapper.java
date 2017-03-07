package com.bitguiders.hadoop.projects.project1.hybrid;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

	public class HybridMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
		IntWritable one = new IntWritable(1);   
		@Override
		    public void map(LongWritable key, Text value,
		                    Mapper.Context context) throws IOException, InterruptedException {
			   
			   String line = value.toString();
			   String[] tokens = line.split(" ");
			   String currentWord="";
			   String customer =tokens[0];
			   
			   StringBuilder console = new StringBuilder(customer);
			   console.append("=>").append("[");
			   for(int i=1;i<tokens.length;i++){
				   currentWord = tokens[i];
				   console.append("{");
				   neighboursLoop:
				   for(int j=i+1;j<tokens.length;j++){
					   
					   /*Let the neighborhood of X, N(X) be the set of all terms after X and
					   before the next X. Example: Let Data block be [a b c a d e]
					   N(a) = {b, c}, N(b) = {c, a, d, e}, N(c) = {a, d, e}, N(a) ={d, e}, N(d) = {e}, N(e) = {}.
					   */
					   if(tokens[i].equals(tokens[j])){
						   break neighboursLoop;
					   }
					   context.write(new Text(currentWord+","+tokens[j]), one);
					   console.append("<(").append(currentWord).append(",").append(tokens[j])
					   .append(")").append(",").append(one.toString()).append(">");
				   }
				   console.append("},");
			   }
			  console.append("]");
			  System.out.println(console.toString());
		   }
		   @Override
		    public void cleanup(Context context) throws IOException, InterruptedException{
		    }

}
