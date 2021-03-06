/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.flst.tables;


import cn.edu.kmust.flst.domain.flst.Flst;
import cn.edu.kmust.flst.domain.flst.Indexes;
import cn.edu.kmust.flst.domain.flst.Keys;
import cn.edu.kmust.flst.domain.flst.tables.records.ArticleRecord;

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
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Article extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = -12992395;

    /**
     * The reference instance of <code>FLST.ARTICLE</code>
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
     * The column <code>FLST.ARTICLE.ARTICLE_ID</code>.
     */
    public final TableField<ArticleRecord, Integer> ARTICLE_ID = createField("ARTICLE_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_TITLE</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_TITLE = createField("ARTICLE_TITLE", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_BRIEF</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_BRIEF = createField("ARTICLE_BRIEF", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_COVER</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_COVER = createField("ARTICLE_COVER", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_DATE</code>.
     */
    public final TableField<ArticleRecord, Timestamp> ARTICLE_DATE = createField("ARTICLE_DATE", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_CLICKS</code>.
     */
    public final TableField<ArticleRecord, Integer> ARTICLE_CLICKS = createField("ARTICLE_CLICKS", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_AUTHOR</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_AUTHOR = createField("ARTICLE_AUTHOR", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_SOURCES</code>.
     */
    public final TableField<ArticleRecord, Integer> ARTICLE_SOURCES = createField("ARTICLE_SOURCES", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_SOURCES_NAME</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_SOURCES_NAME = createField("ARTICLE_SOURCES_NAME", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_SOURCES_LINK</code>.
     */
    public final TableField<ArticleRecord, String> ARTICLE_SOURCES_LINK = createField("ARTICLE_SOURCES_LINK", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>FLST.ARTICLE.ARTICLE_SN</code>.
     */
    public final TableField<ArticleRecord, Integer> ARTICLE_SN = createField("ARTICLE_SN", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>FLST.ARTICLE.MENU_ID</code>.
     */
    public final TableField<ArticleRecord, String> MENU_ID = createField("MENU_ID", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>FLST.ARTICLE</code> table reference
     */
    public Article() {
        this(DSL.name("ARTICLE"), null);
    }

    /**
     * Create an aliased <code>FLST.ARTICLE</code> table reference
     */
    public Article(String alias) {
        this(DSL.name(alias), ARTICLE);
    }

    /**
     * Create an aliased <code>FLST.ARTICLE</code> table reference
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
        return Arrays.<Index>asList(Indexes.CONSTRAINT_INDEX_F, Indexes.CONSTRAINT_INDEX_FF, Indexes.PRIMARY_KEY_F);
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
        return Keys.CONSTRAINT_F;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleRecord>>asList(Keys.CONSTRAINT_F);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ArticleRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ArticleRecord, ?>>asList(Keys.CONSTRAINT_FF2, Keys.CONSTRAINT_FF);
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
