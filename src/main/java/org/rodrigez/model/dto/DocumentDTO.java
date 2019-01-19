package org.rodrigez.model.dto;

import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class DocumentDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("documentType")
    private String documentType;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("format")
    private String format;

    @SerializedName("url")
    private String url;

    @SerializedName("datePublished")
    private Date datePublished;

    @SerializedName("dateModified")
    private Date dateModified;

    @SerializedName("language")
    private String language;

    @SerializedName("documentOf")
    private String documentOf;

    @SerializedName("relatedItem")
    private String relatedItem;

    public String getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    public String getUrl() {
        return url;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public String getLanguage() {
        return language;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", documentType='").append(documentType).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", format='").append(format).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", datePublished=").append(datePublished);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", language='").append(language).append('\'');
        sb.append(", documentOf='").append(documentOf).append('\'');
        sb.append(", relatedItem='").append(relatedItem).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
