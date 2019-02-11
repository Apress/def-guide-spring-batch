CREATE TABLE CUSTOMER  (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(45) ,
  middle_initial VARCHAR(1) ,
  last_name VARCHAR(45) ,
  address VARCHAR(45) ,
  city VARCHAR(45) ,
  state VARCHAR(2) ,
  zip VARCHAR(5),
  email VARCHAR(255)
) ;
