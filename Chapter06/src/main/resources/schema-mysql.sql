CREATE  TABLE IF NOT EXISTS account_summary (
  id INT NOT NULL AUTO_INCREMENT ,
  account_number VARCHAR(10) NOT NULL ,
  current_balance DECIMAL(10,2) NOT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS transaction (
  id INT NOT NULL AUTO_INCREMENT ,
  timestamp TIMESTAMP NOT NULL ,
  amount DECIMAL(8,2) NOT NULL ,
  account_summary_id INT NOT NULL ,
  PRIMARY KEY (id) ,
  INDEX fk_Transaction_Account_Summary (account_summary_id ASC) ,
  CONSTRAINT fk_Transaction_Account_Summary
    FOREIGN KEY (account_summary_id )
    REFERENCES Account_Summary (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
