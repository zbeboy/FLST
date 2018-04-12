package cn.edu.kmust.flst.service.backstage.menus

import cn.edu.kmust.flst.domain.Tables.MENUS
import cn.edu.kmust.flst.domain.tables.daos.MenusDao
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
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
 * Created by zbeboy 2018-04-11 .
 **/
@Service("menusService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class MenusServiceImpl @Autowired constructor(dslContext: DSLContext) : MenusService {

    private val create: DSLContext = dslContext

    @Resource
    open lateinit var menusDao: MenusDao

    override fun findByMenuName(menuName: String): List<Menus> {
        return menusDao.fetchByMenuName(menuName)
    }

    override fun findByMenuNameEn(menuNameEn: String): List<Menus> {
        return menusDao.fetchByMenuNameEn(menuNameEn)
    }

    override fun findByMenuFixed(menuFixed: Byte): List<Menus> {
        return menusDao.fetchByMenuFixed(menuFixed)
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun save(menus: Menus) {
        menusDao.insert(menus)
    }

    override fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Result<Record8<String, String, String, String, String, String, Int, Byte>> {
        val a = searchCondition(bootstrapTableUtils)
        val selectOnConditionStep = if (ObjectUtils.isEmpty(a)) {
            create.select(
                    MENUS.`as`("M").MENU_ID,
                    MENUS.`as`("M").MENU_NAME,
                    MENUS.`as`("M").MENU_NAME_EN,
                    MENUS.`as`("M").MENU_LINK,
                    MENUS.`as`("M").MENU_LINK_EN,
                    MENUS.`as`("N").MENU_NAME.`as`("menuPidName"),
                    MENUS.`as`("M").MENU_ORDER,
                    MENUS.`as`("M").MENU_SHOW
            )
                    .from(MENUS.`as`("M"))
                    .leftJoin(MENUS.`as`("N"))
                    .on(MENUS.`as`("M").field(MENUS.MENU_PID).eq(MENUS.`as`("N").field(MENUS.MENU_ID)))
        } else {
            create.select(
                    MENUS.`as`("M").MENU_ID,
                    MENUS.`as`("M").MENU_NAME,
                    MENUS.`as`("M").MENU_NAME_EN,
                    MENUS.`as`("M").MENU_LINK,
                    MENUS.`as`("M").MENU_LINK_EN,
                    MENUS.`as`("N").MENU_NAME.`as`("menuPidName"),
                    MENUS.`as`("M").MENU_ORDER,
                    MENUS.`as`("M").MENU_SHOW
            )
                    .from(MENUS.`as`("M"))
                    .leftJoin(MENUS.`as`("N"))
                    .on(MENUS.`as`("M").field(MENUS.MENU_PID).eq(MENUS.`as`("N").field(MENUS.MENU_ID)))
                    .where(a)
        }

        val sortField = sortCondition(bootstrapTableUtils)
        if (!ObjectUtils.isEmpty(sortField)) {
            selectOnConditionStep.orderBy(*sortField!!)
        }
        val start = bootstrapTableUtils.pageNumber - 1
        val length = bootstrapTableUtils.pageSize
        return selectOnConditionStep.limit(start, length).fetch()
    }


    override fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Int {
        val count: Record1<Int>
        val a = searchCondition(bootstrapTableUtils)
        count = if (ObjectUtils.isEmpty(a)) {
            val selectJoinStep = create.selectCount()
                    .from(MENUS.`as`("M"))
                    .leftJoin(MENUS.`as`("N"))
                    .on(MENUS.`as`("M").field(MENUS.MENU_PID).eq(MENUS.`as`("N").field(MENUS.MENU_ID)))
            selectJoinStep.fetchOne()
        } else {
            val selectConditionStep = create.selectCount()
                    .from(MENUS.`as`("M"))
                    .leftJoin(MENUS.`as`("N"))
                    .on(MENUS.`as`("M").field(MENUS.MENU_PID).eq(MENUS.`as`("N").field(MENUS.MENU_ID)))
                    .where(a)
            selectConditionStep.fetchOne()
        }
        return count.value1()
    }

    /**
     * 应用数据全局搜索条件
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 搜索条件
     */
    fun searchCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Condition? {
        var a: Condition? = null

        val search = bootstrapTableUtils.search
        if (!ObjectUtils.isEmpty(search)) {
            val menuName = StringUtils.trimWhitespace(search!!.getString("menuName"))
            val menuNameEn = StringUtils.trimWhitespace(search.getString("menuNameEn"))
            val menuPidName = StringUtils.trimWhitespace(search.getString("menuPidName"))
            if (StringUtils.hasLength(menuName)) {
                a = MENUS.`as`("M").MENU_NAME.like(SQLQueryUtils.likeAllParam(menuName))
            }

            if (StringUtils.hasLength(menuNameEn)) {
                a = if (ObjectUtils.isEmpty(a)) {
                    MENUS.`as`("M").MENU_NAME_EN.like(SQLQueryUtils.likeAllParam(menuNameEn))
                } else {
                    a!!.and(MENUS.`as`("M").MENU_NAME_EN.like(SQLQueryUtils.likeAllParam(menuNameEn)))
                }
            }

            if (StringUtils.hasLength(menuPidName)) {
                a = if (ObjectUtils.isEmpty(a)) {
                    MENUS.`as`("N").MENU_NAME_EN.like(SQLQueryUtils.likeAllParam(menuPidName))
                } else {
                    a!!.and(MENUS.`as`("N").MENU_NAME_EN.like(SQLQueryUtils.likeAllParam(menuPidName)))
                }
            }

        }
        return a
    }

    /**
     * 应用数据排序
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param selectConditionStep 条件
     */
    private fun sortCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Array<SortField<*>?>? {
        val orderColumnName = bootstrapTableUtils.sortName
        val orderDir = bootstrapTableUtils.sortOrder
        val isAsc = "asc".equals(orderDir, ignoreCase = true)
        var sortField: Array<SortField<*>?>? = null
        if (StringUtils.hasLength(orderColumnName)) {
            if ("menuName".equals(orderColumnName, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = MENUS.`as`("M").MENU_NAME.asc()
                } else {
                    sortField[0] = MENUS.`as`("M").MENU_NAME.desc()
                }
            }

            if ("menuNameEn".equals(orderColumnName, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = MENUS.`as`("M").MENU_NAME_EN.asc()
                } else {
                    sortField[0] = MENUS.`as`("M").MENU_NAME_EN.desc()
                }
            }
        }

        return sortField
    }
}