package org.rodrigez.model.domain;

import org.rodrigez.model.dto.DocumentDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document", schema = "prozorro")
public class Document {

    @Id
    @Column(name = "document_id")
    private String documentId;

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

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
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


        // TODO: 19.01.19 Подгрузка існуючих обєктів(перенести в сервіси)
        String relatedItemId = dto.getRelatedItem();
        switch (dto.getDocumentOf()){
            case "tender" : {
                this.tender = new Tender();
                // подгрузить з бд відповідний тендер
                this.tender.setTenderId(relatedItemId);
                break;
            }
            case "item" : {
                this.item = new Item();
                this.item.setItemId(relatedItemId);
                break;
            }
            case "lot" : {
                this.lot = new Lot();
                this.lot.setLotId(relatedItemId);
                break;
            }
        }
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
        sb.append(", tender=").append(tender.getTenderId());
        sb.append(", item=").append(item.getItemId());
        sb.append(", lot=").append(lot.getLotId());
        sb.append('}');
        return sb.toString();
    }
}
