package com.ruleengine.transfer.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruleengine.transfer.rest.dto.CreateTransferRequest;
import com.ruleengine.transfer.rest.dto.TransferResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TransferResourceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createTransfer() throws Exception {
        final var accountOwnerId = UUID.randomUUID();
        CreateTransferRequest req = CreateTransferRequest.builder()
                .amount(BigDecimal.TEN)
                .destinationIban("IBAN1")
                .sourceIban("IBAN0")
                .accountOwnerId(accountOwnerId)
                .build();
        final var body = mapper.writeValueAsString(req);

        final var result = mvc.perform(MockMvcRequestBuilders.post("/transfers")
                .content(body).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        final var response = mapper.readValue(result.getResponse().getContentAsString(), TransferResponse.class);
        System.out.println(response);
    }
}