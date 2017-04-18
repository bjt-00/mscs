This file contains instructions to run given jar/bat/sh.
Please follow instructions.

Linux 
------------------------------------------------------------------------------
Step 1: -> Open hadoop.sh and set following params according to your settings.
jarPath='/home/cloudera/Desktop/hadoop/hadoop.jar'
inputPath='/user/cloudera/input/mr.txt'
outputPath='/user/cloudera/output'

Step 2: open terminal and run 'hadoop.sh'
bash /home/cloudera/Desktop/hadoop/hadoop.sh

Window
--------------------------------------------
Step 1: open hadoop.bat and set params according to your settings.
java -jar D:\hadoop\hadoop.jar D:\hadoop\input\mr.txt D:\hadoop\output

Step 2: double click 'hadoop.bat' and run.

or 

Open cmd -> and run directly following command.
java -jar D:\hadoop\hadoop.jar D:\hadoop\input\mr.txt D:\hadoop\output