pig -x local
hadoop fs -copyFromLocal /home/cloudera/Desktop/hadoop/pig/movies.csv /user/cloudera/input

grunt> fs -copyFromLocal /home/cloudera/Desktop/hadoop/pig/users.txt /user/cloudera/input
Warning: fs.defaultFS is not set when running "copyFromLocal" command.
copyFromLocal: `/user/cloudera/input': No such file or directory
