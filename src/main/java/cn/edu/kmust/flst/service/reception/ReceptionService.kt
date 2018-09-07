package cn.edu.kmust.flst.service.reception

import cn.edu.kmust.flst.domain.public_.tables.pojos.Menus
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
     * @param menuId 栏目 id
     */
    fun bannerData(modelMap: ModelMap, menuId: String)

    /**
     * links数据
     *
     * @param modelMap 页面对象
     */
    fun linksData(modelMap: ModelMap)

    /**
     * columns数据
     *
     * @param modelMap 页面对象
     * @param menuId 栏目 id
     */
    fun columnsData(modelMap: ModelMap, menuId: String, request: HttpServletRequest)

    /**
     * 获得最顶层id
     *
     * @param menus 栏目
     * @param list 数据
     */
    fun getMaxPid(menus: Menus, list: ArrayList<Menus>, request: HttpServletRequest)
}