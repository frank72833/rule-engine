package com.ruleengine.transfer;

import com.ruleengine.transfer.repository.TransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TransferService {

    private static final Logger LOG = LoggerFactory.getLogger(TransferService.class);

    private final TransferRepository repository;

    public TransferService(final TransferRepository repository) {
        this.repository = repository;
    }

    public Transfer create(Transfer transfer) {
        LOG.info("create: transfer {}", transfer);
        final var savedTransfer = repository.add(transfer);
        return savedTransfer;
    }
}
