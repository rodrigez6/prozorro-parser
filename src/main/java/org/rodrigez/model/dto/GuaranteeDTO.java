package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

public class GuaranteeDTO {

    @SerializedName("amount")
    private float amount;

    @SerializedName("currency")
    private String currency;

    public float getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GuaranteeDTO{");
        sb.append("amount=").append(amount);
        sb.append(", currency='").append(currency).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
