/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.daos;


import cn.edu.kmust.flst.domain.tables.ArticleEn;
import cn.edu.kmust.flst.domain.tables.records.ArticleEnRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
@Repository
public class ArticleEnDao extends DAOImpl<ArticleEnRecord, cn.edu.kmust.flst.domain.tables.pojos.ArticleEn, Integer> {

    /**
     * Create a new ArticleEnDao without any configuration
     */
    public ArticleEnDao() {
        super(ArticleEn.ARTICLE_EN, cn.edu.kmust.flst.domain.tables.pojos.ArticleEn.class);
    }

    /**
     * Create a new ArticleEnDao with an attached configuration
     */
    @Autowired
    public ArticleEnDao(Configuration configuration) {
        super(ArticleEn.ARTICLE_EN, cn.edu.kmust.flst.domain.tables.pojos.ArticleEn.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(cn.edu.kmust.flst.domain.tables.pojos.ArticleEn object) {
        return object.getArticleId();
    }

    /**
     * Fetch records that have <code>article_id IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleId(Integer... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>article_id = value</code>
     */
    public cn.edu.kmust.flst.domain.tables.pojos.ArticleEn fetchOneByArticleId(Integer value) {
        return fetchOne(ArticleEn.ARTICLE_EN.ARTICLE_ID, value);
    }

    /**
     * Fetch records that have <code>article_title IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleTitle(String... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_TITLE, values);
    }

    /**
     * Fetch records that have <code>article_brief IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleBrief(String... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_BRIEF, values);
    }

    /**
     * Fetch records that have <code>article_cover IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleCover(String... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_COVER, values);
    }

    /**
     * Fetch records that have <code>article_content IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleContent(String... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_CONTENT, values);
    }

    /**
     * Fetch records that have <code>article_date IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleDate(Timestamp... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_DATE, values);
    }

    /**
     * Fetch records that have <code>article_clicks IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleClicks(Integer... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_CLICKS, values);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByUsername(String... values) {
        return fetch(ArticleEn.ARTICLE_EN.USERNAME, values);
    }

    /**
     * Fetch records that have <code>article_sources IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleSources(Integer... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_SOURCES, values);
    }

    /**
     * Fetch records that have <code>article_sources_name IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleSourcesName(String... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_SOURCES_NAME, values);
    }

    /**
     * Fetch records that have <code>article_sources_link IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.ArticleEn> fetchByArticleSourcesLink(String... values) {
        return fetch(ArticleEn.ARTICLE_EN.ARTICLE_SOURCES_LINK, values);
    }
}