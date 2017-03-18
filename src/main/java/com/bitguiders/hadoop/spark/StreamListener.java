package com.bitguiders.hadoop.spark;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
public final class StreamListener {

  private StreamListener() {
  }

  public static void startStreaming(String master,String host,String port) throws InterruptedException{

	  JavaStreamingContext context = new JavaStreamingContext(master, "SparkStreamingTest",
	            Durations.seconds(2), System.getenv("SPARK_HOME"),
	            JavaStreamingContext.jarOfClass(StreamListener.class));

	    //JavaDStream<String> lines = context.textFileStream("hdfs://quickstart.cloudera:8020/user/hive/warehouse/employees");
	    JavaDStream<String> lines = context.socketTextStream(host, Integer.parseInt(port));
	    lines.filter(new Function<String,Boolean>(){
	    	
			@Override
			public Boolean call(String v1) throws Exception {
				System.out.println("new msg "+v1);
				return true;
			}
	    	
	    });
	    lines.print();
	    
	    
	    context.start();
	    context.awaitTermination();
	  
  }
  public static void main(String[] args) throws InterruptedException {
	String arg[] = {"local[2]","localhost","9999"};
    startStreaming(arg[0],arg[1], arg[2]);
  }
}