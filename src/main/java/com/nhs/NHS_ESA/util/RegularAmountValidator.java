package com.nhs.NHS_ESA.util;

import com.nhs.NHS_ESA.domain.Frequency;
import com.nhs.NHS_ESA.domain.RegularAmount;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegularAmountValidator implements ConstraintValidator<CheckRegularAmount, RegularAmount> {

    @Override
    public void initialize(CheckRegularAmount constraintAnnotation) {
        System.out.println(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.hasLength(regularAmount.getAmount()) || regularAmount.getFrequency() == null
                || !regularAmount.getAmount().matches("[0-9.]*")) {
            return false;
        }
        /*
         *TO DO - Instead of the below condition, need to fetch the income and outgoing details to
         * calculate the whole money using some other APIs.
         * To validate the amount for the api - /regularamount/save
         * */
        return regularAmount.getFrequency().equals(Frequency.WEEK) || regularAmount.getFrequency().equals(Frequency.MONTH)
                || Double.parseDouble(regularAmount.getAmount()) % regularAmount.getFrequency().getValue() == 0;

    }
}
