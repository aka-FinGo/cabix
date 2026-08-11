package com.google.common.eventbus;

@ElementTypesAreNonnullByDefault
/* loaded from: classes6.dex */
public interface SubscriberExceptionHandler {
    void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext);
}
