/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain;


import cn.edu.kmust.flst.domain.tables.Article;
import cn.edu.kmust.flst.domain.tables.ArticleContent;
import cn.edu.kmust.flst.domain.tables.ArticleEn;
import cn.edu.kmust.flst.domain.tables.ArticleEnContent;
import cn.edu.kmust.flst.domain.tables.Authorities;
import cn.edu.kmust.flst.domain.tables.Banner;
import cn.edu.kmust.flst.domain.tables.DataInfo;
import cn.edu.kmust.flst.domain.tables.Files;
import cn.edu.kmust.flst.domain.tables.FriendlyLink;
import cn.edu.kmust.flst.domain.tables.Menus;
import cn.edu.kmust.flst.domain.tables.PersistentLogins;
import cn.edu.kmust.flst.domain.tables.Users;
import cn.edu.kmust.flst.domain.tables.records.ArticleContentRecord;
import cn.edu.kmust.flst.domain.tables.records.ArticleEnContentRecord;
import cn.edu.kmust.flst.domain.tables.records.ArticleEnRecord;
import cn.edu.kmust.flst.domain.tables.records.ArticleRecord;
import cn.edu.kmust.flst.domain.tables.records.AuthoritiesRecord;
import cn.edu.kmust.flst.domain.tables.records.BannerRecord;
import cn.edu.kmust.flst.domain.tables.records.DataInfoRecord;
import cn.edu.kmust.flst.domain.tables.records.FilesRecord;
import cn.edu.kmust.flst.domain.tables.records.FriendlyLinkRecord;
import cn.edu.kmust.flst.domain.tables.records.MenusRecord;
import cn.edu.kmust.flst.domain.tables.records.PersistentLoginsRecord;
import cn.edu.kmust.flst.domain.tables.records.UsersRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>flst</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ArticleRecord, Integer> IDENTITY_ARTICLE = Identities0.IDENTITY_ARTICLE;
    public static final Identity<ArticleEnRecord, Integer> IDENTITY_ARTICLE_EN = Identities0.IDENTITY_ARTICLE_EN;
    public static final Identity<BannerRecord, Integer> IDENTITY_BANNER = Identities0.IDENTITY_BANNER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ArticleRecord> KEY_ARTICLE_PRIMARY = UniqueKeys0.KEY_ARTICLE_PRIMARY;
    public static final UniqueKey<ArticleContentRecord> KEY_ARTICLE_CONTENT_PRIMARY = UniqueKeys0.KEY_ARTICLE_CONTENT_PRIMARY;
    public static final UniqueKey<ArticleEnRecord> KEY_ARTICLE_EN_PRIMARY = UniqueKeys0.KEY_ARTICLE_EN_PRIMARY;
    public static final UniqueKey<ArticleEnContentRecord> KEY_ARTICLE_EN_CONTENT_PRIMARY = UniqueKeys0.KEY_ARTICLE_EN_CONTENT_PRIMARY;
    public static final UniqueKey<AuthoritiesRecord> KEY_AUTHORITIES_PRIMARY = UniqueKeys0.KEY_AUTHORITIES_PRIMARY;
    public static final UniqueKey<BannerRecord> KEY_BANNER_PRIMARY = UniqueKeys0.KEY_BANNER_PRIMARY;
    public static final UniqueKey<DataInfoRecord> KEY_DATA_INFO_PRIMARY = UniqueKeys0.KEY_DATA_INFO_PRIMARY;
    public static final UniqueKey<FilesRecord> KEY_FILES_PRIMARY = UniqueKeys0.KEY_FILES_PRIMARY;
    public static final UniqueKey<FriendlyLinkRecord> KEY_FRIENDLY_LINK_PRIMARY = UniqueKeys0.KEY_FRIENDLY_LINK_PRIMARY;
    public static final UniqueKey<MenusRecord> KEY_MENUS_PRIMARY = UniqueKeys0.KEY_MENUS_PRIMARY;
    public static final UniqueKey<MenusRecord> KEY_MENUS_MENU_NAME = UniqueKeys0.KEY_MENUS_MENU_NAME;
    public static final UniqueKey<MenusRecord> KEY_MENUS_MENU_NAME_EN = UniqueKeys0.KEY_MENUS_MENU_NAME_EN;
    public static final UniqueKey<PersistentLoginsRecord> KEY_PERSISTENT_LOGINS_PRIMARY = UniqueKeys0.KEY_PERSISTENT_LOGINS_PRIMARY;
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = UniqueKeys0.KEY_USERS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ArticleRecord, UsersRecord> ARTICLE_IBFK_2 = ForeignKeys0.ARTICLE_IBFK_2;
    public static final ForeignKey<ArticleRecord, MenusRecord> ARTICLE_IBFK_1 = ForeignKeys0.ARTICLE_IBFK_1;
    public static final ForeignKey<ArticleContentRecord, ArticleRecord> ARTICLE_CONTENT_IBFK_1 = ForeignKeys0.ARTICLE_CONTENT_IBFK_1;
    public static final ForeignKey<ArticleEnRecord, UsersRecord> ARTICLE_EN_IBFK_2 = ForeignKeys0.ARTICLE_EN_IBFK_2;
    public static final ForeignKey<ArticleEnRecord, MenusRecord> ARTICLE_EN_IBFK_1 = ForeignKeys0.ARTICLE_EN_IBFK_1;
    public static final ForeignKey<ArticleEnContentRecord, ArticleEnRecord> ARTICLE_EN_CONTENT_IBFK_1 = ForeignKeys0.ARTICLE_EN_CONTENT_IBFK_1;
    public static final ForeignKey<AuthoritiesRecord, UsersRecord> AUTHORITIES_IBFK_1 = ForeignKeys0.AUTHORITIES_IBFK_1;
    public static final ForeignKey<BannerRecord, MenusRecord> BANNER_IBFK_1 = ForeignKeys0.BANNER_IBFK_1;
    public static final ForeignKey<BannerRecord, UsersRecord> BANNER_IBFK_2 = ForeignKeys0.BANNER_IBFK_2;
    public static final ForeignKey<MenusRecord, UsersRecord> MENUS_IBFK_1 = ForeignKeys0.MENUS_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ArticleRecord, Integer> IDENTITY_ARTICLE = Internal.createIdentity(Article.ARTICLE, Article.ARTICLE.ARTICLE_ID);
        public static Identity<ArticleEnRecord, Integer> IDENTITY_ARTICLE_EN = Internal.createIdentity(ArticleEn.ARTICLE_EN, ArticleEn.ARTICLE_EN.ARTICLE_ID);
        public static Identity<BannerRecord, Integer> IDENTITY_BANNER = Internal.createIdentity(Banner.BANNER, Banner.BANNER.BANNER_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ArticleRecord> KEY_ARTICLE_PRIMARY = Internal.createUniqueKey(Article.ARTICLE, "KEY_article_PRIMARY", Article.ARTICLE.ARTICLE_ID);
        public static final UniqueKey<ArticleContentRecord> KEY_ARTICLE_CONTENT_PRIMARY = Internal.createUniqueKey(ArticleContent.ARTICLE_CONTENT, "KEY_article_content_PRIMARY", ArticleContent.ARTICLE_CONTENT.ID);
        public static final UniqueKey<ArticleEnRecord> KEY_ARTICLE_EN_PRIMARY = Internal.createUniqueKey(ArticleEn.ARTICLE_EN, "KEY_article_en_PRIMARY", ArticleEn.ARTICLE_EN.ARTICLE_ID);
        public static final UniqueKey<ArticleEnContentRecord> KEY_ARTICLE_EN_CONTENT_PRIMARY = Internal.createUniqueKey(ArticleEnContent.ARTICLE_EN_CONTENT, "KEY_article_en_content_PRIMARY", ArticleEnContent.ARTICLE_EN_CONTENT.ID);
        public static final UniqueKey<AuthoritiesRecord> KEY_AUTHORITIES_PRIMARY = Internal.createUniqueKey(Authorities.AUTHORITIES, "KEY_authorities_PRIMARY", Authorities.AUTHORITIES.USERNAME, Authorities.AUTHORITIES.AUTHORITY);
        public static final UniqueKey<BannerRecord> KEY_BANNER_PRIMARY = Internal.createUniqueKey(Banner.BANNER, "KEY_banner_PRIMARY", Banner.BANNER.BANNER_ID);
        public static final UniqueKey<DataInfoRecord> KEY_DATA_INFO_PRIMARY = Internal.createUniqueKey(DataInfo.DATA_INFO, "KEY_data_info_PRIMARY", DataInfo.DATA_INFO.DATA_KEY);
        public static final UniqueKey<FilesRecord> KEY_FILES_PRIMARY = Internal.createUniqueKey(Files.FILES, "KEY_files_PRIMARY", Files.FILES.FILE_ID);
        public static final UniqueKey<FriendlyLinkRecord> KEY_FRIENDLY_LINK_PRIMARY = Internal.createUniqueKey(FriendlyLink.FRIENDLY_LINK, "KEY_friendly_link_PRIMARY", FriendlyLink.FRIENDLY_LINK.LINK_ID);
        public static final UniqueKey<MenusRecord> KEY_MENUS_PRIMARY = Internal.createUniqueKey(Menus.MENUS, "KEY_menus_PRIMARY", Menus.MENUS.MENU_ID);
        public static final UniqueKey<MenusRecord> KEY_MENUS_MENU_NAME = Internal.createUniqueKey(Menus.MENUS, "KEY_menus_menu_name", Menus.MENUS.MENU_NAME);
        public static final UniqueKey<MenusRecord> KEY_MENUS_MENU_NAME_EN = Internal.createUniqueKey(Menus.MENUS, "KEY_menus_menu_name_en", Menus.MENUS.MENU_NAME_EN);
        public static final UniqueKey<PersistentLoginsRecord> KEY_PERSISTENT_LOGINS_PRIMARY = Internal.createUniqueKey(PersistentLogins.PERSISTENT_LOGINS, "KEY_persistent_logins_PRIMARY", PersistentLogins.PERSISTENT_LOGINS.SERIES);
        public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, "KEY_users_PRIMARY", Users.USERS.USERNAME);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ArticleRecord, UsersRecord> ARTICLE_IBFK_2 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_USERS_PRIMARY, Article.ARTICLE, "article_ibfk_2", Article.ARTICLE.ARTICLE_AUTHOR);
        public static final ForeignKey<ArticleRecord, MenusRecord> ARTICLE_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_MENUS_PRIMARY, Article.ARTICLE, "article_ibfk_1", Article.ARTICLE.MENU_ID);
        public static final ForeignKey<ArticleContentRecord, ArticleRecord> ARTICLE_CONTENT_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_ARTICLE_PRIMARY, ArticleContent.ARTICLE_CONTENT, "article_content_ibfk_1", ArticleContent.ARTICLE_CONTENT.ID);
        public static final ForeignKey<ArticleEnRecord, UsersRecord> ARTICLE_EN_IBFK_2 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_USERS_PRIMARY, ArticleEn.ARTICLE_EN, "article_en_ibfk_2", ArticleEn.ARTICLE_EN.ARTICLE_AUTHOR);
        public static final ForeignKey<ArticleEnRecord, MenusRecord> ARTICLE_EN_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_MENUS_PRIMARY, ArticleEn.ARTICLE_EN, "article_en_ibfk_1", ArticleEn.ARTICLE_EN.MENU_ID);
        public static final ForeignKey<ArticleEnContentRecord, ArticleEnRecord> ARTICLE_EN_CONTENT_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_ARTICLE_EN_PRIMARY, ArticleEnContent.ARTICLE_EN_CONTENT, "article_en_content_ibfk_1", ArticleEnContent.ARTICLE_EN_CONTENT.ID);
        public static final ForeignKey<AuthoritiesRecord, UsersRecord> AUTHORITIES_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_USERS_PRIMARY, Authorities.AUTHORITIES, "authorities_ibfk_1", Authorities.AUTHORITIES.USERNAME);
        public static final ForeignKey<BannerRecord, MenusRecord> BANNER_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_MENUS_PRIMARY, Banner.BANNER, "banner_ibfk_1", Banner.BANNER.MENU_ID);
        public static final ForeignKey<BannerRecord, UsersRecord> BANNER_IBFK_2 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_USERS_PRIMARY, Banner.BANNER, "banner_ibfk_2", Banner.BANNER.BANNER_CREATOR);
        public static final ForeignKey<MenusRecord, UsersRecord> MENUS_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_USERS_PRIMARY, Menus.MENUS, "menus_ibfk_1", Menus.MENUS.MENU_CREATOR);
    }
}
