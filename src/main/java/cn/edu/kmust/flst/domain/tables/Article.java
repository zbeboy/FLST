/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables;


import cn.edu.kmust.flst.domain.Flst;
import cn.edu.kmust.flst.domain.Indexes;
import cn.edu.kmust.flst.domain.Keys;
import cn.edu.kmust.flst.domain.tables.records.ArticleRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Article extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = 1086786971;

    /**
     * The reference instance of <code>flst.article</code>
     */
    public static final Article ARTICLE = new Article();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticleRecord> getRecordType() {
        return ArticleRecord.class;
    }

    /**
     * The column <code>flst.article.article_id</code>.
     */
    public final TableField<ArticleRecord, Integer> ARTICLE_ID = createField("article_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>flst.article.article_title</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_TITLE = createField("article_title", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>flst.article.article_brief</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_BRIEF = createField("article_brief", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>flst.article.article_cover</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_COVER = createField("article_cover", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>flst.article.article_date</code>.
     */
    public final TableField<ArticleRecord, Timestamp> ARTICLE_DATE = createField("article_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>flst.article.article_clicks</code>.
     */
    public final TableField<ArticleRecord, Integer> ARTICLE_CLICKS = createField("article_clicks", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>flst.article.username</code>.
     */
    public final TableField<ArticleRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>flst.article.article_sources</code>.
     */
    public final TableField<ArticleRecord, Integer> ARTICLE_SOURCES = createField("article_sources", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>flst.article.article_sources_name</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_SOURCES_NAME = createField("article_sources_name", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>flst.article.article_sources_link</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_SOURCES_LINK = createField("article_sources_link", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>flst.article.menu_id</code>.
     */
    public final TableField<ArticleRecord, String> MENU_ID = createField("menu_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>flst.article</code> table reference
     */
    public Article() {
        this(DSL.name("article"), null);
    }

    /**
     * Create an aliased <code>flst.article</code> table reference
     */
    public Article(String alias) {
        this(DSL.name(alias), ARTICLE);
    }

    /**
     * Create an aliased <code>flst.article</code> table reference
     */
    public Article(Name alias) {
        this(alias, ARTICLE);
    }

    private Article(Name alias, Table<ArticleRecord> aliased) {
        this(alias, aliased, null);
    }

    private Article(Name alias, Table<ArticleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Flst.FLST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ARTICLE_MENU_ID, Indexes.ARTICLE_PRIMARY, Indexes.ARTICLE_USERNAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ArticleRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ARTICLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticleRecord> getPrimaryKey() {
        return Keys.KEY_ARTICLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleRecord>>asList(Keys.KEY_ARTICLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ArticleRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ArticleRecord, ?>>asList(Keys.ARTICLE_IBFK_2, Keys.ARTICLE_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article as(String alias) {
        return new Article(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article as(Name alias) {
        return new Article(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Article rename(String name) {
        return new Article(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Article rename(Name name) {
        return new Article(name, null);
    }
}
