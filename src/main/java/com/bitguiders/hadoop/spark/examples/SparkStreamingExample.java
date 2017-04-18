package com.bitguiders.hadoop.spark.examples;

import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * Counts words in UTF8 encoded, '\n' delimited text received from the network every second.
 * Usage: NetworkWordCount <master> <hostname> <port>
 *   <master> is the Spark master URL. In local mode, <master> should be 'local[n]' with n > 1.
 *   <hostname> and <port> describe the TCP server that Spark Streaming would connect to receive data.
 *
 * To run this on your local machine, you need to first run a Netcat server
 *    `$ nc -lk 9999`
 * and then run the example
 *    `$ ./run org.apache.spark.streaming.examples.JavaNetworkWordCount local[2] localhost 9999`
 */
public final class SparkStreamingExample {

  private SparkStreamingExample() {
  }

  public static void startStreaming(String master,String host,String port) throws InterruptedException{

	  JavaStreamingContext context = new JavaStreamingContext(master, "SparkStreamingTest",
	            Durations.seconds(2), System.getenv("SPARK_HOME"),
	            JavaStreamingContext.jarOfClass(SparkStreamingExample.class));

	    JavaDStream<String> lines = context.socketTextStream(host, Integer.parseInt(port));
	    lines.print();

	    context.start();
	    context.awaitTermination();
	  
  }
  public static void main(String[] args) throws InterruptedException {
	String arg[] = {"local[2]","localhost","9999"};
    startStreaming(arg[0],arg[1], arg[2]);
  }
}