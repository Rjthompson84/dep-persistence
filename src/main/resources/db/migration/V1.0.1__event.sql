CREATE TABLE IF NOT EXISTS Event (
    id              BIGINT(25)      UNIQUE NOT NULL AUTO_INCREMENT,
    owner_id        BIGINT(25)      NOT NULL,
    title           VARCHAR(255)    NOT NULL,
    venue           VARCHAR(255)    NULL,
    time_and_date   DATETIME        NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS event_user (
    event_id    BIGINT(25),
    guests_id    BIGINT(25)
);