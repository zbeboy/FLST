/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.flst.tables.records;


import cn.edu.kmust.flst.domain.flst.tables.Files;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class FilesRecord extends UpdatableRecordImpl<FilesRecord> implements Record7<String, Long, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = 599944959;

    /**
     * Setter for <code>FLST.FILES.FILE_ID</code>.
     */
    public void setFileId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>FLST.FILES.FILE_ID</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getFileId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>FLST.FILES.SIZE</code>.
     */
    public void setSize(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>FLST.FILES.SIZE</code>.
     */
    public Long getSize() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>FLST.FILES.ORIGINAL_FILE_NAME</code>.
     */
    public void setOriginalFileName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>FLST.FILES.ORIGINAL_FILE_NAME</code>.
     */
    @Size(max = 300)
    public String getOriginalFileName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>FLST.FILES.NEW_NAME</code>.
     */
    public void setNewName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>FLST.FILES.NEW_NAME</code>.
     */
    @Size(max = 300)
    public String getNewName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>FLST.FILES.RELATIVE_PATH</code>.
     */
    public void setRelativePath(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>FLST.FILES.RELATIVE_PATH</code>.
     */
    @Size(max = 500)
    public String getRelativePath() {
        return (String) get(4);
    }

    /**
     * Setter for <code>FLST.FILES.EXT</code>.
     */
    public void setExt(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>FLST.FILES.EXT</code>.
     */
    @Size(max = 10)
    public String getExt() {
        return (String) get(5);
    }

    /**
     * Setter for <code>FLST.FILES.UPLOAD_DATE</code>.
     */
    public void setUploadDate(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>FLST.FILES.UPLOAD_DATE</code>.
     */
    @NotNull
    public Timestamp getUploadDate() {
        return (Timestamp) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, Long, String, String, String, String, Timestamp> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, Long, String, String, String, String, Timestamp> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Files.FILES.FILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Files.FILES.SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Files.FILES.ORIGINAL_FILE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Files.FILES.NEW_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Files.FILES.RELATIVE_PATH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Files.FILES.EXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return Files.FILES.UPLOAD_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getFileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getOriginalFileName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getNewName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getRelativePath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getExt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component7() {
        return getUploadDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getFileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getOriginalFileName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getNewName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getRelativePath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getExt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getUploadDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord value1(String value) {
        setFileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord value2(Long value) {
        setSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord value3(String value) {
        setOriginalFileName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord value4(String value) {
        setNewName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord value5(String value) {
        setRelativePath(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord value6(String value) {
        setExt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord value7(Timestamp value) {
        setUploadDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FilesRecord values(String value1, Long value2, String value3, String value4, String value5, String value6, Timestamp value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FilesRecord
     */
    public FilesRecord() {
        super(Files.FILES);
    }

    /**
     * Create a detached, initialised FilesRecord
     */
    public FilesRecord(String fileId, Long size, String originalFileName, String newName, String relativePath, String ext, Timestamp uploadDate) {
        super(Files.FILES);

        set(0, fileId);
        set(1, size);
        set(2, originalFileName);
        set(3, newName);
        set(4, relativePath);
        set(5, ext);
        set(6, uploadDate);
    }
}
