movies = LOAD '/home/cloudera/Desktop/hadoop/pig/movies.csv' USING PigStorage(',') As (movieId,title,description);
pfilter = FILTER movies BY description MATCHES 'Adventure.*';
--ptokenize = FOREACH pfilter GENERATE movieId,title,TOKENIZE(description,'|') AS description;
ptokenize = FOREACH pfilter GENERATE movieId,title,'Adventure' AS description;

ratings = LOAD '/home/cloudera/Desktop/hadoop/pig/ratings.txt' USING PigStorage('\\t') AS (mId,userId,rating);
fratings= FILTER ratings BY rating >=5;

mrjoin  = JOIN ptokenize BY movieId, fratings BY mId;
mroutput = FOREACH mrjoin GENERATE movieId,userId,title,description,rating;
mrlimit = LIMIT mroutput 20;

users = LOAD '/home/cloudera/Desktop/hadoop/pig/users.txt' USING PigStorage('|') AS (uId,age,gender);
rujoin= JOIN mrlimit BY userId, users BY uId;
fgroup   = GROUP rujoin BY gender;
fselect = FOREACH fgroup GENERATE group,COUNT(rujoin) as total;
rgroup = FILTER fselect BY group eq 'M';
foutput= FOREACH rgroup GENERATE total;

--dump foutput;
STORE foutput INTO 'top20MaleViewer';