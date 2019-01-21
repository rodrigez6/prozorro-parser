package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AwardDTO {

    @SerializedName("id")
    private String id;

    @SerializedName("bid_id")
    private String bidId;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("status")
    private String status;

    @SerializedName("date")
    private Date date;

    @SerializedName("value")
    private ValueDTO valueDTO;

    @SerializedName("suppliers")
    private List<OrganizationDTO> supplierList = new ArrayList<>();

    @SerializedName("items")
    private List<ItemDTO> itemDTOList = new ArrayList<>();

    @SerializedName("documents")
    private List<DocumentDTO> documentDTOList = new ArrayList<>();

    @SerializedName("complaints")
    private List<ComplaintDTO> complaintDTOList = new ArrayList<>();

    @SerializedName("period")
    private PeriodDTO complaintPeriodDTO;

    @SerializedName("lotId")
    private String lotId;

    public String getId() {
        return id;
    }

    public String getBidId() {
        return bidId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public ValueDTO getValueDTO() {
        return valueDTO;
    }

    public List<OrganizationDTO> getSupplierList() {
        return supplierList;
    }

    public List<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }

    public List<DocumentDTO> getDocumentDTOList() {
        return documentDTOList;
    }

    public List<ComplaintDTO> getComplaintDTOList() {
        return complaintDTOList;
    }

    public PeriodDTO getComplaintPeriodDTO() {
        return complaintPeriodDTO;
    }

    public String getLotId() {
        return lotId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AwardDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", bidId='").append(bidId).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", date=").append(date);
        sb.append(", valueDTO=").append(valueDTO);
        sb.append(", supplierList=").append(supplierList);
        sb.append(", itemDTOList=").append(itemDTOList);
        sb.append(", documentDTOList=").append(documentDTOList);
        sb.append(", complaintDTOList=").append(complaintDTOList);
        sb.append(", complaintPeriodDTO=").append(complaintPeriodDTO);
        sb.append(", lotId='").append(lotId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
