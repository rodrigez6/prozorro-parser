package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractDTO implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("awardID")
    private String awardId;

    @SerializedName("contractID")
    private String contractId;

    @SerializedName("contractNumber")
    private String contractNumber;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("value")
    private ValueDTO valueDTO;

    @SerializedName("items")
    private List<ItemDTO> itemDTOList = new ArrayList<>();

    @SerializedName("suppliers")
    private List<OrganizationDTO> supplierList = new ArrayList<>();

    @SerializedName("status")
    private String status;

    @SerializedName("period")
    private PeriodDTO periodDTO;

    @SerializedName("dateSigned")
    private Date dateSigned;

    @SerializedName("date")
    private Date date;

    @SerializedName("documents")
    private List<DocumentDTO> documentDTOList = new ArrayList<>();

    public List<DocumentDTO> getDocumentDTOList() {
        return documentDTOList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContractDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", awardId='").append(awardId).append('\'');
        sb.append(", contractId='").append(contractId).append('\'');
        sb.append(", contractNumber='").append(contractNumber).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", valueDTO=").append(valueDTO);
        sb.append(", itemDTOList=").append(itemDTOList);
        sb.append(", supplierList=").append(supplierList);
        sb.append(", status='").append(status).append('\'');
        sb.append(", periodDTO=").append(periodDTO);
        sb.append(", dateSigned=").append(dateSigned);
        sb.append(", date=").append(date);
        sb.append(", documentDTOList=").append(documentDTOList);
        sb.append('}');
        return sb.toString();
    }

}
