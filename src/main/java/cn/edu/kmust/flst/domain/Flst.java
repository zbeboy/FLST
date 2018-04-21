/*
 * This file is generated by jOOQ.
 */
package cn.edu.kmust.flst.domain;


import cn.edu.kmust.flst.domain.tables.*;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.10.6"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Flst extends SchemaImpl {

    private static final long serialVersionUID = 790602150;

    /**
     * The reference instance of <code>flst</code>
     */
    public static final Flst FLST = new Flst();

    /**
     * The table <code>flst.article</code>.
     */
    public final Article ARTICLE = cn.edu.kmust.flst.domain.tables.Article.ARTICLE;

    /**
     * The table <code>flst.article_en</code>.
     */
    public final ArticleEn ARTICLE_EN = cn.edu.kmust.flst.domain.tables.ArticleEn.ARTICLE_EN;

    /**
     * The table <code>flst.authorities</code>.
     */
    public final Authorities AUTHORITIES = cn.edu.kmust.flst.domain.tables.Authorities.AUTHORITIES;

    /**
     * The table <code>flst.banner</code>.
     */
    public final Banner BANNER = cn.edu.kmust.flst.domain.tables.Banner.BANNER;

    /**
     * The table <code>flst.data_info</code>.
     */
    public final DataInfo DATA_INFO = cn.edu.kmust.flst.domain.tables.DataInfo.DATA_INFO;

    /**
     * The table <code>flst.files</code>.
     */
    public final Files FILES = cn.edu.kmust.flst.domain.tables.Files.FILES;

    /**
     * The table <code>flst.friendly_link</code>.
     */
    public final FriendlyLink FRIENDLY_LINK = cn.edu.kmust.flst.domain.tables.FriendlyLink.FRIENDLY_LINK;

    /**
     * The table <code>flst.menus</code>.
     */
    public final Menus MENUS = cn.edu.kmust.flst.domain.tables.Menus.MENUS;

    /**
     * The table <code>flst.persistent_logins</code>.
     */
    public final PersistentLogins PERSISTENT_LOGINS = cn.edu.kmust.flst.domain.tables.PersistentLogins.PERSISTENT_LOGINS;

    /**
     * The table <code>flst.users</code>.
     */
    public final Users USERS = cn.edu.kmust.flst.domain.tables.Users.USERS;

    /**
     * No further instances allowed
     */
    private Flst() {
        super("flst", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
                Article.ARTICLE,
                ArticleEn.ARTICLE_EN,
                Authorities.AUTHORITIES,
                Banner.BANNER,
                DataInfo.DATA_INFO,
                Files.FILES,
                FriendlyLink.FRIENDLY_LINK,
                Menus.MENUS,
                PersistentLogins.PERSISTENT_LOGINS,
                Users.USERS);
    }
}
