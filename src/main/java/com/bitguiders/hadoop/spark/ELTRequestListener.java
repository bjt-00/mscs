package com.bitguiders.hadoop.spark;

import java.util.TreeMap;

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
			        	jobPool.put(jobDetails[0], jobDetails[1]);
			        }
			    }
		        run();
	    	}
    }
    private static void run(){
    	for(String jobId: jobPool.keySet()){
    		send(jobId,STATUS_STARTED);
    	}
    }
}
