package com.nhs.NHS_ESA.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhs.NHS_ESA.domain.Frequency;
import com.nhs.NHS_ESA.domain.RegularAmount;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegularAmountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void testInvalidAmount() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.TWO_WEEK);
        regularAmount.setAmount("");
        MvcResult mvcResult = invokeRegularAPI(regularAmount);
        Assert.assertEquals("Please check all the required fields", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testNullFrequency() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setAmount("");
        MvcResult mvcResult = invokeRegularAPI(regularAmount);
        Assert.assertEquals("Please check all the required fields", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testWeeklyAmount() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setAmount("111");
        regularAmount.setFrequency(Frequency.WEEK);
        MvcResult mvcResult = invokeRegularAPI(regularAmount);
        Assert.assertEquals("Successfully Updated", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testMonthlyAmount() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setAmount("111");
        regularAmount.setFrequency(Frequency.MONTH);
        MvcResult mvcResult = invokeRegularAPI(regularAmount);
        Assert.assertEquals("Successfully Updated", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testFrequencyWithValidAmount() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setAmount("1000");
        regularAmount.setFrequency(Frequency.TWO_WEEK);
        MvcResult mvcResult = invokeRegularAPI(regularAmount);
        Assert.assertEquals("Successfully Updated", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testFrequencyWithInvalidAmount() throws Exception {
        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setAmount("111");
        regularAmount.setFrequency(Frequency.TWO_WEEK);
        MvcResult mvcResult = invokeRegularAPI(regularAmount);
        Assert.assertEquals("Please check all the required fields", mvcResult.getResponse().getContentAsString());
    }

    private MvcResult invokeRegularAPI(RegularAmount regularAmount) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/regularamount/save")
                .header("content-type", "application/json")
                .content(mapper.writeValueAsString(regularAmount))
                .accept(MediaType.APPLICATION_JSON);
        return mockMvc.perform(request).andReturn();
    }

}

