package com.google.firebase.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: classes6.dex */
public interface PausableScheduledExecutorService extends ScheduledExecutorService, PausableExecutorService, AutoCloseable {
    @Override // com.google.firebase.concurrent.PausableExecutorService, java.lang.AutoCloseable
    /* synthetic */ default void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }
}
