package cn.edu.kmust.flst.service.system

import cn.edu.kmust.flst.domain.tables.daos.UsersDao
import cn.edu.kmust.flst.domain.tables.pojos.Users
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.util.ObjectUtils


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

    override fun getUsernameFromSession(): String? {
        val principal = SecurityContextHolder.getContext().authentication.principal
        var username: String? = null
        if (!ObjectUtils.isEmpty(principal) && principal is UserDetails) {
            username = principal.username
        }
        return username
    }
}