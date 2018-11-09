/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema;


import cn.edu.kmust.flst.domain.DefaultCatalog;
import cn.edu.kmust.flst.domain.information_schema.tables.Catalogs;
import cn.edu.kmust.flst.domain.information_schema.tables.Collations;
import cn.edu.kmust.flst.domain.information_schema.tables.ColumnPrivileges;
import cn.edu.kmust.flst.domain.information_schema.tables.Columns;
import cn.edu.kmust.flst.domain.information_schema.tables.Constants;
import cn.edu.kmust.flst.domain.information_schema.tables.Constraints;
import cn.edu.kmust.flst.domain.information_schema.tables.CrossReferences;
import cn.edu.kmust.flst.domain.information_schema.tables.Domains;
import cn.edu.kmust.flst.domain.information_schema.tables.FunctionAliases;
import cn.edu.kmust.flst.domain.information_schema.tables.FunctionColumns;
import cn.edu.kmust.flst.domain.information_schema.tables.Help;
import cn.edu.kmust.flst.domain.information_schema.tables.InDoubt;
import cn.edu.kmust.flst.domain.information_schema.tables.Indexes;
import cn.edu.kmust.flst.domain.information_schema.tables.KeyColumnUsage;
import cn.edu.kmust.flst.domain.information_schema.tables.Locks;
import cn.edu.kmust.flst.domain.information_schema.tables.QueryStatistics;
import cn.edu.kmust.flst.domain.information_schema.tables.ReferentialConstraints;
import cn.edu.kmust.flst.domain.information_schema.tables.Rights;
import cn.edu.kmust.flst.domain.information_schema.tables.Roles;
import cn.edu.kmust.flst.domain.information_schema.tables.Schemata;
import cn.edu.kmust.flst.domain.information_schema.tables.Sequences;
import cn.edu.kmust.flst.domain.information_schema.tables.SessionState;
import cn.edu.kmust.flst.domain.information_schema.tables.Sessions;
import cn.edu.kmust.flst.domain.information_schema.tables.Settings;
import cn.edu.kmust.flst.domain.information_schema.tables.Synonyms;
import cn.edu.kmust.flst.domain.information_schema.tables.TableConstraints;
import cn.edu.kmust.flst.domain.information_schema.tables.TablePrivileges;
import cn.edu.kmust.flst.domain.information_schema.tables.TableTypes;
import cn.edu.kmust.flst.domain.information_schema.tables.Tables;
import cn.edu.kmust.flst.domain.information_schema.tables.Triggers;
import cn.edu.kmust.flst.domain.information_schema.tables.TypeInfo;
import cn.edu.kmust.flst.domain.information_schema.tables.Users;
import cn.edu.kmust.flst.domain.information_schema.tables.Views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class InformationSchema extends SchemaImpl {

    private static final long serialVersionUID = -165481193;

    /**
     * The reference instance of <code>information_schema</code>
     */
    public static final InformationSchema INFORMATION_SCHEMA = new InformationSchema();

    /**
     * The table <code>information_schema.catalogs</code>.
     */
    public final Catalogs CATALOGS = cn.edu.kmust.flst.domain.information_schema.tables.Catalogs.CATALOGS;

    /**
     * The table <code>information_schema.collations</code>.
     */
    public final Collations COLLATIONS = cn.edu.kmust.flst.domain.information_schema.tables.Collations.COLLATIONS;

    /**
     * The table <code>information_schema.column_privileges</code>.
     */
    public final ColumnPrivileges COLUMN_PRIVILEGES = cn.edu.kmust.flst.domain.information_schema.tables.ColumnPrivileges.COLUMN_PRIVILEGES;

    /**
     * The table <code>information_schema.columns</code>.
     */
    public final Columns COLUMNS = cn.edu.kmust.flst.domain.information_schema.tables.Columns.COLUMNS;

    /**
     * The table <code>information_schema.constants</code>.
     */
    public final Constants CONSTANTS = cn.edu.kmust.flst.domain.information_schema.tables.Constants.CONSTANTS;

    /**
     * The table <code>information_schema.constraints</code>.
     */
    public final Constraints CONSTRAINTS = cn.edu.kmust.flst.domain.information_schema.tables.Constraints.CONSTRAINTS;

    /**
     * The table <code>information_schema.cross_references</code>.
     */
    public final CrossReferences CROSS_REFERENCES = cn.edu.kmust.flst.domain.information_schema.tables.CrossReferences.CROSS_REFERENCES;

    /**
     * The table <code>information_schema.domains</code>.
     */
    public final Domains DOMAINS = cn.edu.kmust.flst.domain.information_schema.tables.Domains.DOMAINS;

    /**
     * The table <code>information_schema.function_aliases</code>.
     */
    public final FunctionAliases FUNCTION_ALIASES = cn.edu.kmust.flst.domain.information_schema.tables.FunctionAliases.FUNCTION_ALIASES;

    /**
     * The table <code>information_schema.function_columns</code>.
     */
    public final FunctionColumns FUNCTION_COLUMNS = cn.edu.kmust.flst.domain.information_schema.tables.FunctionColumns.FUNCTION_COLUMNS;

    /**
     * The table <code>information_schema.help</code>.
     */
    public final Help HELP = cn.edu.kmust.flst.domain.information_schema.tables.Help.HELP;

    /**
     * The table <code>information_schema.in_doubt</code>.
     */
    public final InDoubt IN_DOUBT = cn.edu.kmust.flst.domain.information_schema.tables.InDoubt.IN_DOUBT;

    /**
     * The table <code>information_schema.indexes</code>.
     */
    public final Indexes INDEXES = cn.edu.kmust.flst.domain.information_schema.tables.Indexes.INDEXES;

    /**
     * The table <code>information_schema.key_column_usage</code>.
     */
    public final KeyColumnUsage KEY_COLUMN_USAGE = cn.edu.kmust.flst.domain.information_schema.tables.KeyColumnUsage.KEY_COLUMN_USAGE;

    /**
     * The table <code>information_schema.locks</code>.
     */
    public final Locks LOCKS = cn.edu.kmust.flst.domain.information_schema.tables.Locks.LOCKS;

    /**
     * The table <code>information_schema.query_statistics</code>.
     */
    public final QueryStatistics QUERY_STATISTICS = cn.edu.kmust.flst.domain.information_schema.tables.QueryStatistics.QUERY_STATISTICS;

    /**
     * The table <code>information_schema.referential_constraints</code>.
     */
    public final ReferentialConstraints REFERENTIAL_CONSTRAINTS = cn.edu.kmust.flst.domain.information_schema.tables.ReferentialConstraints.REFERENTIAL_CONSTRAINTS;

    /**
     * The table <code>information_schema.rights</code>.
     */
    public final Rights RIGHTS = cn.edu.kmust.flst.domain.information_schema.tables.Rights.RIGHTS;

    /**
     * The table <code>information_schema.roles</code>.
     */
    public final Roles ROLES = cn.edu.kmust.flst.domain.information_schema.tables.Roles.ROLES;

    /**
     * The table <code>information_schema.schemata</code>.
     */
    public final Schemata SCHEMATA = cn.edu.kmust.flst.domain.information_schema.tables.Schemata.SCHEMATA;

    /**
     * The table <code>information_schema.sequences</code>.
     */
    public final Sequences SEQUENCES = cn.edu.kmust.flst.domain.information_schema.tables.Sequences.SEQUENCES;

    /**
     * The table <code>information_schema.session_state</code>.
     */
    public final SessionState SESSION_STATE = cn.edu.kmust.flst.domain.information_schema.tables.SessionState.SESSION_STATE;

    /**
     * The table <code>information_schema.sessions</code>.
     */
    public final Sessions SESSIONS = cn.edu.kmust.flst.domain.information_schema.tables.Sessions.SESSIONS;

    /**
     * The table <code>information_schema.settings</code>.
     */
    public final Settings SETTINGS = cn.edu.kmust.flst.domain.information_schema.tables.Settings.SETTINGS;

    /**
     * The table <code>information_schema.synonyms</code>.
     */
    public final Synonyms SYNONYMS = cn.edu.kmust.flst.domain.information_schema.tables.Synonyms.SYNONYMS;

    /**
     * The table <code>information_schema.table_constraints</code>.
     */
    public final TableConstraints TABLE_CONSTRAINTS = cn.edu.kmust.flst.domain.information_schema.tables.TableConstraints.TABLE_CONSTRAINTS;

    /**
     * The table <code>information_schema.table_privileges</code>.
     */
    public final TablePrivileges TABLE_PRIVILEGES = cn.edu.kmust.flst.domain.information_schema.tables.TablePrivileges.TABLE_PRIVILEGES;

    /**
     * The table <code>information_schema.table_types</code>.
     */
    public final TableTypes TABLE_TYPES = cn.edu.kmust.flst.domain.information_schema.tables.TableTypes.TABLE_TYPES;

    /**
     * The table <code>information_schema.tables</code>.
     */
    public final Tables TABLES = cn.edu.kmust.flst.domain.information_schema.tables.Tables.TABLES;

    /**
     * The table <code>information_schema.triggers</code>.
     */
    public final Triggers TRIGGERS = cn.edu.kmust.flst.domain.information_schema.tables.Triggers.TRIGGERS;

    /**
     * The table <code>information_schema.type_info</code>.
     */
    public final TypeInfo TYPE_INFO = cn.edu.kmust.flst.domain.information_schema.tables.TypeInfo.TYPE_INFO;

    /**
     * The table <code>information_schema.users</code>.
     */
    public final Users USERS = cn.edu.kmust.flst.domain.information_schema.tables.Users.USERS;

    /**
     * The table <code>information_schema.views</code>.
     */
    public final Views VIEWS = cn.edu.kmust.flst.domain.information_schema.tables.Views.VIEWS;

    /**
     * No further instances allowed
     */
    private InformationSchema() {
        super("information_schema", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Catalogs.CATALOGS,
            Collations.COLLATIONS,
            ColumnPrivileges.COLUMN_PRIVILEGES,
            Columns.COLUMNS,
            Constants.CONSTANTS,
            Constraints.CONSTRAINTS,
            CrossReferences.CROSS_REFERENCES,
            Domains.DOMAINS,
            FunctionAliases.FUNCTION_ALIASES,
            FunctionColumns.FUNCTION_COLUMNS,
            Help.HELP,
            InDoubt.IN_DOUBT,
            Indexes.INDEXES,
            KeyColumnUsage.KEY_COLUMN_USAGE,
            Locks.LOCKS,
            QueryStatistics.QUERY_STATISTICS,
            ReferentialConstraints.REFERENTIAL_CONSTRAINTS,
            Rights.RIGHTS,
            Roles.ROLES,
            Schemata.SCHEMATA,
            Sequences.SEQUENCES,
            SessionState.SESSION_STATE,
            Sessions.SESSIONS,
            Settings.SETTINGS,
            Synonyms.SYNONYMS,
            TableConstraints.TABLE_CONSTRAINTS,
            TablePrivileges.TABLE_PRIVILEGES,
            TableTypes.TABLE_TYPES,
            Tables.TABLES,
            Triggers.TRIGGERS,
            TypeInfo.TYPE_INFO,
            Users.USERS,
            Views.VIEWS);
    }
}
