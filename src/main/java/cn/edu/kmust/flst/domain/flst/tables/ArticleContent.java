/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.flst.tables;


import cn.edu.kmust.flst.domain.flst.Flst;
import cn.edu.kmust.flst.domain.flst.Indexes;
import cn.edu.kmust.flst.domain.flst.Keys;
import cn.edu.kmust.flst.domain.flst.tables.records.ArticleContentRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class ArticleContent extends TableImpl<ArticleContentRecord> {

    private static final long serialVersionUID = -628768354;

    /**
     * The reference instance of <code>FLST.ARTICLE_CONTENT</code>
     */
    public static final ArticleContent ARTICLE_CONTENT = new ArticleContent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticleContentRecord> getRecordType() {
        return ArticleContentRecord.class;
    }

    /**
     * The column <code>FLST.ARTICLE_CONTENT.ID</code>.
     */
    public final TableField<ArticleContentRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>FLST.ARTICLE_CONTENT.ARTICLE_CONTENT</code>.
     */
    public final TableField<ArticleContentRecord, String> ARTICLE_CONTENT_ = createField("ARTICLE_CONTENT", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>FLST.ARTICLE_CONTENT</code> table reference
     */
    public ArticleContent() {
        this(DSL.name("ARTICLE_CONTENT"), null);
    }

    /**
     * Create an aliased <code>FLST.ARTICLE_CONTENT</code> table reference
     */
    public ArticleContent(String alias) {
        this(DSL.name(alias), ARTICLE_CONTENT);
    }

    /**
     * Create an aliased <code>FLST.ARTICLE_CONTENT</code> table reference
     */
    public ArticleContent(Name alias) {
        this(alias, ARTICLE_CONTENT);
    }

    private ArticleContent(Name alias, Table<ArticleContentRecord> aliased) {
        this(alias, aliased, null);
    }

    private ArticleContent(Name alias, Table<ArticleContentRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticleContentRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticleContentRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleContentRecord>>asList(Keys.CONSTRAINT_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ArticleContentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ArticleContentRecord, ?>>asList(Keys.CONSTRAINT_29);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleContent as(String alias) {
        return new ArticleContent(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleContent as(Name alias) {
        return new ArticleContent(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ArticleContent rename(String name) {
        return new ArticleContent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ArticleContent rename(Name name) {
        return new ArticleContent(name, null);
    }
}