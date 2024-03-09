DROP DATABASE IF EXISTS Movie_Website;
CREATE DATABASE IF NOT EXISTS Movie_Website;
USE Movie_Website;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
	id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email			VARCHAR(225) NOT NULL,
    username		VARCHAR(50) NOT NULL,
    `password`		VARCHAR(800) NOT NULL,
    count			INT DEFAULT 5,
    `role` 			ENUM('ADMIN','USER') DEFAULT 'USER',
    `created_at`	DATETIME DEFAULT NOW()
);
 
INSERT INTO `User` (email, username, `password`, `role`, `created_at`)
VALUES
('user1@gmail.com', 'user1', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'ADMIN', '2022-02-02 '),
('user2@gmail.com', 'user2', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user3@gmail.com', 'user3', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user4@gmail.com', 'user4', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user5@gmail.com', 'user5', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user6@gmail.com', 'user6', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user7@gmail.com', 'user7', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user8@gmail.com', 'user8', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user9@gmail.com', 'user9', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02 '),
('user10@gmail.com', 'user10', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi', 'USER', '2022-02-02');

DROP TABLE IF EXISTS Video;
CREATE TABLE Video (
	id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,				
    user_id			INT UNSIGNED ,
    `name`			VARCHAR(100) NOT NULL,
    thumbnail		VARCHAR(100) NOT NULL,
    `source`		VARCHAR(200) NOT NULL,
    `view`			INT UNSIGNED DEFAULT 0,
    `description`	VARCHAR(1000),
    `created_at`	DATETIME DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES `User`(id) ON DELETE CASCADE
    );
    
INSERT INTO Video (user_id, `name`, thumbnail, `source`, `view`, `description`, `created_at`)
VALUES
(1, 'Video 1', 'thumbnail1.jpg', 'video_source_1.mp4', 1000, 'Description 1', '2022-02-02 '),
(2, 'Video 2', 'thumbnail2.jpg', 'video_source_2.mp4', 1500, 'Description 2', '2022-02-02'),
(3, 'Video 3', 'thumbnail3.jpg', 'video_source_3.mp4', 2000, 'Description 3', '2022-02-02 '),
(4, 'Video 4', 'thumbnail4.jpg', 'video_source_4.mp4', 1200, 'Description 4', '2022-02-02'),
(5, 'Video 5', 'thumbnail5.jpg', 'video_source_5.mp4', 1800, 'Description 5', '2022-02-02 '),
(6, 'Video 6', 'thumbnail6.jpg', 'video_source_6.mp4', 900, 'Description 6', '2022-02-02');



DROP TABLE IF EXISTS Package;
CREATE TABLE Package (
	id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name`			VARCHAR(100) NOT NULL,
    count			INT NOT NULL,
    price			DECIMAL NOT NULL
);

INSERT INTO Package (`name`, count, price)
VALUES
('Package 1', 10, 20),
('Package 2', 20, 30),
('Package 3', 30, 40);


DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order` (
	id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id			INT UNSIGNED NOT NULL,
    package_id		INT UNSIGNED NOT NULL,
    price			DECIMAL NOT NULL,
    `created_at`	DATETIME DEFAULT NOW(),
    FOREIGN KEY (package_id) REFERENCES Package(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES `User`(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS FavoriteList;
CREATE TABLE FavoriteList(
	id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id			INT UNSIGNED NOT NULL,
    video_id		INT UNSIGNED NOT NULL,
    `created_at`	DATETIME DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES `User`(id),
    FOREIGN KEY (video_id) REFERENCES Video(id) 
);

INSERT INTO FavoriteList (user_id, video_id, created_at)
VALUES
(1, 1, '2022-02-03'),
(2, 2, '2022-02-02'),
(3, 3, '2022-02-02'),
(4, 4, '2022-02-02'),
(5, 5, '2022-02-02'),
(6, 6, '2022-02-02'),
(1, 6, '2022-02-02');


DROP TABLE IF EXISTS Review;
CREATE TABLE Review(
	id				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	user_id			INT UNSIGNED NOT NULL,
    video_id		INT UNSIGNED NOT NULL,
    `comment`		VARCHAR(1000) NOT NULL,
    `created_at`	DATETIME DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES `User`(id) ON DELETE CASCADE,
    FOREIGN KEY (video_id) REFERENCES Video(id) ON DELETE CASCADE
);

INSERT INTO Review (user_id, video_id, `comment`, created_at)
VALUES
(1, 1, 'Great video!', '2022-02-02'),
(2, 2, 'Nice content!', '2022-02-02'),
(3, 3, 'Interesting video.', '2022-02-02'),
(4, 4, 'Good job!', '2022-02-02'),
(5, 5, 'Enjoyed watching it.', '2022-02-02'),
(6, 6, 'Awesome!', '2022-02-02');
