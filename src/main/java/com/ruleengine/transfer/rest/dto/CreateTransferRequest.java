package com.ruleengine.transfer.rest.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Value
@Jacksonized
@Builder
public class CreateTransferRequest {
    @NotNull
    String sourceIban;
    @NotNull
    String destinationIban;
    @NotNull
    BigDecimal amount;
    @NotNull
    UUID accountOwnerId;
}
