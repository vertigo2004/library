
CREATE TABLE user
(
  id INT AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  dob DATE,
  PRIMARY KEY (id)
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE author
(
  id INT AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  middle_name VARCHAR(50),
  last_name VARCHAR(50) NOT NULL,
  dob DATE,
  PRIMARY KEY (id)

) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE genre
(
  id INT AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE publicity
(
  id INT AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE book
(
  id INT AUTO_INCREMENT,
  title VARCHAR(256) NOT NULL,
  annotation TEXT,
  published VARCHAR(4),
  publicity_id INT,
  pages INT,
  PRIMARY KEY (id),
  FOREIGN KEY (publicity_id) REFERENCES publicity (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB CHARACTER SET=utf8;

CREATE TABLE book_author
(
  book_id INTEGER NOT NULL,
  author_id INTEGER NOT NULL,
  FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (author_id) REFERENCES author (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB;

CREATE TABLE book_genre
(
  book_id INTEGER NOT NULL,
  genre_id INTEGER NOT NULL,
  FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (genre_id) REFERENCES genre (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB;

CREATE TABLE logbook
(
  book_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  handout DATE NOT NULL,
  returned DATE,
  FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB;