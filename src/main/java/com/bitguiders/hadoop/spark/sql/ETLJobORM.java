package com.bitguiders.hadoop.spark.sql;
import java.io.Serializable;

public class ETLJobORM implements Serializable {

	String userId;
	String domain;
	String etlJob;
	String operation;
	
	public ETLJobORM(){}
	public ETLJobORM(String userId,String domain,String etlJob,String operation){
		this.userId = userId;
		this.domain = domain;
		this.etlJob = etlJob;
		this.operation = operation;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getEtlJob() {
		return etlJob;
	}
	public void setEtlJob(String etlJob) {
		this.etlJob = etlJob;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	@Override
	public String toString() {
		return "ETLLogORM [userId=" + userId + ", domain=" + domain
				+ ", etlJob=" + etlJob + ", operation=" + operation + "]";
	}
}