package com.bitguiders.hadoop.projects.project1.pair;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.bitguiders.hadoop.projects.util.Pair;
import com.bitguiders.hadoop.projects.util.Util;

public class PairReducer extends Reducer<Pair, IntWritable, Text, Text> {

	TreeMap<Pair,TreeMap> finalMap = new TreeMap<Pair,TreeMap>();
    @Override
    public void reduce(Pair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
    	
    	//load if map already exists for given key
    	TreeMap<Pair,Integer> subMap = (finalMap.containsKey(new Pair(key.getKey(),""))?finalMap.get(new Pair(key.getKey(),"")):new TreeMap<Pair,Integer>()); 

    	//get existing count for given key;
  		int count =0;
 
  		for(IntWritable value:values){
  			Pair p = new Pair("",key.getValue());
  			count = (subMap.containsKey(p)? subMap.get(p):0);
  			count += value.get();
  			subMap.put(p, count);
  			}
    	
    	finalMap.put(new Pair(key.getKey(),""),subMap);
    }
    @Override
    public void cleanup(Context context) throws IOException, InterruptedException{
   	TreeMap<String, Integer> counterMap = new TreeMap<String,Integer>();
    	
    	for(Pair m:finalMap.keySet()){
    		TreeMap<Pair,Integer> subMap = finalMap.get(m);
    		int mapTotal = 0;
    			for(Pair sm: subMap.keySet()){
    				mapTotal +=subMap.get(sm);
    		}
    		counterMap.put(m.getKey(), mapTotal);
    	}
 
    	StringBuilder console = new StringBuilder();
    	for(Pair pair:finalMap.keySet()){
			   
    		   console.append("[");

    		TreeMap<Pair,Integer> subMap = finalMap.get(pair);
    		double mapTotal = counterMap.get(pair.getKey());
    			for(Pair sm: subMap.keySet()){
    				int subTotal = subMap.get(sm);
    				double probability = (subTotal/mapTotal);
    				console.append("<(").append(pair.getKey()).append(",").append(sm.getValue()).append("),")
    				.append(Util.format(probability))
    				.append(">");
    		}
    		console.append("]");
    		context.write(new Text(),new Text(console.toString()));
    		console.delete(0, console.length());
    	}
    }

  }