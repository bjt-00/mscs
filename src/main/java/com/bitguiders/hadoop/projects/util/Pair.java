package com.bitguiders.hadoop.projects.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class Pair implements WritableComparable<Pair> {
	String key;
	String value;

	public Pair(){
		
	}
	public Pair(String key,String value){
		this.key=key;
		this.value=value;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key=key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void readFields(DataInput in) throws IOException {
		this.key = WritableUtils.readString(in);
		this.value = WritableUtils.readString(in);
	}
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, key);
		WritableUtils.writeString(out, value+"");
	}
	public int compareTo(Pair pair) {
		if(pair==null)
		return 0;
		return key.compareTo(pair.getKey());//&value.compareTo(pair.getValue());
	}
	
	@Override
	public String toString() {
	return key+ "," + value;
	}
	
}
