package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TenderDTO {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("tenderID")
    private String tenderId;

    @SerializedName("procuringEntity")
    private ProcuringEntityDTO procuringEntityDTO;

    @SerializedName("value")
    private ValueDTO valueDTO;

    @SerializedName("guarantee")
    private GuaranteeDTO guaranteeDTO;

    @SerializedName("date")
    private Date date;

    @SerializedName("items")
    private List<ItemDTO> itemDTOList = new ArrayList<>();

    @SerializedName("features")
    private List<FeatureDTO> featureDTOList = new ArrayList<>();

    @SerializedName("documents")
    private List<DocumentDTO> documentDTOList = new ArrayList<>();

    @SerializedName("questions")
    private List<QuestionDTO> questionDTOList = new ArrayList<>();

    @SerializedName("complaints")
    private List<ComplaintDTO> complaintDTOList = new ArrayList<>();

    @SerializedName("bids")
    private List<BidDTO> bidDTOList = new ArrayList<>();

    @SerializedName("minimalStep")
    private ValueDTO minimalStep;

    @SerializedName("awards")
    private List<AwardDTO> awardList = new ArrayList<>();

    @SerializedName("contracts")
    private List<ContractDTO> contractDTOList = new ArrayList<>();

    @SerializedName("enquiryPeriod")
    private PeriodDTO enquiryPeriodDTO;

    @SerializedName("tenderPeriod")
    private PeriodDTO tenderPeriodDTO;

    @SerializedName("auctionPeriod")
    private PeriodDTO auctionPeriodDTO;

    @SerializedName("auctionUrl")
    private URL auctionUrl;

    @SerializedName("awardPeriod")
    private PeriodDTO awardPeriodDTO;

    @SerializedName("status")
    private String status;

    @SerializedName("lots")
    private List<LotDTO> lotDTOList = new ArrayList<>();

    @SerializedName("cancellations")
    private List<CancellationDTO> cancellationDTOList = new ArrayList<>();

    @SerializedName("funders")
    private List<OrganizationDTO> funderList = new ArrayList<>();

    @SerializedName("revisions")
    private List<RevisionDTO> revisionDTOList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTenderId() {
        return tenderId;
    }

    public ProcuringEntityDTO getProcuringEntityDTO() {
        return procuringEntityDTO;
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

    public List<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }

    public List<FeatureDTO> getFeatureDTOList() {
        return featureDTOList;
    }

    public List<DocumentDTO> getDocumentDTOList() {
        return documentDTOList;
    }

    public List<QuestionDTO> getQuestionDTOList() {
        return questionDTOList;
    }

    public List<ComplaintDTO> getComplaintDTOList() {
        return complaintDTOList;
    }

    public List<BidDTO> getBidDTOList() {
        return bidDTOList;
    }

    public ValueDTO getMinimalStep() {
        return minimalStep;
    }

    public List<AwardDTO> getAwardList() {
        return awardList;
    }

    public List<ContractDTO> getContractDTOList() {
        return contractDTOList;
    }

    public PeriodDTO getEnquiryPeriodDTO() {
        return enquiryPeriodDTO;
    }

    public PeriodDTO getTenderPeriodDTO() {
        return tenderPeriodDTO;
    }

    public PeriodDTO getAuctionPeriodDTO() {
        return auctionPeriodDTO;
    }

    public URL getAuctionUrl() {
        return auctionUrl;
    }

    public PeriodDTO getAwardPeriodDTO() {
        return awardPeriodDTO;
    }

    public String getStatus() {
        return status;
    }

    public List<LotDTO> getLotDTOList() {
        return lotDTOList;
    }

    public List<CancellationDTO> getCancellationDTOList() {
        return cancellationDTOList;
    }

    public List<OrganizationDTO> getFunderList() {
        return funderList;
    }

    public List<RevisionDTO> getRevisionDTOList() {
        return revisionDTOList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TenderDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", tenderId='").append(tenderId).append('\'');
        sb.append(", procuringEntityDTO=").append(procuringEntityDTO);
        sb.append(", valueDTO=").append(valueDTO);
        sb.append(", guaranteeDTO=").append(guaranteeDTO);
        sb.append(", date=").append(date);
        sb.append(", itemDTOList=").append(itemDTOList);
        sb.append(", featureDTOList=").append(featureDTOList);
        sb.append(", documentDTOList=").append(documentDTOList);
        sb.append(", questionDTOList=").append(questionDTOList);
        sb.append(", complaintDTOList=").append(complaintDTOList);
        sb.append(", bidDTOList=").append(bidDTOList);
        sb.append(", minimalStep=").append(minimalStep);
        sb.append(", awardList=").append(awardList);
        sb.append(", contractDTOList=").append(contractDTOList);
        sb.append(", enquiryPeriodDTO=").append(enquiryPeriodDTO);
        sb.append(", tenderPeriodDTO=").append(tenderPeriodDTO);
        sb.append(", auctionPeriodDTO=").append(auctionPeriodDTO);
        sb.append(", auctionUrl=").append(auctionUrl);
        sb.append(", awardPeriodDTO=").append(awardPeriodDTO);
        sb.append(", status='").append(status).append('\'');
        sb.append(", lotDTOList=").append(lotDTOList);
        sb.append(", cancellationDTOList=").append(cancellationDTOList);
        sb.append(", funderList=").append(funderList);
        sb.append(", revisionDTOList=").append(revisionDTOList);
        sb.append('}');
        return sb.toString();
    }
}
