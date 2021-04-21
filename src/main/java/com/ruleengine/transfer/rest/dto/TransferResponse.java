package com.ruleengine.transfer.rest.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Jacksonized
@Builder
public class TransferResponse {
    private UUID id;
    private String sourceIban;
    private String destinationIban;
    private BigDecimal amount;
    private UUID accountOwnerId;
}
