inputPath='/home/cloudera/Desktop/hadoop/spark'
outputPath='/user/cloudera/input/ejt'
echo "------------------------"
echo "EJT ::: ETL Job Tracker"
echo "------------------------"
echo "Setup started it may take few minutes...";
echo ""
echo "Cleaning existing data.."
hadoop fs -rm -r $outputPath
hadoop fs -mkdir $outputPath/
hadoop fs -mkdir $outputPath/etl_log

echo ""
echo "Copying fresh data.."
hadoop fs -put $inputPath/etl_log.csv $outputPath/etl_log
hadoop fs -put $inputPath/data.txt $outputPath/
echo ""
echo "executing nc -lk 9999"
echo "available jobs [hybrid,stripes,pair]"
echo "userId,domain,etlJob,operation"
echo "------------------------------------"
echo "Example: abdul,mapreduce,hybrid,add"
echo "------------------------------------"

echo "You can type now"

nc -lk 9999;