package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class ComplaintDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("author")
    private OrganizationDTO author;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("date")
    private Date date;

    @SerializedName("dateCancelled")
    private Date dateCancelled;

    @SerializedName("dateSubmitted")
    private Date dateSubmitted;

    @SerializedName("dateAnswered")
    private Date dateAnswered;

    @SerializedName("dateEscalated")
    private Date dateEscalated;

    @SerializedName("dateDecision")
    private Date dateDecision;

    @SerializedName("status")
    private String status;

    @SerializedName("type")
    private String type;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("resolutionType")
    private String resolutionType;

    @SerializedName("satisfied")
    private String satisfied;

    @SerializedName("decision")
    private String decision;

    @SerializedName("cancellationReason")
    private String cancellationReason;

    @SerializedName("documents")
    private List<DocumentDTO> documentDTOList;

    @SerializedName("relatedLot")
    private String relatedLot;

    @SerializedName("tendererAction")
    private String tendererAction;

    @SerializedName("tendererActionDate")
    private Date tendererActionDate;

    public String getId() {
        return id;
    }

    public OrganizationDTO getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public Date getDateAnswered() {
        return dateAnswered;
    }

    public Date getDateEscalated() {
        return dateEscalated;
    }

    public Date getDateDecision() {
        return dateDecision;
    }

    public Date getDateCancelled() {
        return dateCancelled;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getResolution() {
        return resolution;
    }

    public String getResolutionType() {
        return resolutionType;
    }

    public String getSatisfied() {
        return satisfied;
    }

    public String getDecision() {
        return decision;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public List<DocumentDTO> getDocumentDTOList() {
        return documentDTOList;
    }

    public String getRelatedLot() {
        return relatedLot;
    }

    public String getTendererAction() {
        return tendererAction;
    }

    public Date getTendererActionDate() {
        return tendererActionDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ComplaintDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", author=").append(author);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", date=").append(date);
        sb.append(", dateSubmitted=").append(dateSubmitted);
        sb.append(", dateAnswered=").append(dateAnswered);
        sb.append(", dateEscalated=").append(dateEscalated);
        sb.append(", dateCanceled=").append(dateCancelled);
        sb.append(", status='").append(status).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", resolution='").append(resolution).append('\'');
        sb.append(", resolutionType='").append(resolutionType).append('\'');
        sb.append(", satisfied='").append(satisfied).append('\'');
        sb.append(", decision='").append(decision).append('\'');
        sb.append(", cancellationReason='").append(cancellationReason).append('\'');
        sb.append(", documentDTOList=").append(documentDTOList);
        sb.append(", relatedLot='").append(relatedLot).append('\'');
        sb.append(", tendererAction='").append(tendererAction).append('\'');
        sb.append(", tendererActionDate=").append(tendererActionDate);
        sb.append('}');
        return sb.toString();
    }
}
