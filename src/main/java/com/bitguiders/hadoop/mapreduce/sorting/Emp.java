package com.bitguiders.hadoop.mapreduce.sorting;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class Emp implements WritableComparable<Emp> {
	String empId;
	String lastName;
	String department;
	
	public Emp(){
		
	}
	public Emp(String[] vals){
		this.empId=vals[0];
		this.lastName=vals[1];
		this.department=vals[2];
	}
	public Emp(String empId,String lastName){
		this.empId=empId;
		this.lastName=lastName;
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId=empId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public void readFields(DataInput in) throws IOException {
		this.empId = WritableUtils.readString(in);
		this.lastName = WritableUtils.readString(in);
	}
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, empId);
		WritableUtils.writeString(out, lastName+"");
	}
	public int compareTo(Emp pair) {
		String key= toString();
		if(pair==null)
		return 0;
		return -1*key.compareTo(pair.toString());
	}
	
	@Override
	public String toString() {
	return  lastName;
	}
	
}
