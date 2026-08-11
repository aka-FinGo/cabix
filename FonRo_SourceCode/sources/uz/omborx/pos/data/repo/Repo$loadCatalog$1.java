package uz.FonRo.pos.data.repo;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import uz.FonRo.pos.data.local.CacheStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Repo.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.Repo", f = "Repo.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {356, 186, 187}, m = "loadCatalog", n = {"$this$withLock_u24default$iv", "force", "$this$withLock_u24default$iv", "force", "gen", "$this$withLock_u24default$iv", CacheStore.PRODUCTS, "force", "gen"}, nl = {357, 187, 188}, s = {"L$0", "Z$0", "L$0", "Z$0", "I$0", "L$0", "L$2", "Z$0", "I$0"}, v = 2)
/* loaded from: classes5.dex */
public final class Repo$loadCatalog$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Repo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Repo$loadCatalog$1(Repo repo, Continuation<? super Repo$loadCatalog$1> continuation) {
        super(continuation);
        this.this$0 = repo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadCatalog(false, this);
    }
}
