package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class CancellationDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("reason")
    private String reason;

    @SerializedName("status")
    private String status;

    @SerializedName("documents")
    private List<DocumentDTO> documentDTOList;

    @SerializedName("date")
    private Date date;

    @SerializedName("cancellationOf")
    private String cancellationOf;

    @SerializedName("relatedLot")
    private String relatedLot;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancellationDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", reason='").append(reason).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", documentDTOList=").append(documentDTOList);
        sb.append(", date=").append(date);
        sb.append(", cancellationOf='").append(cancellationOf).append('\'');
        sb.append(", relatedLot='").append(relatedLot).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
