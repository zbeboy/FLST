package cn.edu.kmust.flst.config

import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
open class WebConfiguration: WebMvcConfigurer {

    /**
     * 设置默认首页
     * 注: 这里会指定该url为最高级，不会被spring security 影响到，否则会跳转到login页面.
     * spring 默认支持首页index.html，这里添加是因为可以对首页做一些数据显示操作.
     */
    override fun addViewControllers(registry: ViewControllerRegistry?) {

        registry!!.addViewController("/").setViewName("forward:/index")

        registry.setOrder(Ordered.HIGHEST_PRECEDENCE)

        super.addViewControllers(registry)

    }

}