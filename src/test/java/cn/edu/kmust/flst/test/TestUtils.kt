package cn.edu.kmust.flst.test

import cn.edu.kmust.flst.service.util.UUIDUtils
import junit.framework.TestCase
import org.junit.Test

open class TestUtils:TestCase() {

    @Test
    fun testUuid(){
        val list = UUIDUtils.getUUID(10)
        list!!.forEach { i->
            println(i)
        }
    }
}