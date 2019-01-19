package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.net.URI;

public class ClassificationDTO {

    @SerializedName("scheme")
    private String scheme;

    @SerializedName("id")
    private String id;

    @SerializedName("description")
    private String description;

    @SerializedName("uri")
    private URI uri;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassificationDTO{");
        sb.append("scheme='").append(scheme).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", uri=").append(uri);
        sb.append('}');
        return sb.toString();
    }
}
