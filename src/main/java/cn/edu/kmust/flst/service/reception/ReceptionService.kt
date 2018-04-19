package cn.edu.kmust.flst.service.reception

import org.springframework.ui.ModelMap
import javax.servlet.http.HttpServletRequest

interface ReceptionService {

    /**
     * nav数据
     *
     * @param modelMap 页面对象
     * @param request 请求
     */
    fun navData(modelMap: ModelMap, request: HttpServletRequest)

    /**
     * website数据
     *
     * @param modelMap 页面对象
     * @param request 请求
     */
    fun websiteData(modelMap: ModelMap, request: HttpServletRequest)

    /**
     * banner数据
     *
     * @param modelMap 页面对象
     * @param request 请求
     * @param menuId 栏目 id
     */
    fun bannerData(modelMap: ModelMap, request: HttpServletRequest, menuId: String)

    /**
     * links数据
     *
     * @param modelMap 页面对象
     * @param request 请求
     */
    fun linksData(modelMap: ModelMap, request: HttpServletRequest)
}