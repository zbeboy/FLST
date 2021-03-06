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
public class InDoubt implements Serializable {

    private static final long serialVersionUID = -158890533;

    private String transaction;
    private String state;

    public InDoubt() {}

    public InDoubt(InDoubt value) {
        this.transaction = value.transaction;
        this.state = value.state;
    }

    public InDoubt(
        String transaction,
        String state
    ) {
        this.transaction = transaction;
        this.state = state;
    }

    @Size(max = 2147483647)
    public String getTransaction() {
        return this.transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    @Size(max = 2147483647)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("InDoubt (");

        sb.append(transaction);
        sb.append(", ").append(state);

        sb.append(")");
        return sb.toString();
    }
}
