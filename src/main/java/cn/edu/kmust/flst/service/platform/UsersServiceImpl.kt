package cn.edu.kmust.flst.service.platform

import cn.edu.kmust.flst.domain.tables.daos.UsersDao
import cn.edu.kmust.flst.domain.tables.pojos.Users
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * Created by zbeboy 2017-11-19 .
 **/
@Service("usersService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class UsersServiceImpl @Autowired constructor(dslContext: DSLContext) : UsersService {

    private val create: DSLContext = dslContext

    @Resource
    open lateinit var usersDao: UsersDao

    override fun findByUsername(username: String): Users? {
        return usersDao.findById(username)
    }
}