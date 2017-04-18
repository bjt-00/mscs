package com.bitguiders.hadoop.projects.project1.stripes;


import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StripesReducer extends Reducer< Text,NeighborMap,Text,NeighborMap>
{
	@Override
	public void reduce(Text keyword,Iterable<NeighborMap> neighborList, Context context) throws IOException, InterruptedException
	{
		NeighborMap intermidiateMap=new NeighborMap();
		for(NeighborMap cuMap: neighborList)
		{
			intermidiateMap.mergeWithOtherFreqMap(cuMap);
		}
		NeighborMap outputMap= intermidiateMap.computeOcurrenceprobability();
		context.write(keyword, outputMap);		
	}

}

