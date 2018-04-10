package cn.edu.kmust.flst.service.system

/**
 * Created by zbeboy 2017-11-17 .
 **/
interface AuthoritiesService {
    /**
     * Check if user is login by remember me cookie, refer
     * org.springframework.security.authentication.AuthenticationTrustResolverImpl
     * @return true or false
     */
    fun isRememberMeAuthenticated(): Boolean
}