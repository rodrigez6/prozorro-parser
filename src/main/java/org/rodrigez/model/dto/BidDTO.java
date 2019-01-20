package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.net.URL;
import java.util.List;

public class BidDTO {

    @SerializedName("tenderers")
    private List<OrganizationDTO> organizationDTOList = new ArrayList<>();

    @SerializedName("date")
    private Date date;

    @SerializedName("id")
    private String id;

    @SerializedName("status")
    private String status;

    @SerializedName("value")
    private ValueDTO valueDTO;

    @SerializedName("documents")
    private List<DocumentDTO> documentDTOList = new ArrayList<>();

    @SerializedName("parameters")
    private List<ParameterDTO> parameterDTOList = new ArrayList<>();

    @SerializedName("lotValues")
    private List<LotValueDTO> lotValueDTOList = new ArrayList<>();

    @SerializedName("participationUrl")
    private URL participationUrl;

    public List<OrganizationDTO> getOrganizationDTOList() {
        return organizationDTOList;
    }

    public Date getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public ValueDTO getValueDTO() {
        return valueDTO;
    }

    public List<DocumentDTO> getDocumentDTOList() {
        return documentDTOList;
    }

    public List<ParameterDTO> getParameterDTOList() {
        return parameterDTOList;
    }

    public List<LotValueDTO> getLotValueDTOList() {
        return lotValueDTOList;
    }

    public URL getParticipationUrl() {
        return participationUrl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BidDTO{");
        sb.append("organizationDTOList=").append(organizationDTOList);
        sb.append(", date=").append(date);
        sb.append(", id='").append(id).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", valueDTO=").append(valueDTO);
        sb.append(", documentDTOList=").append(documentDTOList);
        sb.append(", parameterDTOList=").append(parameterDTOList);
        sb.append(", lotValueDTOList=").append(lotValueDTOList);
        sb.append(", participationUrl=").append(participationUrl);
        sb.append('}');
        return sb.toString();
    }
}
