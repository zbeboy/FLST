package cn.edu.kmust.flst.service.backstage.menus

import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.Record8
import org.jooq.Result

/**
 * Created by zbeboy 2018-04-11 .
 **/
interface MenusService {
    /**
     * 分页查询
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 分页数据
     */
    fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Result<Record8<String, String, String, String, String, String, Int, Byte>>

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
    fun save(menus: Menus);
}