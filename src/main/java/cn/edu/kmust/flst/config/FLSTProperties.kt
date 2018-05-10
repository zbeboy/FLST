package cn.edu.kmust.flst.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Spring boot 配置属性加载.
 *
 * @author zbeboy
 * @version 1.0
 * @since 1.0
 */
@ConfigurationProperties(prefix = "flst", ignoreUnknownFields = false)
class FLSTProperties {

    private val constants = Constants()

    private val certificate = Certificate()

    fun getConstants(): Constants {
        return constants
    }

    fun getCertificate(): Certificate {
        return certificate
    }

    /**
     * 通用初始化参数
     */
    class Constants {

        var documentRoot: String? = null

        var staticImages: String? = null
    }

    /**
     * let's encrypt 证书参数
     */
    class Certificate {
        var place: String? = null
    }
}