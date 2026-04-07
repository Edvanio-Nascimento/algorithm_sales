package com.github.edy.model;

import java.time.OffsetDateTime;

public abstract class Auditing {

    protected final OffsetDateTime createdAt = OffsetDateTime.now();
    protected OffsetDateTime updatedAt = createdAt;

    protected void toUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }
}
