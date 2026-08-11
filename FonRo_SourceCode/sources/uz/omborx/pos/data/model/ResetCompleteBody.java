package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
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

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\nHÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR*\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000fR*\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u000fÊ\u0001\u0002\b0Ê\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Luz/FonRo/pos/data/model/ResetCompleteBody;", "", "email", "", "code", HintConstants.AUTOFILL_HINT_NEW_PASSWORD, "confirmPassword", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEmail", "()Ljava/lang/String;", "getCode", "getNewPassword$annotations", "()V", "getNewPassword", "Lkotlinx/serialization/SerialName;", "value", "new_password", "getConfirmPassword$annotations", "getConfirmPassword", "confirm_password", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ResetCompleteBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String code;
    private final String confirmPassword;
    private final String email;
    private final String newPassword;

    public static /* synthetic */ ResetCompleteBody copy$default(ResetCompleteBody resetCompleteBody, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resetCompleteBody.email;
        }
        if ((i & 2) != 0) {
            str2 = resetCompleteBody.code;
        }
        if ((i & 4) != 0) {
            str3 = resetCompleteBody.newPassword;
        }
        if ((i & 8) != 0) {
            str4 = resetCompleteBody.confirmPassword;
        }
        return resetCompleteBody.copy(str, str2, str3, str4);
    }

    @SerialName("confirm_password")
    public static /* synthetic */ void getConfirmPassword$annotations() {
    }

    @SerialName("new_password")
    public static /* synthetic */ void getNewPassword$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNewPassword() {
        return this.newPassword;
    }

    /* renamed from: component4, reason: from getter */
    public final String getConfirmPassword() {
        return this.confirmPassword;
    }

    public final ResetCompleteBody copy(String email, String code, String newPassword, String confirmPassword) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(confirmPassword, "confirmPassword");
        return new ResetCompleteBody(email, code, newPassword, confirmPassword);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResetCompleteBody)) {
            return false;
        }
        ResetCompleteBody resetCompleteBody = (ResetCompleteBody) other;
        return Intrinsics.areEqual(this.email, resetCompleteBody.email) && Intrinsics.areEqual(this.code, resetCompleteBody.code) && Intrinsics.areEqual(this.newPassword, resetCompleteBody.newPassword) && Intrinsics.areEqual(this.confirmPassword, resetCompleteBody.confirmPassword);
    }

    public int hashCode() {
        return (((((this.email.hashCode() * 31) + this.code.hashCode()) * 31) + this.newPassword.hashCode()) * 31) + this.confirmPassword.hashCode();
    }

    public String toString() {
        return "ResetCompleteBody(email=" + this.email + ", code=" + this.code + ", newPassword=" + this.newPassword + ", confirmPassword=" + this.confirmPassword + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ResetCompleteBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ResetCompleteBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ResetCompleteBody> serializer() {
            return ResetCompleteBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ResetCompleteBody(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, ResetCompleteBody$$serializer.INSTANCE.getDescriptor());
        }
        this.email = str;
        this.code = str2;
        this.newPassword = str3;
        this.confirmPassword = str4;
    }

    public ResetCompleteBody(String email, String code, String newPassword, String confirmPassword) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(confirmPassword, "confirmPassword");
        this.email = email;
        this.code = code;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ResetCompleteBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.email);
        output.encodeStringElement(serialDesc, 1, self.code);
        output.encodeStringElement(serialDesc, 2, self.newPassword);
        output.encodeStringElement(serialDesc, 3, self.confirmPassword);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getNewPassword() {
        return this.newPassword;
    }

    public final String getConfirmPassword() {
        return this.confirmPassword;
    }
}
