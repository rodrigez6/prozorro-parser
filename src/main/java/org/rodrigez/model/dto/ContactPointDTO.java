package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class ContactPointDTO {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("telephone")
    private String telephone;

    @SerializedName("faxNumber")
    private String faxNumber;

    @SerializedName("url")
    private URL url;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactPointDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", faxNumber='").append(faxNumber).append('\'');
        sb.append(", url=").append(url);
        sb.append('}');
        return sb.toString();
    }
}
