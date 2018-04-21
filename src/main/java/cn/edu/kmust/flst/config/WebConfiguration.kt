package cn.edu.kmust.flst.config

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.io.File
import javax.inject.Inject


@Configuration
open class WebConfiguration : WebMvcConfigurer {

    @Inject
    open lateinit var env: Environment

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
        if (this.env.acceptsProfiles(Workbook.SPRING_PROFILE_PRODUCTION)) {
            val documentRoot = File(System.getProperty("user.dir") + Workbook.DIRECTORY_SPLIT + Workbook.DOCUMENT_ROOT)
            if (!documentRoot.exists()) {
                documentRoot.mkdirs()
            }
            undertow.documentRoot = documentRoot
        }
        return undertow
    }

}