/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables;


import cn.edu.kmust.flst.domain.Flst;
import cn.edu.kmust.flst.domain.Indexes;
import cn.edu.kmust.flst.domain.Keys;
import cn.edu.kmust.flst.domain.tables.records.MenusRecord;

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

    private static final long serialVersionUID = -1666773605;

    /**
     * The reference instance of <code>flst.menus</code>
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
     * The column <code>flst.menus.menu_id</code>.
     */
    public final TableField<MenusRecord, String> MENU_ID = createField("menu_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>flst.menus.menu_name</code>.
     */
    public final TableField<MenusRecord, String> MENU_NAME = createField("menu_name", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>flst.menus.menu_name_en</code>.
     */
    public final TableField<MenusRecord, String> MENU_NAME_EN = createField("menu_name_en", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>flst.menus.out_link</code>.
     */
    public final TableField<MenusRecord, Byte> OUT_LINK = createField("out_link", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>flst.menus.menu_link</code>.
     */
    public final TableField<MenusRecord, String> MENU_LINK = createField("menu_link", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>flst.menus.menu_pid</code>.
     */
    public final TableField<MenusRecord, String> MENU_PID = createField("menu_pid", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>flst.menus.menu_order</code>.
     */
    public final TableField<MenusRecord, Integer> MENU_ORDER = createField("menu_order", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>flst.menus.menu_show</code>.
     */
    public final TableField<MenusRecord, Byte> MENU_SHOW = createField("menu_show", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>flst.menus.menu_fixed</code>.
     */
    public final TableField<MenusRecord, Byte> MENU_FIXED = createField("menu_fixed", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>flst.menus.show_article</code>.
     */
    public final TableField<MenusRecord, Byte> SHOW_ARTICLE = createField("show_article", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>flst.menus.order_way</code>.
     */
    public final TableField<MenusRecord, Integer> ORDER_WAY = createField("order_way", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>flst.menus.menu_creator</code>.
     */
    public final TableField<MenusRecord, String> MENU_CREATOR = createField("menu_creator", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>flst.menus</code> table reference
     */
    public Menus() {
        this(DSL.name("menus"), null);
    }

    /**
     * Create an aliased <code>flst.menus</code> table reference
     */
    public Menus(String alias) {
        this(DSL.name(alias), MENUS);
    }

    /**
     * Create an aliased <code>flst.menus</code> table reference
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
        return Arrays.<Index>asList(Indexes.MENUS_MENU_CREATOR, Indexes.MENUS_MENU_NAME, Indexes.MENUS_MENU_NAME_EN, Indexes.MENUS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MenusRecord> getPrimaryKey() {
        return Keys.KEY_MENUS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MenusRecord>> getKeys() {
        return Arrays.<UniqueKey<MenusRecord>>asList(Keys.KEY_MENUS_PRIMARY, Keys.KEY_MENUS_MENU_NAME, Keys.KEY_MENUS_MENU_NAME_EN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MenusRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MenusRecord, ?>>asList(Keys.MENUS_IBFK_1);
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
