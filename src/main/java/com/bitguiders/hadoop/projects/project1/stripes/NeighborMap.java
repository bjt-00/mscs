package com.bitguiders.hadoop.projects.project1.stripes;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Set;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class NeighborMap implements Writable
{
	private MapWritable map=new MapWritable();
	
	public  boolean isEmpty()
	{
		return map.size()==0;
	}
		
	public void mergeWithOtherFreqMap(NeighborMap otherNeighborMap)
	{
		Set<Writable> curKeys=otherNeighborMap.map.keySet();
		for(Writable key:curKeys)
		{
			if(this.map.containsKey(key))
			{
				int old=((IntWritable)(this.map.get(key))).get();
				int to_add=((IntWritable)(otherNeighborMap.map.get(key))).get();
				map.put(key, new IntWritable(old+to_add));
			}
			else
			{				
				int to_add=((IntWritable)(otherNeighborMap.map.get(key))).get();
				map.put(key, new IntWritable(to_add));
			}
		}
	}
	
	public NeighborMap computeOcurrenceprobability()
	{
		NeighborMap ProbabilityMap=new NeighborMap();
		
		int marginal=0;
		Set<Writable> keys=map.keySet();
		for(Writable t: keys)
		{
			marginal = marginal+((IntWritable)map.get(t)).get();
			
		}
		for(Writable t: keys)
		{
			int tempInt=(((IntWritable)map.get(t)).get()*100)/marginal;
			ProbabilityMap.map.put(t, new IntWritable(tempInt));
		}
		return ProbabilityMap;
		
	}
	
	public void addFrequency(Text t)
	{
		if(map.get(t)==null)
		{
			map.put(t, new IntWritable(1));
		}
		else
		{
			IntWritable newvalue=new IntWritable(((IntWritable)(map.get(t))).get()+1);
			map.put(t, newvalue);
		}
	}
	
	
	public void readFields(DataInput in) throws IOException 
	{
		map.readFields(in);
		
	}

	public void write(DataOutput out) throws IOException 
	{
		map.write(out);
		
	}
	
	@Override
	public String toString() 
	{
		String output="";
		Set<Writable> keys=map.keySet();
		System.out.print("{");
		output+="{";
		int i=0;
		for(Writable t: keys)
		{
			Text item=(Text)t;
			IntWritable count=(IntWritable)map.get(t);
			if(i==0)
			{
				output+="("+item.toString()+", "+count+")";
			}
			else
			{
				output+=", ("+item.toString()+", "+count+")";
			}
			i++;
		}
		output+="}";
		return output;
	}

}	

