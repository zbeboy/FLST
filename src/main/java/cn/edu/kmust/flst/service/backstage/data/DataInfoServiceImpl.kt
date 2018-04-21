package cn.edu.kmust.flst.service.backstage.data

import cn.edu.kmust.flst.domain.Tables.DATA_INFO
import cn.edu.kmust.flst.domain.tables.daos.DataInfoDao
import cn.edu.kmust.flst.domain.tables.pojos.DataInfo
import cn.edu.kmust.flst.domain.tables.records.DataInfoRecord
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import org.jooq.DSLContext
import org.jooq.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
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

    @Cacheable(cacheNames = ["data_info"], key = "#prefix")
    override fun findByPrefix(prefix: String): Result<DataInfoRecord> {
        return create.selectFrom(DATA_INFO)
                .where(DATA_INFO.DATA_KEY.like(SQLQueryUtils.rightLikeParam(prefix)))
                .fetch()
    }

    @CacheEvict(cacheNames = ["data_info"], allEntries = true)
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