package com.bitguiders.hadoop.spark;

import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
public final class ETLStreamListener {

  @SuppressWarnings("serial")
public static void startStreaming(String master,String host,String port) throws InterruptedException{

	  JavaStreamingContext context = new JavaStreamingContext(master, "SparkStreamingTest",
	            Durations.seconds(2), System.getenv("SPARK_HOME"),
	            JavaStreamingContext.jarOfClass(ETLStreamListener.class));

	  JavaDStream<String> lines = context.textFileStream("hdfs://quickstart.cloudera:8020/user/cloudera/output");
	  //JavaDStream<String> lines = context.socketTextStream(host, Integer.parseInt(port));
	   
	  lines.foreachRDD(new VoidFunction<JavaRDD<String>>(){

		@Override
		public void call(JavaRDD<String> rdd) throws Exception {
			ELTRequestListener.receive();
			List<String> data = rdd.collect();
			for(String str:data){
				System.out.println("data => "+str);
				if(str.contains(";")){
				String param[] = str.split(";");
					if(param.length==4){
						ELTRequestListener.send(param[0], param[1], param[2],param[3]);
					}
				}
			}
			rdd.saveAsTextFile("/home/cloudera/workspace/hadoop/output");
		}
		  
	  });
	  
	  
	    //lines.print();
	    
	    
	    context.start();
	    context.awaitTermination();
	  
  }
  public static void main(String[] args) throws InterruptedException {
	String arg[] = {"local[2]","localhost","9999"};
    startStreaming(arg[0],arg[1], arg[2]);
  }
  
}