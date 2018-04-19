package cn.edu.kmust.flst.service.backstage.banner

import cn.edu.kmust.flst.domain.Tables.BANNER
import cn.edu.kmust.flst.domain.Tables.MENUS
import cn.edu.kmust.flst.domain.tables.daos.BannerDao
import cn.edu.kmust.flst.domain.tables.pojos.Banner
import cn.edu.kmust.flst.domain.tables.records.BannerRecord
import cn.edu.kmust.flst.service.plugin.BootstrapTablesPlugin
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
 * Created by zbeboy 2018-04-14 .
 **/
@Service("bannerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class BannerServiceImpl @Autowired constructor(dslContext: DSLContext) : BootstrapTablesPlugin<MenusBean>(), BannerService {

    private val create: DSLContext = dslContext

    @Resource
    open lateinit var bannerDao: BannerDao

    override fun findById(id: Int): Banner {
        return bannerDao.findById(id)
    }

    override fun findByMenuId(menuId: String): Result<BannerRecord> {
        return create.selectFrom(BANNER)
                .where(BANNER.MENU_ID.eq(menuId))
                .orderBy(BANNER.BANNER_DATE.desc())
                .fetch()
    }

    override fun findByMenuIdAndBannerShow(menuId: String, bannerShow: Byte): Result<BannerRecord> {
        return create.selectFrom(BANNER)
                .where(BANNER.MENU_ID.eq(menuId).and(BANNER.BANNER_SHOW.eq(bannerShow)))
                .orderBy(BANNER.BANNER_DATE.desc())
                .fetch()
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun save(banner: Banner) {
        bannerDao.insert(banner)
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun saveAndReturnId(banner: Banner): Int {
        val record = create.insertInto(BANNER, BANNER.BANNER_LINK, BANNER.BANNER_DATE, BANNER.BANNER_SHOW, BANNER.MENU_ID, BANNER.USERNAME)
                .values(banner.bannerLink, banner.bannerDate, banner.bannerShow, banner.menuId, banner.username)
                .returning(BANNER.BANNER_ID)
                .fetchOne()
        return record.getValue(BANNER.BANNER_ID)
    }

    override fun update(banner: Banner) {
        bannerDao.update(banner)
    }

    override fun deleteById(id: Int) {
        bannerDao.deleteById(id)
    }

    override fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Result<Record> {
        return dataPagingQueryAllWithCondition(bootstrapTableUtils, create, MENUS, MENUS.MENU_PID.eq("0"))
    }

    override fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Int {
        return statisticsWithCondition(bootstrapTableUtils, create, MENUS, MENUS.MENU_PID.eq("0"))
    }

    /**
     * 全局搜索条件
     *
     * @param bootstrapTableUtils datatables工具类
     * @return 搜索条件
     */
    override fun searchCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Condition? {
        var a: Condition? = null
        val search = bootstrapTableUtils.search
        if (!ObjectUtils.isEmpty(search)) {
            val menuName = StringUtils.trimWhitespace(search!!.getString("menuName"))
            val menuNameEn = StringUtils.trimWhitespace(search.getString("menuNameEn"))
            if (StringUtils.hasLength(menuName)) {
                a = MENUS.MENU_NAME.like(SQLQueryUtils.likeAllParam(menuName))
            }

            if (StringUtils.hasLength(menuNameEn)) {
                a = if (ObjectUtils.isEmpty(a)) {
                    MENUS.MENU_NAME_EN.like(SQLQueryUtils.likeAllParam(menuNameEn))
                } else {
                    a!!.and(MENUS.MENU_NAME_EN.like(SQLQueryUtils.likeAllParam(menuNameEn)))
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
    override fun sortCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>, selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int) {
        val orderColumnName = bootstrapTableUtils.sortName
        val orderDir = bootstrapTableUtils.sortOrder
        val isAsc = "asc".equals(orderDir, ignoreCase = true)
        var sortField: Array<SortField<*>?>? = null
        if (StringUtils.hasLength(orderColumnName)) {
            if ("menuName".equals(orderColumnName!!, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = MENUS.MENU_NAME.asc()
                } else {
                    sortField[0] = MENUS.MENU_NAME.desc()
                }
            }

            if ("menuNameEn".equals(orderColumnName, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = MENUS.MENU_NAME_EN.asc()
                } else {
                    sortField[0] = MENUS.MENU_NAME_EN.desc()
                }
            }
        }
        sortToFinish(selectConditionStep, selectJoinStep, type, *sortField!!)
    }
}