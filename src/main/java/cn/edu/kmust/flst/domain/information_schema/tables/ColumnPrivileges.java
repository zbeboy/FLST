/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.information_schema.tables.records.ColumnPrivilegesRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class ColumnPrivileges extends TableImpl<ColumnPrivilegesRecord> {

    private static final long serialVersionUID = -676322027;

    /**
     * The reference instance of <code>information_schema.column_privileges</code>
     */
    public static final ColumnPrivileges COLUMN_PRIVILEGES = new ColumnPrivileges();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ColumnPrivilegesRecord> getRecordType() {
        return ColumnPrivilegesRecord.class;
    }

    /**
     * The column <code>information_schema.column_privileges.grantor</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> GRANTOR = createField("grantor", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.column_privileges.grantee</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> GRANTEE = createField("grantee", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.column_privileges.table_catalog</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> TABLE_CATALOG = createField("table_catalog", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.column_privileges.table_schema</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> TABLE_SCHEMA = createField("table_schema", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.column_privileges.table_name</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> TABLE_NAME = createField("table_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.column_privileges.column_name</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> COLUMN_NAME = createField("column_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.column_privileges.privilege_type</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> PRIVILEGE_TYPE = createField("privilege_type", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.column_privileges.is_grantable</code>.
     */
    public final TableField<ColumnPrivilegesRecord, String> IS_GRANTABLE = createField("is_grantable", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * Create a <code>information_schema.column_privileges</code> table reference
     */
    public ColumnPrivileges() {
        this(DSL.name("column_privileges"), null);
    }

    /**
     * Create an aliased <code>information_schema.column_privileges</code> table reference
     */
    public ColumnPrivileges(String alias) {
        this(DSL.name(alias), COLUMN_PRIVILEGES);
    }

    /**
     * Create an aliased <code>information_schema.column_privileges</code> table reference
     */
    public ColumnPrivileges(Name alias) {
        this(alias, COLUMN_PRIVILEGES);
    }

    private ColumnPrivileges(Name alias, Table<ColumnPrivilegesRecord> aliased) {
        this(alias, aliased, null);
    }

    private ColumnPrivileges(Name alias, Table<ColumnPrivilegesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColumnPrivileges as(String alias) {
        return new ColumnPrivileges(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColumnPrivileges as(Name alias) {
        return new ColumnPrivileges(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ColumnPrivileges rename(String name) {
        return new ColumnPrivileges(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ColumnPrivileges rename(Name name) {
        return new ColumnPrivileges(name, null);
    }
}
