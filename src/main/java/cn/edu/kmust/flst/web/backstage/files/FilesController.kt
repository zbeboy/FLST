package cn.edu.kmust.flst.web.backstage.files

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Files
import cn.edu.kmust.flst.service.backstage.files.FilesService
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.FilesUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.service.util.UUIDUtils
import cn.edu.kmust.flst.web.bean.backstage.files.FilesBean
import cn.edu.kmust.flst.web.bean.file.FileBean
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

@Controller
open class FilesController {

    private val log = LoggerFactory.getLogger(FilesController::class.java)

    @Resource
    open lateinit var filesService: FilesService

    @Resource
    open lateinit var uploadService: UploadService

    /**
     * 文件管理
     *
     * @return 文件管理
     */
    @RequestMapping(value = ["/web/backstage/files"], method = [(RequestMethod.GET)])
    fun banner(): String {
        return "backstage/files/files_list"
    }

    /**
     * 列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/files/data"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun filesData(request: HttpServletRequest): BootstrapTableUtils<FilesBean> {
        val bootstrapTableUtils = BootstrapTableUtils<FilesBean>(request)
        val records = filesService.findAllByPage(bootstrapTableUtils)
        var files: List<FilesBean> = ArrayList()
        if (!ObjectUtils.isEmpty(records) && records.isNotEmpty) {
            files = records.into(FilesBean::class.java)
            files.forEach { i ->
                i.uploadDateStr = DateTimeUtils.timestampToString(i.uploadDate, "yyyy-MM-dd")
                i.downloadPath = RequestUtils.getBaseUrl(request) + Workbook.MY_FILES_PATH + i.fileId
            }
        }
        bootstrapTableUtils.total = filesService.countByCondition(bootstrapTableUtils)
        bootstrapTableUtils.rows = files
        return bootstrapTableUtils
    }

    /**
     * 上传
     *
     * @param multipartHttpServletRequest   文件
     * @param request                       请求
     * @return true or false
     */
    @RequestMapping("/web/backstage/files/upload")
    @ResponseBody
    fun filesUpload(multipartHttpServletRequest: MultipartHttpServletRequest, request: HttpServletRequest): AjaxUtils<FileBean> {
        val ajaxUtils = AjaxUtils.of<FileBean>()
        try {
            val path = Workbook.filesPath()
            val fileBeen = uploadService.upload(multipartHttpServletRequest,
                    RequestUtils.getRealPath(request) + path, request.remoteAddr)
            if (fileBeen.isNotEmpty() && fileBeen.size > 0) {
                val files = Files()
                val fileBean = fileBeen[0]
                files.fileId = UUIDUtils.getUUID()
                files.size = fileBean.size.toString()
                files.originalFileName = fileBean.originalFileName
                files.newName = fileBean.newName
                files.relativePath = path + fileBean.newName
                files.ext = fileBean.ext
                files.uploadDate = DateTimeUtils.getNow()
                filesService.save(files)
                ajaxUtils.success().msg("保存文件成功").listData(fileBeen)
            } else {
                ajaxUtils.fail().msg("未发现文件")
            }
        } catch (e: Exception) {
            log.error("Upload file error, error is {}", e)
            ajaxUtils.fail().msg("保存文件异常")
        }

        return ajaxUtils
    }

    /**
     * 删除
     *
     * @param fileId id
     * @return 结果
     */
    @RequestMapping(value = ["/web/backstage/files/delete"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun delete(@RequestParam("fileId") fileId: String, request: HttpServletRequest): AjaxUtils<*> {
        val files = filesService.findById(fileId)
        FilesUtils.deleteFile(RequestUtils.getRealPath(request) + files!!.relativePath)
        filesService.deleteById(fileId)
        return AjaxUtils.of<Any>().success().msg("删除成功")
    }
}