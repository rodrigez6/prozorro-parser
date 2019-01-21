package org.rodrigez.model.domain;

import org.rodrigez.model.dto.QuestionDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "prozorro")
public class Question {

    @Id
    @Column(name = "question_id")
    private String questionId;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name= "date")
    private Date date;

    @Column(name = "date_answered")
    private Date dateAnswered;

    @Column(name = "answer")
    private String answer;

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return questionId.equals(question.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId);
    }

    public Question(){
    }

    public Question(QuestionDTO dto){
        this.questionId = dto.getId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.date = dto.getDate();
        this.dateAnswered = dto.getDateAnswered();
        this.answer = dto.getAnswer();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("questionId='").append(questionId).append('\'');
        sb.append(", organization=").append(organization);
        sb.append(", tender=").append(tender.getTenderId());
        sb.append(", item=").append(item.getItemId());
        sb.append(", lot=").append(lot.getLotId());
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", date=").append(date);
        sb.append(", dateAnswered=").append(dateAnswered);
        sb.append(", answer='").append(answer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
