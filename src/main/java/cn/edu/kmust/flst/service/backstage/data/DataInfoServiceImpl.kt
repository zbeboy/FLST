package cn.edu.kmust.flst.service.backstage.data

import cn.edu.kmust.flst.domain.Tables.DATA_INFO
import cn.edu.kmust.flst.domain.tables.daos.DataInfoDao
import cn.edu.kmust.flst.domain.tables.pojos.DataInfo
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * Created by zbeboy 2018-04-16 .
 **/
@Service("dataInfoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class DataInfoServiceImpl @Autowired constructor(dslContext: DSLContext) : DataInfoService {

    private val create: DSLContext = dslContext

    @Resource
    open lateinit var dataInfoDao: DataInfoDao

    override fun findById(id: String): DataInfo? {
        return dataInfoDao.findById(id)
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun save(dataInfo: List<DataInfo>) {
        val bind = create.batch(create.insertInto(DATA_INFO, DATA_INFO.DATA_KEY, DATA_INFO.DATA_VALUE).values("", null)
                .onDuplicateKeyUpdate().set(DATA_INFO.DATA_VALUE, ""))
        dataInfo.forEach({ data ->
            bind.bind(data.dataKey, data.dataValue, data.dataValue)
        })
        bind.execute()
    }
}