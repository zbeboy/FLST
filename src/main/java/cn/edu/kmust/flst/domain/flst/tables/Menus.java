/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.flst.tables;


import cn.edu.kmust.flst.domain.flst.Flst;
import cn.edu.kmust.flst.domain.flst.Indexes;
import cn.edu.kmust.flst.domain.flst.Keys;
import cn.edu.kmust.flst.domain.flst.tables.records.MenusRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Menus extends TableImpl<MenusRecord> {

    private static final long serialVersionUID = -1622779362;

    /**
     * The reference instance of <code>FLST.MENUS</code>
     */
    public static final Menus MENUS = new Menus();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MenusRecord> getRecordType() {
        return MenusRecord.class;
    }

    /**
     * The column <code>FLST.MENUS.MENU_ID</code>.
     */
    public final TableField<MenusRecord, String> MENU_ID = createField("MENU_ID", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_NAME</code>.
     */
    public final TableField<MenusRecord, String> MENU_NAME = createField("MENU_NAME", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_NAME_EN</code>.
     */
    public final TableField<MenusRecord, String> MENU_NAME_EN = createField("MENU_NAME_EN", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>FLST.MENUS.OUT_LINK</code>.
     */
    public final TableField<MenusRecord, Boolean> OUT_LINK = createField("OUT_LINK", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_LINK</code>.
     */
    public final TableField<MenusRecord, String> MENU_LINK = createField("MENU_LINK", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_PID</code>.
     */
    public final TableField<MenusRecord, String> MENU_PID = createField("MENU_PID", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_ORDER</code>.
     */
    public final TableField<MenusRecord, Integer> MENU_ORDER = createField("MENU_ORDER", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_SHOW</code>.
     */
    public final TableField<MenusRecord, Boolean> MENU_SHOW = createField("MENU_SHOW", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_FIXED</code>.
     */
    public final TableField<MenusRecord, Boolean> MENU_FIXED = createField("MENU_FIXED", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>FLST.MENUS.SHOW_ARTICLE</code>.
     */
    public final TableField<MenusRecord, Boolean> SHOW_ARTICLE = createField("SHOW_ARTICLE", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>FLST.MENUS.ORDER_WAY</code>.
     */
    public final TableField<MenusRecord, Integer> ORDER_WAY = createField("ORDER_WAY", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>FLST.MENUS.MENU_CREATOR</code>.
     */
    public final TableField<MenusRecord, String> MENU_CREATOR = createField("MENU_CREATOR", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>FLST.MENUS</code> table reference
     */
    public Menus() {
        this(DSL.name("MENUS"), null);
    }

    /**
     * Create an aliased <code>FLST.MENUS</code> table reference
     */
    public Menus(String alias) {
        this(DSL.name(alias), MENUS);
    }

    /**
     * Create an aliased <code>FLST.MENUS</code> table reference
     */
    public Menus(Name alias) {
        this(alias, MENUS);
    }

    private Menus(Name alias, Table<MenusRecord> aliased) {
        this(alias, aliased, null);
    }

    private Menus(Name alias, Table<MenusRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Flst.FLST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CONSTRAINT_INDEX_4, Indexes.CONSTRAINT_INDEX_45, Indexes.CONSTRAINT_INDEX_45D, Indexes.PRIMARY_KEY_45);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MenusRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_45;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MenusRecord>> getKeys() {
        return Arrays.<UniqueKey<MenusRecord>>asList(Keys.CONSTRAINT_45, Keys.CONSTRAINT_45D, Keys.CONSTRAINT_45D9);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MenusRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MenusRecord, ?>>asList(Keys.CONSTRAINT_45D9E);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Menus as(String alias) {
        return new Menus(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Menus as(Name alias) {
        return new Menus(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Menus rename(String name) {
        return new Menus(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Menus rename(Name name) {
        return new Menus(name, null);
    }
}