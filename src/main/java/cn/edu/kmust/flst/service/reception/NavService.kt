package cn.edu.kmust.flst.service.reception

import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-15 .
 **/
interface NavService {

    /**
     * 递归生成nav
     *
     * @param language 生成的语言
     * @param request 请求
     * @return html
     */
    fun navHtml(language: String, request: HttpServletRequest): String
}