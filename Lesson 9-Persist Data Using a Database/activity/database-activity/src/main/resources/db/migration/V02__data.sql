INSERT INTO author(id, username, fullname, password)
VALUES(1, 'admin', 'Administrator', '{bcrypt}$2a$10$u1Sgpi8I6uahy3OhhmmKLuK4eEkbvPqIaKP39RNgY3pgTtazOnN7S');
INSERT INTO role(author_id, role) VALUES(1, 'ADMIN');
INSERT INTO role(author_id, role) VALUES(1, 'USER');

INSERT INTO author(id, username, fullname, password)
VALUES(2, 'peter', 'Peter Quinn', '{bcrypt}$2a$10$/4kEl7USPy1tBKkeLT8hk.b6j0XKDkHlNeFjOObd562F0eVfsor5W');
INSERT INTO role(author_id, role) VALUES(2, 'USER');

INSERT INTO author(id, username, fullname, password)
VALUES(3, 'paul', 'Paul Nipkow', '{bcrypt}$2a$10$zw9bMTUiQ/vQMaTftJpWHe74GB72Px8A0YxmZVGH9Xy5CyWzFde4W');
INSERT INTO role(author_id, role) VALUES(3, 'USER');

INSERT INTO author(id, username, fullname, password)
VALUES(4, 'cate', 'Catherine Sakai', '{bcrypt}$2a$10$TOn7Q2g34xwNqiyEgY6FEulcDZoHg3bW6fHM972l.RVN2IsFsNQPC');
INSERT INTO role(author_id, role) VALUES(4, 'USER');


INSERT INTO short_message(id, author_id, posted_time, message_text)
VALUES(1, 3, '1884-01-06 14:02:00', 'Der hier zu beschreibende Apparat hat den Zweck, ein am Orte A befindliches Objekt an einem beliebigen anderen Orte B sichtbar zu machen.');
INSERT INTO short_message(id, author_id, posted_time, message_text)
VALUES(2, 4, '1995-08-11 13:10:00', 'While I was out there, I saw something. What was it?');
INSERT INTO short_message(id, author_id, posted_time, message_text)
VALUES(3, 2, '2009-01-12 20:39:00', 'My thoughts keep disappearing.');
INSERT INTO short_message(id, author_id, posted_time, message_text)
VALUES(4, 3, '1930-05-13 08:42:00', 'Television? The word is half Greek and half Latin. No good will come of it.');
INSERT INTO short_message(id, author_id, posted_time, message_text)
VALUES(5, 4, '1998-05-15 10:04:00', 'I don’t mean to alarm you, but your pants are talking to you.');
INSERT INTO short_message(id, author_id, posted_time, message_text)
VALUES(6, 2, '2014-05-18 22:47:00', 'For once in your life you need to listen!');
INSERT INTO short_message(id, author_id, posted_time, message_text)
VALUES(7, 2, '2017-04-03 02:14:00', 'So, that’s the two thousand I owe you, less the two thousand you stole from me leaves what? How much I owe you now?');
