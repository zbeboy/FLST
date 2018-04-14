package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.Tables.ARTICLE_EN
import cn.edu.kmust.flst.domain.Tables.MENUS
import cn.edu.kmust.flst.domain.tables.daos.ArticleEnDao
import cn.edu.kmust.flst.domain.tables.pojos.ArticleEn
import cn.edu.kmust.flst.service.plugin.BootstrapTablesPlugin
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
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
    override fun save(article: ArticleEn) {
        articleEnDao.insert(article)
    }

    override fun update(article: ArticleEn) {
        articleEnDao.update(article)
    }

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
        val orderColumnName = bootstrapTableUtils.sortName
        val orderDir = bootstrapTableUtils.sortOrder
        val isAsc = "asc".equals(orderDir, ignoreCase = true)
        var sortField: Array<SortField<*>?>? = null
        if (StringUtils.hasLength(orderColumnName)) {
            if ("articleDateStr".equals(orderColumnName!!, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = ARTICLE_EN.ARTICLE_DATE.asc()
                } else {
                    sortField[0] = ARTICLE_EN.ARTICLE_DATE.desc()
                }
            }
        }
        sortToFinish(selectConditionStep, selectJoinStep, type, *sortField!!)
    }
}