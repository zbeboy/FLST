package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.public_.tables.pojos.ArticleContent

/**
 * Created by zbeboy 2018-04-25 .
 **/
interface ArticleContentService {

    /**
     * 保存
     *
     * @param articleContent 数据
     */
    fun save(articleContent: ArticleContent)

    /**
     * 更新
     *
     * @param articleContent 数据
     */
    fun update(articleContent: ArticleContent)

    /**
     * 通过主键删除
     *
     * @param id 主键
     */
    fun deleteById(id: Int)
}