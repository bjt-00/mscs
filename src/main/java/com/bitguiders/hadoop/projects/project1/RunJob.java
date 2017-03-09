package com.bitguiders.hadoop.projects.project1;

import java.util.Scanner;

import org.apache.hadoop.mapred.FileAlreadyExistsException;
import org.apache.hadoop.util.ToolRunner;

import com.bitguiders.hadoop.projects.project1.hybrid.HybridJob;
import com.bitguiders.hadoop.projects.project1.pair.PairJob;
import com.bitguiders.hadoop.projects.project1.stripes.StripesJob;

public class RunJob {
	  public static void main(String args[]) throws Exception {
		  try{
		  start(args);
		  }catch(FileAlreadyExistsException e){
			  System.out.println(e.getMessage());
		  }
		  //System.exit(res);
		  }
	  public static void start(String args[]) throws Exception{
		  int jobId=4;
	  
		  //in case job param doens't exists
		  if(null == args || args.length<2){
			  System.out.println("Job Arguments missing ");
			  System.out.println("Example:  input/mr.txt output 3");

			  System.out.println("Please enter arguments now");
			  Scanner scanner = new Scanner(System.in);
			  String arg = scanner.nextLine();
			  System.out.println("="+arg);
			  args = arg.split(" ");
			  jobId = Integer.parseInt(args[2]);
		  }
		  else if(args.length==2){
		  System.out.println("Pair    Job Id : 1\nStripes Job Id : 2");
		  System.out.println("Hybrid  Job Id : 3\nExit    Job Id : 0");

		  System.out.println("Which Job you want to run..? Enter Job Id");
		  Scanner scanner = new Scanner(System.in);
		  jobId = scanner.nextInt();
		  }else{
			  jobId = Integer.parseInt(args[2]);			  
		  }
		  
		  int res=0;
		  switch(jobId){
		  case 0:
			  System.out.println("Exiting Now..");
			  System.exit(0);
			  break;
		  case 1:
			  System.out.println("Running Stripes...");
			  args[1] = args[1]+"//pair";
			  res = ToolRunner.run(new PairJob(), args);
			  break;
		  case 2:
			  System.out.println("Running Stripe...");
			  args[1] = args[1]+"//stripes";
			  res = ToolRunner.run(new StripesJob(), args);
			  break;
		  case 3:
			  System.out.println("Running HybridJob...");
			  args[1] = args[1]+"//hybrid";
			  res = ToolRunner.run(new HybridJob(), args);
			  break;
		 default:
			 System.out.println("Please enter correct JobId");
			 start(args);
		  }

	  }
}
