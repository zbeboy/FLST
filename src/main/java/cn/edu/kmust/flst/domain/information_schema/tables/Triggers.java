/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.information_schema.tables.records.TriggersRecord;

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
public class Triggers extends TableImpl<TriggersRecord> {

    private static final long serialVersionUID = -704892680;

    /**
     * The reference instance of <code>information_schema.triggers</code>
     */
    public static final Triggers TRIGGERS = new Triggers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TriggersRecord> getRecordType() {
        return TriggersRecord.class;
    }

    /**
     * The column <code>information_schema.triggers.trigger_catalog</code>.
     */
    public final TableField<TriggersRecord, String> TRIGGER_CATALOG = createField("trigger_catalog", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.trigger_schema</code>.
     */
    public final TableField<TriggersRecord, String> TRIGGER_SCHEMA = createField("trigger_schema", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.trigger_name</code>.
     */
    public final TableField<TriggersRecord, String> TRIGGER_NAME = createField("trigger_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.trigger_type</code>.
     */
    public final TableField<TriggersRecord, String> TRIGGER_TYPE = createField("trigger_type", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.table_catalog</code>.
     */
    public final TableField<TriggersRecord, String> TABLE_CATALOG = createField("table_catalog", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.table_schema</code>.
     */
    public final TableField<TriggersRecord, String> TABLE_SCHEMA = createField("table_schema", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.table_name</code>.
     */
    public final TableField<TriggersRecord, String> TABLE_NAME = createField("table_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.before</code>.
     */
    public final TableField<TriggersRecord, Boolean> BEFORE = createField("before", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>information_schema.triggers.java_class</code>.
     */
    public final TableField<TriggersRecord, String> JAVA_CLASS = createField("java_class", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.queue_size</code>.
     */
    public final TableField<TriggersRecord, Integer> QUEUE_SIZE = createField("queue_size", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.triggers.no_wait</code>.
     */
    public final TableField<TriggersRecord, Boolean> NO_WAIT = createField("no_wait", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>information_schema.triggers.remarks</code>.
     */
    public final TableField<TriggersRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.sql</code>.
     */
    public final TableField<TriggersRecord, String> SQL = createField("sql", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.triggers.id</code>.
     */
    public final TableField<TriggersRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>information_schema.triggers</code> table reference
     */
    public Triggers() {
        this(DSL.name("triggers"), null);
    }

    /**
     * Create an aliased <code>information_schema.triggers</code> table reference
     */
    public Triggers(String alias) {
        this(DSL.name(alias), TRIGGERS);
    }

    /**
     * Create an aliased <code>information_schema.triggers</code> table reference
     */
    public Triggers(Name alias) {
        this(alias, TRIGGERS);
    }

    private Triggers(Name alias, Table<TriggersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Triggers(Name alias, Table<TriggersRecord> aliased, Field<?>[] parameters) {
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
    public Triggers as(String alias) {
        return new Triggers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triggers as(Name alias) {
        return new Triggers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Triggers rename(String name) {
        return new Triggers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Triggers rename(Name name) {
        return new Triggers(name, null);
    }
}
