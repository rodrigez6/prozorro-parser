package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RevisionDTO {

    @SerializedName("date")
    private Date date;

    @SerializedName("changes")
    private List<String> changeList = new ArrayList<>();

    public Date getDate() {
        return date;
    }

    public List<String> getChangeList() {
        return changeList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RevisionDTO{");
        sb.append("date=").append(date);
        sb.append(", changeList=").append(changeList);
        sb.append('}');
        return sb.toString();
    }
}
