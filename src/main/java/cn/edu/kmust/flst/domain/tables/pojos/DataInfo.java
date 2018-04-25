/*
 * This file is generated by jOOQ.
 */
package cn.edu.kmust.flst.domain.tables.pojos;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


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
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class DataInfo implements Serializable {

    private static final long serialVersionUID = -128705490;

    private String dataKey;
    private String dataValue;

    public DataInfo() {
    }

    public DataInfo(DataInfo value) {
        this.dataKey = value.dataKey;
        this.dataValue = value.dataValue;
    }

    public DataInfo(
            String dataKey,
            String dataValue
    ) {
        this.dataKey = dataKey;
        this.dataValue = dataValue;
    }

    @NotNull
    @Size(max = 200)
    public String getDataKey() {
        return this.dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    @Size(max = 200)
    public String getDataValue() {
        return this.dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DataInfo (");

        sb.append(dataKey);
        sb.append(", ").append(dataValue);

        sb.append(")");
        return sb.toString();
    }
}
