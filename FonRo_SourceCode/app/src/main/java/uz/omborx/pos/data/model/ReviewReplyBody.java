package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\nHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001b\u0002\b)¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fÊ\u0001\u0002\b-Ê\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0002¨\u0006,"}, d2 = {"Luz/FonRo/pos/data/model/ReviewReplyBody;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "reviewId", "", "reply", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()Ljava/lang/String;", "getReviewId$annotations", "()V", "getReviewId", "()J", "Lkotlinx/serialization/SerialName;", "value", "review_id", "getReply", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ReviewReplyBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String reply;
    private final long reviewId;
    private final String type;

    public static /* synthetic */ ReviewReplyBody copy$default(ReviewReplyBody reviewReplyBody, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reviewReplyBody.type;
        }
        if ((i & 2) != 0) {
            j = reviewReplyBody.reviewId;
        }
        if ((i & 4) != 0) {
            str2 = reviewReplyBody.reply;
        }
        return reviewReplyBody.copy(str, j, str2);
    }

    @SerialName("review_id")
    public static /* synthetic */ void getReviewId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final long getReviewId() {
        return this.reviewId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReply() {
        return this.reply;
    }

    public final ReviewReplyBody copy(String type, long reviewId, String reply) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(reply, "reply");
        return new ReviewReplyBody(type, reviewId, reply);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReviewReplyBody)) {
            return false;
        }
        ReviewReplyBody reviewReplyBody = (ReviewReplyBody) other;
        return Intrinsics.areEqual(this.type, reviewReplyBody.type) && this.reviewId == reviewReplyBody.reviewId && Intrinsics.areEqual(this.reply, reviewReplyBody.reply);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Long.hashCode(this.reviewId)) * 31) + this.reply.hashCode();
    }

    public String toString() {
        return "ReviewReplyBody(type=" + this.type + ", reviewId=" + this.reviewId + ", reply=" + this.reply + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ReviewReplyBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ReviewReplyBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReviewReplyBody> serializer() {
            return ReviewReplyBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ReviewReplyBody(int i, String str, long j, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, ReviewReplyBody$$serializer.INSTANCE.getDescriptor());
        }
        this.type = str;
        this.reviewId = j;
        this.reply = str2;
    }

    public ReviewReplyBody(String type, long j, String reply) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.type = type;
        this.reviewId = j;
        this.reply = reply;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ReviewReplyBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.type);
        output.encodeLongElement(serialDesc, 1, self.reviewId);
        output.encodeStringElement(serialDesc, 2, self.reply);
    }

    public final String getType() {
        return this.type;
    }

    public final long getReviewId() {
        return this.reviewId;
    }

    public final String getReply() {
        return this.reply;
    }
}
