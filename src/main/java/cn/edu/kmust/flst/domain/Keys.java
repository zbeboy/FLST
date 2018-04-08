/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain;


import cn.edu.kmust.flst.domain.tables.Authorities;
import cn.edu.kmust.flst.domain.tables.PersistentLogins;
import cn.edu.kmust.flst.domain.tables.Users;
import cn.edu.kmust.flst.domain.tables.records.AuthoritiesRecord;
import cn.edu.kmust.flst.domain.tables.records.PersistentLoginsRecord;
import cn.edu.kmust.flst.domain.tables.records.UsersRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>flst</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthoritiesRecord> KEY_AUTHORITIES_PRIMARY = UniqueKeys0.KEY_AUTHORITIES_PRIMARY;
    public static final UniqueKey<PersistentLoginsRecord> KEY_PERSISTENT_LOGINS_PRIMARY = UniqueKeys0.KEY_PERSISTENT_LOGINS_PRIMARY;
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = UniqueKeys0.KEY_USERS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AuthoritiesRecord, UsersRecord> AUTHORITIES_IBFK_1 = ForeignKeys0.AUTHORITIES_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<AuthoritiesRecord> KEY_AUTHORITIES_PRIMARY = Internal.createUniqueKey(Authorities.AUTHORITIES, "KEY_authorities_PRIMARY", Authorities.AUTHORITIES.USERNAME, Authorities.AUTHORITIES.AUTHORITY);
        public static final UniqueKey<PersistentLoginsRecord> KEY_PERSISTENT_LOGINS_PRIMARY = Internal.createUniqueKey(PersistentLogins.PERSISTENT_LOGINS, "KEY_persistent_logins_PRIMARY", PersistentLogins.PERSISTENT_LOGINS.SERIES);
        public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, "KEY_users_PRIMARY", Users.USERS.USERNAME);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<AuthoritiesRecord, UsersRecord> AUTHORITIES_IBFK_1 = Internal.createForeignKey(cn.edu.kmust.flst.domain.Keys.KEY_USERS_PRIMARY, Authorities.AUTHORITIES, "authorities_ibfk_1", Authorities.AUTHORITIES.USERNAME);
    }
}
