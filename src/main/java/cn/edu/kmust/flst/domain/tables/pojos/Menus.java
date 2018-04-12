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
public class Menus implements Serializable {

    private static final long serialVersionUID = 2019323803;

    private String  menuId;
    private String  menuName;
    private String  menuNameEn;
    private String  menuLink;
    private String  menuLinkEn;
    private String  menuPid;
    private Integer menuOrder;
    private Byte    menuShow;
    private Byte    menuFixed;

    public Menus() {}

    public Menus(Menus value) {
        this.menuId = value.menuId;
        this.menuName = value.menuName;
        this.menuNameEn = value.menuNameEn;
        this.menuLink = value.menuLink;
        this.menuLinkEn = value.menuLinkEn;
        this.menuPid = value.menuPid;
        this.menuOrder = value.menuOrder;
        this.menuShow = value.menuShow;
        this.menuFixed = value.menuFixed;
    }

    public Menus(
        String  menuId,
        String  menuName,
        String  menuNameEn,
        String  menuLink,
        String  menuLinkEn,
        String  menuPid,
        Integer menuOrder,
        Byte    menuShow,
        Byte    menuFixed
    ) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuNameEn = menuNameEn;
        this.menuLink = menuLink;
        this.menuLinkEn = menuLinkEn;
        this.menuPid = menuPid;
        this.menuOrder = menuOrder;
        this.menuShow = menuShow;
        this.menuFixed = menuFixed;
    }

    @NotNull
    @Size(max = 64)
    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @NotNull
    @Size(max = 20)
    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @NotNull
    @Size(max = 50)
    public String getMenuNameEn() {
        return this.menuNameEn;
    }

    public void setMenuNameEn(String menuNameEn) {
        this.menuNameEn = menuNameEn;
    }

    @NotNull
    @Size(max = 200)
    public String getMenuLink() {
        return this.menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    @NotNull
    @Size(max = 200)
    public String getMenuLinkEn() {
        return this.menuLinkEn;
    }

    public void setMenuLinkEn(String menuLinkEn) {
        this.menuLinkEn = menuLinkEn;
    }

    @Size(max = 64)
    public String getMenuPid() {
        return this.menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid;
    }

    @NotNull
    public Integer getMenuOrder() {
        return this.menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Byte getMenuShow() {
        return this.menuShow;
    }

    public void setMenuShow(Byte menuShow) {
        this.menuShow = menuShow;
    }

    public Byte getMenuFixed() {
        return this.menuFixed;
    }

    public void setMenuFixed(Byte menuFixed) {
        this.menuFixed = menuFixed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menus (");

        sb.append(menuId);
        sb.append(", ").append(menuName);
        sb.append(", ").append(menuNameEn);
        sb.append(", ").append(menuLink);
        sb.append(", ").append(menuLinkEn);
        sb.append(", ").append(menuPid);
        sb.append(", ").append(menuOrder);
        sb.append(", ").append(menuShow);
        sb.append(", ").append(menuFixed);

        sb.append(")");
        return sb.toString();
    }
}
