package cn.edu.kmust.flst.service.system

import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationTrustResolverImpl
import org.springframework.security.authentication.RememberMeAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils

/**
 * Created by zbeboy 2017-11-17 .
 **/
@Service("authoritiesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class AuthoritiesServiceImpl @Autowired constructor(dslContext: DSLContext) : AuthoritiesService {

    private val create: DSLContext = dslContext

    override fun isAnonymousAuthenticated(): Boolean {
        val authentication = SecurityContextHolder.getContext().authentication
        return !ObjectUtils.isEmpty(authentication) && AuthenticationTrustResolverImpl().isAnonymous(authentication)
    }

}