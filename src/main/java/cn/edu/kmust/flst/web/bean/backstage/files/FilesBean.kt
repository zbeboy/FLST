package cn.edu.kmust.flst.web.bean.backstage.files

import cn.edu.kmust.flst.domain.flst.tables.pojos.Files

class FilesBean : Files() {
    var uploadDateStr: String? = null
    var downloadPath: String? = null
}