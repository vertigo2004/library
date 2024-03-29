use library;

INSERT INTO user (id, email, password, firstname, lastname, dob) VALUES
(1, 'vertigo.if@gmail.com', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'Олег', 'Пашкевич', '1972-10-22'),
(2, 'admin@mylib.com', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'Мар''ян', 'Лукаш', null ),
(3, 'librarian@mylib.com', '$2a$10$.xysUEZxutiwXaduiJJ8oeWpXU9FbU5W7ow9.0KdjBepM0w86ZAT.', 'Світлана', 'Федорчук', null);

INSERT INTO genre (id, name) VALUES
(1, 'Біографія'), (2, 'Детектив'), (3, 'Історичний'), (4, 'Збірка'), (5, 'Пригоди'), (6, 'Психологія'),
(7,'Наукова фантастика'), (8, 'Фентезі'), (9, 'Гумор'), (10, 'Жіночий'), (11, 'Програмування'), (12, 'Нон-фікшн'),
(13, 'Дитяча'), (14, 'Фікшн');

INSERT INTO publicity (id, name) VALUES
(1, 'Фабула'),
(2, 'Видавництво Старого Лева'),
(3, 'Oracle Press'),
(4, 'А-БА-БА-ГА-ЛА-МА-ГА'),
(5, 'КСД');

INSERT INTO author (id, firstname, middlename, lastname, dob) VALUES
(1, 'Джо', null, 'Харт', null),
(2, 'Скарлет', null, 'Кертіс', null),
(3, 'Сара', null, 'Паппворт', null),
(4, 'Дорж', null, 'Бату', null),
(5, 'Герберт', null, 'Шилдт', null),
(6, 'Дж.', 'К.', 'Ролінг', '1965-07-31'),
(7, 'Карлос', 'Руїс', 'Сафон', null);

INSERT INTO book (id, title, annotation, publicity_id, published) VALUES
(1, 'Як Черчилль урятував світ', 'Дослідник розкриває таємниці подій, що спричинили початок Другої світової війни.', 1, '2019'),
(2, 'Феміністки не носять рожеве', 'збірка творів від 52 різних жінок', 2, '2019'),
(3, 'Це Моне', 'Ілюстрований життєпис Моне', 2, '2019'),
(4, 'Франческа. Володарка офіцерського жетона', 'Друга книга пригод життєрадісної героїні', 2, '2019'),
(5, 'Java 8. Руководство для начинающих', '', 3, '2015'),
(6, 'Java 8. Полное руководство', null, 3, '2016'),
(7, 'Гаррі Поттер і філософський камінь', null, 4,'2002'),
(8, 'Гаррі Поттер і таємна кімната', null, 4,'2002'),
(9, 'Гаррі Поттер і прокляте дитя', null, 4,'2016'),
(10, 'Тінь вітру', null, 5,'2017'),
(11, 'Гра янгола', null, 5,'2017'),
(12, 'В’язень Неба', null, 5,'2017'),
(13, 'Лабіринт духів', null, 5,'2018');

INSERT INTO book_author (book_id, author_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 5),
(7, 6),
(8, 6),
(9, 6),
(10, 7),
(11, 7),
(12, 7),
(13, 7);

INSERT INTO book_genre (book_id, genre_id) VALUES
(1, 12),
(2, 12),
(2, 4),
(3, 1),
(4, 5),
(4, 9),
(5, 11),
(6, 11),
(7, 13),
(8, 13),
(9, 13),
(7, 8),
(8, 8),
(9, 8),
(10, 14),
(11, 14),
(12, 14),
(13, 14);

INSERT INTO role (id, name) VALUES
(1, 'ADMIN'),
(2, 'LIBRARIAN'),
(3, 'USER');

INSERT INTO user_role (user_id, role_id) VALUES
(1, 3),
(2, 1),
(3, 2),
(3, 3);

INSERT INTO hibernate_sequence (next_val) VALUE (100);