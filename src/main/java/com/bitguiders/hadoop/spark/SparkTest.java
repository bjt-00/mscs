package com.bitguiders.hadoop.spark;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class SparkTest {

	/* private static final FlatMapFunction<String, String> WORDS_EXTRACTOR = 
	            new FlatMapFunction<String, String>() { 
	                @Override 
	                public Iterator<String> call(String s) throws Exception { 
	                	System.out.println(s);
	                    return (Iterator<String>) Arrays.asList(s.split(" ")); 
	                } 
	            }; 
            private static final PairFunction<String, String, Integer> WORDS_MAPPER = 
                    new PairFunction<String, String, Integer>() { 
                        @Override 
                        public Tuple2<String, Integer> call(String s) throws Exception { 
                            return new Tuple2<String, Integer>(s, 1); 
                        } 
                    }; 
         
            private static final Function2<Integer, Integer, Integer> WORDS_REDUCER = 
                    new Function2<Integer, Integer, Integer>() { 
                        @Override 
                        public Integer call(Integer a, Integer b) throws Exception { 
                            return a + b; 
                        } 
                    }; 

              public static void main_(String[] args) { 
            	 
                String inputFileName = "/home/cloudera/workspace/hadoop/input/users.txt" ; 
                String outputDirName = "/home/cloudera/workspace/hadoop/output/spark" ; 
         
                SparkConf conf = new SparkConf().setAppName(SparkTest.class.getName()).setMaster("local[*]").set("spark.executor.memory","1g");; 
                JavaSparkContext context = new JavaSparkContext(conf); 
         
                JavaRDD<String> file = context.textFile(inputFileName); 
                JavaRDD<String> words = file.flatMap(WORDS_EXTRACTOR); 
                JavaPairRDD<String, Integer> pairs = words.mapToPair(WORDS_MAPPER); 
                JavaPairRDD<String, Integer> counter = pairs.reduceByKey(WORDS_REDUCER); 
         
                
                //System.out.println("Total words = "+file.count());
                counter.saveAsTextFile(outputDirName); 
            } */
	public static void main(String arg[]){
		//String filePath="/home/cloudera/workspace/hadoop/input/users.txt";
		//String filePath="hdfs://quickstart.cloudera:8020/user/cloudera/input/users.txt";

		String outputPath="/home/cloudera/workspace/hadoop/output";
		//filePath ="/user/hive/warehouse/employees.csv";
		String filePath="D:\\workspaces\\bitguiders\\java\\hadoop\\input\\input.txt";
		System.out.println(filePath);
		
		SparkConf conf = new SparkConf().setAppName(SparkTest.class.getName()).setMaster("local").set("spark.executor.memory","1g");
		JavaSparkContext context = new JavaSparkContext(conf);
		JavaRDD<String> lines = context.textFile(filePath).cache();
		
		List<String> list = lines.collect();
		System.out.println("No of lines = "+list.size());
		
		long count =lines.filter(new Function<String,Boolean>(){
			public Boolean call(String s){
				System.out.println(s);
				return true;
			}
		}).count();
		
		System.out.println(" Total lines received = "+count);
		//lines.saveAsTextFile(outputPath);
		
		
		//for(int i=0;i<lines.count();i++){
			//System.out.println(lines.toString());
		//}
	}
	/*public static void main_x(String arg[]){
		String filePath="hdfs://namenode_host:8020/user/hive/warehouse/employees/employees.csv";
		SparkConf conf = new SparkConf().setAppName(SparkTest.class.getName()).setMaster("local[*]");//.set("spark.executor.memory","1g");
		JavaSparkContext context = new JavaSparkContext(conf);
		System.out.println("Reading data now..");
		JavaRDD tokenized = context.textFile(filePath).flatMap(
			      new FlatMapFunction<String, String>() {
			        public Iterator<String> call(String s) {
			        	System.out.println("entered ---");
			        	System.out.println(s);
			          return (Iterator<String>) Arrays.asList(s.split(" "));
			        }
			      }
			    );
		System.out.println("Finished...");
	}*/
}
