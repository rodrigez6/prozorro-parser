package org.rodrigez.model.dto;

import java.util.Date;
import com.google.gson.annotations.SerializedName;

public class QuestionDTO {

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

    @SerializedName("dateAnswered")
    private Date dateAnswered;

    @SerializedName("answer")
    private String answer;

    @SerializedName("questionOf")
    private String questionOf;

    @SerializedName("relatedItem")
    private String relatedItem;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", author=").append(author);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", date=").append(date);
        sb.append(", dateAnswered=").append(dateAnswered);
        sb.append(", answer='").append(answer).append('\'');
        sb.append(", questionOf='").append(questionOf).append('\'');
        sb.append(", relatedItem='").append(relatedItem).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
