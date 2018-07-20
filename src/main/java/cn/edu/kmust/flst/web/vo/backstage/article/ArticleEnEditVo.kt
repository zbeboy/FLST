package cn.edu.kmust.flst.web.vo.backstage.article

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by zbeboy 2018-04-14 .
 **/
open class ArticleEnEditVo {
    @NotNull
    @Min(1)
    var articleId: Int? = null
    @NotNull
    @Size(max = 64)
    var menuId: String? = null
    @NotNull
    @Size(max = 200)
    var articleTitle: String? = null
    var articleBrief: String? = null
    @NotNull
    @Size(max = 200)
    var articleCover: String? = null
    @NotNull
    var articleContent: String? = null
    var articleSources: Int? = null
    var articleSourcesName: String? = null
    var articleSourcesLink: String? = null
    var articleSn: Int? = 0
}