/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.information_schema.tables.records.SynonymsRecord;

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
public class Synonyms extends TableImpl<SynonymsRecord> {

    private static final long serialVersionUID = -306478888;

    /**
     * The reference instance of <code>INFORMATION_SCHEMA.SYNONYMS</code>
     */
    public static final Synonyms SYNONYMS = new Synonyms();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SynonymsRecord> getRecordType() {
        return SynonymsRecord.class;
    }

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.SYNONYM_CATALOG</code>.
     */
    public final TableField<SynonymsRecord, String> SYNONYM_CATALOG = createField("SYNONYM_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.SYNONYM_SCHEMA</code>.
     */
    public final TableField<SynonymsRecord, String> SYNONYM_SCHEMA = createField("SYNONYM_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.SYNONYM_NAME</code>.
     */
    public final TableField<SynonymsRecord, String> SYNONYM_NAME = createField("SYNONYM_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.SYNONYM_FOR</code>.
     */
    public final TableField<SynonymsRecord, String> SYNONYM_FOR = createField("SYNONYM_FOR", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.SYNONYM_FOR_SCHEMA</code>.
     */
    public final TableField<SynonymsRecord, String> SYNONYM_FOR_SCHEMA = createField("SYNONYM_FOR_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.TYPE_NAME</code>.
     */
    public final TableField<SynonymsRecord, String> TYPE_NAME = createField("TYPE_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.STATUS</code>.
     */
    public final TableField<SynonymsRecord, String> STATUS = createField("STATUS", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.REMARKS</code>.
     */
    public final TableField<SynonymsRecord, String> REMARKS = createField("REMARKS", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.SYNONYMS.ID</code>.
     */
    public final TableField<SynonymsRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>INFORMATION_SCHEMA.SYNONYMS</code> table reference
     */
    public Synonyms() {
        this(DSL.name("SYNONYMS"), null);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.SYNONYMS</code> table reference
     */
    public Synonyms(String alias) {
        this(DSL.name(alias), SYNONYMS);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.SYNONYMS</code> table reference
     */
    public Synonyms(Name alias) {
        this(alias, SYNONYMS);
    }

    private Synonyms(Name alias, Table<SynonymsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Synonyms(Name alias, Table<SynonymsRecord> aliased, Field<?>[] parameters) {
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
    public Synonyms as(String alias) {
        return new Synonyms(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Synonyms as(Name alias) {
        return new Synonyms(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Synonyms rename(String name) {
        return new Synonyms(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Synonyms rename(Name name) {
        return new Synonyms(name, null);
    }
}
