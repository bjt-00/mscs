package com.bitguiders.hadoop.shell;

import java.io.*;
public class ShellHandler {

        public static void main(String[] args) throws Exception {
        	
        }
         public static String execute(String command){
        	System.out.println("elt> "+ command);
        	StringBuffer response = new StringBuffer();
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
        }
               return response.toString();
        }
}