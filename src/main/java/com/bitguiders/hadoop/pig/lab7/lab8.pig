movies = LOAD '/home/cloudera/workspace/pig/lab1/input/input.csv' USING PigStorage(',') AS (movieId,title,genres);

normalized = FOREACH movies GENERATE movieId,title,FLATTEN(TOKENIZE(genres,'|')) AS genre;

adventurious = filter normalized BY ($2=='Adventure');

rating = LOAD '/home/cloudera/workspace/pig/lab1/input/rating.txt' AS (userId,movieId,ratings,timestamp);

merged = JOIN adventurious BY movieId,rating BY movieId;

movieRating = FOREACH merged GENERATE movieId,title,genre,ratings;

topRated = FILTER movieRating BY (ratings == '5');

ordered = order topRated BY title DESC;

top20 = limit ordered 20;