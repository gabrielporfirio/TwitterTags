CREATE TABLE IF NOT EXISTS tweet (tweet_id bigint,
					username text,
					message text,
					hashtags list<text>,
					PRIMARY KEY(tweet_id));
					
INSERT INTO tweet (tweet_id, username, message, hashtags) VALUES (10000101, 'gabrielporfirio', 'Baseball will return to the 2020 Olympics in Tokyo. #tokyo #olympics', ['#tokyo', '#olympics']);
INSERT INTO tweet (tweet_id, username, message, hashtags) VALUES (10000102, 'joaosilva', 'Nos vemos em Tóquio 2020. #japao2020 #jogosolimpicos', ['#japao2020', '#jogosolimpicos']);
INSERT INTO tweet (tweet_id, username, message, hashtags) VALUES (10000103, 'mariasouza', 'O mascote dos Jogos Olímpicos de Tóquio 2020 Miraitowa e o mascote Paralímpico Someity! #olimpiadas2020 #japao', ['#olimpiadas2020', '#japao']);

SELECT tweet_id, username, hashtags, message FROM tweet
WHERE tweet_id = 10000121 ;