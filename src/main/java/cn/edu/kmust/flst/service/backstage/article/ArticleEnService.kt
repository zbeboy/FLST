package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.tables.pojos.ArticleEn
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.Record
import org.jooq.Result
import java.sql.Timestamp
import java.util.*

/**
 * Created by zbeboy 2018-04-14 .
 **/
interface ArticleEnService {

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return 数据
     */
    fun findById(id: Int): ArticleEn

    /**
     * 通过主键关联查询
     *
     * @param id 主键
     * @return 数据
     */
    fun findByIdAndCache(id: Int): Optional<Record>

    /**
     * 通过查询下一篇文章
     *
     * @param articleDate 日期
     * @return 数据
     */
    fun findOneGTArticleDateByPage(articleDate: Timestamp, menuId: String): Optional<Record>

    /**
     * 通过查询上一篇文章
     *
     * @param articleDate 日期
     * @return 数据
     */
    fun findOneLTArticleDateByPage(articleDate: Timestamp, menuId: String): Optional<Record>

    /**
     * 查询最新一条
     *
     * @return 数据
     */
    fun findOneByPageOrderByArticleDate(menuId: String): Optional<Record>

    /**
     * 分页查询
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 分页数据
     */
    fun findAllByPage(bootstrapTableUtils: BootstrapTableUtils<ArticleEnBean>): Result<Record>

    /**
     * 根据条件查询总数
     *
     * @return 条件查询总数
     */
    fun countByCondition(bootstrapTableUtils: BootstrapTableUtils<ArticleEnBean>): Int

    /**
     * 保存
     *
     * @param article 数据
     */
    fun save(article: ArticleEn)

    /**
     * 更新
     *
     * @param article 数据
     */
    fun update(article: ArticleEn)

    /**
     * 更新点击量
     */
    fun updateClicks(articleId: Int)

    /**
     * 通过主键删除
     *
     * @param id 主键
     */
    fun deleteById(id: Int)
}