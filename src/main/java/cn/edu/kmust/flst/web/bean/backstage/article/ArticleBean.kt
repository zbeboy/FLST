package cn.edu.kmust.flst.web.bean.backstage.article

import cn.edu.kmust.flst.domain.flst.tables.pojos.Article

/**
 * Created by zbeboy 2018-04-13 .
 **/
class ArticleBean : Article() {
    var articleDateStr: String? = null
    var articleContent: String? = null
    var menuName: String? = null
    var menuNameEn: String? = null
    var outLink: Byte? = null
    var menuLink: String? = null
    var menuPid: String? = null
    var menuOrder: Int? = null
    var menuShow: Byte? = null
    var menuFixed: Byte? = null
    var showArticle: Byte? = null
    var orderWay: Int? = null
}