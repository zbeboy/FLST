package cn.edu.kmust.flst.service.backstage.menus

import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.domain.tables.records.MenusRecord
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.Record
import org.jooq.Record8
import org.jooq.Record9
import org.jooq.Result

/**
 * Created by zbeboy 2018-04-11 .
 **/
interface MenusService {

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return 数据
     */
    fun findById(id: String): Menus

    /**
     * 查询全部
     */
    fun findAll():List<Menus>

    /**
     * 通过pid查询
     *
     * @param pid 父Id
     * @param menuShow 是否显示
     * @param menuFixed 是否是固定模块
     * @return 数据
     */
    fun findByPIdAndMenuShowAndMenuFixed(pid: String, menuShow: Byte, menuFixed: Byte): Result<MenusRecord>

    /**
     * 通过pid查询
     *
     * @param pid 父Id
     * @param menuShow 是否显示
     * @return 数据
     */
    fun findByPIdAndMenuShow(pid: String, menuShow: Byte): Result<MenusRecord>

    /**
     * 分页查询
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 分页数据
     */
    fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Result<Record9<String, String, String, String, Byte, String, Int, Byte, Byte>>

    /**
     * 根据条件查询总数
     *
     * @return 条件查询总数
     */
    fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Int

    /**
     * 通过栏目中文名查找
     *
     * @param menuName 栏目中文名
     * @return 数据
     */
    fun findByMenuName(menuName: String): List<Menus>

    /**
     * 通过栏目英文名查找
     *
     * @param menuNameEn 栏目英文名
     * @return 数据
     */
    fun findByMenuNameEn(menuNameEn: String): List<Menus>

    /**
     * 通过栏目中文名查找 注:不等于id
     *
     * @param menuName 栏目中文名
     * @param menuId 栏目id
     * @return 数据
     */
    fun findByMenuNameNeMenuId(menuName: String, menuId: String): Result<Record>

    /**
     * 通过栏目英文名查找 注:不等于id
     *
     * @param menuNameEn 栏目英文名
     * @param menuId 栏目id
     * @return 数据
     */
    fun findByMenuNameEnNeMenuId(menuNameEn: String, menuId: String): Result<Record>

    /**
     * 通过栏目状态查找
     *
     * @param menuFixed 栏目状态
     * @return 数据
     */
    fun findByMenuFixed(menuFixed: Byte): List<Menus>

    /**
     * 保存
     *
     * @param menus 数据
     */
    fun save(menus: Menus)

    /**
     * 更新
     *
     * @param menus 数据
     */
    fun update(menus: Menus)
}