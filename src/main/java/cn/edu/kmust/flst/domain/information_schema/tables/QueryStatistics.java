/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.information_schema.tables.records.QueryStatisticsRecord;

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
public class QueryStatistics extends TableImpl<QueryStatisticsRecord> {

    private static final long serialVersionUID = 1514065639;

    /**
     * The reference instance of <code>information_schema.query_statistics</code>
     */
    public static final QueryStatistics QUERY_STATISTICS = new QueryStatistics();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QueryStatisticsRecord> getRecordType() {
        return QueryStatisticsRecord.class;
    }

    /**
     * The column <code>information_schema.query_statistics.sql_statement</code>.
     */
    public final TableField<QueryStatisticsRecord, String> SQL_STATEMENT = createField("sql_statement", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>information_schema.query_statistics.execution_count</code>.
     */
    public final TableField<QueryStatisticsRecord, Integer> EXECUTION_COUNT = createField("execution_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.query_statistics.min_execution_time</code>.
     */
    public final TableField<QueryStatisticsRecord, Double> MIN_EXECUTION_TIME = createField("min_execution_time", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>information_schema.query_statistics.max_execution_time</code>.
     */
    public final TableField<QueryStatisticsRecord, Double> MAX_EXECUTION_TIME = createField("max_execution_time", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>information_schema.query_statistics.cumulative_execution_time</code>.
     */
    public final TableField<QueryStatisticsRecord, Double> CUMULATIVE_EXECUTION_TIME = createField("cumulative_execution_time", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>information_schema.query_statistics.average_execution_time</code>.
     */
    public final TableField<QueryStatisticsRecord, Double> AVERAGE_EXECUTION_TIME = createField("average_execution_time", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>information_schema.query_statistics.std_dev_execution_time</code>.
     */
    public final TableField<QueryStatisticsRecord, Double> STD_DEV_EXECUTION_TIME = createField("std_dev_execution_time", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>information_schema.query_statistics.min_row_count</code>.
     */
    public final TableField<QueryStatisticsRecord, Integer> MIN_ROW_COUNT = createField("min_row_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.query_statistics.max_row_count</code>.
     */
    public final TableField<QueryStatisticsRecord, Integer> MAX_ROW_COUNT = createField("max_row_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.query_statistics.cumulative_row_count</code>.
     */
    public final TableField<QueryStatisticsRecord, Long> CUMULATIVE_ROW_COUNT = createField("cumulative_row_count", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>information_schema.query_statistics.average_row_count</code>.
     */
    public final TableField<QueryStatisticsRecord, Double> AVERAGE_ROW_COUNT = createField("average_row_count", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>information_schema.query_statistics.std_dev_row_count</code>.
     */
    public final TableField<QueryStatisticsRecord, Double> STD_DEV_ROW_COUNT = createField("std_dev_row_count", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * Create a <code>information_schema.query_statistics</code> table reference
     */
    public QueryStatistics() {
        this(DSL.name("query_statistics"), null);
    }

    /**
     * Create an aliased <code>information_schema.query_statistics</code> table reference
     */
    public QueryStatistics(String alias) {
        this(DSL.name(alias), QUERY_STATISTICS);
    }

    /**
     * Create an aliased <code>information_schema.query_statistics</code> table reference
     */
    public QueryStatistics(Name alias) {
        this(alias, QUERY_STATISTICS);
    }

    private QueryStatistics(Name alias, Table<QueryStatisticsRecord> aliased) {
        this(alias, aliased, null);
    }

    private QueryStatistics(Name alias, Table<QueryStatisticsRecord> aliased, Field<?>[] parameters) {
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
    public QueryStatistics as(String alias) {
        return new QueryStatistics(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryStatistics as(Name alias) {
        return new QueryStatistics(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QueryStatistics rename(String name) {
        return new QueryStatistics(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QueryStatistics rename(Name name) {
        return new QueryStatistics(name, null);
    }
}
