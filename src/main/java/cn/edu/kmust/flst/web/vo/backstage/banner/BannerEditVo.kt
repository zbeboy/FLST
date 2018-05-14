package cn.edu.kmust.flst.web.vo.backstage.banner

import javax.validation.constraints.NotNull

/**
 * Created by zbeboy 2018-05-14 .
 **/
open class BannerEditVo {
    @NotNull
    var name: String? = null
    @NotNull
    var pk: Int? = null
    var value: String? = null
}