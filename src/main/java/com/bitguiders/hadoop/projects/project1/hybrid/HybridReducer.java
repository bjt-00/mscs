package com.bitguiders.hadoop.projects.project1.hybrid;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.bitguiders.hadoop.projects.util.Pair;

public class HybridReducer extends Reducer<Pair, IntWritable, Text, Text> {
	TreeMap<String,TreeMap> finalMap = new TreeMap<String,TreeMap>();
    @Override
    public void reduce(Pair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

    	//load if map already exists for given key
    	TreeMap<String,Integer> subMap = (finalMap.containsKey(key.getKey())?finalMap.get(key.getKey()):new TreeMap<String,Integer>()); 

    	//get existing count for given key;
  		int count =0;
 
  		for(IntWritable value:values){
  			count = (subMap.containsKey(key.getValue())? subMap.get(key.getValue()):0);
  			count ++;
  			subMap.put(key.getValue(), count);
    	}
    	
    	//(Mary~34,{(56,2),(num, count)}
    	finalMap.put(key.getKey(),subMap);
    }
    @Override
    public void cleanup(Context context) throws IOException, InterruptedException{
    	TreeMap<String, Integer> counterMap = new TreeMap<String,Integer>();
    	
    	for(String m:finalMap.keySet()){
    		TreeMap<String,Integer> subMap = finalMap.get(m);
    		int mapTotal = 0;
    			for(String sm: subMap.keySet()){
    				mapTotal +=subMap.get(sm);
    		}
    		counterMap.put(m, mapTotal);
    	}
 
    	StringBuilder console = new StringBuilder("");
    	for(String m:finalMap.keySet()){
    		  // String keySplit[] = m.split("~");
			   
    		   console.append(m);
			   console.append("=>").append("[");

    		TreeMap<String,Integer> subMap = finalMap.get(m);
    		int mapTotal = counterMap.get(m);
    			for(String sm: subMap.keySet()){
    				int subTotal = subMap.get(sm);
    				float probability = subTotal/mapTotal;
    				console.append("<(").append(sm).append(",")
    				.append(subMap.get(sm)).append("/").append(mapTotal).append(")").append(">");
    		}
    		console.append("]");
    		context.write(new Text(),new Text(console.toString()));
    		console.delete(0, console.length());
    	}
    }
    public static void main(String[] arg){
    	Float  val= new Float(2/7);
    	
    	System.out.println(String.format("%.2f", val));
    }
  }