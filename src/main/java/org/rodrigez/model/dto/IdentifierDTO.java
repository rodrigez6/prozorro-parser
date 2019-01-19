package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.net.URI;

public class IdentifierDTO {

    @SerializedName("scheme")
    private String scheme;

    @SerializedName("id")
    private String id;

    @SerializedName("legalName")
    private String legalName;

    @SerializedName("uri")
    private URI uri;

    public String getScheme() {
        return scheme;
    }

    public String getId() {
        return id;
    }

    public String getLegalName() {
        return legalName;
    }

    public URI getUri() {
        return uri;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IdentifierDTO{");
        sb.append("scheme='").append(scheme).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", legalName='").append(legalName).append('\'');
        sb.append(", uri=").append(uri);
        sb.append('}');
        return sb.toString();
    }
}
