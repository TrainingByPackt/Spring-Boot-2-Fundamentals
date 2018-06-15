CREATE TABLE message_authors(
   message_id INT,
   author_ID INT
);

INSERT INTO message_authors
SELECT id, author_id FROM short_message;

ALTER TABLE short_message
DROP COLUMN author_id;
