package com.bitguiders.hadoop.spark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.receiver.Receiver;

import com.google.common.io.Closeables;
public final class StreamListener extends Receiver<String> {


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
  
  // ============= Receiver code that receives data over a socket ==============

  String host = null;
  int port = -1;

  public StreamListener(String host_ , int port_) {
    super(StorageLevel.MEMORY_AND_DISK_2());
    host = host_;
    port = port_;
  }

  @Override
  public void onStart() {
    // Start the thread that receives data over a connection
    //new Thread(this.receive).start();
	  
  }

  @Override
  public void onStop() {
    // There is nothing much to do as the thread calling receive()
    // is designed to stop by itself isStopped() returns false
  }

  /** Create a socket connection and receive data until receiver is stopped */
  private void receive() {
    try {
      Socket socket = null;
      BufferedReader reader = null;
      try {
        // connect to the server
        socket = new Socket(host, port);
        reader = new BufferedReader(
            new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        // Until stopped or connection broken continue reading
        String userInput;
        while (!isStopped() && (userInput = reader.readLine()) != null) {
          System.out.println("Received data '" + userInput + "'");
          store(userInput);
        }
      } finally {
        Closeables.close(reader, /* swallowIOException = */ true);
        Closeables.close(socket,  /* swallowIOException = */ true);
      }
      // Restart in an attempt to connect again when server is active again
      restart("Trying to connect again");
    } catch(ConnectException ce) {
      // restart if could not connect to server
      restart("Could not connect", ce);
    } catch(Throwable t) {
      restart("Error receiving data", t);
    }
  }
}