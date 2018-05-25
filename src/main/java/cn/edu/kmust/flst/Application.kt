package cn.edu.kmust.flst

/**
 * 初始化密码: govern MUt6N8h*
 * 文章管理员密码: maintain1 , maintain2 XDbqe2aY
 */
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