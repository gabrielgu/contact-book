CREATE DATABASE IF NOT EXISTS db_user;
CREATE DATABASE IF NOT EXISTS db_contact_book;

CREATE USER 'api_user'@'%' IDENTIFIED BY 'password';
CREATE USER 'api_contact_book'@'%' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON db_user.* TO 'api_user'@'%';
GRANT ALL PRIVILEGES ON db_contact_book.* TO 'api_contact_book'@'%';