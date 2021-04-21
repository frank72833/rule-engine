package com.ruleengine.customer;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Jacksonized
@Builder(toBuilder=true)
public class Customer {
    UUID id;
    String country;
}
