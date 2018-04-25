/*
 * This file is generated by jOOQ.
 */
package cn.edu.kmust.flst.domain.tables;


import cn.edu.kmust.flst.domain.Flst;
import cn.edu.kmust.flst.domain.Indexes;
import cn.edu.kmust.flst.domain.Keys;
import cn.edu.kmust.flst.domain.tables.records.BannerRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


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
public class Banner extends TableImpl<BannerRecord> {

    private static final long serialVersionUID = 340335500;

    /**
     * The reference instance of <code>flst.banner</code>
     */
    public static final Banner BANNER = new Banner();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BannerRecord> getRecordType() {
        return BannerRecord.class;
    }

    /**
     * The column <code>flst.banner.banner_id</code>.
     */
    public final TableField<BannerRecord, Integer> BANNER_ID = createField("banner_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>flst.banner.banner_link</code>.
     */
    public final TableField<BannerRecord, String> BANNER_LINK = createField("banner_link", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>flst.banner.banner_date</code>.
     */
    public final TableField<BannerRecord, Timestamp> BANNER_DATE = createField("banner_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>flst.banner.banner_show</code>.
     */
    public final TableField<BannerRecord, Byte> BANNER_SHOW = createField("banner_show", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>flst.banner.menu_id</code>.
     */
    public final TableField<BannerRecord, String> MENU_ID = createField("menu_id", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>flst.banner.username</code>.
     */
    public final TableField<BannerRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>flst.banner</code> table reference
     */
    public Banner() {
        this(DSL.name("banner"), null);
    }

    /**
     * Create an aliased <code>flst.banner</code> table reference
     */
    public Banner(String alias) {
        this(DSL.name(alias), BANNER);
    }

    /**
     * Create an aliased <code>flst.banner</code> table reference
     */
    public Banner(Name alias) {
        this(alias, BANNER);
    }

    private Banner(Name alias, Table<BannerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Banner(Name alias, Table<BannerRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.BANNER_MENU_ID, Indexes.BANNER_PRIMARY, Indexes.BANNER_USERNAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<BannerRecord, Integer> getIdentity() {
        return Keys.IDENTITY_BANNER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BannerRecord> getPrimaryKey() {
        return Keys.KEY_BANNER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BannerRecord>> getKeys() {
        return Arrays.<UniqueKey<BannerRecord>>asList(Keys.KEY_BANNER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<BannerRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BannerRecord, ?>>asList(Keys.BANNER_IBFK_1, Keys.BANNER_IBFK_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Banner as(String alias) {
        return new Banner(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Banner as(Name alias) {
        return new Banner(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Banner rename(String name) {
        return new Banner(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Banner rename(Name name) {
        return new Banner(name, null);
    }
}
