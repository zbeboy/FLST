package cn.edu.kmust.flst.service.backstage.links

import cn.edu.kmust.flst.domain.Tables.FRIENDLY_LINK
import cn.edu.kmust.flst.service.plugin.BootstrapTablesPlugin
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import cn.edu.kmust.flst.web.bean.backstage.links.LinksBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils

/**
 * Created by zbeboy 2018-04-16 .
 **/
@Service("linksService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class LinksServiceImpl @Autowired constructor(dslContext: DSLContext) : BootstrapTablesPlugin<LinksBean>(), LinksService {

    private val create: DSLContext = dslContext

    override fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<LinksBean>): Result<Record> {
        return dataPagingQueryAll(bootstrapTableUtils, create, FRIENDLY_LINK)
    }

    override fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<LinksBean>): Int {
        return statisticsWithCondition(bootstrapTableUtils, create, FRIENDLY_LINK)
    }

    /**
     * 全局搜索条件
     *
     * @param bootstrapTableUtils datatables工具类
     * @return 搜索条件
     */
    override fun searchCondition(bootstrapTableUtils: BootstrapTableUtils<LinksBean>): Condition? {
        var a: Condition? = null
        val search = bootstrapTableUtils.search
        if (!ObjectUtils.isEmpty(search)) {
            val linkName = StringUtils.trimWhitespace(search!!.getString("linkName"))
            val linkNameEn = StringUtils.trimWhitespace(search.getString("linkNameEn"))
            if (StringUtils.hasLength(linkName)) {
                a = FRIENDLY_LINK.LINK_NAME.like(SQLQueryUtils.likeAllParam(linkName))
            }

            if (StringUtils.hasLength(linkNameEn)) {
                a = if (ObjectUtils.isEmpty(a)) {
                    FRIENDLY_LINK.LINK_NAME_EN.like(SQLQueryUtils.likeAllParam(linkNameEn))
                } else {
                    a!!.and(FRIENDLY_LINK.LINK_NAME_EN.like(SQLQueryUtils.likeAllParam(linkNameEn)))
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
    override fun sortCondition(bootstrapTableUtils: BootstrapTableUtils<LinksBean>, selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int) {
        val orderColumnName = bootstrapTableUtils.sortName
        val orderDir = bootstrapTableUtils.sortOrder
        val isAsc = "asc".equals(orderDir, ignoreCase = true)
        var sortField: Array<SortField<*>?>? = null
        if (StringUtils.hasLength(orderColumnName)) {
            if ("linkName".equals(orderColumnName!!, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = FRIENDLY_LINK.LINK_NAME.asc()
                } else {
                    sortField[0] = FRIENDLY_LINK.LINK_NAME.desc()
                }
            }

            if ("linkNameEn".equals(orderColumnName, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = FRIENDLY_LINK.LINK_NAME_EN.asc()
                } else {
                    sortField[0] = FRIENDLY_LINK.LINK_NAME_EN.desc()
                }
            }
        }
        sortToFinish(selectConditionStep, selectJoinStep, type, *sortField!!)
    }
}