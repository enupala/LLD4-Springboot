ALTER TABLE category
    ADD `description` VARCHAR(255) NULL;

DROP TABLE tb_user_seq;

ALTER TABLE s_user
    MODIFY avg_rating FLOAT NOT NULL;

ALTER TABLE s_user
    MODIFY no_of_sessions INT NOT NULL;

ALTER TABLE s_user
    MODIFY user_type INT NULL;