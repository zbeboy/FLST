package cn.edu.kmust.flst.web.util

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-11 .
 **/
open class BootstrapTableUtils<T> {
    /*
   返回的数据
    */
    var rows: List<T>? = null

    var total: Int = 0

    /*
    请求数据
     */
    var sortName: String? = null

    var sortOrder: String? = null

    var pageSize: Int = 0

    var pageNumber: Int = 0

    /*
   额外搜索参数
    */
    var extraSearch: String? = null

    /*
   object extraSearch
    */
    var search: JSONObject? = null

    companion object {
        @JvmStatic
        fun <T> of(): BootstrapTableUtils<T> {
            return BootstrapTableUtils()
        }
    }

    constructor()

    constructor(request: HttpServletRequest) {
        val sortNameParam = request.getParameter("sortName")
        val sortOrderParam = request.getParameter("sortOrder")
        val pageSizeParam = request.getParameter("pageSize")
        val pageNumberParam = request.getParameter("pageNumber")
        val extraSearchParam = request.getParameter("extraSearch")

        if (NumberUtils.isDigits(pageSizeParam)) {
            this.pageSize = NumberUtils.toInt(pageSizeParam)
        }

        if (NumberUtils.isDigits(pageNumberParam)) {
            this.pageNumber = NumberUtils.toInt(pageNumberParam)
        }

        if (StringUtils.isNotBlank(sortNameParam)) {
            this.sortName = sortNameParam
        }

        if (StringUtils.isNotBlank(sortOrderParam)) {
            this.sortOrder = sortOrderParam
        }

        if (StringUtils.isNotBlank(extraSearchParam)) {
            this.extraSearch = extraSearchParam
            this.search = JSON.parseObject(extraSearchParam)
        }
    }
}