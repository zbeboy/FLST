CREATE TABLE users (
  username VARCHAR(64) PRIMARY KEY,
  password VARCHAR(300) NOT NULL,
  enabled  BOOLEAN      NOT NULL
);

CREATE TABLE authorities (
  username  VARCHAR(64) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users (username),
  PRIMARY KEY (username, authority)
);

CREATE TABLE persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) PRIMARY KEY,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
);

CREATE TABLE menus (
  menu_id      VARCHAR(64)           NOT NULL PRIMARY KEY,
  menu_name    VARCHAR(20) UNIQUE    NOT NULL,
  menu_name_en VARCHAR(50) UNIQUE    NOT NULL,
  menu_link    VARCHAR(200)          NOT NULL,
  menu_link_en VARCHAR(200)          NOT NULL,
  menu_pid     VARCHAR(64) DEFAULT 0 NOT NULL,
  menu_order   INT                   NOT NULL,
  menu_show    BOOLEAN DEFAULT 1     NOT NULL,
  menu_fixed   BOOLEAN DEFAULT 0     NOT NULL,
  username     VARCHAR(64)           NOT NULL,
  FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE article (
  article_id           INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  article_title        VARCHAR(100)  NOT NULL,
  article_brief        VARCHAR(200),
  article_cover        VARCHAR(200),
  article_content      TEXT          NOT NULL,
  article_date         DATETIME      NOT NULL,
  article_clicks       INT,
  username             VARCHAR(64)   NOT NULL,
  article_sources      INT DEFAULT 0 NOT NULL,
  article_sources_name VARCHAR(100),
  article_sources_link VARCHAR(200),
  menu_id              VARCHAR(64)   NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id),
  FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE article_en (
  article_id           INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  article_title        VARCHAR(200)  NOT NULL,
  article_brief        VARCHAR(300),
  article_cover        VARCHAR(200),
  article_content      TEXT          NOT NULL,
  article_date         DATETIME      NOT NULL,
  article_clicks       INT,
  username             VARCHAR(64)   NOT NULL,
  article_sources      INT DEFAULT 0 NOT NULL,
  article_sources_name VARCHAR(100),
  article_sources_link VARCHAR(200),
  menu_id              VARCHAR(64)   NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id),
  FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE banner (
  banner_id    INT                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  banner_link  VARCHAR(200)          NOT NULL,
  banner_date  DATETIME              NOT NULL,
  banner_show  BOOLEAN DEFAULT 1     NOT NULL,
  menu_id      VARCHAR(64)           NOT NULL,
  username     VARCHAR(64)           NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id),
  FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$10$HKXHRhnhlC1aZQ4hukD0S.zYep/T5A7FULBo7S2UrJsqQCThUxdo2', 1);
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
