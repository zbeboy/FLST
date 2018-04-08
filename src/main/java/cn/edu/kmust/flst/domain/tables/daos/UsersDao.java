/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.daos;


import cn.edu.kmust.flst.domain.tables.Users;
import cn.edu.kmust.flst.domain.tables.records.UsersRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class UsersDao extends DAOImpl<UsersRecord, cn.edu.kmust.flst.domain.tables.pojos.Users, String> {

    /**
     * Create a new UsersDao without any configuration
     */
    public UsersDao() {
        super(Users.USERS, cn.edu.kmust.flst.domain.tables.pojos.Users.class);
    }

    /**
     * Create a new UsersDao with an attached configuration
     */
    @Autowired
    public UsersDao(Configuration configuration) {
        super(Users.USERS, cn.edu.kmust.flst.domain.tables.pojos.Users.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(cn.edu.kmust.flst.domain.tables.pojos.Users object) {
        return object.getUsername();
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Users> fetchByUsername(String... values) {
        return fetch(Users.USERS.USERNAME, values);
    }

    /**
     * Fetch a unique record that has <code>username = value</code>
     */
    public cn.edu.kmust.flst.domain.tables.pojos.Users fetchOneByUsername(String value) {
        return fetchOne(Users.USERS.USERNAME, value);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Users> fetchByPassword(String... values) {
        return fetch(Users.USERS.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>enabled IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Users> fetchByEnabled(Byte... values) {
        return fetch(Users.USERS.ENABLED, values);
    }
}
