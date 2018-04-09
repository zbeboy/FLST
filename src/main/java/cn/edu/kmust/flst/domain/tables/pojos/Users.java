/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class Users implements Serializable {

    private static final long serialVersionUID = -1008330725;

    private String username;
    private String password;
    private Byte   enabled;

    public Users() {}

    public Users(Users value) {
        this.username = value.username;
        this.password = value.password;
        this.enabled = value.enabled;
    }

    public Users(
        String username,
        String password,
        Byte   enabled
    ) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Size(max = 300)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    public Byte getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Users (");

        sb.append(username);
        sb.append(", ").append(password);
        sb.append(", ").append(enabled);

        sb.append(")");
        return sb.toString();
    }
}