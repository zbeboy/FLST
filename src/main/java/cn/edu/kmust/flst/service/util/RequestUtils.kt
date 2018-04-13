package cn.edu.kmust.flst.service.util

import cn.edu.kmust.flst.config.Workbook
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2017-11-30 .
 **/
@Component
open class RequestUtils {

    companion object {

        /**
         * 获取realPath
         *
         * @param request 请求
         * @return real path.
         */
        @JvmStatic
        fun getRealPath(request: HttpServletRequest): String {
            return request.session.servletContext.getRealPath(Workbook.DIRECTORY_SPLIT) + Workbook.DIRECTORY_SPLIT
        }
    }
}