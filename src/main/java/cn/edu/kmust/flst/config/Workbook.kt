package cn.edu.kmust.flst.config


/**
 * Application constants.
 * 开发环境配置常量
 *
 * @author zbeboy
 * @version 1.1
 * @since 1.0
 */
open class Workbook {
    companion object {
        /*
        开发环境
        */
        const val SPRING_PROFILE_DEVELOPMENT = "dev"

        /*
        生产环境
        */
        const val SPRING_PROFILE_PRODUCTION = "prod"

        /*
       目录分隔符
        */
        const val DIRECTORY_SPLIT = "/"

        /*
        服务器根目录
         */
        const val DOCUMENT_ROOT = "root"

        /*
        前台链接前缀
         */
        const val RECEPTION_LINK = "/user/menu/"

        /*
        自定义图片链接
         */
        const val MY_IMAGES_PATH = "/user/images/"

        const val HTTP_PREFIX = "http://"
        const val HTTPS_PREFIX = "https://"

        /*
        语言
         */
        const val LANGUAGE_ZH_CN = "zh_cn"
        const val LANGUAGE_EN = "en"

        /*
        网站信息键
         */
        const val WEBSITE_ADDRESS = "address"
        const val WEBSITE_ZIP_CODE = "zipCode"
        const val WEBSITE_PHONE = "phone"
        const val WEBSITE_FAX = "fax"
        const val WEBSITE_ADDRESS_EN = "addressEn"

        /**
         * 自定义图片路径
         *
         * @return 路径
         */
        @JvmStatic
        fun imagesPath(): String {
            return "images" + DIRECTORY_SPLIT
        }
    }
}