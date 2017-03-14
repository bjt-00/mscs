
movies = LOAD '/home/cloudera/Desktop/hadoop/pig/movies.csv' USING PigStorage(',') As (movieId,title,description);
pfilter = FILTER movies BY description MATCHES 'Adventure.*';
--ptokenize = FOREACH pfilter GENERATE movieId,title,TOKENIZE(description,'|') AS description;
ptokenize = FOREACH pfilter GENERATE movieId,title,'Adventure' AS description;

--ratings = LOAD '/home/cloudera/Desktop/hadoop/pig/ratings.txt' USING PigStorage('\\t') AS (mId,userId,rating);
--mrjoin  = JOIN pfilter BY movieId, ratings BY mId;
--foutput = FOREACH mrjoin GENERATE movieId,title,description,rating;

pselect = LIMIT ptokenize 15;
dump pselect;

--pflattern = FOREACH ptokenize GENERATE group, flattern(ptokenize);
--pgroup  = GROUP pfilter BY title;
--pcount  = FOREACH pgroup GENERATE group , COUNT(pfilter) AS total;
--porder  = ORDER pcount by total DESC;