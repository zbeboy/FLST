/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables.records;


import cn.edu.kmust.flst.domain.information_schema.tables.Tables;

import javax.annotation.Generated;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.TableRecordImpl;


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
public class TablesRecord extends TableRecordImpl<TablesRecord> implements Record12<String, String, String, String, String, String, String, Long, Integer, String, String, Long> {

    private static final long serialVersionUID = 194706701;

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.TABLE_CATALOG</code>.
     */
    public void setTableCatalog(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.TABLE_CATALOG</code>.
     */
    @Size(max = 2147483647)
    public String getTableCatalog() {
        return (String) get(0);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.TABLE_SCHEMA</code>.
     */
    public void setTableSchema(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.TABLE_SCHEMA</code>.
     */
    @Size(max = 2147483647)
    public String getTableSchema() {
        return (String) get(1);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.TABLE_NAME</code>.
     */
    public void setTableName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.TABLE_NAME</code>.
     */
    @Size(max = 2147483647)
    public String getTableName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.TABLE_TYPE</code>.
     */
    public void setTableType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.TABLE_TYPE</code>.
     */
    @Size(max = 2147483647)
    public String getTableType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.STORAGE_TYPE</code>.
     */
    public void setStorageType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.STORAGE_TYPE</code>.
     */
    @Size(max = 2147483647)
    public String getStorageType() {
        return (String) get(4);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.SQL</code>.
     */
    public void setSql(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.SQL</code>.
     */
    @Size(max = 2147483647)
    public String getSql() {
        return (String) get(5);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.REMARKS</code>.
     */
    public void setRemarks(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.REMARKS</code>.
     */
    @Size(max = 2147483647)
    public String getRemarks() {
        return (String) get(6);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.LAST_MODIFICATION</code>.
     */
    public void setLastModification(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.LAST_MODIFICATION</code>.
     */
    public Long getLastModification() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.ID</code>.
     */
    public void setId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.TYPE_NAME</code>.
     */
    public void setTypeName(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.TYPE_NAME</code>.
     */
    @Size(max = 2147483647)
    public String getTypeName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.TABLE_CLASS</code>.
     */
    public void setTableClass(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.TABLE_CLASS</code>.
     */
    @Size(max = 2147483647)
    public String getTableClass() {
        return (String) get(10);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.TABLES.ROW_COUNT_ESTIMATE</code>.
     */
    public void setRowCountEstimate(Long value) {
        set(11, value);
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.TABLES.ROW_COUNT_ESTIMATE</code>.
     */
    public Long getRowCountEstimate() {
        return (Long) get(11);
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<String, String, String, String, String, String, String, Long, Integer, String, String, Long> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<String, String, String, String, String, String, String, Long, Integer, String, String, Long> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Tables.TABLES.TABLE_CATALOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Tables.TABLES.TABLE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Tables.TABLES.TABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Tables.TABLES.TABLE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Tables.TABLES.STORAGE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Tables.TABLES.SQL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Tables.TABLES.REMARKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return Tables.TABLES.LAST_MODIFICATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return Tables.TABLES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Tables.TABLES.TYPE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Tables.TABLES.TABLE_CLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field12() {
        return Tables.TABLES.ROW_COUNT_ESTIMATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getTableType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getStorageType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getSql();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getLastModification();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getTypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getTableClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component12() {
        return getRowCountEstimate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getTableCatalog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTableSchema();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTableType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStorageType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getSql();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getLastModification();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getTypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getTableClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value12() {
        return getRowCountEstimate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value1(String value) {
        setTableCatalog(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value2(String value) {
        setTableSchema(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value3(String value) {
        setTableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value4(String value) {
        setTableType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value5(String value) {
        setStorageType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value6(String value) {
        setSql(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value7(String value) {
        setRemarks(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value8(Long value) {
        setLastModification(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value9(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value10(String value) {
        setTypeName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value11(String value) {
        setTableClass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord value12(Long value) {
        setRowCountEstimate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TablesRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, Long value8, Integer value9, String value10, String value11, Long value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TablesRecord
     */
    public TablesRecord() {
        super(Tables.TABLES);
    }

    /**
     * Create a detached, initialised TablesRecord
     */
    public TablesRecord(String tableCatalog, String tableSchema, String tableName, String tableType, String storageType, String sql, String remarks, Long lastModification, Integer id, String typeName, String tableClass, Long rowCountEstimate) {
        super(Tables.TABLES);

        set(0, tableCatalog);
        set(1, tableSchema);
        set(2, tableName);
        set(3, tableType);
        set(4, storageType);
        set(5, sql);
        set(6, remarks);
        set(7, lastModification);
        set(8, id);
        set(9, typeName);
        set(10, tableClass);
        set(11, rowCountEstimate);
    }
}