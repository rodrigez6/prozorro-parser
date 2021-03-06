package org.rodrigez.model.domain;

import org.rodrigez.model.dto.ContractDTO;
import org.rodrigez.model.dto.PeriodDTO;
import org.rodrigez.model.dto.ValueDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "contract", schema = "prozorro")
public class Contract {

    @Id
    @Column(name = "contract_id")
    private String contractId;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @OneToOne
    @JoinColumn(name = "award_id")
    private Award award;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Item> items = new HashSet<>();

    @ManyToMany(mappedBy = "contracts", fetch = FetchType.EAGER)
    private Set<Organization> suppliers = new HashSet<>();

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "value_amount")
    private float valueAmount;

    @Column(name = "value_currency")
    private String valueCurrency;

    @Column(name = "value_added_tax_included")
    private boolean valueAddedTaxIncluded;

    @Column(name = "status")
    private String status;

    @Column(name = "period_start_date")
    private Date periodStartDate;

    @Column(name = "period_end_date")
    private Date periodEndDate;

    @Column(name = "date_signed")
    private Date dateSigned;

    @Column(name = "date")
    private Date date;

    public void setAward(Award award) {
        this.award = award;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public Tender getTender() {
        return tender;
    }

    public void addDocument(Document document){
        document.setContract(this);
        documents.add(document);
    }

    public void addItem(Item item){
        item.setContract(this);
        items.add(item);
    }

    public void addSupplier(Organization organization){
        organization.addContract(this);
        suppliers.add(organization);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractId.equals(contract.contractId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId);
    }

    public Contract() {
    }

    public Contract(ContractDTO dto) {
        this.contractId = dto.getContractId();
        this.contractNumber = dto.getContractNumber();
        this.title = dto.getTitle();
        this.description = dto.getDescription();

        ValueDTO value = dto.getValueDTO();
        if(value!=null){
            this.valueAmount = value.getAmount();
            this.valueCurrency = value.getCurrency();
            this.valueAddedTaxIncluded = value.isValueAddedTaxIncluded();
        }

        PeriodDTO period = dto.getPeriodDTO();
        if(period!=null){
            this.periodStartDate = period.getStartDate();
            this.periodEndDate = period.getEndDate();
        }

        this.status = dto.getStatus();
        this.dateSigned = dto.getDateSigned();
        this.date = dto.getDate();

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contract{");
        sb.append("contractId='").append(contractId).append('\'');
        if(tender!=null){
            sb.append(", tender=").append(tender.getTenderId());
        }
        if(award!=null){
            sb.append(", award=").append(award);
        }
        sb.append(", documents=").append(documents);
        sb.append(", items=").append(items);
        sb.append(", suppliers=").append(suppliers);
        sb.append(", contractNumber='").append(contractNumber).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", valueAmount=").append(valueAmount);
        sb.append(", valueCurrency='").append(valueCurrency).append('\'');
        sb.append(", valueAddedTaxIncluded=").append(valueAddedTaxIncluded);
        sb.append(", status='").append(status).append('\'');
        sb.append(", periodStartDate=").append(periodStartDate);
        sb.append(", periodEndDate=").append(periodEndDate);
        sb.append(", dateSigned=").append(dateSigned);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
