package com.ruleengine.transfer.rest.provider;

import com.ruleengine.transfer.TransferService;
import com.ruleengine.transfer.rest.dto.CreateTransferRequest;
import com.ruleengine.transfer.rest.dto.converter.CreateTransferRequestConverter;
import com.ruleengine.transfer.rest.dto.TransferResponse;
import com.ruleengine.transfer.rest.dto.converter.TransferResponseConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TransferResourceProvider {

	private static final Logger LOG = LoggerFactory.getLogger(TransferResourceProvider.class);

	private final CreateTransferRequestConverter createTransferRequestConverter;
	private final TransferResponseConverter transferResponseConverter;
	private final TransferService transferService;

	public TransferResourceProvider(final CreateTransferRequestConverter createTransferRequestConverter,
									final TransferResponseConverter transferResponseConverter,
									final TransferService transferService) {
		this.createTransferRequestConverter = createTransferRequestConverter;
		this.transferResponseConverter = transferResponseConverter;
		this.transferService = transferService;
	}

	public TransferResponse create(CreateTransferRequest req) {
		LOG.info("create: request {}", req);
		final var transfer = createTransferRequestConverter.toTransfer(req);
		final var createdTransfer = transferService.create(transfer);
		return transferResponseConverter.toTransferResponse(createdTransfer);
	}
}
