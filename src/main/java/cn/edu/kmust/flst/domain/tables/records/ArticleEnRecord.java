/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.records;


import cn.edu.kmust.flst.domain.tables.ArticleEn;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
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
public class ArticleEnRecord extends UpdatableRecordImpl<ArticleEnRecord> implements Record11<Integer, String, String, String, Timestamp, Integer, String, Integer, String, String, String> {

    private static final long serialVersionUID = 2137217535;

    /**
     * Setter for <code>flst.article_en.article_id</code>.
     */
    public void setArticleId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>flst.article_en.article_id</code>.
     */
    public Integer getArticleId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>flst.article_en.article_title</code>.
     */
    public void setArticleTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>flst.article_en.article_title</code>.
     */
    @NotNull
    @Size(max = 200)
    public String getArticleTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>flst.article_en.article_brief</code>.
     */
    public void setArticleBrief(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>flst.article_en.article_brief</code>.
     */
    @Size(max = 300)
    public String getArticleBrief() {
        return (String) get(2);
    }

    /**
     * Setter for <code>flst.article_en.article_cover</code>.
     */
    public void setArticleCover(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>flst.article_en.article_cover</code>.
     */
    @Size(max = 200)
    public String getArticleCover() {
        return (String) get(3);
    }

    /**
     * Setter for <code>flst.article_en.article_date</code>.
     */
    public void setArticleDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>flst.article_en.article_date</code>.
     */
    @NotNull
    public Timestamp getArticleDate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>flst.article_en.article_clicks</code>.
     */
    public void setArticleClicks(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>flst.article_en.article_clicks</code>.
     */
    public Integer getArticleClicks() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>flst.article_en.article_author</code>.
     */
    public void setArticleAuthor(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>flst.article_en.article_author</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getArticleAuthor() {
        return (String) get(6);
    }

    /**
     * Setter for <code>flst.article_en.article_sources</code>.
     */
    public void setArticleSources(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>flst.article_en.article_sources</code>.
     */
    public Integer getArticleSources() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>flst.article_en.article_sources_name</code>.
     */
    public void setArticleSourcesName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>flst.article_en.article_sources_name</code>.
     */
    @Size(max = 100)
    public String getArticleSourcesName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>flst.article_en.article_sources_link</code>.
     */
    public void setArticleSourcesLink(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>flst.article_en.article_sources_link</code>.
     */
    @Size(max = 200)
    public String getArticleSourcesLink() {
        return (String) get(9);
    }

    /**
     * Setter for <code>flst.article_en.menu_id</code>.
     */
    public void setMenuId(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>flst.article_en.menu_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getMenuId() {
        return (String) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, String, String, String, Timestamp, Integer, String, Integer, String, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, String, String, String, Timestamp, Integer, String, Integer, String, String, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ArticleEn.ARTICLE_EN.ARTICLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return ArticleEn.ARTICLE_EN.ARTICLE_TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ArticleEn.ARTICLE_EN.ARTICLE_BRIEF;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ArticleEn.ARTICLE_EN.ARTICLE_COVER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return ArticleEn.ARTICLE_EN.ARTICLE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return ArticleEn.ARTICLE_EN.ARTICLE_CLICKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return ArticleEn.ARTICLE_EN.ARTICLE_AUTHOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return ArticleEn.ARTICLE_EN.ARTICLE_SOURCES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return ArticleEn.ARTICLE_EN.ARTICLE_SOURCES_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return ArticleEn.ARTICLE_EN.ARTICLE_SOURCES_LINK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return ArticleEn.ARTICLE_EN.MENU_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getArticleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getArticleTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getArticleBrief();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getArticleCover();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getArticleDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getArticleClicks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getArticleAuthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getArticleSources();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getArticleSourcesName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getArticleSourcesLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getMenuId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getArticleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getArticleTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getArticleBrief();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getArticleCover();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getArticleDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getArticleClicks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getArticleAuthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getArticleSources();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getArticleSourcesName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getArticleSourcesLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getMenuId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value1(Integer value) {
        setArticleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value2(String value) {
        setArticleTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value3(String value) {
        setArticleBrief(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value4(String value) {
        setArticleCover(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value5(Timestamp value) {
        setArticleDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value6(Integer value) {
        setArticleClicks(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value7(String value) {
        setArticleAuthor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value8(Integer value) {
        setArticleSources(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value9(String value) {
        setArticleSourcesName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value10(String value) {
        setArticleSourcesLink(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord value11(String value) {
        setMenuId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticleEnRecord values(Integer value1, String value2, String value3, String value4, Timestamp value5, Integer value6, String value7, Integer value8, String value9, String value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ArticleEnRecord
     */
    public ArticleEnRecord() {
        super(ArticleEn.ARTICLE_EN);
    }

    /**
     * Create a detached, initialised ArticleEnRecord
     */
    public ArticleEnRecord(Integer articleId, String articleTitle, String articleBrief, String articleCover, Timestamp articleDate, Integer articleClicks, String articleAuthor, Integer articleSources, String articleSourcesName, String articleSourcesLink, String menuId) {
        super(ArticleEn.ARTICLE_EN);

        set(0, articleId);
        set(1, articleTitle);
        set(2, articleBrief);
        set(3, articleCover);
        set(4, articleDate);
        set(5, articleClicks);
        set(6, articleAuthor);
        set(7, articleSources);
        set(8, articleSourcesName);
        set(9, articleSourcesLink);
        set(10, menuId);
    }
}
