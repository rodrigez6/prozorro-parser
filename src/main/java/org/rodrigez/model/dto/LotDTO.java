package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.net.URL;

public class LotDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("value")
    private ValueDTO valueDTO;

    @SerializedName("guarantee")
    private GuaranteeDTO guaranteeDTO;

    @SerializedName("date")
    private Date date;

    @SerializedName("minimalStep")
    private ValueDTO minimalStep;

    @SerializedName("auctionPeriod")
    private PeriodDTO auctionPeriodDTO;

    @SerializedName("auctionUrl")
    private URL url;

    @SerializedName("status")
    private String status;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ValueDTO getValueDTO() {
        return valueDTO;
    }

    public GuaranteeDTO getGuaranteeDTO() {
        return guaranteeDTO;
    }

    public Date getDate() {
        return date;
    }

    public ValueDTO getMinimalStep() {
        return minimalStep;
    }

    public PeriodDTO getAuctionPeriodDTO() {
        return auctionPeriodDTO;
    }

    public URL getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LotDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", valueDTO=").append(valueDTO);
        sb.append(", guaranteeDTO=").append(guaranteeDTO);
        sb.append(", date=").append(date);
        sb.append(", minimalStep=").append(minimalStep);
        sb.append(", auctionPeriodDTO=").append(auctionPeriodDTO);
        sb.append(", url=").append(url);
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
