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
  menu_id      VARCHAR(64)                        NOT NULL PRIMARY KEY,
  menu_name    VARCHAR(20) UNIQUE                 NOT NULL,
  menu_name_en VARCHAR(100) UNIQUE                NOT NULL,
  out_link     BOOLEAN DEFAULT 0                  NOT NULL,
  menu_link    VARCHAR(200)                       NOT NULL,
  menu_pid     VARCHAR(64) DEFAULT 0              NOT NULL,
  menu_order   INT                                NOT NULL,
  menu_show    BOOLEAN DEFAULT 1                  NOT NULL,
  menu_fixed   BOOLEAN DEFAULT 0                  NOT NULL,
  show_article BOOLEAN DEFAULT 0                  NOT NULL,
  order_way    INT DEFAULT 0                      NOT NULL,
  menu_creator VARCHAR(64)                        NOT NULL,
  FOREIGN KEY (menu_creator) REFERENCES users (username)
);

CREATE TABLE article (
  article_id           INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  article_title        VARCHAR(100)  NOT NULL,
  article_brief        VARCHAR(200),
  article_cover        VARCHAR(200),
  article_date         DATETIME      NOT NULL,
  article_clicks       INT,
  article_author       VARCHAR(64)   NOT NULL,
  article_sources      INT DEFAULT 0 NOT NULL,
  article_sources_name VARCHAR(100),
  article_sources_link VARCHAR(200),
  article_sn           INT DEFAULT 0 NOT NULL,
  menu_id              VARCHAR(64)   NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id),
  FOREIGN KEY (article_author) REFERENCES users (username)
);

CREATE TABLE article_content (
  id              INT      NOT NULL PRIMARY KEY,
  article_content LONGTEXT NOT NULL,
  FOREIGN KEY (id) REFERENCES article (article_id)
);

CREATE TABLE article_en (
  article_id           INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  article_title        VARCHAR(200)  NOT NULL,
  article_brief        VARCHAR(300),
  article_cover        VARCHAR(200),
  article_date         DATETIME      NOT NULL,
  article_clicks       INT,
  article_author       VARCHAR(64)   NOT NULL,
  article_sources      INT DEFAULT 0 NOT NULL,
  article_sources_name VARCHAR(100),
  article_sources_link VARCHAR(200),
  article_sn           INT DEFAULT 0 NOT NULL,
  menu_id              VARCHAR(64)   NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id),
  FOREIGN KEY (article_author) REFERENCES users (username)
);

CREATE TABLE article_en_content (
  id              INT      NOT NULL PRIMARY KEY,
  article_content LONGTEXT NOT NULL,
  FOREIGN KEY (id) REFERENCES article_en (article_id)
);

CREATE TABLE banner (
  banner_id       INT                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  banner_link     VARCHAR(200)          NOT NULL,
  banner_date     DATETIME              NOT NULL,
  banner_show     BOOLEAN DEFAULT 1     NOT NULL,
  banner_title    VARCHAR(30),
  banner_title_en VARCHAR(50),
  banner_brief    VARCHAR(50),
  banner_brief_en VARCHAR(80),
  menu_id         VARCHAR(64)           NOT NULL,
  banner_creator  VARCHAR(64)           NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id),
  FOREIGN KEY (banner_creator) REFERENCES users (username)
);

CREATE TABLE friendly_link (
  link_id      VARCHAR(64)       NOT NULL PRIMARY KEY,
  link_name    VARCHAR(100)      NOT NULL,
  link_name_en VARCHAR(200)      NOT NULL,
  link_url     VARCHAR(200)      NOT NULL,
  link_show    BOOLEAN DEFAULT 1 NOT NULL
);

CREATE TABLE data_info (
  data_key   VARCHAR(200) NOT NULL PRIMARY KEY,
  data_value VARCHAR(200)
);

CREATE TABLE files (
  file_id            VARCHAR(64) NOT NULL PRIMARY KEY,
  size               LONG,
  original_file_name VARCHAR(300),
  new_name           VARCHAR(300),
  relative_path      VARCHAR(500),
  ext                VARCHAR(10),
  upload_date        DATETIME    NOT NULL
);