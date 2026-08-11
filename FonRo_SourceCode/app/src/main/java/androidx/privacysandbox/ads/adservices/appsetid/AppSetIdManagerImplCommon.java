package androidx.privacysandbox.ads.adservices.appsetid;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$$ExternalSyntheticLambda4;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: AppSetIdManagerImplCommon.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u0006H\u0097@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager;", "mAppSetIdManager", "Landroid/adservices/appsetid/AppSetIdManager;", "(Landroid/adservices/appsetid/AppSetIdManager;)V", "convertResponse", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "response", "Landroid/adservices/appsetid/AppSetId;", "getAppSetId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppSetIdAsyncInternal", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public class AppSetIdManagerImplCommon extends AppSetIdManager {
    private final android.adservices.appsetid.AppSetIdManager mAppSetIdManager;

    @Override // androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager
    public Object getAppSetId(Continuation<? super AppSetId> continuation) {
        return getAppSetId$suspendImpl(this, continuation);
    }

    public AppSetIdManagerImplCommon(android.adservices.appsetid.AppSetIdManager mAppSetIdManager) {
        Intrinsics.checkNotNullParameter(mAppSetIdManager, "mAppSetIdManager");
        this.mAppSetIdManager = mAppSetIdManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.appsetid.AppSetId> r5) {
        /*
            boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            if (r0 == 0) goto L14
            r0 = r5
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.getAppSetIdAsyncInternal(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            android.adservices.appsetid.AppSetId r5 = androidx.privacysandbox.ads.adservices.common.AdFilters$$ExternalSyntheticApiModelOutline0.m(r5)
            androidx.privacysandbox.ads.adservices.appsetid.AppSetId r4 = r4.convertResponse(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AppSetId convertResponse(android.adservices.appsetid.AppSetId response) {
        int scope;
        String id;
        String id2;
        scope = response.getScope();
        if (scope == 1) {
            id2 = response.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "response.id");
            return new AppSetId(id2, 1);
        }
        id = response.getId();
        Intrinsics.checkNotNullExpressionValue(id, "response.id");
        return new AppSetId(id, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAppSetIdAsyncInternal(Continuation<? super android.adservices.appsetid.AppSetId> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.mAppSetIdManager.getAppSetId(new AdIdManagerImplCommon$$ExternalSyntheticLambda4(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
