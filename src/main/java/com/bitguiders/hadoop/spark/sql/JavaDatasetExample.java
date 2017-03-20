/*package com.bitguiders.hadoop.spark.sql;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SQLContext;

public class JavaDatasetExample {

    public static void main(String[] args) throws Exception {

        SparkConf sparkConf = new SparkConf()
                .setAppName("Example")
                .setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        SQLContext sqlContext = new SQLContext(sc);

        List<JavaPerson> data = JavaData.sampleData();

        //NOTE: this does not actually work ... throws error "no encoder found for example_java.common.JavaPerson"
        Dataset<JavaPerson> dataset = sqlContext.createDataset(data, Encoders.bean(JavaPerson.class));

        Dataset<JavaPerson> below21 = dataset.filter((FilterFunction<JavaPerson>) person -> (person.getAge() < 21));

        below21.foreach((ForeachFunction<JavaPerson>) person -> System.out.println(">>Below 21...\n"+person));
        
        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("output.txt"), "utf-8"));
        
        List<JavaPerson> data1 = new ArrayList<JavaPerson>();        
        Dataset<JavaPerson> above21 = dataset.filter((FilterFunction<JavaPerson>) person -> (person.getAge() > 21));    
        data1 = above21.collectAsList();
        
        for(JavaPerson p: data1){
        	System.out.println("done..."+p.toString());        	
        	writer.write(p.toString());
        }
        System.out.println(">>DONE");
        writer.close();

    }
}*/