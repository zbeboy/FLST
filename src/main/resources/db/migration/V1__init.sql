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
  menu_id      VARCHAR(64)                       NOT NULL PRIMARY KEY,
  menu_name    VARCHAR(20) UNIQUE                NOT NULL,
  menu_name_en VARCHAR(100) UNIQUE                NOT NULL,
  out_link     BOOLEAN DEFAULT 0                 NOT NULL,
  menu_link    VARCHAR(200)                      NOT NULL,
  menu_pid     VARCHAR(64) DEFAULT 0             NOT NULL,
  menu_order   INT                               NOT NULL,
  menu_show    BOOLEAN DEFAULT 1                 NOT NULL,
  menu_fixed   BOOLEAN DEFAULT 0                 NOT NULL,
  show_article BOOLEAN DEFAULT 0                 NOT NULL,
  username     VARCHAR(64)                       NOT NULL,
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
  banner_id   INT                   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  banner_link VARCHAR(200)          NOT NULL,
  banner_date DATETIME              NOT NULL,
  banner_show BOOLEAN DEFAULT 1     NOT NULL,
  menu_id     VARCHAR(64)           NOT NULL,
  username    VARCHAR(64)           NOT NULL,
  FOREIGN KEY (menu_id) REFERENCES menus (menu_id),
  FOREIGN KEY (username) REFERENCES users (username)
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

CREATE TABLE files(
  file_id               VARCHAR(64) NOT NULL PRIMARY KEY,
  size                  LONG,
  original_file_name    VARCHAR(300),
  new_name              VARCHAR(300),
  relative_path         VARCHAR(500),
  ext                   VARCHAR(10),
  upload_date  DATETIME NOT NULL
);

INSERT INTO users (username, password, enabled)
VALUES ('govern', '$2a$10$wICea4jxjGeqeL99vXQBnO5dKtvT4Q2EbELrRoNZWCwuXJiLGNgE.', 1);
INSERT INTO authorities (username, authority) VALUES ('govern', 'ROLE_ADMIN');

INSERT INTO menus (menu_id, menu_name, menu_name_en, menu_link, menu_pid, menu_order, menu_fixed, username)
VALUES ('1dec1097f1334196aeb6889f36a4c9ae','首页','Home','/','0',0,1,'govern');
INSERT INTO menus (menu_id, menu_name, menu_name_en, menu_link, menu_pid, menu_order, menu_fixed, username)
VALUES ('9733946a1c7f46d0b68bb7a5fa72ac53','学院新闻','COLLEGE','/user/menu/9733946a1c7f46d0b68bb7a5fa72ac53','1dec1097f1334196aeb6889f36a4c9ae',0,1,'govern');
INSERT INTO menus (menu_id, menu_name, menu_name_en, menu_link, menu_pid, menu_order, menu_fixed, username)
VALUES ('b54ee51a2998490bb770f45b1f727c7b','通知公告','Notice bulletin','/user/menu/b54ee51a2998490bb770f45b1f727c7b','1dec1097f1334196aeb6889f36a4c9ae',1,1,'govern');
INSERT INTO menus (menu_id, menu_name, menu_name_en, menu_link, menu_pid, menu_order, menu_fixed, username)
VALUES ('8ecdb9a3b15e499592d406af4b072263','学术活动','Academic activities','/user/menu/8ecdb9a3b15e499592d406af4b072263','1dec1097f1334196aeb6889f36a4c9ae',2,1,'govern');
INSERT INTO menus (menu_id, menu_name, menu_name_en, menu_link, menu_pid, menu_order, menu_fixed, username)
VALUES ('0c8b4b82fb674155b679a3a6f04a065d','就业信息','Employment information','/user/menu/0c8b4b82fb674155b679a3a6f04a065d','1dec1097f1334196aeb6889f36a4c9ae',3,1,'govern');
INSERT INTO menus (menu_id, menu_name, menu_name_en, menu_link, menu_pid, menu_order, menu_fixed, username)
VALUES ('464a4ada822c486ba5cf58f7d86e6c7d','科研成果','Scientific research achievements','/user/menu/464a4ada822c486ba5cf58f7d86e6c7d','1dec1097f1334196aeb6889f36a4c9ae',4,1,'govern');
INSERT INTO menus (menu_id, menu_name, menu_name_en, menu_link, menu_pid, menu_order, menu_fixed, username)
VALUES ('9ce3b73dac3a4a21838df4ea7b4afce2','科研动态','Research trends','/user/menu/9ce3b73dac3a4a21838df4ea7b4afce2','1dec1097f1334196aeb6889f36a4c9ae',5,1,'govern');