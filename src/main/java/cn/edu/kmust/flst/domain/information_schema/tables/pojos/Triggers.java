/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.information_schema.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.Size;


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
public class Triggers implements Serializable {

    private static final long serialVersionUID = -1230534565;

    private String  triggerCatalog;
    private String  triggerSchema;
    private String  triggerName;
    private String  triggerType;
    private String  tableCatalog;
    private String  tableSchema;
    private String  tableName;
    private Boolean before;
    private String  javaClass;
    private Integer queueSize;
    private Boolean noWait;
    private String  remarks;
    private String  sql;
    private Integer id;

    public Triggers() {}

    public Triggers(Triggers value) {
        this.triggerCatalog = value.triggerCatalog;
        this.triggerSchema = value.triggerSchema;
        this.triggerName = value.triggerName;
        this.triggerType = value.triggerType;
        this.tableCatalog = value.tableCatalog;
        this.tableSchema = value.tableSchema;
        this.tableName = value.tableName;
        this.before = value.before;
        this.javaClass = value.javaClass;
        this.queueSize = value.queueSize;
        this.noWait = value.noWait;
        this.remarks = value.remarks;
        this.sql = value.sql;
        this.id = value.id;
    }

    public Triggers(
        String  triggerCatalog,
        String  triggerSchema,
        String  triggerName,
        String  triggerType,
        String  tableCatalog,
        String  tableSchema,
        String  tableName,
        Boolean before,
        String  javaClass,
        Integer queueSize,
        Boolean noWait,
        String  remarks,
        String  sql,
        Integer id
    ) {
        this.triggerCatalog = triggerCatalog;
        this.triggerSchema = triggerSchema;
        this.triggerName = triggerName;
        this.triggerType = triggerType;
        this.tableCatalog = tableCatalog;
        this.tableSchema = tableSchema;
        this.tableName = tableName;
        this.before = before;
        this.javaClass = javaClass;
        this.queueSize = queueSize;
        this.noWait = noWait;
        this.remarks = remarks;
        this.sql = sql;
        this.id = id;
    }

    @Size(max = 2147483647)
    public String getTriggerCatalog() {
        return this.triggerCatalog;
    }

    public void setTriggerCatalog(String triggerCatalog) {
        this.triggerCatalog = triggerCatalog;
    }

    @Size(max = 2147483647)
    public String getTriggerSchema() {
        return this.triggerSchema;
    }

    public void setTriggerSchema(String triggerSchema) {
        this.triggerSchema = triggerSchema;
    }

    @Size(max = 2147483647)
    public String getTriggerName() {
        return this.triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    @Size(max = 2147483647)
    public String getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Size(max = 2147483647)
    public String getTableCatalog() {
        return this.tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    @Size(max = 2147483647)
    public String getTableSchema() {
        return this.tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    @Size(max = 2147483647)
    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Boolean getBefore() {
        return this.before;
    }

    public void setBefore(Boolean before) {
        this.before = before;
    }

    @Size(max = 2147483647)
    public String getJavaClass() {
        return this.javaClass;
    }

    public void setJavaClass(String javaClass) {
        this.javaClass = javaClass;
    }

    public Integer getQueueSize() {
        return this.queueSize;
    }

    public void setQueueSize(Integer queueSize) {
        this.queueSize = queueSize;
    }

    public Boolean getNoWait() {
        return this.noWait;
    }

    public void setNoWait(Boolean noWait) {
        this.noWait = noWait;
    }

    @Size(max = 2147483647)
    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Size(max = 2147483647)
    public String getSql() {
        return this.sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Triggers (");

        sb.append(triggerCatalog);
        sb.append(", ").append(triggerSchema);
        sb.append(", ").append(triggerName);
        sb.append(", ").append(triggerType);
        sb.append(", ").append(tableCatalog);
        sb.append(", ").append(tableSchema);
        sb.append(", ").append(tableName);
        sb.append(", ").append(before);
        sb.append(", ").append(javaClass);
        sb.append(", ").append(queueSize);
        sb.append(", ").append(noWait);
        sb.append(", ").append(remarks);
        sb.append(", ").append(sql);
        sb.append(", ").append(id);

        sb.append(")");
        return sb.toString();
    }
}