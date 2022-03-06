package com.nhs.NHS_ESA.domain;


import com.nhs.NHS_ESA.util.CheckRegularAmount;

import javax.validation.constraints.NotNull;


@CheckRegularAmount
public class RegularAmount {

    @NotNull
    Frequency frequency;

    @NotNull
    String amount;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
