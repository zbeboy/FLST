/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.flst;


import cn.edu.kmust.flst.domain.flst.tables.Article;
import cn.edu.kmust.flst.domain.flst.tables.ArticleContent;
import cn.edu.kmust.flst.domain.flst.tables.ArticleEn;
import cn.edu.kmust.flst.domain.flst.tables.ArticleEnContent;
import cn.edu.kmust.flst.domain.flst.tables.Authorities;
import cn.edu.kmust.flst.domain.flst.tables.Banner;
import cn.edu.kmust.flst.domain.flst.tables.DataInfo;
import cn.edu.kmust.flst.domain.flst.tables.Files;
import cn.edu.kmust.flst.domain.flst.tables.FriendlyLink;
import cn.edu.kmust.flst.domain.flst.tables.Menus;
import cn.edu.kmust.flst.domain.flst.tables.PersistentLogins;
import cn.edu.kmust.flst.domain.flst.tables.Users;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>FLST</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CONSTRAINT_INDEX_F = Indexes0.CONSTRAINT_INDEX_F;
    public static final Index CONSTRAINT_INDEX_FF = Indexes0.CONSTRAINT_INDEX_FF;
    public static final Index PRIMARY_KEY_F = Indexes0.PRIMARY_KEY_F;
    public static final Index PRIMARY_KEY_2 = Indexes0.PRIMARY_KEY_2;
    public static final Index CONSTRAINT_INDEX_2 = Indexes0.CONSTRAINT_INDEX_2;
    public static final Index CONSTRAINT_INDEX_26 = Indexes0.CONSTRAINT_INDEX_26;
    public static final Index PRIMARY_KEY_26 = Indexes0.PRIMARY_KEY_26;
    public static final Index PRIMARY_KEY_9 = Indexes0.PRIMARY_KEY_9;
    public static final Index CONSTRAINT_INDEX_A = Indexes0.CONSTRAINT_INDEX_A;
    public static final Index PRIMARY_KEY_A = Indexes0.PRIMARY_KEY_A;
    public static final Index CONSTRAINT_INDEX_7 = Indexes0.CONSTRAINT_INDEX_7;
    public static final Index CONSTRAINT_INDEX_74 = Indexes0.CONSTRAINT_INDEX_74;
    public static final Index PRIMARY_KEY_7 = Indexes0.PRIMARY_KEY_7;
    public static final Index PRIMARY_KEY_92 = Indexes0.PRIMARY_KEY_92;
    public static final Index PRIMARY_KEY_3 = Indexes0.PRIMARY_KEY_3;
    public static final Index PRIMARY_KEY_1 = Indexes0.PRIMARY_KEY_1;
    public static final Index CONSTRAINT_INDEX_4 = Indexes0.CONSTRAINT_INDEX_4;
    public static final Index CONSTRAINT_INDEX_45 = Indexes0.CONSTRAINT_INDEX_45;
    public static final Index CONSTRAINT_INDEX_45D = Indexes0.CONSTRAINT_INDEX_45D;
    public static final Index PRIMARY_KEY_45 = Indexes0.PRIMARY_KEY_45;
    public static final Index PRIMARY_KEY_A3 = Indexes0.PRIMARY_KEY_A3;
    public static final Index PRIMARY_KEY_4 = Indexes0.PRIMARY_KEY_4;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index CONSTRAINT_INDEX_F = Internal.createIndex("CONSTRAINT_INDEX_F", Article.ARTICLE, new OrderField[] { Article.ARTICLE.MENU_ID }, false);
        public static Index CONSTRAINT_INDEX_FF = Internal.createIndex("CONSTRAINT_INDEX_FF", Article.ARTICLE, new OrderField[] { Article.ARTICLE.ARTICLE_AUTHOR }, false);
        public static Index PRIMARY_KEY_F = Internal.createIndex("PRIMARY_KEY_F", Article.ARTICLE, new OrderField[] { Article.ARTICLE.ARTICLE_ID }, true);
        public static Index PRIMARY_KEY_2 = Internal.createIndex("PRIMARY_KEY_2", ArticleContent.ARTICLE_CONTENT, new OrderField[] { ArticleContent.ARTICLE_CONTENT.ID }, true);
        public static Index CONSTRAINT_INDEX_2 = Internal.createIndex("CONSTRAINT_INDEX_2", ArticleEn.ARTICLE_EN, new OrderField[] { ArticleEn.ARTICLE_EN.MENU_ID }, false);
        public static Index CONSTRAINT_INDEX_26 = Internal.createIndex("CONSTRAINT_INDEX_26", ArticleEn.ARTICLE_EN, new OrderField[] { ArticleEn.ARTICLE_EN.ARTICLE_AUTHOR }, false);
        public static Index PRIMARY_KEY_26 = Internal.createIndex("PRIMARY_KEY_26", ArticleEn.ARTICLE_EN, new OrderField[] { ArticleEn.ARTICLE_EN.ARTICLE_ID }, true);
        public static Index PRIMARY_KEY_9 = Internal.createIndex("PRIMARY_KEY_9", ArticleEnContent.ARTICLE_EN_CONTENT, new OrderField[] { ArticleEnContent.ARTICLE_EN_CONTENT.ID }, true);
        public static Index CONSTRAINT_INDEX_A = Internal.createIndex("CONSTRAINT_INDEX_A", Authorities.AUTHORITIES, new OrderField[] { Authorities.AUTHORITIES.USERNAME }, false);
        public static Index PRIMARY_KEY_A = Internal.createIndex("PRIMARY_KEY_A", Authorities.AUTHORITIES, new OrderField[] { Authorities.AUTHORITIES.USERNAME, Authorities.AUTHORITIES.AUTHORITY }, true);
        public static Index CONSTRAINT_INDEX_7 = Internal.createIndex("CONSTRAINT_INDEX_7", Banner.BANNER, new OrderField[] { Banner.BANNER.MENU_ID }, false);
        public static Index CONSTRAINT_INDEX_74 = Internal.createIndex("CONSTRAINT_INDEX_74", Banner.BANNER, new OrderField[] { Banner.BANNER.BANNER_CREATOR }, false);
        public static Index PRIMARY_KEY_7 = Internal.createIndex("PRIMARY_KEY_7", Banner.BANNER, new OrderField[] { Banner.BANNER.BANNER_ID }, true);
        public static Index PRIMARY_KEY_92 = Internal.createIndex("PRIMARY_KEY_92", DataInfo.DATA_INFO, new OrderField[] { DataInfo.DATA_INFO.DATA_KEY }, true);
        public static Index PRIMARY_KEY_3 = Internal.createIndex("PRIMARY_KEY_3", Files.FILES, new OrderField[] { Files.FILES.FILE_ID }, true);
        public static Index PRIMARY_KEY_1 = Internal.createIndex("PRIMARY_KEY_1", FriendlyLink.FRIENDLY_LINK, new OrderField[] { FriendlyLink.FRIENDLY_LINK.LINK_ID }, true);
        public static Index CONSTRAINT_INDEX_4 = Internal.createIndex("CONSTRAINT_INDEX_4", Menus.MENUS, new OrderField[] { Menus.MENUS.MENU_NAME }, true);
        public static Index CONSTRAINT_INDEX_45 = Internal.createIndex("CONSTRAINT_INDEX_45", Menus.MENUS, new OrderField[] { Menus.MENUS.MENU_NAME_EN }, true);
        public static Index CONSTRAINT_INDEX_45D = Internal.createIndex("CONSTRAINT_INDEX_45D", Menus.MENUS, new OrderField[] { Menus.MENUS.MENU_CREATOR }, false);
        public static Index PRIMARY_KEY_45 = Internal.createIndex("PRIMARY_KEY_45", Menus.MENUS, new OrderField[] { Menus.MENUS.MENU_ID }, true);
        public static Index PRIMARY_KEY_A3 = Internal.createIndex("PRIMARY_KEY_A3", PersistentLogins.PERSISTENT_LOGINS, new OrderField[] { PersistentLogins.PERSISTENT_LOGINS.SERIES }, true);
        public static Index PRIMARY_KEY_4 = Internal.createIndex("PRIMARY_KEY_4", Users.USERS, new OrderField[] { Users.USERS.USERNAME }, true);
    }
}
