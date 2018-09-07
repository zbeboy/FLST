package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.public_.tables.pojos.ArticleEnContent

/**
 * Created by zbeboy 2018-04-25 .
 **/
interface ArticleEnContentService {
    /**
     * 保存
     *
     * @param articleEnContent 数据
     */
    fun save(articleEnContent: ArticleEnContent)

    /**
     * 更新
     *
     * @param articleEnContent 数据
     */
    fun update(articleEnContent: ArticleEnContent)

    /**
     * 通过主键删除
     *
     * @param id 主键
     */
    fun deleteById(id: Int)
}