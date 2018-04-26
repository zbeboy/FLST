/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.records;


import cn.edu.kmust.flst.domain.tables.Menus;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


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
public class MenusRecord extends UpdatableRecordImpl<MenusRecord> implements Record11<String, String, String, Byte, String, String, Integer, Byte, Byte, Byte, String> {

    private static final long serialVersionUID = -1934910987;

    /**
     * Setter for <code>flst.menus.menu_id</code>.
     */
    public void setMenuId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>flst.menus.menu_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getMenuId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>flst.menus.menu_name</code>.
     */
    public void setMenuName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>flst.menus.menu_name</code>.
     */
    @NotNull
    @Size(max = 20)
    public String getMenuName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>flst.menus.menu_name_en</code>.
     */
    public void setMenuNameEn(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>flst.menus.menu_name_en</code>.
     */
    @NotNull
    @Size(max = 100)
    public String getMenuNameEn() {
        return (String) get(2);
    }

    /**
     * Setter for <code>flst.menus.out_link</code>.
     */
    public void setOutLink(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>flst.menus.out_link</code>.
     */
    public Byte getOutLink() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>flst.menus.menu_link</code>.
     */
    public void setMenuLink(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>flst.menus.menu_link</code>.
     */
    @NotNull
    @Size(max = 200)
    public String getMenuLink() {
        return (String) get(4);
    }

    /**
     * Setter for <code>flst.menus.menu_pid</code>.
     */
    public void setMenuPid(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>flst.menus.menu_pid</code>.
     */
    @Size(max = 64)
    public String getMenuPid() {
        return (String) get(5);
    }

    /**
     * Setter for <code>flst.menus.menu_order</code>.
     */
    public void setMenuOrder(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>flst.menus.menu_order</code>.
     */
    @NotNull
    public Integer getMenuOrder() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>flst.menus.menu_show</code>.
     */
    public void setMenuShow(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>flst.menus.menu_show</code>.
     */
    public Byte getMenuShow() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>flst.menus.menu_fixed</code>.
     */
    public void setMenuFixed(Byte value) {
        set(8, value);
    }

    /**
     * Getter for <code>flst.menus.menu_fixed</code>.
     */
    public Byte getMenuFixed() {
        return (Byte) get(8);
    }

    /**
     * Setter for <code>flst.menus.show_article</code>.
     */
    public void setShowArticle(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>flst.menus.show_article</code>.
     */
    public Byte getShowArticle() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>flst.menus.username</code>.
     */
    public void setUsername(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>flst.menus.username</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return (String) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, Byte, String, String, Integer, Byte, Byte, Byte, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, Byte, String, String, Integer, Byte, Byte, Byte, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Menus.MENUS.MENU_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Menus.MENUS.MENU_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Menus.MENUS.MENU_NAME_EN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Menus.MENUS.OUT_LINK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Menus.MENUS.MENU_LINK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Menus.MENUS.MENU_PID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Menus.MENUS.MENU_ORDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Menus.MENUS.MENU_SHOW;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field9() {
        return Menus.MENUS.MENU_FIXED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field10() {
        return Menus.MENUS.SHOW_ARTICLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Menus.MENUS.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getMenuId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getMenuName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getMenuNameEn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component4() {
        return getOutLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getMenuLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getMenuPid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getMenuOrder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component8() {
        return getMenuShow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component9() {
        return getMenuFixed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component10() {
        return getShowArticle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getMenuId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getMenuName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getMenuNameEn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getOutLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMenuLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getMenuPid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getMenuOrder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getMenuShow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value9() {
        return getMenuFixed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value10() {
        return getShowArticle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value1(String value) {
        setMenuId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value2(String value) {
        setMenuName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value3(String value) {
        setMenuNameEn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value4(Byte value) {
        setOutLink(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value5(String value) {
        setMenuLink(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value6(String value) {
        setMenuPid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value7(Integer value) {
        setMenuOrder(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value8(Byte value) {
        setMenuShow(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value9(Byte value) {
        setMenuFixed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value10(Byte value) {
        setShowArticle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord value11(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MenusRecord values(String value1, String value2, String value3, Byte value4, String value5, String value6, Integer value7, Byte value8, Byte value9, Byte value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MenusRecord
     */
    public MenusRecord() {
        super(Menus.MENUS);
    }

    /**
     * Create a detached, initialised MenusRecord
     */
    public MenusRecord(String menuId, String menuName, String menuNameEn, Byte outLink, String menuLink, String menuPid, Integer menuOrder, Byte menuShow, Byte menuFixed, Byte showArticle, String username) {
        super(Menus.MENUS);

        set(0, menuId);
        set(1, menuName);
        set(2, menuNameEn);
        set(3, outLink);
        set(4, menuLink);
        set(5, menuPid);
        set(6, menuOrder);
        set(7, menuShow);
        set(8, menuFixed);
        set(9, showArticle);
        set(10, username);
    }
}
