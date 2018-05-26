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
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Menus implements Serializable {

    private static final long serialVersionUID = 369870792;

    private String  menuId;
    private String  menuName;
    private String  menuNameEn;
    private Byte    outLink;
    private String  menuLink;
    private String  menuPid;
    private Integer menuOrder;
    private Byte    menuShow;
    private Byte    menuFixed;
    private Byte    showArticle;
    private String  menuCreator;

    public Menus() {}

    public Menus(Menus value) {
        this.menuId = value.menuId;
        this.menuName = value.menuName;
        this.menuNameEn = value.menuNameEn;
        this.outLink = value.outLink;
        this.menuLink = value.menuLink;
        this.menuPid = value.menuPid;
        this.menuOrder = value.menuOrder;
        this.menuShow = value.menuShow;
        this.menuFixed = value.menuFixed;
        this.showArticle = value.showArticle;
        this.menuCreator = value.menuCreator;
    }

    public Menus(
        String  menuId,
        String  menuName,
        String  menuNameEn,
        Byte    outLink,
        String  menuLink,
        String  menuPid,
        Integer menuOrder,
        Byte    menuShow,
        Byte    menuFixed,
        Byte    showArticle,
        String  menuCreator
    ) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuNameEn = menuNameEn;
        this.outLink = outLink;
        this.menuLink = menuLink;
        this.menuPid = menuPid;
        this.menuOrder = menuOrder;
        this.menuShow = menuShow;
        this.menuFixed = menuFixed;
        this.showArticle = showArticle;
        this.menuCreator = menuCreator;
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
    @Size(max = 100)
    public String getMenuNameEn() {
        return this.menuNameEn;
    }

    public void setMenuNameEn(String menuNameEn) {
        this.menuNameEn = menuNameEn;
    }

    public Byte getOutLink() {
        return this.outLink;
    }

    public void setOutLink(Byte outLink) {
        this.outLink = outLink;
    }

    @NotNull
    @Size(max = 200)
    public String getMenuLink() {
        return this.menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
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

    public Byte getShowArticle() {
        return this.showArticle;
    }

    public void setShowArticle(Byte showArticle) {
        this.showArticle = showArticle;
    }

    @NotNull
    @Size(max = 64)
    public String getMenuCreator() {
        return this.menuCreator;
    }

    public void setMenuCreator(String menuCreator) {
        this.menuCreator = menuCreator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menus (");

        sb.append(menuId);
        sb.append(", ").append(menuName);
        sb.append(", ").append(menuNameEn);
        sb.append(", ").append(outLink);
        sb.append(", ").append(menuLink);
        sb.append(", ").append(menuPid);
        sb.append(", ").append(menuOrder);
        sb.append(", ").append(menuShow);
        sb.append(", ").append(menuFixed);
        sb.append(", ").append(showArticle);
        sb.append(", ").append(menuCreator);

        sb.append(")");
        return sb.toString();
    }
}
