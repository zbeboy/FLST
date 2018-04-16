package cn.edu.kmust.flst.service.backstage.data

import cn.edu.kmust.flst.domain.tables.pojos.DataInfo

/**
 * Created by zbeboy 2018-04-16 .
 **/
interface DataInfoService {

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return 数据
     */
    fun findById(id: String): DataInfo?

    /**
     * 保存
     *
     * @param dataInfo 数据
     */
    fun save(dataInfo: List<DataInfo>)
}