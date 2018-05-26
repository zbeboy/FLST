/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.records;


import cn.edu.kmust.flst.domain.tables.DataInfo;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class DataInfoRecord extends UpdatableRecordImpl<DataInfoRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -22622952;

    /**
     * Setter for <code>flst.data_info.data_key</code>.
     */
    public void setDataKey(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>flst.data_info.data_key</code>.
     */
    @NotNull
    @Size(max = 200)
    public String getDataKey() {
        return (String) get(0);
    }

    /**
     * Setter for <code>flst.data_info.data_value</code>.
     */
    public void setDataValue(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>flst.data_info.data_value</code>.
     */
    @Size(max = 200)
    public String getDataValue() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return DataInfo.DATA_INFO.DATA_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return DataInfo.DATA_INFO.DATA_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getDataKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDataValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getDataKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDataValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataInfoRecord value1(String value) {
        setDataKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataInfoRecord value2(String value) {
        setDataValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataInfoRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DataInfoRecord
     */
    public DataInfoRecord() {
        super(DataInfo.DATA_INFO);
    }

    /**
     * Create a detached, initialised DataInfoRecord
     */
    public DataInfoRecord(String dataKey, String dataValue) {
        super(DataInfo.DATA_INFO);

        set(0, dataKey);
        set(1, dataValue);
    }
}
