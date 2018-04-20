package cn.edu.kmust.flst.service.backstage.files

import cn.edu.kmust.flst.domain.Tables.FILES
import cn.edu.kmust.flst.domain.tables.daos.FilesDao
import cn.edu.kmust.flst.domain.tables.pojos.Files
import cn.edu.kmust.flst.service.plugin.BootstrapTablesPlugin
import cn.edu.kmust.flst.service.util.SQLQueryUtils
import cn.edu.kmust.flst.web.bean.backstage.files.FilesBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import javax.annotation.Resource

@Service("filesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class FilesServiceImpl @Autowired constructor(dslContext: DSLContext) : BootstrapTablesPlugin<FilesBean>(), FilesService {

    private val create: DSLContext = dslContext

    @Resource
    open lateinit var filesDao: FilesDao

    override fun findById(id: String): Files? {
        return filesDao.findById(id)
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun save(files: Files) {
        filesDao.insert(files)
    }

    override fun deleteById(id: String) {
        filesDao.deleteById(id)
    }

    override fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<FilesBean>): Result<Record> {
        return dataPagingQueryAll(bootstrapTableUtils, create, FILES)
    }

    override fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<FilesBean>): Int {
        return statisticsWithCondition(bootstrapTableUtils, create, FILES)
    }

    /**
     * 全局搜索条件
     *
     * @param bootstrapTableUtils datatables工具类
     * @return 搜索条件
     */
    override fun searchCondition(bootstrapTableUtils: BootstrapTableUtils<FilesBean>): Condition? {
        var a: Condition? = null
        val search = bootstrapTableUtils.search
        if (!ObjectUtils.isEmpty(search)) {
            val originalFileName = StringUtils.trimWhitespace(search!!.getString("originalFileName"))
            if (StringUtils.hasLength(originalFileName)) {
                a = FILES.ORIGINAL_FILE_NAME.like(SQLQueryUtils.likeAllParam(originalFileName))
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
    override fun sortCondition(bootstrapTableUtils: BootstrapTableUtils<FilesBean>, selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int) {
        val orderColumnName = bootstrapTableUtils.sortName
        val orderDir = bootstrapTableUtils.sortOrder
        val isAsc = "asc".equals(orderDir, ignoreCase = true)
        var sortField: Array<SortField<*>?>? = null
        if (StringUtils.hasLength(orderColumnName)) {
            if ("originalFileName".equals(orderColumnName!!, ignoreCase = true)) {
                sortField = arrayOfNulls(2)
                if (isAsc) {
                    sortField[0] = FILES.ORIGINAL_FILE_NAME.asc()
                    sortField[1] = FILES.FILE_ID.asc()
                } else {
                    sortField[0] = FILES.ORIGINAL_FILE_NAME.desc()
                    sortField[1] = FILES.FILE_ID.desc()
                }
            }

            if ("uploadDate".equals(orderColumnName, ignoreCase = true)) {
                sortField = arrayOfNulls(1)
                if (isAsc) {
                    sortField[0] = FILES.UPLOAD_DATE.asc()
                } else {
                    sortField[0] = FILES.UPLOAD_DATE.desc()
                }
            }
        }
        sortToFinish(selectConditionStep, selectJoinStep, type, *sortField!!)
    }
}