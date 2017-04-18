package com.bitguiders.hadoop.projects.project1.stripes;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class StripesMapper extends Mapper<LongWritable, Text,Text, NeighborMap > 
{
	HashMap<Text,NeighborMap>  associativeMap;
	
	@Override
	public void setup(Context context)
	{
		 associativeMap= new HashMap<Text, NeighborMap>();
		 
	}
	@Override
	public  void map(LongWritable key, Text doc, Context context) throws IOException, InterruptedException
	{
		StringTokenizer itr = new StringTokenizer(doc.toString());
		List<String> allWords=new ArrayList<String>();
		while (itr.hasMoreTokens()) 
		{
			allWords.add(itr.nextToken().trim());
		}
		allWords.remove(0);
		int index_count=0;
		for(String main_word:allWords)
		{
			List<Text> neighbours=WordHelper.getNeighbours(allWords, index_count);
			NeighborMap tempMap=new NeighborMap();			
			for(Text neighbour: neighbours)
			{
				tempMap.addFrequency(neighbour);
			}
			index_count++;
			
			if(associativeMap.get(new Text(main_word))==null)
			{
				associativeMap.put(new Text(main_word), tempMap);
			}
			else
			{
				associativeMap.get(new Text(main_word)).mergeWithOtherFreqMap(tempMap);
			}
			
		}
	}
	@Override
	public void cleanup(Context context) throws IOException, InterruptedException
	{
		
		Set<Text> keys=associativeMap.keySet();
		for(Text t: keys)
		{
			if(!associativeMap.get(t).isEmpty())
			{
				context.write(t, associativeMap.get(t));
				System.out.println(t+"   "+associativeMap.get(t).toString());
			}
		}
		
	}
	
}

