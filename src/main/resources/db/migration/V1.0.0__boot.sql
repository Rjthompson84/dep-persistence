CREATE TABLE IF NOT EXISTS User (
  id            BIGINT(25)      UNIQUE NOT NULL AUTO_INCREMENT,
  email         VARCHAR(255)    UNIQUE NOT NULL,
  enabled       BIT(1)          NOT NULL DEFAULT 0,
  first_name    VARCHAR(255)    NOT NULL,
  last_name     VARCHAR(255)    NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY (id)
);
