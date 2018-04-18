package cn.edu.kmust.flst.service.reception

import org.springframework.ui.ModelMap
import javax.servlet.http.HttpServletRequest

interface ReceptionService {

    /**
     * 首页数据
     *
     * @param modelMap 页面对象
     * @param request 请求
     */
    fun commonData(modelMap: ModelMap, request: HttpServletRequest)
}