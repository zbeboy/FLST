/*
 * This file is generated by jOOQ.
 */
package cn.edu.kmust.flst.domain.tables.pojos;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;


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
public class ArticleEn implements Serializable {

    private static final long serialVersionUID = 2035812645;

    private Integer articleId;
    private String articleTitle;
    private String articleBrief;
    private String articleCover;
    private String articleContent;
    private Timestamp articleDate;
    private Integer articleClicks;
    private String username;
    private Integer articleSources;
    private String articleSourcesName;
    private String articleSourcesLink;
    private String menuId;

    public ArticleEn() {
    }

    public ArticleEn(ArticleEn value) {
        this.articleId = value.articleId;
        this.articleTitle = value.articleTitle;
        this.articleBrief = value.articleBrief;
        this.articleCover = value.articleCover;
        this.articleContent = value.articleContent;
        this.articleDate = value.articleDate;
        this.articleClicks = value.articleClicks;
        this.username = value.username;
        this.articleSources = value.articleSources;
        this.articleSourcesName = value.articleSourcesName;
        this.articleSourcesLink = value.articleSourcesLink;
        this.menuId = value.menuId;
    }

    public ArticleEn(
            Integer articleId,
            String articleTitle,
            String articleBrief,
            String articleCover,
            String articleContent,
            Timestamp articleDate,
            Integer articleClicks,
            String username,
            Integer articleSources,
            String articleSourcesName,
            String articleSourcesLink,
            String menuId
    ) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleBrief = articleBrief;
        this.articleCover = articleCover;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleClicks = articleClicks;
        this.username = username;
        this.articleSources = articleSources;
        this.articleSourcesName = articleSourcesName;
        this.articleSourcesLink = articleSourcesLink;
        this.menuId = menuId;
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @NotNull
    @Size(max = 200)
    public String getArticleTitle() {
        return this.articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Size(max = 300)
    public String getArticleBrief() {
        return this.articleBrief;
    }

    public void setArticleBrief(String articleBrief) {
        this.articleBrief = articleBrief;
    }

    @Size(max = 200)
    public String getArticleCover() {
        return this.articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    @NotNull
    @Size(max = 65535)
    public String getArticleContent() {
        return this.articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @NotNull
    public Timestamp getArticleDate() {
        return this.articleDate;
    }

    public void setArticleDate(Timestamp articleDate) {
        this.articleDate = articleDate;
    }

    public Integer getArticleClicks() {
        return this.articleClicks;
    }

    public void setArticleClicks(Integer articleClicks) {
        this.articleClicks = articleClicks;
    }

    @NotNull
    @Size(max = 64)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getArticleSources() {
        return this.articleSources;
    }

    public void setArticleSources(Integer articleSources) {
        this.articleSources = articleSources;
    }

    @Size(max = 100)
    public String getArticleSourcesName() {
        return this.articleSourcesName;
    }

    public void setArticleSourcesName(String articleSourcesName) {
        this.articleSourcesName = articleSourcesName;
    }

    @Size(max = 200)
    public String getArticleSourcesLink() {
        return this.articleSourcesLink;
    }

    public void setArticleSourcesLink(String articleSourcesLink) {
        this.articleSourcesLink = articleSourcesLink;
    }

    @NotNull
    @Size(max = 64)
    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ArticleEn (");

        sb.append(articleId);
        sb.append(", ").append(articleTitle);
        sb.append(", ").append(articleBrief);
        sb.append(", ").append(articleCover);
        sb.append(", ").append(articleContent);
        sb.append(", ").append(articleDate);
        sb.append(", ").append(articleClicks);
        sb.append(", ").append(username);
        sb.append(", ").append(articleSources);
        sb.append(", ").append(articleSourcesName);
        sb.append(", ").append(articleSourcesLink);
        sb.append(", ").append(menuId);

        sb.append(")");
        return sb.toString();
    }
}
