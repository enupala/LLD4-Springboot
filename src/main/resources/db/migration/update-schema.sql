CREATE TABLE category
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE instructor
(
    user_id    BIGINT NOT NULL,
    avg_rating FLOAT  NOT NULL,
    CONSTRAINT pk_instructor PRIMARY KEY (user_id)
);

CREATE TABLE mentor
(
    user_id                     BIGINT NOT NULL,
    specialization              VARCHAR(255) NULL,
    company_name                VARCHAR(255) NULL,
    no_of_mock_interviews_taken INT    NOT NULL,
    CONSTRAINT pk_mentor PRIMARY KEY (user_id)
);

CREATE TABLE mp_instructor
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    avg_rating FLOAT NOT NULL,
    CONSTRAINT pk_mp_instructor PRIMARY KEY (id)
);

CREATE TABLE mp_mentor
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    company_name   VARCHAR(255) NULL,
    CONSTRAINT pk_mp_mentor PRIMARY KEY (id)
);

CREATE TABLE mp_ta
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    avg_rating     FLOAT NOT NULL,
    no_of_sessions INT   NOT NULL,
    CONSTRAINT pk_mp_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price         FLOAT NOT NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE s_user
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    user_type      INT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    company_name   VARCHAR(255) NULL,
    avg_rating     FLOAT NOT NULL,
    no_of_sessions INT   NOT NULL,
    CONSTRAINT pk_s_user PRIMARY KEY (id)
);

CREATE TABLE ta
(
    user_id        BIGINT NOT NULL,
    avg_rating     FLOAT  NOT NULL,
    no_of_sessions INT    NOT NULL,
    CONSTRAINT pk_ta PRIMARY KEY (user_id)
);

CREATE TABLE tb_instructor
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    avg_rating FLOAT  NOT NULL,
    CONSTRAINT pk_tb_instructor PRIMARY KEY (id)
);

CREATE TABLE tb_mentor
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    company_name   VARCHAR(255) NULL,
    CONSTRAINT pk_tb_mentor PRIMARY KEY (id)
);

CREATE TABLE tb_ta
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    avg_rating     FLOAT  NOT NULL,
    no_of_sessions INT    NOT NULL,
    CONSTRAINT pk_tb_ta PRIMARY KEY (id)
);

CREATE TABLE tb_user
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tb_user PRIMARY KEY (id)
);

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE instructor
    ADD CONSTRAINT FK_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE mentor
    ADD CONSTRAINT FK_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE ta
    ADD CONSTRAINT FK_TA_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);