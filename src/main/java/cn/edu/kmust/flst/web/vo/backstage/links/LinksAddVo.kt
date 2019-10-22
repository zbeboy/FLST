package cn.edu.kmust.flst.web.vo.backstage.links

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by zbeboy 2018-04-16 .
 **/
open class LinksAddVo {
    @NotNull
    @Size(max = 100)
    var linkName: String? = null
    @NotNull
    @Size(max = 200)
    var linkNameEn: String? = null
    @NotNull
    @Size(max = 200)
    var linkUrl: String? = null
    var linkShow: Boolean? = null
}