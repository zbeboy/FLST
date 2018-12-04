package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.flst.tables.daos.ArticleEnContentDao
import cn.edu.kmust.flst.domain.flst.tables.pojos.ArticleEnContent
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * Created by zbeboy 2018-04-25 .
 **/
@Service("articleEnContentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class ArticleEnContentServiceImpl : ArticleEnContentService {

    @Resource
    open lateinit var articleEnContentDao: ArticleEnContentDao

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun save(articleEnContent: ArticleEnContent) {
        articleEnContentDao.insert(articleEnContent)
    }

    override fun update(articleEnContent: ArticleEnContent) {
        articleEnContentDao.update(articleEnContent)
    }

    override fun deleteById(id: Int) {
        articleEnContentDao.deleteById(id)
    }
}