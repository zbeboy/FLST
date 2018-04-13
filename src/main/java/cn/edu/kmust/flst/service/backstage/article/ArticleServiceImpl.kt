package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.Tables.ARTICLE
import cn.edu.kmust.flst.service.plugin.BootstrapTablesPlugin
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils

/**
 * Created by zbeboy 2018-04-13 .
 **/
@Service("articleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class ArticleServiceImpl @Autowired constructor(dslContext: DSLContext) : BootstrapTablesPlugin<ArticleBean>(), ArticleService {

    private val create: DSLContext = dslContext

    override fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<ArticleBean>): Result<Record> {
        return dataPagingQueryAll(bootstrapTableUtils, create, ARTICLE)
    }

    override fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<ArticleBean>): Int {
        return statisticsWithCondition(bootstrapTableUtils, create, ARTICLE)
    }

    /**
     * 全局搜索条件
     *
     * @param bootstrapTableUtils datatables工具类
     * @return 搜索条件
     */
    override fun searchCondition(bootstrapTableUtils: BootstrapTableUtils<ArticleBean>): Condition? {
        var a: Condition? = null
        val search = bootstrapTableUtils.search
        if (!ObjectUtils.isEmpty(search)) {
            val articleTitle = StringUtils.trimWhitespace(search!!.getString("articleTitle"))
            if (StringUtils.hasLength(articleTitle)) {
                a = ARTICLE.ARTICLE_TITLE.like(SQLQueryUtils.likeAllParam(articleTitle))
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
    override fun sortCondition(bootstrapTableUtils: BootstrapTableUtils<ArticleBean>, selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int) {
        val orderColumnName = bootstrapTableUtils.sortName
        val orderDir = bootstrapTableUtils.sortOrder
        val isAsc = "asc".equals(orderDir, ignoreCase = true)
        var sortField: Array<SortField<*>?>? = null
        if (StringUtils.hasLength(orderColumnName)) {
            if ("articleDateStr".equals(orderColumnName!!, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = ARTICLE.ARTICLE_DATE.asc()
                } else {
                    sortField[0] = ARTICLE.ARTICLE_DATE.desc()
                }
            }
        }
        sortToFinish(selectConditionStep, selectJoinStep, type, *sortField!!)
    }
}