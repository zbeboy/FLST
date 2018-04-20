/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.daos;


import cn.edu.kmust.flst.domain.tables.Files;
import cn.edu.kmust.flst.domain.tables.records.FilesRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class FilesDao extends DAOImpl<FilesRecord, cn.edu.kmust.flst.domain.tables.pojos.Files, String> {

    /**
     * Create a new FilesDao without any configuration
     */
    public FilesDao() {
        super(Files.FILES, cn.edu.kmust.flst.domain.tables.pojos.Files.class);
    }

    /**
     * Create a new FilesDao with an attached configuration
     */
    @Autowired
    public FilesDao(Configuration configuration) {
        super(Files.FILES, cn.edu.kmust.flst.domain.tables.pojos.Files.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(cn.edu.kmust.flst.domain.tables.pojos.Files object) {
        return object.getFileId();
    }

    /**
     * Fetch records that have <code>file_id IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Files> fetchByFileId(String... values) {
        return fetch(Files.FILES.FILE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>file_id = value</code>
     */
    public cn.edu.kmust.flst.domain.tables.pojos.Files fetchOneByFileId(String value) {
        return fetchOne(Files.FILES.FILE_ID, value);
    }

    /**
     * Fetch records that have <code>size IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Files> fetchBySize(String... values) {
        return fetch(Files.FILES.SIZE, values);
    }

    /**
     * Fetch records that have <code>original_file_name IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Files> fetchByOriginalFileName(String... values) {
        return fetch(Files.FILES.ORIGINAL_FILE_NAME, values);
    }

    /**
     * Fetch records that have <code>new_name IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Files> fetchByNewName(String... values) {
        return fetch(Files.FILES.NEW_NAME, values);
    }

    /**
     * Fetch records that have <code>relative_path IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Files> fetchByRelativePath(String... values) {
        return fetch(Files.FILES.RELATIVE_PATH, values);
    }

    /**
     * Fetch records that have <code>ext IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Files> fetchByExt(String... values) {
        return fetch(Files.FILES.EXT, values);
    }

    /**
     * Fetch records that have <code>upload_date IN (values)</code>
     */
    public List<cn.edu.kmust.flst.domain.tables.pojos.Files> fetchByUploadDate(Timestamp... values) {
        return fetch(Files.FILES.UPLOAD_DATE, values);
    }
}
