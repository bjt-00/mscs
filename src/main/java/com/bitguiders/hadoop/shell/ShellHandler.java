package com.bitguiders.hadoop.shell;

import java.io.*;
public class ShellHandler {

        public static void main(String[] args) throws Exception {
        	execute("hadoop fs -rm -r /user/cloudera/output/pair",
        			"bash /home/cloudera/Desktop/hadoop/hadoop.sh"
        	//"java -jar /home/cloudera/Desktop/hadoop/hadoop.jar /home/cloudera/Desktop/hadoop/input/mr.txt /user/cloudera/output/ 1"
        	);
        }
         public static String execute(String... commands){
        	
        	StringBuffer response = new StringBuffer();
        	for(String command:commands){
        		//System.out.println("elt> "+ command);
            try {
                // String target = new String("mkdir stackOver");
                Runtime rt = Runtime.getRuntime();
                Process proc = rt.exec(command);
                proc.waitFor();
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                String line = "";                       
                while ((line = reader.readLine())!= null) {
                	response.append(line + "\n");
                }
                //System.out.println("elt> " + response);
        } catch (Throwable t) {
                t.printStackTrace();
        }}//for end
               return response.toString();
        }
}