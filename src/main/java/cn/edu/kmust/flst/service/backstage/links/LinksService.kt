package cn.edu.kmust.flst.service.backstage.links

import cn.edu.kmust.flst.domain.public_.tables.pojos.FriendlyLink
import cn.edu.kmust.flst.domain.public_.tables.records.FriendlyLinkRecord
import cn.edu.kmust.flst.web.bean.backstage.links.LinksBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.Record
import org.jooq.Result

/**
 * Created by zbeboy 2018-04-16 .
 **/
interface LinksService {

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return 数据
     */
    fun findById(id: String): FriendlyLink

    /**
     * 通过是否显示查询全部
     *
     * @param linkShow 是否显示
     * @return 数据
     */
    fun findAllByLinkShow(linkShow: Boolean): Result<FriendlyLinkRecord>

    /**
     * 分页查询
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 分页数据
     */
    fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<LinksBean>): Result<Record>

    /**
     * 根据条件查询总数
     *
     * @return 条件查询总数
     */
    fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<LinksBean>): Int

    /**
     * 保存
     *
     * @param friendlyLink 数据
     */
    fun save(friendlyLink: FriendlyLink)

    /**
     * 更新
     *
     * @param friendlyLink 数据
     */
    fun update(friendlyLink: FriendlyLink)

    /**
     * 删除
     *
     * @param id 主键
     */
    fun deleteById(id: String)
}