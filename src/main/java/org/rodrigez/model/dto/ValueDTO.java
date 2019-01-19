package org.rodrigez.model.dto;

import com.google.gson.annotations.SerializedName;

public class ValueDTO {

    @SerializedName("amount")
    private float amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("valueAddedTaxIncluded")
    private boolean valueAddedTaxIncluded;

    public float getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isValueAddedTaxIncluded() {
        return valueAddedTaxIncluded;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValueDTO{");
        sb.append("amount=").append(amount);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", valueAddedTaxIncluded=").append(valueAddedTaxIncluded);
        sb.append('}');
        return sb.toString();
    }
}
