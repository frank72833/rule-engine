package com.ruleengine.transfer.rest;

import com.ruleengine.transfer.rest.dto.CreateTransferRequest;
import com.ruleengine.transfer.rest.provider.TransferResourceProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("transfers")
public class TransferResource {

    private final TransferResourceProvider transferResourceProvider;

	public TransferResource(final TransferResourceProvider transferResourceProvider) {
		this.transferResourceProvider = transferResourceProvider;
	}

	@PostMapping
	public ResponseEntity<?> createTransfer(@Valid @RequestBody CreateTransferRequest req) {
		final var transfer = transferResourceProvider.create(req);
		return ResponseEntity.ok(transfer);
	}
}
