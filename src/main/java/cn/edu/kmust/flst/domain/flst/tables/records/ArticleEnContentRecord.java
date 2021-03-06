/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.flst.tables.records;


import cn.edu.kmust.flst.domain.flst.tables.ArticleEnContent;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ArticleEnContentRecord extends UpdatableRecordImpl<ArticleEnContentRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = -1454136309;

    /**
     * Setter for <code>FLST.ARTICLE_EN_CONTENT.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>FLST.ARTICLE_EN_CONTENT.ID</code>.
     */
    @NotNull
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>FLST.ARTICLE_EN_CONTENT.ARTICLE_CONTENT</code>.
     */
    public void setArticleContent(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>FLST.ARTICLE_EN_CONTENT.ARTICLE_CONTENT</code>.
     */
    @NotNull
    @Size(max = 2147483647)
    public String getArticleContent() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ArticleEnContent.ARTICLE_EN_CONTENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return ArticleEnContent.ARTICLE_EN_CONTENT.ARTICLE_CONTENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getArticleContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getArticleContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnContentRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnContentRecord value2(String value) {
        setArticleContent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnContentRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ArticleEnContentRecord
     */
    public ArticleEnContentRecord() {
        super(ArticleEnContent.ARTICLE_EN_CONTENT);
    }

    /**
     * Create a detached, initialised ArticleEnContentRecord
     */
    public ArticleEnContentRecord(Integer id, String articleContent) {
        super(ArticleEnContent.ARTICLE_EN_CONTENT);

        set(0, id);
        set(1, articleContent);
    }
}
