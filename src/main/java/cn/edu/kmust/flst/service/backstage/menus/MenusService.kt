package cn.edu.kmust.flst.service.backstage.menus

import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.Record7
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
    fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Result<Record7<String, String, String, String, String, Int, Byte>>

    /**
     * 根据条件查询总数
     *
     * @return 条件查询总数
     */
    fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<MenusBean>): Int
}