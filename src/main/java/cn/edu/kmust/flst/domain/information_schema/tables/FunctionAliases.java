/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.information_schema.tables.records.FunctionAliasesRecord;

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
public class FunctionAliases extends TableImpl<FunctionAliasesRecord> {

    private static final long serialVersionUID = 815212309;

    /**
     * The reference instance of <code>information_schema.function_aliases</code>
     */
    public static final FunctionAliases FUNCTION_ALIASES = new FunctionAliases();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FunctionAliasesRecord> getRecordType() {
        return FunctionAliasesRecord.class;
    }

    /**
     * The column <code>information_schema.function_aliases.alias_catalog</code>.
     */
    public final TableField<FunctionAliasesRecord, String> ALIAS_CATALOG = createField("alias_catalog", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.function_aliases.alias_schema</code>.
     */
    public final TableField<FunctionAliasesRecord, String> ALIAS_SCHEMA = createField("alias_schema", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.function_aliases.alias_name</code>.
     */
    public final TableField<FunctionAliasesRecord, String> ALIAS_NAME = createField("alias_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.function_aliases.java_class</code>.
     */
    public final TableField<FunctionAliasesRecord, String> JAVA_CLASS = createField("java_class", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.function_aliases.java_method</code>.
     */
    public final TableField<FunctionAliasesRecord, String> JAVA_METHOD = createField("java_method", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.function_aliases.data_type</code>.
     */
    public final TableField<FunctionAliasesRecord, Integer> DATA_TYPE = createField("data_type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.function_aliases.type_name</code>.
     */
    public final TableField<FunctionAliasesRecord, String> TYPE_NAME = createField("type_name", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.function_aliases.column_count</code>.
     */
    public final TableField<FunctionAliasesRecord, Integer> COLUMN_COUNT = createField("column_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.function_aliases.returns_result</code>.
     */
    public final TableField<FunctionAliasesRecord, Short> RETURNS_RESULT = createField("returns_result", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>information_schema.function_aliases.remarks</code>.
     */
    public final TableField<FunctionAliasesRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.function_aliases.id</code>.
     */
    public final TableField<FunctionAliasesRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.function_aliases.source</code>.
     */
    public final TableField<FunctionAliasesRecord, String> SOURCE = createField("source", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * Create a <code>information_schema.function_aliases</code> table reference
     */
    public FunctionAliases() {
        this(DSL.name("function_aliases"), null);
    }

    /**
     * Create an aliased <code>information_schema.function_aliases</code> table reference
     */
    public FunctionAliases(String alias) {
        this(DSL.name(alias), FUNCTION_ALIASES);
    }

    /**
     * Create an aliased <code>information_schema.function_aliases</code> table reference
     */
    public FunctionAliases(Name alias) {
        this(alias, FUNCTION_ALIASES);
    }

    private FunctionAliases(Name alias, Table<FunctionAliasesRecord> aliased) {
        this(alias, aliased, null);
    }

    private FunctionAliases(Name alias, Table<FunctionAliasesRecord> aliased, Field<?>[] parameters) {
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
    public FunctionAliases as(String alias) {
        return new FunctionAliases(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FunctionAliases as(Name alias) {
        return new FunctionAliases(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FunctionAliases rename(String name) {
        return new FunctionAliases(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FunctionAliases rename(Name name) {
        return new FunctionAliases(name, null);
    }
}
