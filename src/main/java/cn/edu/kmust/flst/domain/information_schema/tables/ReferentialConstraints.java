/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.information_schema.tables.records.ReferentialConstraintsRecord;

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
public class ReferentialConstraints extends TableImpl<ReferentialConstraintsRecord> {

    private static final long serialVersionUID = 138314276;

    /**
     * The reference instance of <code>information_schema.referential_constraints</code>
     */
    public static final ReferentialConstraints REFERENTIAL_CONSTRAINTS = new ReferentialConstraints();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReferentialConstraintsRecord> getRecordType() {
        return ReferentialConstraintsRecord.class;
    }

    /**
     * The column <code>information_schema.referential_constraints.constraint_catalog</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> CONSTRAINT_CATALOG = createField("constraint_catalog", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.constraint_schema</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> CONSTRAINT_SCHEMA = createField("constraint_schema", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.constraint_name</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> CONSTRAINT_NAME = createField("constraint_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.unique_constraint_catalog</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> UNIQUE_CONSTRAINT_CATALOG = createField("unique_constraint_catalog", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.unique_constraint_schema</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> UNIQUE_CONSTRAINT_SCHEMA = createField("unique_constraint_schema", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.unique_constraint_name</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> UNIQUE_CONSTRAINT_NAME = createField("unique_constraint_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.match_option</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> MATCH_OPTION = createField("match_option", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.update_rule</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> UPDATE_RULE = createField("update_rule", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.referential_constraints.delete_rule</code>.
     */
    public final TableField<ReferentialConstraintsRecord, String> DELETE_RULE = createField("delete_rule", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * Create a <code>information_schema.referential_constraints</code> table reference
     */
    public ReferentialConstraints() {
        this(DSL.name("referential_constraints"), null);
    }

    /**
     * Create an aliased <code>information_schema.referential_constraints</code> table reference
     */
    public ReferentialConstraints(String alias) {
        this(DSL.name(alias), REFERENTIAL_CONSTRAINTS);
    }

    /**
     * Create an aliased <code>information_schema.referential_constraints</code> table reference
     */
    public ReferentialConstraints(Name alias) {
        this(alias, REFERENTIAL_CONSTRAINTS);
    }

    private ReferentialConstraints(Name alias, Table<ReferentialConstraintsRecord> aliased) {
        this(alias, aliased, null);
    }

    private ReferentialConstraints(Name alias, Table<ReferentialConstraintsRecord> aliased, Field<?>[] parameters) {
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
    public ReferentialConstraints as(String alias) {
        return new ReferentialConstraints(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReferentialConstraints as(Name alias) {
        return new ReferentialConstraints(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ReferentialConstraints rename(String name) {
        return new ReferentialConstraints(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ReferentialConstraints rename(Name name) {
        return new ReferentialConstraints(name, null);
    }
}
