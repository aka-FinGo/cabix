package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\bL\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ¨\u00012\u00020\u0001:\u0004§\u0001¨\u0001B\u0099\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 Bÿ\u0001\b\u0010\u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\u001f\u0010%J\t\u0010~\u001a\u00020\u0003HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u000eHÆ\u0003J\u009c\u0002\u0010\u0098\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000eHÆ\u0001J\u0017\u0010\u0099\u0001\u001a\u00030\u009a\u00012\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\u000b\u0010\u009c\u0001\u001a\u00020\"HÖ\u0081\u0004J\u000b\u0010\u009d\u0001\u001a\u00020\u0006HÖ\u0081\u0004J2\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\u00002\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u0001H\u0001b\u0003\b¦\u0001¢\u0006\u0003\b¥\u0001R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\t0,¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R8\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(1r\f\b*\u0012\b\b+\u0012\u0004\b\t0,¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010)R8\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(5r\f\b*\u0012\b\b+\u0012\u0004\b\t06¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010'\u001a\u0004\b3\u00104R*\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(9¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010'\u001a\u0004\b8\u00104R8\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(<r\f\b*\u0012\b\b+\u0012\u0004\b\t0,¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010'\u001a\u0004\b;\u0010)R,\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(?¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010'\u001a\u0004\b>\u00104R,\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(B¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010'\u001a\u0004\bA\u00104R*\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(E¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010'\u001a\u0004\bD\u00104R,\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(H¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010'\u001a\u0004\bG\u00104R8\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(Lr\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010'\u001a\u0004\bJ\u0010KR8\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(Pr\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010'\u001a\u0004\bO\u0010KR8\u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(Sr\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010'\u001a\u0004\bR\u0010KR8\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(Vr\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010'\u001a\u0004\bU\u0010KR8\u0010\u0012\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(Yr\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bW\u0010'\u001a\u0004\bX\u0010KR8\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(\\r\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bZ\u0010'\u001a\u0004\b[\u0010KR8\u0010\u0014\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(_r\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\b]\u0010'\u001a\u0004\b^\u0010KR8\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(br\f\b*\u0012\b\b+\u0012\u0004\b\t0,¢\u0006\u000e\n\u0000\u0012\u0004\b`\u0010'\u001a\u0004\ba\u0010)R,\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(e¢\u0006\u000e\n\u0000\u0012\u0004\bc\u0010'\u001a\u0004\bd\u00104R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bf\u00104R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bg\u00104R,\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(j¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010'\u001a\u0004\bi\u00104R*\u0010\u001a\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bk\u0010'\u001a\u0004\bl\u0010KR8\u0010\u001b\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(or\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bm\u0010'\u001a\u0004\bn\u0010KR8\u0010\u001c\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(rr\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bp\u0010'\u001a\u0004\bq\u0010KR8\u0010\u001d\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b/\u0012\b\b0\u0012\u0004\b\b(ur\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bs\u0010'\u001a\u0004\bt\u0010KR*\u0010\u001e\u001a\u00020\u000e8\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\t0M¢\u0006\u000e\n\u0000\u0012\u0004\bv\u0010'\u001a\u0004\bw\u0010KR\u0011\u0010x\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\by\u00104R\u0011\u0010z\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b{\u00104R\u0011\u0010|\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b}\u0010KÊ\u0001\u0002\b*Ê\u0001\u000e\bª\u0001\u0012\t\b«\u0001\u0012\u0004\b\u0003\u0010\u0002¨\u0006©\u0001"}, d2 = {"Luz/FonRo/pos/data/model/SaleRow;", "", "id", "", "saleId", "transactionId", "", "soldAt", "customerId", "customerName", "cashierName", "paymentType", "paymentStatus", "paidAmount", "", "receivedAmount", "changeAmount", "cashAmount", "cardAmount", "debtAmount", "discountAmount", "productId", "productName", "name", "unit", "productUnit", FirebaseAnalytics.Param.QUANTITY, "returnedQuantity", "salePrice", "totalAmount", "profit", "<init>", "(JJLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDDDDJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDDDDJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getSaleId$annotations", "getSaleId", "Lkotlinx/serialization/SerialName;", "value", "sale_id", "getTransactionId$annotations", "getTransactionId", "()Ljava/lang/String;", FirebaseAnalytics.Param.TRANSACTION_ID, "Luz/FonRo/pos/data/net/LenientString;", "getSoldAt$annotations", "getSoldAt", "sold_at", "getCustomerId$annotations", "getCustomerId", "customer_id", "getCustomerName$annotations", "getCustomerName", "customer_name", "getCashierName$annotations", "getCashierName", "cashier_name", "getPaymentType$annotations", "getPaymentType", FirebaseAnalytics.Param.PAYMENT_TYPE, "getPaymentStatus$annotations", "getPaymentStatus", "payment_status", "getPaidAmount$annotations", "getPaidAmount", "()D", "paid_amount", "Luz/FonRo/pos/data/net/LenientDouble;", "getReceivedAmount$annotations", "getReceivedAmount", "received_amount", "getChangeAmount$annotations", "getChangeAmount", "change_amount", "getCashAmount$annotations", "getCashAmount", "cash_amount", "getCardAmount$annotations", "getCardAmount", "card_amount", "getDebtAmount$annotations", "getDebtAmount", "debt_amount", "getDiscountAmount$annotations", "getDiscountAmount", "discount_amount", "getProductId$annotations", "getProductId", FirebaseAnalytics.Param.PRODUCT_ID, "getProductName$annotations", "getProductName", FirebaseAnalytics.Param.PRODUCT_NAME, "getName", "getUnit", "getProductUnit$annotations", "getProductUnit", "product_unit", "getQuantity$annotations", "getQuantity", "getReturnedQuantity$annotations", "getReturnedQuantity", "returned_quantity", "getSalePrice$annotations", "getSalePrice", "sale_price", "getTotalAmount$annotations", "getTotalAmount", "total_amount", "getProfit$annotations", "getProfit", "title", "getTitle", "unitCode", "getUnitCode", "returnedShare", "getReturnedShare", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SaleRow {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double cardAmount;
    private final double cashAmount;
    private final String cashierName;
    private final double changeAmount;
    private final long customerId;
    private final String customerName;
    private final double debtAmount;
    private final double discountAmount;
    private final long id;
    private final String name;
    private final double paidAmount;
    private final String paymentStatus;
    private final String paymentType;
    private final long productId;
    private final String productName;
    private final String productUnit;
    private final double profit;
    private final double quantity;
    private final double receivedAmount;
    private final double returnedQuantity;
    private final long saleId;
    private final double salePrice;
    private final String soldAt;
    private final double totalAmount;
    private final String transactionId;
    private final String unit;

    public SaleRow() {
        this(0L, 0L, (String) null, (String) null, 0L, (String) null, (String) null, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0L, (String) null, (String) null, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, RectListKt.Lower26Bits, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SaleRow copy$default(SaleRow saleRow, long j, long j2, String str, String str2, long j3, String str3, String str4, String str5, String str6, double d, double d2, double d3, double d4, double d5, double d6, double d7, long j4, String str7, String str8, String str9, String str10, double d8, double d9, double d10, double d11, double d12, int i, Object obj) {
        double d13;
        double d14;
        double d15;
        double d16;
        long j5;
        String str11;
        String str12;
        String str13;
        double d17;
        double d18;
        double d19;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        double d20;
        double d21;
        double d22;
        double d23;
        double d24;
        SaleRow saleRow2;
        long j6;
        String str19;
        String str20;
        long j7;
        long j8 = (i & 1) != 0 ? saleRow.id : j;
        long j9 = (i & 2) != 0 ? saleRow.saleId : j2;
        String str21 = (i & 4) != 0 ? saleRow.transactionId : str;
        String str22 = (i & 8) != 0 ? saleRow.soldAt : str2;
        long j10 = (i & 16) != 0 ? saleRow.customerId : j3;
        String str23 = (i & 32) != 0 ? saleRow.customerName : str3;
        String str24 = (i & 64) != 0 ? saleRow.cashierName : str4;
        String str25 = (i & 128) != 0 ? saleRow.paymentType : str5;
        String str26 = (i & 256) != 0 ? saleRow.paymentStatus : str6;
        double d25 = (i & 512) != 0 ? saleRow.paidAmount : d;
        long j11 = j8;
        double d26 = (i & 1024) != 0 ? saleRow.receivedAmount : d2;
        double d27 = (i & 2048) != 0 ? saleRow.changeAmount : d3;
        double d28 = (i & 4096) != 0 ? saleRow.cashAmount : d4;
        double d29 = (i & 8192) != 0 ? saleRow.cardAmount : d5;
        double d30 = (i & 16384) != 0 ? saleRow.debtAmount : d6;
        double d31 = (i & 32768) != 0 ? saleRow.discountAmount : d7;
        long j12 = (i & 65536) != 0 ? saleRow.productId : j4;
        String str27 = (i & 131072) != 0 ? saleRow.productName : str7;
        long j13 = j12;
        String str28 = (i & 262144) != 0 ? saleRow.name : str8;
        String str29 = (i & 524288) != 0 ? saleRow.unit : str9;
        String str30 = str28;
        String str31 = (i & 1048576) != 0 ? saleRow.productUnit : str10;
        String str32 = str29;
        double d32 = (i & 2097152) != 0 ? saleRow.quantity : d8;
        double d33 = (i & 4194304) != 0 ? saleRow.returnedQuantity : d9;
        double d34 = (i & 8388608) != 0 ? saleRow.salePrice : d10;
        double d35 = (i & 16777216) != 0 ? saleRow.totalAmount : d11;
        if ((i & 33554432) != 0) {
            d14 = d35;
            d13 = saleRow.profit;
            d16 = d31;
            j5 = j13;
            str11 = str30;
            str12 = str32;
            str13 = str31;
            d17 = d32;
            d18 = d33;
            d19 = d34;
            str14 = str27;
            str16 = str24;
            str17 = str25;
            str18 = str26;
            d20 = d25;
            d21 = d26;
            d22 = d27;
            d23 = d28;
            d24 = d29;
            d15 = d30;
            saleRow2 = saleRow;
            j6 = j9;
            str19 = str21;
            str20 = str22;
            j7 = j10;
            str15 = str23;
        } else {
            d13 = d12;
            d14 = d35;
            d15 = d30;
            d16 = d31;
            j5 = j13;
            str11 = str30;
            str12 = str32;
            str13 = str31;
            d17 = d32;
            d18 = d33;
            d19 = d34;
            str14 = str27;
            str15 = str23;
            str16 = str24;
            str17 = str25;
            str18 = str26;
            d20 = d25;
            d21 = d26;
            d22 = d27;
            d23 = d28;
            d24 = d29;
            saleRow2 = saleRow;
            j6 = j9;
            str19 = str21;
            str20 = str22;
            j7 = j10;
        }
        return saleRow2.copy(j11, j6, str19, str20, j7, str15, str16, str17, str18, d20, d21, d22, d23, d24, d15, d16, j5, str14, str11, str12, str13, d17, d18, d19, d14, d13);
    }

    @SerialName("card_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getCardAmount$annotations() {
    }

    @SerialName("cash_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getCashAmount$annotations() {
    }

    @SerialName("cashier_name")
    public static /* synthetic */ void getCashierName$annotations() {
    }

    @SerialName("change_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getChangeAmount$annotations() {
    }

    @SerialName("customer_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getCustomerId$annotations() {
    }

    @SerialName("customer_name")
    public static /* synthetic */ void getCustomerName$annotations() {
    }

    @SerialName("debt_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDebtAmount$annotations() {
    }

    @SerialName("discount_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDiscountAmount$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("paid_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPaidAmount$annotations() {
    }

    @SerialName("payment_status")
    public static /* synthetic */ void getPaymentStatus$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PAYMENT_TYPE)
    public static /* synthetic */ void getPaymentType$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
    }

    @SerialName("product_unit")
    public static /* synthetic */ void getProductUnit$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getProfit$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    @SerialName("received_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getReceivedAmount$annotations() {
    }

    @SerialName("returned_quantity")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getReturnedQuantity$annotations() {
    }

    @SerialName("sale_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getSaleId$annotations() {
    }

    @SerialName("sale_price")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getSalePrice$annotations() {
    }

    @SerialName("sold_at")
    public static /* synthetic */ void getSoldAt$annotations() {
    }

    @SerialName("total_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getTotalAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.TRANSACTION_ID)
    @Serializable(with = LenientString.class)
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final double getPaidAmount() {
        return this.paidAmount;
    }

    /* renamed from: component11, reason: from getter */
    public final double getReceivedAmount() {
        return this.receivedAmount;
    }

    /* renamed from: component12, reason: from getter */
    public final double getChangeAmount() {
        return this.changeAmount;
    }

    /* renamed from: component13, reason: from getter */
    public final double getCashAmount() {
        return this.cashAmount;
    }

    /* renamed from: component14, reason: from getter */
    public final double getCardAmount() {
        return this.cardAmount;
    }

    /* renamed from: component15, reason: from getter */
    public final double getDebtAmount() {
        return this.debtAmount;
    }

    /* renamed from: component16, reason: from getter */
    public final double getDiscountAmount() {
        return this.discountAmount;
    }

    /* renamed from: component17, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component18, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* renamed from: component19, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSaleId() {
        return this.saleId;
    }

    /* renamed from: component20, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component21, reason: from getter */
    public final String getProductUnit() {
        return this.productUnit;
    }

    /* renamed from: component22, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component23, reason: from getter */
    public final double getReturnedQuantity() {
        return this.returnedQuantity;
    }

    /* renamed from: component24, reason: from getter */
    public final double getSalePrice() {
        return this.salePrice;
    }

    /* renamed from: component25, reason: from getter */
    public final double getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component26, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSoldAt() {
        return this.soldAt;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCashierName() {
        return this.cashierName;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPaymentStatus() {
        return this.paymentStatus;
    }

    public final SaleRow copy(long id, long saleId, String transactionId, String soldAt, long customerId, String customerName, String cashierName, String paymentType, String paymentStatus, double paidAmount, double receivedAmount, double changeAmount, double cashAmount, double cardAmount, double debtAmount, double discountAmount, long productId, String productName, String name, String unit, String productUnit, double quantity, double returnedQuantity, double salePrice, double totalAmount, double profit) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        return new SaleRow(id, saleId, transactionId, soldAt, customerId, customerName, cashierName, paymentType, paymentStatus, paidAmount, receivedAmount, changeAmount, cashAmount, cardAmount, debtAmount, discountAmount, productId, productName, name, unit, productUnit, quantity, returnedQuantity, salePrice, totalAmount, profit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleRow)) {
            return false;
        }
        SaleRow saleRow = (SaleRow) other;
        return this.id == saleRow.id && this.saleId == saleRow.saleId && Intrinsics.areEqual(this.transactionId, saleRow.transactionId) && Intrinsics.areEqual(this.soldAt, saleRow.soldAt) && this.customerId == saleRow.customerId && Intrinsics.areEqual(this.customerName, saleRow.customerName) && Intrinsics.areEqual(this.cashierName, saleRow.cashierName) && Intrinsics.areEqual(this.paymentType, saleRow.paymentType) && Intrinsics.areEqual(this.paymentStatus, saleRow.paymentStatus) && Double.compare(this.paidAmount, saleRow.paidAmount) == 0 && Double.compare(this.receivedAmount, saleRow.receivedAmount) == 0 && Double.compare(this.changeAmount, saleRow.changeAmount) == 0 && Double.compare(this.cashAmount, saleRow.cashAmount) == 0 && Double.compare(this.cardAmount, saleRow.cardAmount) == 0 && Double.compare(this.debtAmount, saleRow.debtAmount) == 0 && Double.compare(this.discountAmount, saleRow.discountAmount) == 0 && this.productId == saleRow.productId && Intrinsics.areEqual(this.productName, saleRow.productName) && Intrinsics.areEqual(this.name, saleRow.name) && Intrinsics.areEqual(this.unit, saleRow.unit) && Intrinsics.areEqual(this.productUnit, saleRow.productUnit) && Double.compare(this.quantity, saleRow.quantity) == 0 && Double.compare(this.returnedQuantity, saleRow.returnedQuantity) == 0 && Double.compare(this.salePrice, saleRow.salePrice) == 0 && Double.compare(this.totalAmount, saleRow.totalAmount) == 0 && Double.compare(this.profit, saleRow.profit) == 0;
    }

    public int hashCode() {
        int hashCode = ((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.saleId)) * 31) + this.transactionId.hashCode()) * 31) + this.soldAt.hashCode()) * 31) + Long.hashCode(this.customerId)) * 31;
        String str = this.customerName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cashierName;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.paymentType.hashCode()) * 31;
        String str3 = this.paymentStatus;
        int hashCode4 = (((((((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Double.hashCode(this.paidAmount)) * 31) + Double.hashCode(this.receivedAmount)) * 31) + Double.hashCode(this.changeAmount)) * 31) + Double.hashCode(this.cashAmount)) * 31) + Double.hashCode(this.cardAmount)) * 31) + Double.hashCode(this.debtAmount)) * 31) + Double.hashCode(this.discountAmount)) * 31) + Long.hashCode(this.productId)) * 31;
        String str4 = this.productName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.unit;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.productUnit;
        return ((((((((((hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31) + Double.hashCode(this.quantity)) * 31) + Double.hashCode(this.returnedQuantity)) * 31) + Double.hashCode(this.salePrice)) * 31) + Double.hashCode(this.totalAmount)) * 31) + Double.hashCode(this.profit);
    }

    public String toString() {
        return "SaleRow(id=" + this.id + ", saleId=" + this.saleId + ", transactionId=" + this.transactionId + ", soldAt=" + this.soldAt + ", customerId=" + this.customerId + ", customerName=" + this.customerName + ", cashierName=" + this.cashierName + ", paymentType=" + this.paymentType + ", paymentStatus=" + this.paymentStatus + ", paidAmount=" + this.paidAmount + ", receivedAmount=" + this.receivedAmount + ", changeAmount=" + this.changeAmount + ", cashAmount=" + this.cashAmount + ", cardAmount=" + this.cardAmount + ", debtAmount=" + this.debtAmount + ", discountAmount=" + this.discountAmount + ", productId=" + this.productId + ", productName=" + this.productName + ", name=" + this.name + ", unit=" + this.unit + ", productUnit=" + this.productUnit + ", quantity=" + this.quantity + ", returnedQuantity=" + this.returnedQuantity + ", salePrice=" + this.salePrice + ", totalAmount=" + this.totalAmount + ", profit=" + this.profit + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SaleRow$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SaleRow;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SaleRow> serializer() {
            return SaleRow$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SaleRow(int i, long j, long j2, String str, String str2, long j3, String str3, String str4, String str5, String str6, double d, double d2, double d3, double d4, double d5, double d6, double d7, long j4, String str7, String str8, String str9, String str10, double d8, double d9, double d10, double d11, double d12, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = j;
        }
        if ((i & 2) == 0) {
            this.saleId = 0L;
        } else {
            this.saleId = j2;
        }
        if ((i & 4) == 0) {
            this.transactionId = "";
        } else {
            this.transactionId = str;
        }
        if ((i & 8) == 0) {
            this.soldAt = "";
        } else {
            this.soldAt = str2;
        }
        if ((i & 16) == 0) {
            this.customerId = 0L;
        } else {
            this.customerId = j3;
        }
        if ((i & 32) == 0) {
            this.customerName = null;
        } else {
            this.customerName = str3;
        }
        if ((i & 64) == 0) {
            this.cashierName = null;
        } else {
            this.cashierName = str4;
        }
        if ((i & 128) == 0) {
            this.paymentType = "";
        } else {
            this.paymentType = str5;
        }
        if ((i & 256) == 0) {
            this.paymentStatus = null;
        } else {
            this.paymentStatus = str6;
        }
        if ((i & 512) == 0) {
            this.paidAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.paidAmount = d;
        }
        if ((i & 1024) == 0) {
            this.receivedAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.receivedAmount = d2;
        }
        if ((i & 2048) == 0) {
            this.changeAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.changeAmount = d3;
        }
        if ((i & 4096) == 0) {
            this.cashAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.cashAmount = d4;
        }
        if ((i & 8192) == 0) {
            this.cardAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.cardAmount = d5;
        }
        if ((i & 16384) == 0) {
            this.debtAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.debtAmount = d6;
        }
        if ((32768 & i) == 0) {
            this.discountAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.discountAmount = d7;
        }
        if ((65536 & i) == 0) {
            this.productId = 0L;
        } else {
            this.productId = j4;
        }
        if ((131072 & i) == 0) {
            this.productName = null;
        } else {
            this.productName = str7;
        }
        if ((262144 & i) == 0) {
            this.name = null;
        } else {
            this.name = str8;
        }
        if ((524288 & i) == 0) {
            this.unit = null;
        } else {
            this.unit = str9;
        }
        if ((1048576 & i) == 0) {
            this.productUnit = null;
        } else {
            this.productUnit = str10;
        }
        if ((2097152 & i) == 0) {
            this.quantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.quantity = d8;
        }
        if ((4194304 & i) == 0) {
            this.returnedQuantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.returnedQuantity = d9;
        }
        if ((8388608 & i) == 0) {
            this.salePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.salePrice = d10;
        }
        if ((16777216 & i) == 0) {
            this.totalAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.totalAmount = d11;
        }
        if ((i & 33554432) == 0) {
            this.profit = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.profit = d12;
        }
    }

    public SaleRow(long j, long j2, String transactionId, String soldAt, long j3, String str, String str2, String paymentType, String str3, double d, double d2, double d3, double d4, double d5, double d6, double d7, long j4, String str4, String str5, String str6, String str7, double d8, double d9, double d10, double d11, double d12) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        this.id = j;
        this.saleId = j2;
        this.transactionId = transactionId;
        this.soldAt = soldAt;
        this.customerId = j3;
        this.customerName = str;
        this.cashierName = str2;
        this.paymentType = paymentType;
        this.paymentStatus = str3;
        this.paidAmount = d;
        this.receivedAmount = d2;
        this.changeAmount = d3;
        this.cashAmount = d4;
        this.cardAmount = d5;
        this.debtAmount = d6;
        this.discountAmount = d7;
        this.productId = j4;
        this.productName = str4;
        this.name = str5;
        this.unit = str6;
        this.productUnit = str7;
        this.quantity = d8;
        this.returnedQuantity = d9;
        this.salePrice = d10;
        this.totalAmount = d11;
        this.profit = d12;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SaleRow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.saleId != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientLong.INSTANCE, Long.valueOf(self.saleId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.transactionId, "")) {
            output.encodeSerializableElement(serialDesc, 2, LenientString.INSTANCE, self.transactionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.soldAt, "")) {
            output.encodeStringElement(serialDesc, 3, self.soldAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.customerId != 0) {
            output.encodeSerializableElement(serialDesc, 4, LenientLong.INSTANCE, Long.valueOf(self.customerId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.customerName != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.customerName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.cashierName != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.cashierName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.paymentType, "")) {
            output.encodeStringElement(serialDesc, 7, self.paymentType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.paymentStatus != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.paymentStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || Double.compare(self.paidAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 9, LenientDouble.INSTANCE, Double.valueOf(self.paidAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || Double.compare(self.receivedAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 10, LenientDouble.INSTANCE, Double.valueOf(self.receivedAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || Double.compare(self.changeAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 11, LenientDouble.INSTANCE, Double.valueOf(self.changeAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || Double.compare(self.cashAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 12, LenientDouble.INSTANCE, Double.valueOf(self.cashAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || Double.compare(self.cardAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 13, LenientDouble.INSTANCE, Double.valueOf(self.cardAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || Double.compare(self.debtAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 14, LenientDouble.INSTANCE, Double.valueOf(self.debtAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || Double.compare(self.discountAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 15, LenientDouble.INSTANCE, Double.valueOf(self.discountAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.productId != 0) {
            output.encodeSerializableElement(serialDesc, 16, LenientLong.INSTANCE, Long.valueOf(self.productId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.productName != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.productName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.unit != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.unit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) || self.productUnit != null) {
            output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.productUnit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 21, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) || Double.compare(self.returnedQuantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 22, LenientDouble.INSTANCE, Double.valueOf(self.returnedQuantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) || Double.compare(self.salePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 23, LenientDouble.INSTANCE, Double.valueOf(self.salePrice));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) || Double.compare(self.totalAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 24, LenientDouble.INSTANCE, Double.valueOf(self.totalAmount));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 25) && Double.compare(self.profit, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 25, LenientDouble.INSTANCE, Double.valueOf(self.profit));
    }

    public /* synthetic */ SaleRow(long j, long j2, String str, String str2, long j3, String str3, String str4, String str5, String str6, double d, double d2, double d3, double d4, double d5, double d6, double d7, long j4, String str7, String str8, String str9, String str10, double d8, double d9, double d10, double d11, double d12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? 0L : j3, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) == 0 ? str5 : "", (i & 256) != 0 ? null : str6, (i & 512) != 0 ? 0.0d : d, (i & 1024) != 0 ? 0.0d : d2, (i & 2048) != 0 ? 0.0d : d3, (i & 4096) != 0 ? 0.0d : d4, (i & 8192) != 0 ? 0.0d : d5, (i & 16384) != 0 ? 0.0d : d6, (32768 & i) != 0 ? 0.0d : d7, (65536 & i) != 0 ? 0L : j4, (131072 & i) != 0 ? null : str7, (i & 262144) != 0 ? null : str8, (i & 524288) != 0 ? null : str9, (i & 1048576) != 0 ? null : str10, (i & 2097152) != 0 ? 0.0d : d8, (i & 4194304) != 0 ? 0.0d : d9, (i & 8388608) != 0 ? 0.0d : d10, (i & 16777216) != 0 ? 0.0d : d11, (i & 33554432) != 0 ? 0.0d : d12);
    }

    public final long getId() {
        return this.id;
    }

    public final long getSaleId() {
        return this.saleId;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getSoldAt() {
        return this.soldAt;
    }

    public final long getCustomerId() {
        return this.customerId;
    }

    public final String getCustomerName() {
        return this.customerName;
    }

    public final String getCashierName() {
        return this.cashierName;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final String getPaymentStatus() {
        return this.paymentStatus;
    }

    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final double getReceivedAmount() {
        return this.receivedAmount;
    }

    public final double getChangeAmount() {
        return this.changeAmount;
    }

    public final double getCashAmount() {
        return this.cashAmount;
    }

    public final double getCardAmount() {
        return this.cardAmount;
    }

    public final double getDebtAmount() {
        return this.debtAmount;
    }

    public final double getDiscountAmount() {
        return this.discountAmount;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final String getProductUnit() {
        return this.productUnit;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final double getReturnedQuantity() {
        return this.returnedQuantity;
    }

    public final double getSalePrice() {
        return this.salePrice;
    }

    public final double getTotalAmount() {
        return this.totalAmount;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final String getTitle() {
        String str = this.productName;
        if (str != null) {
            return str;
        }
        String str2 = this.name;
        return str2 == null ? "" : str2;
    }

    public final String getUnitCode() {
        String str = this.productUnit;
        if (str != null) {
            return str;
        }
        String str2 = this.unit;
        return str2 == null ? "pcs" : str2;
    }

    public final double getReturnedShare() {
        double d = this.quantity;
        double d2 = this.returnedQuantity;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return Math.min(1.0d, d2 / d);
        }
        if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return 1.0d;
        }
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
