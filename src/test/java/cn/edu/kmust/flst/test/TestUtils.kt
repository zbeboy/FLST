package cn.edu.kmust.flst.test

import cn.edu.kmust.flst.service.util.UUIDUtils
import cn.edu.kmust.flst.web.util.ImageUtils
import junit.framework.TestCase
import org.junit.Test

open class TestUtils : TestCase() {

    @Test
    fun testImage() {
        ImageUtils.optimize("f:/023.jpg", "f:/023_temp.jpg", 0.5f)
    }
}