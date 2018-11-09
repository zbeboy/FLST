/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.information_schema.tables.records.DomainsRecord;

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
public class Domains extends TableImpl<DomainsRecord> {

    private static final long serialVersionUID = -1935729738;

    /**
     * The reference instance of <code>information_schema.domains</code>
     */
    public static final Domains DOMAINS = new Domains();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DomainsRecord> getRecordType() {
        return DomainsRecord.class;
    }

    /**
     * The column <code>information_schema.domains.domain_catalog</code>.
     */
    public final TableField<DomainsRecord, String> DOMAIN_CATALOG = createField("domain_catalog", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.domain_schema</code>.
     */
    public final TableField<DomainsRecord, String> DOMAIN_SCHEMA = createField("domain_schema", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.domain_name</code>.
     */
    public final TableField<DomainsRecord, String> DOMAIN_NAME = createField("domain_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.column_default</code>.
     */
    public final TableField<DomainsRecord, String> COLUMN_DEFAULT = createField("column_default", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.is_nullable</code>.
     */
    public final TableField<DomainsRecord, String> IS_NULLABLE = createField("is_nullable", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.data_type</code>.
     */
    public final TableField<DomainsRecord, Integer> DATA_TYPE = createField("data_type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.domains.precision</code>.
     */
    public final TableField<DomainsRecord, Integer> PRECISION = createField("precision", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.domains.scale</code>.
     */
    public final TableField<DomainsRecord, Integer> SCALE = createField("scale", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.domains.type_name</code>.
     */
    public final TableField<DomainsRecord, String> TYPE_NAME = createField("type_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.selectivity</code>.
     */
    public final TableField<DomainsRecord, Integer> SELECTIVITY = createField("selectivity", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.domains.check_constraint</code>.
     */
    public final TableField<DomainsRecord, String> CHECK_CONSTRAINT = createField("check_constraint", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.remarks</code>.
     */
    public final TableField<DomainsRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.sql</code>.
     */
    public final TableField<DomainsRecord, String> SQL = createField("sql", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.domains.id</code>.
     */
    public final TableField<DomainsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>information_schema.domains</code> table reference
     */
    public Domains() {
        this(DSL.name("domains"), null);
    }

    /**
     * Create an aliased <code>information_schema.domains</code> table reference
     */
    public Domains(String alias) {
        this(DSL.name(alias), DOMAINS);
    }

    /**
     * Create an aliased <code>information_schema.domains</code> table reference
     */
    public Domains(Name alias) {
        this(alias, DOMAINS);
    }

    private Domains(Name alias, Table<DomainsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Domains(Name alias, Table<DomainsRecord> aliased, Field<?>[] parameters) {
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
    public Domains as(String alias) {
        return new Domains(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Domains as(Name alias) {
        return new Domains(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Domains rename(String name) {
        return new Domains(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Domains rename(Name name) {
        return new Domains(name, null);
    }
}
