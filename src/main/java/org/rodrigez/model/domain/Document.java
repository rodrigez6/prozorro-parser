package org.rodrigez.model.domain;

import org.rodrigez.model.dto.DocumentDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "document", schema = "prozorro")
public class Document {

    @Id
    @Column(name = "document_id")
    private String documentId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name = "bid_id")
    private Bid bid;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    @ManyToOne
    @JoinColumn(name = "cancellation_id")
    private Cancellation cancellation;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "award_id")
    private Award award;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "title")
    private String title;

    @Column(name = "format")
    private String format;

    @Column(name = "url")
    private String url;

    @Column(name = "date_published")
    private Date datePublished;

    @Column(name = "date_modified")
    private Date dateModified;

    @Column(name = "language")
    private String language;

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return documentId.equals(document.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId);
    }

    public Document() {
    }

    public Document(DocumentDTO dto) {
        this.documentId = dto.getId();
        this.documentType = dto.getDocumentType();
        this.title = dto.getTitle();
        this.format = dto.getFormat();
        this.url = dto.getUrl();
        this.datePublished = dto.getDatePublished();
        this.dateModified = dto.getDateModified();
        this.language = dto.getLanguage();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("documentId='").append(documentId).append('\'');
        sb.append(", documentType='").append(documentType).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", format='").append(format).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", datePublished=").append(datePublished);
        sb.append(", dateModified=").append(dateModified);
        sb.append(", language='").append(language).append('\'');
        if(tender!=null){
            sb.append(", tender=").append(tender.getTenderId());
        }
        if(item!=null){
            sb.append(", item=").append(item.getItemId());
        }
        if(lot!=null){
            sb.append(", lot=").append(lot.getLotId());
        }
        if(bid!=null){
            sb.append(", bid=").append(bid.getBidId());
        }
        sb.append('}');
        return sb.toString();
    }


}
