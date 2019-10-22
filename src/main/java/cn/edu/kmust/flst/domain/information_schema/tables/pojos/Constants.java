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
public class Constants implements Serializable {

    private static final long serialVersionUID = 1093493826;

    private String  constantCatalog;
    private String  constantSchema;
    private String  constantName;
    private Integer dataType;
    private String  remarks;
    private String  sql;
    private Integer id;

    public Constants() {}

    public Constants(Constants value) {
        this.constantCatalog = value.constantCatalog;
        this.constantSchema = value.constantSchema;
        this.constantName = value.constantName;
        this.dataType = value.dataType;
        this.remarks = value.remarks;
        this.sql = value.sql;
        this.id = value.id;
    }

    public Constants(
        String  constantCatalog,
        String  constantSchema,
        String  constantName,
        Integer dataType,
        String  remarks,
        String  sql,
        Integer id
    ) {
        this.constantCatalog = constantCatalog;
        this.constantSchema = constantSchema;
        this.constantName = constantName;
        this.dataType = dataType;
        this.remarks = remarks;
        this.sql = sql;
        this.id = id;
    }

    @Size(max = 2147483647)
    public String getConstantCatalog() {
        return this.constantCatalog;
    }

    public void setConstantCatalog(String constantCatalog) {
        this.constantCatalog = constantCatalog;
    }

    @Size(max = 2147483647)
    public String getConstantSchema() {
        return this.constantSchema;
    }

    public void setConstantSchema(String constantSchema) {
        this.constantSchema = constantSchema;
    }

    @Size(max = 2147483647)
    public String getConstantName() {
        return this.constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
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
        StringBuilder sb = new StringBuilder("Constants (");

        sb.append(constantCatalog);
        sb.append(", ").append(constantSchema);
        sb.append(", ").append(constantName);
        sb.append(", ").append(dataType);
        sb.append(", ").append(remarks);
        sb.append(", ").append(sql);
        sb.append(", ").append(id);

        sb.append(")");
        return sb.toString();
    }
}
