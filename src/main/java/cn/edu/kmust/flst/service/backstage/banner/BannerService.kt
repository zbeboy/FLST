package cn.edu.kmust.flst.service.backstage.banner

import cn.edu.kmust.flst.domain.flst.tables.pojos.Banner
import cn.edu.kmust.flst.domain.flst.tables.records.BannerRecord
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.Record
import org.jooq.Result

/**
 * Created by zbeboy 2018-04-14 .
 **/
interface BannerService {

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return 数据
     */
    fun findById(id: Int): Banner

    /**
     * 通过栏目id查询
     *
     * @param menuId 栏目id
     * @return 数据
     */
    fun findByMenuId(menuId: String): Result<BannerRecord>

    /**
     * 通过栏目id查询
     *
     * @param menuId 栏目id
     * @param bannerShow 是否显示
     * @return 数据
     */
    fun findByMenuIdAndBannerShow(menuId: String, bannerShow: Boolean): Result<BannerRecord>

    /**
     * 分页查询
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 分页数据
     */
    fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Result<Record>

    /**
     * 根据条件查询总数
     *
     * @return 条件查询总数
     */
    fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Int

    /**
     * 保存
     *
     * @param banner 数据
     */
    fun save(banner: Banner)

    /**
     * 保存
     *
     * @param banner 数据
     */
    fun saveAndReturnId(banner: Banner): Int

    /**
     * 更新
     *
     * @param banner 数据
     */
    fun update(banner: Banner)

    /**
     * 通过主键删除
     *
     * @param id 主键
     */
    fun deleteById(id: Int)
}