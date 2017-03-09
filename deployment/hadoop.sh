jarPath='/home/cloudera/Desktop/hadoop/hadoop.jar'
inputPath='/user/cloudera/input/mr.txt'
outputPath='/user/cloudera/output'

echo 'Pair   Job Id : 1'
echo 'Stripe Job Id : 2'
echo 'Hybrid Job Id : 3'
echo 'Exit   Job Id : 0'
echo 'Enter your choice..'

read jobId

if [ $jobId -eq 1 ]
then
  echo "Pair..."
elif [ $jobId -eq 1 ]
then
    echo "Cleaning $outputPath/pair directories for fresh run"
  hadoop fs -rm -r  $outputPath/pair
elif [ $jobId -eq 2 ]
then
    echo "Cleaning $outputPath/stripe directories for fresh run"
  hadoop fs -rm -r  $outputPath/stripes
elif [ $jobId -eq 3 ]
then
    echo "Cleaning $outputPath/hybrid directories for fresh run"
  hadoop fs -rm -r  $outputPath/hybrid
else
  $jobId=0
fi


 
#hdfs dfs -rmdir  /user/cloudera/output/ 

#java -jar /home/cloudera/Desktop/hadoop/hadoop.jar /home/cloudera/Desktop/hadoop/input/mr.txt /home/cloudera/Desktop/hadoop/output/
hadoop jar $jarPath $inputPath $outputPath $jobId