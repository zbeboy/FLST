package cn.edu.kmust.flst.service.backstage.data

import cn.edu.kmust.flst.domain.tables.pojos.DataInfo
import cn.edu.kmust.flst.domain.tables.records.DataInfoRecord
import org.jooq.Record
import org.jooq.Result

/**
 * Created by zbeboy 2018-04-16 .
 **/
interface DataInfoService {

    /**
     * 通过前缀查询
     *
     * @param prefix 前缀
     * @return 数据
     */
    fun findByPrefix(prefix: String): Result<DataInfoRecord>

    /**
     * 保存
     *
     * @param dataInfo 数据
     */
    fun save(dataInfo: List<DataInfo>)
}