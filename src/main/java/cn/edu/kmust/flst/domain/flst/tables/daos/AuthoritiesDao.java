/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.flst.tables.daos;


import cn.edu.kmust.flst.domain.flst.tables.Authorities;
import cn.edu.kmust.flst.domain.flst.tables.records.AuthoritiesRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class AuthoritiesDao extends DAOImpl<AuthoritiesRecord, cn.edu.kmust.flst.domain.flst.tables.pojos.Authorities, Record2<String, String>> {

    /**
     * Create a new AuthoritiesDao without any configuration
     */
    public AuthoritiesDao() {
        super(Authorities.AUTHORITIES, cn.edu.kmust.flst.domain.flst.tables.pojos.Authorities.class);
    }

    /**
     * Create a new AuthoritiesDao with an attached configuration
     */
    @Autowired
    public AuthoritiesDao(Configuration configuration) {
        super(Authorities.AUTHORITIES, cn.edu.kmust.flst.domain.flst.tables.pojos.Authorities.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Record2<String, String> getId(cn.edu.kmust.flst.domain.flst.tables.pojos.Authorities object) {
        return compositeKeyRecord(object.getUsername(), object.getAuthority());
    }

    /**
     * Fetch records that have <code>USERNAME IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.flst.tables.pojos.Authorities> fetchByUsername(String... values) {
        return fetch(Authorities.AUTHORITIES.USERNAME, values);
    }

    /**
     * Fetch records that have <code>AUTHORITY IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.flst.tables.pojos.Authorities> fetchByAuthority(String... values) {
        return fetch(Authorities.AUTHORITIES.AUTHORITY, values);
    }
}
