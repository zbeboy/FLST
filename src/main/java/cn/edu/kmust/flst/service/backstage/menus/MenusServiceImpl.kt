package cn.edu.kmust.flst.service.backstage.menus

import cn.edu.kmust.flst.domain.flst.Tables.MENUS
import cn.edu.kmust.flst.domain.flst.tables.daos.MenusDao
import cn.edu.kmust.flst.domain.flst.tables.pojos.Menus
import cn.edu.kmust.flst.domain.flst.tables.records.MenusRecord
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
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

    override fun findById(id: String): Menus {
        return menusDao.findById(id)
    }

    override fun findAll(): List<Menus> {
        return menusDao.findAll()
    }

    override fun findByPIdAndMenuShowAndMenuFixed(pid: String, menuShow: Boolean, menuFixed: Boolean): Result<MenusRecord> {
        return create.selectFrom(MENUS)
                .where(MENUS.MENU_PID.eq(pid).and(MENUS.MENU_SHOW.eq(menuShow)).and(MENUS.MENU_FIXED.eq(menuFixed)))
                .orderBy(MENUS.MENU_ORDER)
                .fetch()
    }

    override fun findByPIdAndMenuShow(pid: String, menuShow: Boolean): Result<MenusRecord> {
        return create.selectFrom(MENUS)
                .where(MENUS.MENU_PID.eq(pid).and(MENUS.MENU_SHOW.eq(menuShow)))
                .orderBy(MENUS.MENU_ORDER)
                .fetch()
    }

    override fun findByMenuName(menuName: String): List<Menus> {
        return menusDao.fetchByMenuName(menuName)
    }

    override fun findByMenuNameEn(menuNameEn: String): List<Menus> {
        return menusDao.fetchByMenuNameEn(menuNameEn)
    }

    override fun findByMenuNameNeMenuId(menuName: String, menuId: String): Result<Record> {
        return create.select()
                .from(MENUS)
                .where(MENUS.MENU_NAME.eq(menuName).and(MENUS.MENU_ID.ne(menuId)))
                .fetch()
    }

    override fun findByMenuNameEnNeMenuId(menuNameEn: String, menuId: String): Result<Record> {
        return create.select()
                .from(MENUS)
                .where(MENUS.MENU_NAME_EN.eq(menuNameEn).and(MENUS.MENU_ID.ne(menuId)))
                .fetch()
    }

    override fun findByMenuFixed(menuFixed: Boolean): List<Menus> {
        return menusDao.fetchByMenuFixed(menuFixed)
    }

    @CacheEvict(cacheNames = ["nav"], allEntries = true)
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun save(menus: Menus) {
        menusDao.insert(menus)
    }

    @CacheEvict(cacheNames = ["nav"], allEntries = true)
    override fun update(menus: Menus) {
        menusDao.update(menus)
    }

    override fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Result<Record11<String, String, String, String, String, Boolean, String, Int, Boolean, Boolean, Int>> {
        val a = searchCondition(bootstrapTableUtils)
        val selectOnConditionStep = if (ObjectUtils.isEmpty(a)) {
            create.select(
                    MENUS.`as`("M").MENU_ID,
                    MENUS.`as`("M").MENU_NAME,
                    MENUS.`as`("M").MENU_NAME_EN,
                    MENUS.`as`("M").MENU_LINK,
                    MENUS.`as`("M").MENU_PID,
                    MENUS.`as`("M").OUT_LINK,
                    MENUS.`as`("N").MENU_NAME.`as`("menuPidName"),
                    MENUS.`as`("M").MENU_ORDER,
                    MENUS.`as`("M").MENU_SHOW,
                    MENUS.`as`("M").SHOW_ARTICLE,
                    MENUS.`as`("M").ORDER_WAY
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
                    MENUS.`as`("M").MENU_PID,
                    MENUS.`as`("M").OUT_LINK,
                    MENUS.`as`("N").MENU_NAME.`as`("menuPidName"),
                    MENUS.`as`("M").MENU_ORDER,
                    MENUS.`as`("M").MENU_SHOW,
                    MENUS.`as`("M").SHOW_ARTICLE,
                    MENUS.`as`("M").ORDER_WAY
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

        bootstrapTableUtils.pageNumber = if (bootstrapTableUtils.pageNumber <= 0) 1 else bootstrapTableUtils.pageNumber
        val length = bootstrapTableUtils.pageSize
        val start = (bootstrapTableUtils.pageNumber - 1) * length
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
                    if (menuPidName == "无") {
                        MENUS.`as`("M").MENU_PID.eq("0")
                    } else {
                        MENUS.`as`("N").MENU_NAME.like(SQLQueryUtils.likeAllParam(menuPidName))
                    }
                } else {
                    if (menuPidName == "无") {
                        a!!.and(MENUS.`as`("M").MENU_PID.eq("0"))
                    } else {
                        a!!.and(MENUS.`as`("N").MENU_NAME.like(SQLQueryUtils.likeAllParam(menuPidName)))
                    }
                }
            }

        }
        return a
    }

    /**
     * 应用数据排序
     *
     * @param bootstrapTableUtils bootstrapTable工具类
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