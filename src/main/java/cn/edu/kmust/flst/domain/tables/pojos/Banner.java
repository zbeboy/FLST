/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

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
public class Banner implements Serializable {

    private static final long serialVersionUID = -2145899991;

    private Integer   bannerId;
    private String    bannerLink;
    private Timestamp bannerDate;
    private Byte      bannerShow;
    private String    bannerTitle;
    private String    bannerTitleEn;
    private String    bannerBrief;
    private String    bannerBriefEn;
    private String    menuId;
    private String    bannerCreator;

    public Banner() {}

    public Banner(Banner value) {
        this.bannerId = value.bannerId;
        this.bannerLink = value.bannerLink;
        this.bannerDate = value.bannerDate;
        this.bannerShow = value.bannerShow;
        this.bannerTitle = value.bannerTitle;
        this.bannerTitleEn = value.bannerTitleEn;
        this.bannerBrief = value.bannerBrief;
        this.bannerBriefEn = value.bannerBriefEn;
        this.menuId = value.menuId;
        this.bannerCreator = value.bannerCreator;
    }

    public Banner(
        Integer   bannerId,
        String    bannerLink,
        Timestamp bannerDate,
        Byte      bannerShow,
        String    bannerTitle,
        String    bannerTitleEn,
        String    bannerBrief,
        String    bannerBriefEn,
        String    menuId,
        String    bannerCreator
    ) {
        this.bannerId = bannerId;
        this.bannerLink = bannerLink;
        this.bannerDate = bannerDate;
        this.bannerShow = bannerShow;
        this.bannerTitle = bannerTitle;
        this.bannerTitleEn = bannerTitleEn;
        this.bannerBrief = bannerBrief;
        this.bannerBriefEn = bannerBriefEn;
        this.menuId = menuId;
        this.bannerCreator = bannerCreator;
    }

    public Integer getBannerId() {
        return this.bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    @NotNull
    @Size(max = 200)
    public String getBannerLink() {
        return this.bannerLink;
    }

    public void setBannerLink(String bannerLink) {
        this.bannerLink = bannerLink;
    }

    @NotNull
    public Timestamp getBannerDate() {
        return this.bannerDate;
    }

    public void setBannerDate(Timestamp bannerDate) {
        this.bannerDate = bannerDate;
    }

    public Byte getBannerShow() {
        return this.bannerShow;
    }

    public void setBannerShow(Byte bannerShow) {
        this.bannerShow = bannerShow;
    }

    @Size(max = 30)
    public String getBannerTitle() {
        return this.bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    @Size(max = 50)
    public String getBannerTitleEn() {
        return this.bannerTitleEn;
    }

    public void setBannerTitleEn(String bannerTitleEn) {
        this.bannerTitleEn = bannerTitleEn;
    }

    @Size(max = 50)
    public String getBannerBrief() {
        return this.bannerBrief;
    }

    public void setBannerBrief(String bannerBrief) {
        this.bannerBrief = bannerBrief;
    }

    @Size(max = 80)
    public String getBannerBriefEn() {
        return this.bannerBriefEn;
    }

    public void setBannerBriefEn(String bannerBriefEn) {
        this.bannerBriefEn = bannerBriefEn;
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
    @Size(max = 64)
    public String getBannerCreator() {
        return this.bannerCreator;
    }

    public void setBannerCreator(String bannerCreator) {
        this.bannerCreator = bannerCreator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Banner (");

        sb.append(bannerId);
        sb.append(", ").append(bannerLink);
        sb.append(", ").append(bannerDate);
        sb.append(", ").append(bannerShow);
        sb.append(", ").append(bannerTitle);
        sb.append(", ").append(bannerTitleEn);
        sb.append(", ").append(bannerBrief);
        sb.append(", ").append(bannerBriefEn);
        sb.append(", ").append(menuId);
        sb.append(", ").append(bannerCreator);

        sb.append(")");
        return sb.toString();
    }
}
