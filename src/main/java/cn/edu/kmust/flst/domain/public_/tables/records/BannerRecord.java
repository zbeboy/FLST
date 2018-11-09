/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.public_.tables.records;


import cn.edu.kmust.flst.domain.public_.tables.Banner;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


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
public class BannerRecord extends UpdatableRecordImpl<BannerRecord> implements Record10<Integer, String, Timestamp, Boolean, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1770347866;

    /**
     * Setter for <code>public.banner.banner_id</code>.
     */
    public void setBannerId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.banner.banner_id</code>.
     */
    public Integer getBannerId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.banner.banner_link</code>.
     */
    public void setBannerLink(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.banner.banner_link</code>.
     */
    @NotNull
    @Size(max = 200)
    public String getBannerLink() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.banner.banner_date</code>.
     */
    public void setBannerDate(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.banner.banner_date</code>.
     */
    @NotNull
    public Timestamp getBannerDate() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>public.banner.banner_show</code>.
     */
    public void setBannerShow(Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.banner.banner_show</code>.
     */
    public Boolean getBannerShow() {
        return (Boolean) get(3);
    }

    /**
     * Setter for <code>public.banner.banner_title</code>.
     */
    public void setBannerTitle(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.banner.banner_title</code>.
     */
    @Size(max = 30)
    public String getBannerTitle() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.banner.banner_title_en</code>.
     */
    public void setBannerTitleEn(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.banner.banner_title_en</code>.
     */
    @Size(max = 50)
    public String getBannerTitleEn() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.banner.banner_brief</code>.
     */
    public void setBannerBrief(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.banner.banner_brief</code>.
     */
    @Size(max = 50)
    public String getBannerBrief() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.banner.banner_brief_en</code>.
     */
    public void setBannerBriefEn(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.banner.banner_brief_en</code>.
     */
    @Size(max = 80)
    public String getBannerBriefEn() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.banner.menu_id</code>.
     */
    public void setMenuId(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.banner.menu_id</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getMenuId() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.banner.banner_creator</code>.
     */
    public void setBannerCreator(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.banner.banner_creator</code>.
     */
    @NotNull
    @Size(max = 64)
    public String getBannerCreator() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, Timestamp, Boolean, String, String, String, String, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, Timestamp, Boolean, String, String, String, String, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Banner.BANNER.BANNER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Banner.BANNER.BANNER_LINK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Banner.BANNER.BANNER_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field4() {
        return Banner.BANNER.BANNER_SHOW;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Banner.BANNER.BANNER_TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Banner.BANNER.BANNER_TITLE_EN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Banner.BANNER.BANNER_BRIEF;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Banner.BANNER.BANNER_BRIEF_EN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Banner.BANNER.MENU_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Banner.BANNER.BANNER_CREATOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getBannerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getBannerLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getBannerDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component4() {
        return getBannerShow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getBannerTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getBannerTitleEn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getBannerBrief();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getBannerBriefEn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getMenuId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getBannerCreator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getBannerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getBannerLink();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getBannerDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value4() {
        return getBannerShow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getBannerTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getBannerTitleEn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getBannerBrief();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getBannerBriefEn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getMenuId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getBannerCreator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value1(Integer value) {
        setBannerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value2(String value) {
        setBannerLink(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value3(Timestamp value) {
        setBannerDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value4(Boolean value) {
        setBannerShow(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value5(String value) {
        setBannerTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value6(String value) {
        setBannerTitleEn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value7(String value) {
        setBannerBrief(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value8(String value) {
        setBannerBriefEn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value9(String value) {
        setMenuId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord value10(String value) {
        setBannerCreator(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BannerRecord values(Integer value1, String value2, Timestamp value3, Boolean value4, String value5, String value6, String value7, String value8, String value9, String value10) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BannerRecord
     */
    public BannerRecord() {
        super(Banner.BANNER);
    }

    /**
     * Create a detached, initialised BannerRecord
     */
    public BannerRecord(Integer bannerId, String bannerLink, Timestamp bannerDate, Boolean bannerShow, String bannerTitle, String bannerTitleEn, String bannerBrief, String bannerBriefEn, String menuId, String bannerCreator) {
        super(Banner.BANNER);

        set(0, bannerId);
        set(1, bannerLink);
        set(2, bannerDate);
        set(3, bannerShow);
        set(4, bannerTitle);
        set(5, bannerTitleEn);
        set(6, bannerBrief);
        set(7, bannerBriefEn);
        set(8, menuId);
        set(9, bannerCreator);
    }
}
