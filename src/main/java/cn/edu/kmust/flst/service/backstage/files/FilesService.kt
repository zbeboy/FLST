package cn.edu.kmust.flst.service.backstage.files


import cn.edu.kmust.flst.domain.public_.tables.pojos.Files
import cn.edu.kmust.flst.web.bean.backstage.files.FilesBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.Record
import org.jooq.Result

interface FilesService {

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return 数据
     */
    fun findById(id: String): Files?

    /**
     * 分页查询
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 分页数据
     */
    fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<FilesBean>): Result<Record>

    /**
     * 根据条件查询总数
     *
     * @return 条件查询总数
     */
    fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<FilesBean>): Int

    /**
     * 保存
     *
     * @param files 数据
     */
    fun save(files: Files)

    /**
     * 通过主键删除
     *
     * @param id 主键
     */
    fun deleteById(id: String)
}