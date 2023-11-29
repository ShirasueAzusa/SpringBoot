package com.ktjiaoyu.crm.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest
record UserControllerTest(WebApplicationContext wac) {
    private static MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetUser() throws Exception {
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/2")).andReturn().getResponse().getContentAsString();
        log.info(" ==>  Result === " + mvcResult);
    }

    @Test
    public void testAddUser() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("usrName", "RESTful");
        params.add("usrPassword", "123456");
        params.add("usrRoleId", "2");
        params.add("usrFlag", "1");
        mockMvc.perform(MockMvcRequestBuilders.post("/user").params(params)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}