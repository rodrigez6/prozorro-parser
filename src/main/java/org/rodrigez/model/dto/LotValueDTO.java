package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.net.URL;

public class LotValueDTO {

    @SerializedName("value")
    private ValueDTO valueDTO;

    @SerializedName("relatedLot")
    private String relatedLot;

    @SerializedName("date")
    private Date date;

    @SerializedName("participationUrl")
    private URL participationUrl;

    public ValueDTO getValueDTO() {
        return valueDTO;
    }

    public String getRelatedLot() {
        return relatedLot;
    }

    public Date getDate() {
        return date;
    }

    public URL getParticipationUrl() {
        return participationUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LotValueDTO{");
        sb.append("valueDTO=").append(valueDTO);
        sb.append(", relatedLot='").append(relatedLot).append('\'');
        sb.append(", date=").append(date);
        sb.append(", participationUrl=").append(participationUrl);
        sb.append('}');
        return sb.toString();
    }
}
