package com.ruleengine.transfer;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Jacksonized
@Builder(toBuilder=true)
public class Transfer {
    UUID id;

    String sourceIban;
    String destinationIban;
    BigDecimal amount;

    UUID accountOwnerId;
}
