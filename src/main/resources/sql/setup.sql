-- create schema
CREATE SCHEMA `chisana` DEFAULT CHARACTER SET utf8 ;

-- create user app with password app and allow all privileges for localhost

CREATE USER 'app'@'localhost' IDENTIFIED BY 'app';

GRANT ALL privileges ON *.* TO 'app'@'localhost'  identified BY 'app';

