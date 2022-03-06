package com.nhs.NHS_ESA.domain;

public enum Frequency {

    WEEK(1), TWO_WEEK(2), FOUR_WEEK(4), MONTH(1), QUARTER(13), YEAR(52);

    private int value;

    Frequency(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
