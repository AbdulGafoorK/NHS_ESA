package com.nhs.NHS_ESA.controller;


import com.nhs.NHS_ESA.domain.RegularAmount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/regularamount")
public class RegularAmountController {

    @PostMapping("/save")
    public ResponseEntity<String> saveRegularAmount(@Valid @RequestBody RegularAmount regularAmount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Please check all the required fields", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
    }
}
