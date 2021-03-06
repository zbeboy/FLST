package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.flst.Tables.*
import cn.edu.kmust.flst.domain.flst.tables.daos.ArticleEnDao
import cn.edu.kmust.flst.domain.flst.tables.pojos.ArticleEn
import cn.edu.kmust.flst.service.plugin.BootstrapTablesPlugin
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.bean.reception.SorterBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import java.sql.Timestamp
import java.util.*
import javax.annotation.Resource

/**
 * Created by zbeboy 2018-04-14 .
 **/
@Service("articleEnService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class ArticleEnServiceImpl @Autowired constructor(dslContext: DSLContext) : BootstrapTablesPlugin<ArticleEnBean>(), ArticleEnService {

    private val create: DSLContext = dslContext

    @Resource
    open lateinit var articleEnDao: ArticleEnDao

    override fun findById(id: Int): ArticleEn {
        return articleEnDao.findById(id)
    }

    override fun findByIdRelation(id: Int): Optional<Record> {
        return create.select()
                .from(ARTICLE_EN)
                .join(ARTICLE_EN_CONTENT)
                .on(ARTICLE_EN.ARTICLE_ID.eq(ARTICLE_EN_CONTENT.ID))
                .where(ARTICLE_EN.ARTICLE_ID.eq(id))
                .fetchOptional()
    }

    @Cacheable(cacheNames = ["article_en"], key = "#id")
    override fun findByIdAndCache(id: Int): Optional<Record> {
        return create.select()
                .from(ARTICLE_EN)
                .join(ARTICLE_EN_CONTENT)
                .on(ARTICLE_EN.ARTICLE_ID.eq(ARTICLE_EN_CONTENT.ID))
                .where(ARTICLE_EN.ARTICLE_ID.eq(id))
                .fetchOptional()
    }

    override fun findOneGTArticleDateByPage(articleDate: Timestamp, menuId: String, sorterBean: SorterBean): Optional<Record> {
        val condition = create.select()
                .from(ARTICLE_EN)
                .where(ARTICLE_EN.ARTICLE_DATE.greaterThan(articleDate).and(ARTICLE_EN.MENU_ID.eq(menuId)))
        sorter(condition, sorterBean)
        return condition.limit(0, 1).fetchOptional()
    }

    override fun findOneLTArticleDateByPage(articleDate: Timestamp, menuId: String, sorterBean: SorterBean): Optional<Record> {
        val condition = create.select()
                .from(ARTICLE_EN)
                .where(ARTICLE_EN.ARTICLE_DATE.lessThan(articleDate).and(ARTICLE_EN.MENU_ID.eq(menuId)))
        sorter(condition, sorterBean)
        return condition.limit(0, 1).fetchOptional()
    }

    @Cacheable(cacheNames = ["article_en"], key = "#menuId")
    override fun findOneByPageOrderByArticleDate(menuId: String, sorterBean: SorterBean): Optional<Record> {
        val condition = create.select()
                .from(ARTICLE_EN)
                .join(ARTICLE_EN_CONTENT)
                .on(ARTICLE_EN.ARTICLE_ID.eq(ARTICLE_EN_CONTENT.ID))
                .where(ARTICLE_EN.MENU_ID.eq(menuId))
        sorter(condition, sorterBean)
        return condition.limit(0, 1).fetchOptional()
    }

    override fun findOneGTArticleSnByPage(articleSn: Int, menuId: String, sorterBean: SorterBean): Optional<Record> {
        val condition = create.select()
                .from(ARTICLE_EN)
                .where(ARTICLE_EN.ARTICLE_SN.greaterThan(articleSn).and(ARTICLE_EN.MENU_ID.eq(menuId)))
        sorter(condition, sorterBean)
        return condition.limit(0, 1).fetchOptional()
    }

    override fun findOneLTArticleSnByPage(articleSn: Int, menuId: String, sorterBean: SorterBean): Optional<Record> {
        val condition = create.select()
                .from(ARTICLE_EN)
                .where(ARTICLE_EN.ARTICLE_SN.lessThan(articleSn).and(ARTICLE_EN.MENU_ID.eq(menuId)))
        sorter(condition, sorterBean)
        return condition.limit(0, 1).fetchOptional()
    }

    override fun findOneByPageOrderByArticleSn(menuId: String, sorterBean: SorterBean): Optional<Record> {
        val condition = create.select()
                .from(ARTICLE_EN)
                .join(ARTICLE_EN_CONTENT)
                .on(ARTICLE_EN.ARTICLE_ID.eq(ARTICLE_EN_CONTENT.ID))
                .where(ARTICLE_EN.MENU_ID.eq(menuId))
        sorter(condition, sorterBean)
        return condition.limit(0, 1).fetchOptional()
    }

    override fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<ArticleEnBean>): Result<Record> {
        val a = searchCondition(bootstrapTableUtils)
        return if (ObjectUtils.isEmpty(a)) {
            val selectJoinStep = create.select()
                    .from(ARTICLE_EN)
                    .join(MENUS)
                    .on(ARTICLE_EN.MENU_ID.eq(MENUS.MENU_ID))
            sortCondition(bootstrapTableUtils, null, selectJoinStep, JOIN_TYPE)
            pagination(bootstrapTableUtils, null, selectJoinStep, JOIN_TYPE)
            selectJoinStep.fetch()
        } else {
            val selectConditionStep = create.select()
                    .from(ARTICLE_EN)
                    .join(MENUS)
                    .on(ARTICLE_EN.MENU_ID.eq(MENUS.MENU_ID))
                    .where(a)
            sortCondition(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            pagination(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            selectConditionStep.fetch()
        }
    }

    override fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<ArticleEnBean>): Int {
        val count: Record1<Int>
        val a = searchCondition(bootstrapTableUtils)
        count = if (ObjectUtils.isEmpty(a)) {
            val selectJoinStep = create.selectCount()
                    .from(ARTICLE_EN)
                    .join(MENUS)
                    .on(ARTICLE_EN.MENU_ID.eq(MENUS.MENU_ID))
            selectJoinStep.fetchOne()
        } else {
            val selectConditionStep = create.selectCount()
                    .from(ARTICLE_EN)
                    .join(MENUS)
                    .on(ARTICLE_EN.MENU_ID.eq(MENUS.MENU_ID))
                    .where(a)
            selectConditionStep.fetchOne()
        }
        return count.value1()
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun saveAndReturnId(article: ArticleEn): Int {
        return create.insertInto(ARTICLE_EN, ARTICLE_EN.ARTICLE_TITLE, ARTICLE_EN.ARTICLE_BRIEF, ARTICLE_EN.ARTICLE_COVER, ARTICLE_EN.ARTICLE_DATE,
                ARTICLE_EN.ARTICLE_CLICKS, ARTICLE_EN.ARTICLE_AUTHOR, ARTICLE_EN.ARTICLE_SOURCES, ARTICLE_EN.ARTICLE_SOURCES_NAME, ARTICLE_EN.ARTICLE_SOURCES_LINK,
                ARTICLE_EN.ARTICLE_SN, ARTICLE_EN.MENU_ID)
                .values(article.articleTitle, article.articleBrief, article.articleCover, article.articleDate, article.articleClicks,
                        article.articleAuthor, article.articleSources, article.articleSourcesName, article.articleSourcesLink, article.articleSn, article.menuId)
                .returning(ARTICLE_EN.ARTICLE_ID)
                .fetchOne().getValue(ARTICLE_EN.ARTICLE_ID)
    }

    @CacheEvict(cacheNames = ["article_en"], key = "#article.articleId", allEntries = true)
    override fun update(article: ArticleEn) {
        articleEnDao.update(article)
    }

    override fun updateClicks(articleId: Int) {
        create.update(ARTICLE_EN).set(ARTICLE_EN.ARTICLE_CLICKS, ARTICLE_EN.ARTICLE_CLICKS + 1)
                .where(ARTICLE_EN.ARTICLE_ID.eq(articleId))
                .execute()
    }

    @CacheEvict(cacheNames = ["article_en"], key = "#id", allEntries = true)
    override fun deleteById(id: Int) {
        articleEnDao.deleteById(id)
    }

    /**
     * 全局搜索条件
     *
     * @param bootstrapTableUtils datatables工具类
     * @return 搜索条件
     */
    override fun searchCondition(bootstrapTableUtils: BootstrapTableUtils<ArticleEnBean>): Condition? {
        var a: Condition? = null
        val search = bootstrapTableUtils.search
        if (!ObjectUtils.isEmpty(search)) {
            val articleTitle = StringUtils.trimWhitespace(search!!.getString("articleTitle"))
            val menuName = StringUtils.trimWhitespace(search.getString("menuName"))
            val menuId = StringUtils.trimWhitespace(search.getString("menuId"))
            if (StringUtils.hasLength(articleTitle)) {
                a = ARTICLE_EN.ARTICLE_TITLE.like(SQLQueryUtils.likeAllParam(articleTitle))
            }

            if (StringUtils.hasLength(menuName)) {
                a = if (ObjectUtils.isEmpty(a)) {
                    MENUS.MENU_NAME.like(SQLQueryUtils.likeAllParam(menuName))
                } else {
                    a!!.and(MENUS.MENU_NAME.like(SQLQueryUtils.likeAllParam(menuName)))
                }
            }

            if (StringUtils.hasLength(menuId)) {
                a = if (ObjectUtils.isEmpty(a)) {
                    MENUS.MENU_ID.eq(menuId)
                } else {
                    a!!.and(MENUS.MENU_ID.eq(menuId))
                }
            }
        }
        return a
    }

    /**
     * 数据排序
     *
     * @param bootstrapTableUtils     datatables工具类
     * @param selectConditionStep 条件
     */
    override fun sortCondition(bootstrapTableUtils: BootstrapTableUtils<ArticleEnBean>, selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int) {
        val orderColumnName = if (StringUtils.hasLength(bootstrapTableUtils.sortName)) bootstrapTableUtils.sortName else "articleDateStr"
        val orderDir = bootstrapTableUtils.sortOrder
        val isAsc = "asc".equals(orderDir, ignoreCase = true)
        var sortField: Array<SortField<*>?>? = null
        if ("articleDateStr".equals(orderColumnName!!, ignoreCase = true)) {
            sortField = arrayOfNulls(1)
            if (isAsc) {
                sortField[0] = ARTICLE_EN.ARTICLE_DATE.asc()
            } else {
                sortField[0] = ARTICLE_EN.ARTICLE_DATE.desc()
            }
        }

        if ("articleSn".equals(orderColumnName, ignoreCase = true)) {
            sortField = arrayOfNulls(1)
            if (isAsc) {
                sortField[0] = ARTICLE_EN.ARTICLE_SN.asc()
            } else {
                sortField[0] = ARTICLE_EN.ARTICLE_SN.desc()
            }
        }
        if(!ObjectUtils.isEmpty(sortField)){
            sortToFinish(selectConditionStep, selectJoinStep, type, *sortField!!)
        }
    }

    private fun sorter(condition: SelectConditionStep<Record>, sorterBean: SorterBean) {
        if (sorterBean.sortName == "articleDateStr") {
            if (sorterBean.sortOrder == "desc") {
                condition.orderBy(ARTICLE_EN.ARTICLE_DATE.desc())
            } else if (sorterBean.sortOrder == "asc") {
                condition.orderBy(ARTICLE_EN.ARTICLE_DATE.asc())
            }
        }

        if (sorterBean.sortName == "articleSn") {
            if (sorterBean.sortOrder == "desc") {
                condition.orderBy(ARTICLE_EN.ARTICLE_SN.desc())
            } else if (sorterBean.sortOrder == "asc") {
                condition.orderBy(ARTICLE_EN.ARTICLE_SN.asc())
            }
        }
    }
}