-- Register for lib
REGISTER /usr/lib/pig/piggybank.jar;
-- Movies
movies  = LOAD 'movies.csv' USING org.apache.pig.piggybank.storage.CSVExcelStorage(',', 'NO_MULTILINE', 'UNIX', 'SKIP_INPUT_HEADER') AS (movieId:int, title:chararray, genres:chararray);
movies = FILTER movies by INDEXOF(genres, 'Adventure',0)!=-1;

-- Create User and filter by gender
user = LOAD 'users.txt' USING PigStorage('|') AS (userId:int, age:int, gender:chararray, occupation:chararray, zipCode:chararray);

user = FILTER user by gender == 'M';

-- Create Ratings
ratings = LOAD 'rating.txt' USING PigStorage('\\t') AS (userId:int, movieId:int, rating:int, timestamp);
ratings = FILTER ratings by rating == 5;

-- Join movies_Gen and Ratings
movies_rating= JOIN movies by movieId, ratings by movieId;
movie_rating_Order= ORDER movies_rating by rating DESC, title;
movie_rating_Order = distinct movie_rating_Order;
partone = LIMIT movie_rating_Order 20;
Store partone into 'part1Output';

-- Join with user to get gender 
ratings = JOIN ratings by userId, user by userId;
ratings = FOREACH ratings Generate $0 as userId,$1 as movieId,$2 as rating;
rating_Group = GROUP ratings by movieId;
highestEachMovie = FOREACH rating_Group Generate group as movieId, MAX(ratings.rating) as rating, COUNT(ratings.userId) as total;
highestEachMovie = ORDER highestEachMovie By rating;

-- Join movies_Gen and Ratings
movies_rating= JOIN movies by movieId, highestEachMovie by movieId;
movie_rating_Order= ORDER movies_rating by rating DESC, title;
parttwo = LIMIT movie_rating_Order 20;
Store parttwo into 'part2Output';



