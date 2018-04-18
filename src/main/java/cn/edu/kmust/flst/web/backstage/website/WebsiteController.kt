package cn.edu.kmust.flst.web.backstage.website

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.DataInfo
import cn.edu.kmust.flst.service.backstage.data.DataInfoService
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.vo.backstage.website.WebsiteVo
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource

/**
 * Created by zbeboy 2018-04-16 .
 **/
@Controller
open class WebsiteController {

    @Resource
    open lateinit var dataInfoService: DataInfoService

    /**
     * 网站信息
     *
     * @return 网站信息
     */
    @RequestMapping(value = ["/web/backstage/website"], method = [(RequestMethod.GET)])
    fun website(modelMap: ModelMap): String {
        val record = dataInfoService.findByPrefix(Workbook.WEBSITE_PREFIX)
        if (record.isNotEmpty) {
            record.forEach { r ->
                modelMap.addAttribute(r.dataKey, r.dataValue)
            }
        }
        return "backstage/website/website_info"
    }

    /**
     * 保存
     *
     * @param websiteVo 数据
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/website/save"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun save(websiteVo: WebsiteVo): AjaxUtils<*> {
        val list: ArrayList<DataInfo> = ArrayList()
        val data1 = DataInfo()
        data1.dataKey = Workbook.WEBSITE_ADDRESS
        data1.dataValue = websiteVo.address
        list.add(data1)

        val data2 = DataInfo()
        data2.dataKey = Workbook.WEBSITE_ADDRESS_EN
        data2.dataValue = websiteVo.addressEn
        list.add(data2)

        val data3 = DataInfo()
        data3.dataKey = Workbook.WEBSITE_ZIP_CODE
        data3.dataValue = websiteVo.zipCode
        list.add(data3)

        val data4 = DataInfo()
        data4.dataKey = Workbook.WEBSITE_PHONE
        data4.dataValue = websiteVo.phone
        list.add(data4)

        val data5 = DataInfo()
        data5.dataKey = Workbook.WEBSITE_FAX
        data5.dataValue = websiteVo.fax
        list.add(data5)
        dataInfoService.save(list)
        return AjaxUtils.of<Any>().success().msg("保存成功")
    }
}