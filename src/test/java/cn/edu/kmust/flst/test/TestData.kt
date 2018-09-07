package cn.edu.kmust.flst.test

import cn.edu.kmust.flst.domain.public_.Tables.*
import org.jooq.DSLContext
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Connection
import java.sql.DriverManager
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
open class TestData {

    @Resource
    open lateinit var create: DSLContext

    open var con: Connection? = null

    @Before
    open fun init() {
        val driver = "com.mysql.jdbc.Driver"
        val url = "jdbc:mysql://localhost/flst?useUnicode=true&characterEncoding=utf-8&useSSL=false"
        val user = "root"
        val password = "123456"
        try {
            Class.forName(driver)
            con = DriverManager.getConnection(url, user, password)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            println("连接成功")
        }
    }

    @Test
    open fun articleEn() {
        val statement = con!!.createStatement()
        val sql = "select * from article_en "
        val rs = statement.executeQuery(sql)

        while (rs.next()) {
            create.insertInto(ARTICLE_EN, ARTICLE_EN.ARTICLE_ID, ARTICLE_EN.ARTICLE_TITLE, ARTICLE_EN.ARTICLE_BRIEF, ARTICLE_EN.ARTICLE_COVER,
                    ARTICLE_EN.ARTICLE_DATE, ARTICLE_EN.ARTICLE_CLICKS, ARTICLE_EN.ARTICLE_AUTHOR, ARTICLE_EN.ARTICLE_SOURCES, ARTICLE_EN.ARTICLE_SOURCES_NAME,
                    ARTICLE_EN.ARTICLE_SOURCES_LINK, ARTICLE_EN.ARTICLE_SN, ARTICLE_EN.MENU_ID)
                    .values(rs.getInt("article_id"), rs.getString("article_title"),rs.getString("article_brief"),
                            rs.getString("article_cover"),rs.getTimestamp("article_date"),rs.getInt("article_clicks"),
                            rs.getString("article_author"),rs.getInt("article_sources"),rs.getString("article_sources_name"),
                            rs.getString("article_sources_link"),rs.getInt("article_sn"),rs.getString("menu_id"))
                    .execute()
        }
        rs.close()
        con!!.close()
    }

    @Test
    open fun articleEnContent() {
        val statement = con!!.createStatement()
        val sql = "select * from article_en_content "
        val rs = statement.executeQuery(sql)

        while (rs.next()) {
            create.insertInto(ARTICLE_EN_CONTENT, ARTICLE_EN_CONTENT.ID, ARTICLE_EN_CONTENT.ARTICLE_CONTENT)
                    .values(rs.getInt("id"), rs.getString("article_content"))
                    .execute()
        }
        rs.close()
        con!!.close()
    }

    @Test
    open fun banner() {
        val statement = con!!.createStatement()
        val sql = "select * from banner "
        val rs = statement.executeQuery(sql)

        while (rs.next()) {
            create.insertInto(BANNER, BANNER.BANNER_ID, BANNER.BANNER_LINK, BANNER.BANNER_DATE,BANNER.BANNER_SHOW, BANNER.BANNER_TITLE,
                    BANNER.BANNER_TITLE_EN, BANNER.BANNER_BRIEF, BANNER.BANNER_BRIEF_EN, BANNER.MENU_ID, BANNER.BANNER_CREATOR)
                    .values(rs.getInt("banner_id"), rs.getString("banner_link"),rs.getTimestamp("banner_date"),
                            rs.getByte("banner_show") == 1.toByte(),rs.getString("banner_title"),rs.getString("banner_title_en"),
                            rs.getString("banner_brief"),rs.getString("banner_brief_en"),rs.getString("menu_id"),rs.getString("banner_creator"))
                    .execute()
        }
        rs.close()
        con!!.close()
    }

    @Test
    open fun friendlyLink() {
        val statement = con!!.createStatement()
        val sql = "select * from friendly_link "
        val rs = statement.executeQuery(sql)

        while (rs.next()) {
            create.insertInto(FRIENDLY_LINK, FRIENDLY_LINK.LINK_ID, FRIENDLY_LINK.LINK_NAME, FRIENDLY_LINK.LINK_NAME_EN,FRIENDLY_LINK.LINK_URL, FRIENDLY_LINK.LINK_SHOW)
                    .values(rs.getString("link_id"), rs.getString("link_name"),rs.getString("link_name_en"),
                            rs.getString("link_url"),rs.getByte("link_show") == 1.toByte())
                    .execute()
        }
        rs.close()
        con!!.close()
    }

    @Test
    open fun dataInfo() {
        val statement = con!!.createStatement()
        val sql = "select * from data_info "
        val rs = statement.executeQuery(sql)

        while (rs.next()) {
            create.insertInto(DATA_INFO, DATA_INFO.DATA_KEY, DATA_INFO.DATA_VALUE)
                    .values(rs.getString("data_key"), rs.getString("data_value"))
                    .execute()
        }
        rs.close()
        con!!.close()
    }

    @Test
    open fun files() {
        val statement = con!!.createStatement()
        val sql = "select * from files "
        val rs = statement.executeQuery(sql)

        while (rs.next()) {
            create.insertInto(FILES, FILES.FILE_ID, FILES.SIZE, FILES.ORIGINAL_FILE_NAME, FILES.NEW_NAME, FILES.RELATIVE_PATH, FILES.EXT, FILES.UPLOAD_DATE)
                    .values(rs.getString("file_id"), rs.getLong("size"),rs.getString("original_file_name"),
                            rs.getString("new_name"),rs.getString("relative_path"),rs.getString("ext"),
                            rs.getTimestamp("upload_date"))
                    .execute()
        }
        rs.close()
        con!!.close()
    }
}