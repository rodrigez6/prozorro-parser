package org.rodrigez.model.domain;

import org.rodrigez.model.dto.CancellationDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cancellation", schema = "prozorro")
public class Cancellation {

    @Id
    @Column(name = "cancellation_id")
    private String cancellationId;

    @OneToMany(mappedBy = "cancellation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Document> documents = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @Column(name = "date")
    private Date date;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private String status;

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Tender getTender() {
        return tender;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public void addDocument(Document document){
        document.setCancellation(this);
        documents.add(document);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancellation that = (Cancellation) o;
        return cancellationId.equals(that.cancellationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cancellationId);
    }

    public Cancellation() {
    }

    public Cancellation(CancellationDTO dto) {
        this.cancellationId = dto.getId();
        this.date = dto.getDate();
        this.reason = dto.getReason();
        this.status = dto.getStatus();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cancellation{");
        sb.append("cancellationId='").append(cancellationId).append('\'');
        sb.append(", documents=").append(documents);
        sb.append(", tender=").append(tender.getTenderId());
        sb.append(", lot=").append(lot.getLotId());
        sb.append(", date=").append(date);
        sb.append(", reason='").append(reason).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
