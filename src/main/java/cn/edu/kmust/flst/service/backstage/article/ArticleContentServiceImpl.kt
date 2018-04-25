package cn.edu.kmust.flst.service.backstage.article

import cn.edu.kmust.flst.domain.tables.daos.ArticleContentDao
import cn.edu.kmust.flst.domain.tables.pojos.ArticleContent
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * Created by zbeboy 2018-04-25 .
 **/
@Service("articleContentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class ArticleContentServiceImpl : ArticleContentService {

    @Resource
    open lateinit var articleContentDao: ArticleContentDao

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    override fun save(articleContent: ArticleContent) {
        articleContentDao.insert(articleContent)
    }

    override fun update(articleContent: ArticleContent) {
        articleContentDao.update(articleContent)
    }

    override fun deleteById(id: Int) {
        articleContentDao.deleteById(id)
    }
}