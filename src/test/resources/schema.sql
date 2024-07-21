DROP TABLE IF EXISTS books;
CREATE TABLE books
(
   id INTEGER PRIMARY KEY AUTO_INCREMENT,
   title varchar (255) NOT NULL,
   memo VARCHAR (255),
   status ENUM
   (
      '未読',
      '読書中',
      '完了'
   )
   NOT NULL,
   created_at timestamp default current_timestamp,
   updated_at datetime default current_timestamp on update current_timestamp
);