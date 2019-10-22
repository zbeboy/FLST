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
import cn.edu.kmust.flst.domain.flst.tables.records.ArticleContentRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.ArticleEnContentRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.ArticleEnRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.ArticleRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.AuthoritiesRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.BannerRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.DataInfoRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.FilesRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.FriendlyLinkRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.MenusRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.PersistentLoginsRecord;
import cn.edu.kmust.flst.domain.flst.tables.records.UsersRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>FLST</code> schema.
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

    public static final UniqueKey<ArticleRecord> CONSTRAINT_F = UniqueKeys0.CONSTRAINT_F;
    public static final UniqueKey<ArticleContentRecord> CONSTRAINT_2 = UniqueKeys0.CONSTRAINT_2;
    public static final UniqueKey<ArticleEnRecord> CONSTRAINT_26 = UniqueKeys0.CONSTRAINT_26;
    public static final UniqueKey<ArticleEnContentRecord> CONSTRAINT_9 = UniqueKeys0.CONSTRAINT_9;
    public static final UniqueKey<AuthoritiesRecord> CONSTRAINT_AB = UniqueKeys0.CONSTRAINT_AB;
    public static final UniqueKey<BannerRecord> CONSTRAINT_7 = UniqueKeys0.CONSTRAINT_7;
    public static final UniqueKey<DataInfoRecord> CONSTRAINT_92 = UniqueKeys0.CONSTRAINT_92;
    public static final UniqueKey<FilesRecord> CONSTRAINT_3 = UniqueKeys0.CONSTRAINT_3;
    public static final UniqueKey<FriendlyLinkRecord> CONSTRAINT_1 = UniqueKeys0.CONSTRAINT_1;
    public static final UniqueKey<MenusRecord> CONSTRAINT_45 = UniqueKeys0.CONSTRAINT_45;
    public static final UniqueKey<MenusRecord> CONSTRAINT_45D = UniqueKeys0.CONSTRAINT_45D;
    public static final UniqueKey<MenusRecord> CONSTRAINT_45D9 = UniqueKeys0.CONSTRAINT_45D9;
    public static final UniqueKey<PersistentLoginsRecord> CONSTRAINT_A3 = UniqueKeys0.CONSTRAINT_A3;
    public static final UniqueKey<UsersRecord> CONSTRAINT_4 = UniqueKeys0.CONSTRAINT_4;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ArticleRecord, UsersRecord> CONSTRAINT_FF2 = ForeignKeys0.CONSTRAINT_FF2;
    public static final ForeignKey<ArticleRecord, MenusRecord> CONSTRAINT_FF = ForeignKeys0.CONSTRAINT_FF;
    public static final ForeignKey<ArticleContentRecord, ArticleRecord> CONSTRAINT_29 = ForeignKeys0.CONSTRAINT_29;
    public static final ForeignKey<ArticleEnRecord, UsersRecord> CONSTRAINT_26BF = ForeignKeys0.CONSTRAINT_26BF;
    public static final ForeignKey<ArticleEnRecord, MenusRecord> CONSTRAINT_26B = ForeignKeys0.CONSTRAINT_26B;
    public static final ForeignKey<ArticleEnContentRecord, ArticleEnRecord> CONSTRAINT_97 = ForeignKeys0.CONSTRAINT_97;
    public static final ForeignKey<AuthoritiesRecord, UsersRecord> CONSTRAINT_A = ForeignKeys0.CONSTRAINT_A;
    public static final ForeignKey<BannerRecord, MenusRecord> CONSTRAINT_74 = ForeignKeys0.CONSTRAINT_74;
    public static final ForeignKey<BannerRecord, UsersRecord> CONSTRAINT_745 = ForeignKeys0.CONSTRAINT_745;
    public static final ForeignKey<MenusRecord, UsersRecord> CONSTRAINT_45D9E = ForeignKeys0.CONSTRAINT_45D9E;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ArticleRecord, Integer> IDENTITY_ARTICLE = Internal.createIdentity(Article.ARTICLE, Article.ARTICLE.ARTICLE_ID);
        public static Identity<ArticleEnRecord, Integer> IDENTITY_ARTICLE_EN = Internal.createIdentity(ArticleEn.ARTICLE_EN, ArticleEn.ARTICLE_EN.ARTICLE_ID);
        public static Identity<BannerRecord, Integer> IDENTITY_BANNER = Internal.createIdentity(Banner.BANNER, Banner.BANNER.BANNER_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ArticleRecord> CONSTRAINT_F = Internal.createUniqueKey(Article.ARTICLE, "CONSTRAINT_F", Article.ARTICLE.ARTICLE_ID);
        public static final UniqueKey<ArticleContentRecord> CONSTRAINT_2 = Internal.createUniqueKey(ArticleContent.ARTICLE_CONTENT, "CONSTRAINT_2", ArticleContent.ARTICLE_CONTENT.ID);
        public static final UniqueKey<ArticleEnRecord> CONSTRAINT_26 = Internal.createUniqueKey(ArticleEn.ARTICLE_EN, "CONSTRAINT_26", ArticleEn.ARTICLE_EN.ARTICLE_ID);
        public static final UniqueKey<ArticleEnContentRecord> CONSTRAINT_9 = Internal.createUniqueKey(ArticleEnContent.ARTICLE_EN_CONTENT, "CONSTRAINT_9", ArticleEnContent.ARTICLE_EN_CONTENT.ID);
        public static final UniqueKey<AuthoritiesRecord> CONSTRAINT_AB = Internal.createUniqueKey(Authorities.AUTHORITIES, "CONSTRAINT_AB", Authorities.AUTHORITIES.USERNAME, Authorities.AUTHORITIES.AUTHORITY);
        public static final UniqueKey<BannerRecord> CONSTRAINT_7 = Internal.createUniqueKey(Banner.BANNER, "CONSTRAINT_7", Banner.BANNER.BANNER_ID);
        public static final UniqueKey<DataInfoRecord> CONSTRAINT_92 = Internal.createUniqueKey(DataInfo.DATA_INFO, "CONSTRAINT_92", DataInfo.DATA_INFO.DATA_KEY);
        public static final UniqueKey<FilesRecord> CONSTRAINT_3 = Internal.createUniqueKey(Files.FILES, "CONSTRAINT_3", Files.FILES.FILE_ID);
        public static final UniqueKey<FriendlyLinkRecord> CONSTRAINT_1 = Internal.createUniqueKey(FriendlyLink.FRIENDLY_LINK, "CONSTRAINT_1", FriendlyLink.FRIENDLY_LINK.LINK_ID);
        public static final UniqueKey<MenusRecord> CONSTRAINT_45 = Internal.createUniqueKey(Menus.MENUS, "CONSTRAINT_45", Menus.MENUS.MENU_ID);
        public static final UniqueKey<MenusRecord> CONSTRAINT_45D = Internal.createUniqueKey(Menus.MENUS, "CONSTRAINT_45D", Menus.MENUS.MENU_NAME);
        public static final UniqueKey<MenusRecord> CONSTRAINT_45D9 = Internal.createUniqueKey(Menus.MENUS, "CONSTRAINT_45D9", Menus.MENUS.MENU_NAME_EN);
        public static final UniqueKey<PersistentLoginsRecord> CONSTRAINT_A3 = Internal.createUniqueKey(PersistentLogins.PERSISTENT_LOGINS, "CONSTRAINT_A3", PersistentLogins.PERSISTENT_LOGINS.SERIES);
        public static final UniqueKey<UsersRecord> CONSTRAINT_4 = Internal.createUniqueKey(Users.USERS, "CONSTRAINT_4", Users.USERS.USERNAME);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ArticleRecord, UsersRecord> CONSTRAINT_FF2 = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_4, Article.ARTICLE, "CONSTRAINT_FF2", Article.ARTICLE.ARTICLE_AUTHOR);
        public static final ForeignKey<ArticleRecord, MenusRecord> CONSTRAINT_FF = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_45, Article.ARTICLE, "CONSTRAINT_FF", Article.ARTICLE.MENU_ID);
        public static final ForeignKey<ArticleContentRecord, ArticleRecord> CONSTRAINT_29 = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_F, ArticleContent.ARTICLE_CONTENT, "CONSTRAINT_29", ArticleContent.ARTICLE_CONTENT.ID);
        public static final ForeignKey<ArticleEnRecord, UsersRecord> CONSTRAINT_26BF = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_4, ArticleEn.ARTICLE_EN, "CONSTRAINT_26BF", ArticleEn.ARTICLE_EN.ARTICLE_AUTHOR);
        public static final ForeignKey<ArticleEnRecord, MenusRecord> CONSTRAINT_26B = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_45, ArticleEn.ARTICLE_EN, "CONSTRAINT_26B", ArticleEn.ARTICLE_EN.MENU_ID);
        public static final ForeignKey<ArticleEnContentRecord, ArticleEnRecord> CONSTRAINT_97 = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_26, ArticleEnContent.ARTICLE_EN_CONTENT, "CONSTRAINT_97", ArticleEnContent.ARTICLE_EN_CONTENT.ID);
        public static final ForeignKey<AuthoritiesRecord, UsersRecord> CONSTRAINT_A = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_4, Authorities.AUTHORITIES, "CONSTRAINT_A", Authorities.AUTHORITIES.USERNAME);
        public static final ForeignKey<BannerRecord, MenusRecord> CONSTRAINT_74 = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_45, Banner.BANNER, "CONSTRAINT_74", Banner.BANNER.MENU_ID);
        public static final ForeignKey<BannerRecord, UsersRecord> CONSTRAINT_745 = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_4, Banner.BANNER, "CONSTRAINT_745", Banner.BANNER.BANNER_CREATOR);
        public static final ForeignKey<MenusRecord, UsersRecord> CONSTRAINT_45D9E = Internal.createForeignKey(cn.edu.kmust.flst.domain.flst.Keys.CONSTRAINT_4, Menus.MENUS, "CONSTRAINT_45D9E", Menus.MENUS.MENU_CREATOR);
    }
}
