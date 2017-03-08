package com.bitguiders.hadoop.projects.project1;

import java.util.Scanner;

import org.apache.hadoop.util.ToolRunner;

import com.bitguiders.hadoop.projects.project1.hybrid.HybridJob;
import com.bitguiders.hadoop.projects.project1.pair.PairJob;
import com.bitguiders.hadoop.projects.project1.stripes.StripesJob;

public class RunJob {
	  public static void main(String args[]) throws Exception {
		  
		  start(args);
		  //System.exit(res);
		  }
	  public static void start(String args[]) throws Exception{
		  System.out.println("Pair Job Id : 1\nStripes Job Id : 2");
		  System.out.println("Hybrid Job Id : 3\nExit : 0");

		  System.out.println("Enter Job id to rund");
		  Scanner scanner = new Scanner(System.in);
		  int jobId = scanner.nextInt();
		  int res=0;
		  switch(jobId){
		  case 0:
			  System.out.println("Exiting Now..");
			  System.exit(0);
			  break;
		  case 1:
			  System.out.println("Running Stripes...");
			  res = ToolRunner.run(new PairJob(), args);
			  break;
		  case 2:
			  System.out.println("Running Stripes...");
			  res = ToolRunner.run(new StripesJob(), args);
			  break;
		  case 3:
			  System.out.println("Running HybridJob...");
			  res = ToolRunner.run(new HybridJob(), args);
			  break;
		 default:
			 System.out.println("Please enter correct JobId");
			 start(args);
		  }

	  }
}
