package com.bitguiders.hadoop.spark;

import java.util.TreeMap;

import com.bitguiders.hadoop.projects.project1.RunJob;
import com.bitguiders.hadoop.shell.ShellHandler;


public class ELTRequestListener {
	private static final String STATUS_STARTED="started";
	private static final String STATUS_STOPPED="stopped";
	
	public static TreeMap<String,String> jobPool = new TreeMap<String,String>();

	public static void send(String userId,String domain,String etlJob,String operation){
        String command = new String("curl http://bitguiders.com/rest/elt/?s=el&a=add&user_id="+userId+"&domain="+domain+"&etl_job="+etlJob+"&operation="+operation);
        ShellHandler.execute(command);
    }
	public static void send(String jobId,String status){
        String command = new String("curl http://bitguiders.com/rest/elt/?s=el&a=update&jid="+jobId+"&status="+status);
        ShellHandler.execute(command);
    }
    public static void receive(){
	    	if(jobPool.size()==0){
	        String command = new String("curl http://bitguiders.com/rest/elt/?s=el&a=list");
	        String response = ShellHandler.execute(command);
		        if(null!=response && response.contains(";")){
		        String etlJobs[] = response.split(";");
			        for(String job:etlJobs){
			        	System.out.println(job);
			        	String jobDetails[] = job.split(",");
			        	jobPool.put(jobDetails[1].trim(), jobDetails[0].trim());
			        }
			    }else if(null!=response && response.contains(",")){
		       
			        	System.out.println(response);
			        	String jobDetails[] = response.split(",");
			        	jobPool.put(jobDetails[1].trim(), jobDetails[0].trim());
			       
			    }
		        if(jobPool.size()>0){
		        run();
		        }
	    	}
    }
    private static void run(){
    	String args[]={"hdfs://quickstart.cloudera:8020/user/cloudera/input/mr.txt",
    			"hdfs://quickstart.cloudera:8020/user/cloudera/output","0"};
    	
    	for(String jobId: jobPool.keySet()){
    		send(jobPool.get(jobId).trim(),STATUS_STARTED);
    		
    		switch(jobId){
    		case  "pair":
    			args[2]="1";
    			break;
       		case  "stripes":
    			args[2]="2";
    			break;
       		case  "hybrid":
    			args[2]="3";
    			break;
    		}
    		
    		try {
				RunJob.start(args);
				send(jobPool.get(jobId).trim(),STATUS_STOPPED);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				jobPool.clear();
			}
    	}
    }
}
