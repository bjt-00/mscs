inputPath='/home/cloudera/Desktop/hadoop/spark'
outputPath='/user/cloudera/input'
echo "------------------------"
echo "EJT ::: ETL Job Tracker"
echo "------------------------"
echo "Setup started it may take few minutes...";
echo ""
echo "Cleaning existing data.."
hadoop fs -rm $outputPath/etl_log.csv
hadoop fs -rm $outputPath/mr.txt
echo ""
echo "Copying fresh data.."
hadoop fs -put $inputPath/etl_log.csv $outputPath
hadoop fs -put $inputPath/mr.txt $outputPath