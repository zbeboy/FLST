package cn.edu.kmust.flst.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.io.File


@Configuration
open class WebConfiguration : WebMvcConfigurer {

    @Autowired
    open lateinit var flstProperties: FLSTProperties

    /**
     * 切换语言
     *
     * @return 语言环境
     */
    @Bean
    open fun localeResolver(): LocaleResolver {
        return SessionLocaleResolver()
    }

    @Bean
    open fun undertow(): UndertowServletWebServerFactory {
        val undertow = UndertowServletWebServerFactory()
        val documentRoot = File(System.getProperty("user.dir") + Workbook.DIRECTORY_SPLIT + flstProperties.getConstants().documentRoot)
        if (!documentRoot.exists()) {
            documentRoot.mkdirs()
        }
        undertow.documentRoot = documentRoot
        return undertow
    }

}