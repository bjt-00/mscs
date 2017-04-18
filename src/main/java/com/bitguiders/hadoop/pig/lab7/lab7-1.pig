movies = LOAD '/home/cloudera/Desktop/hadoop/pig/movies.csv' USING PigStorage(',') As (movieId,title,description);
pfilter = FILTER movies BY description MATCHES 'Adventure.*';
--ptokenize = FOREACH pfilter GENERATE movieId,title,TOKENIZE(description,'|') AS description;
ptokenize = FOREACH pfilter GENERATE movieId,title,'Adventure' AS description;

ratings = LOAD '/home/cloudera/Desktop/hadoop/pig/ratings.txt' USING PigStorage('\\t') AS (mId,userId,rating);
fratings= FILTER ratings BY rating >=5;
mrjoin  = JOIN ptokenize BY movieId, fratings BY mId;
foutput = FOREACH mrjoin GENERATE movieId,title,description,rating;
porder  = ORDER foutput by rating DESC;

pselect = LIMIT porder 20;
dump pselect;
--STORE pselect INTO 'top20movies'