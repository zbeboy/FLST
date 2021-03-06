package cn.edu.kmust.flst

import cn.edu.kmust.flst.config.FLSTProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
@EnableConfigurationProperties(FLSTProperties::class)
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}