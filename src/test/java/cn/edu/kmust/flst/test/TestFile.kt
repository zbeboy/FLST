package cn.edu.kmust.flst.test

import junit.framework.TestCase
import org.junit.Test
import java.io.File

open class TestFile:TestCase() {

    @Test
    fun testFreespace(){
        val file = File("/tmp/undertow-docbase.7288749894684402035.8080/images/")
        println(file.freeSpace)
    }
}