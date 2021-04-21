package com.ruleengine.transfer.rest.dto.converter;

import com.ruleengine.transfer.rest.dto.CreateTransferRequest;
import com.ruleengine.transfer.Transfer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateTransferRequestConverter {
    Transfer toTransfer(CreateTransferRequest req);
}
