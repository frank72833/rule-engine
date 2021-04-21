package com.ruleengine.transfer.rest.dto.converter;

import com.ruleengine.transfer.rest.dto.TransferResponse;
import com.ruleengine.transfer.Transfer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferResponseConverter {
    TransferResponse toTransferResponse(Transfer req);
}
