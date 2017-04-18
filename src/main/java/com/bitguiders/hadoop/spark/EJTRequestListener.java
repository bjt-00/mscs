package com.bitguiders.hadoop.spark;

import java.util.TreeMap;

import com.bitguiders.hadoop.projects.project1.RunJob;
import com.bitguiders.hadoop.shell.ShellHandler;
import com.bitguiders.hadoop.spark.sql.EJTDAO;

import static com.bitguiders.hadoop.spark.util.EJTConstants.*;


public class EJTRequestListener {
	private static  EJTDAO dao = new EJTDAO();

	private static final String STATUS_STARTED="started";
	private static final String STATUS_COMPLETED="completed";
	
	public static TreeMap<String,String> jobPool = new TreeMap<String,String>();

	public static void send(String userId,String domain,String etlJob,String operation){
        String command = new String(CMD_ADD+"&user_id="+userId+"&domain="+domain+"&etl_job="+etlJob+"&operation="+operation);
        ShellHandler.execute(command);
    }
	public static void send(String jobId,String status){
        String command = new String(CMD_UPDATE+jobId+"&status="+status);
        ShellHandler.execute(command);
    }
    public static void receive(){
	    	if(jobPool.size()==0){
	        String response = ShellHandler.execute(CMD_LIST);
		        if(null!=response && response.contains(";")){
		        String etlJobs[] = response.split(";");
			        for(String job:etlJobs){
			        	String jobDetails[] = job.split(",");
			        	System.out.println("EJT Client Request received =>  "+job);
			        	dao.showJobDetails(jobDetails[1].trim());
			        	jobPool.put(jobDetails[1].trim(), jobDetails[0].trim());
			        }
			    }else if(null!=response && response.contains(",")){
			        	String jobDetails[] = response.split(",");
			        	jobPool.put(jobDetails[1].trim(), jobDetails[0].trim());
				    	System.out.println("EJT Client Request received =>  "+response);
			        	dao.showJobDetails(jobDetails[1].trim());
			       
			    }
		        if(jobPool.size()>0){
		        run();
		        }
	    	}
    }
    private static void run(){
    	String args[]={DATA_SOURCE_PATH,
    			OUTPUT_PATH,"0"};
    	
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
				send(jobPool.get(jobId).trim(),STATUS_COMPLETED);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				jobPool.clear();
			}
    	}
    }
}
