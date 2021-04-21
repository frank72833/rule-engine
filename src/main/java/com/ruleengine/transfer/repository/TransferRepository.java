package com.ruleengine.transfer.repository;

import com.ruleengine.transfer.Transfer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class TransferRepository {

    private final Map<UUID, Transfer> transfer;

    public TransferRepository() {
        this.transfer = new HashMap<>();
    }

    public Transfer add(final Transfer transfer) {
        final var id = UUID.randomUUID();
        final var transferToSave = transfer.toBuilder()
                .id(id)
                .build();
        this.transfer.put(transferToSave.getId(), transferToSave);
        return transferToSave;
    }

    public Optional<Transfer> get(final UUID id) {
        return Optional.ofNullable(this.transfer.get(id));
    }
}
