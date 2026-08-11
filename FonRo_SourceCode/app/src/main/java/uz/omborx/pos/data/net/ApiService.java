package uz.FonRo.pos.data.net;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.serialization.json.JsonElement;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.ActivityLogResponse;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.CategoryBody;
import uz.FonRo.pos.data.model.CategoryResponse;
import uz.FonRo.pos.data.model.CodeBody;
import uz.FonRo.pos.data.model.CouponResponse;
import uz.FonRo.pos.data.model.CurrencyBody;
import uz.FonRo.pos.data.model.CustomerBody;
import uz.FonRo.pos.data.model.CustomerResponse;
import uz.FonRo.pos.data.model.DebtPayBody;
import uz.FonRo.pos.data.model.DebtPayResult;
import uz.FonRo.pos.data.model.DebtsResponse;
import uz.FonRo.pos.data.model.EmailBody;
import uz.FonRo.pos.data.model.Expense;
import uz.FonRo.pos.data.model.ExpenseBody;
import uz.FonRo.pos.data.model.GlobalCatalogImportBody;
import uz.FonRo.pos.data.model.GlobalCatalogImportResult;
import uz.FonRo.pos.data.model.GlobalCatalogResponse;
import uz.FonRo.pos.data.model.LoginBody;
import uz.FonRo.pos.data.model.OrderIdBody;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.model.PlanBody;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.ProductBody;
import uz.FonRo.pos.data.model.ProductResponse;
import uz.FonRo.pos.data.model.RegisterBody;
import uz.FonRo.pos.data.model.ResetCompleteBody;
import uz.FonRo.pos.data.model.ResetVerifyBody;
import uz.FonRo.pos.data.model.ReturnBody;
import uz.FonRo.pos.data.model.ReviewReplyBody;
import uz.FonRo.pos.data.model.SaleBody;
import uz.FonRo.pos.data.model.SaleResult;
import uz.FonRo.pos.data.model.SalesHistoryResponse;
import uz.FonRo.pos.data.model.SelfLimitsBody;
import uz.FonRo.pos.data.model.SelfLimitsResponse;
import uz.FonRo.pos.data.model.Session;
import uz.FonRo.pos.data.model.ShopInfoBody;
import uz.FonRo.pos.data.model.ShopOrdersResponse;
import uz.FonRo.pos.data.model.ShopReviewsResponse;
import uz.FonRo.pos.data.model.ShopStoreInfo;
import uz.FonRo.pos.data.model.SlugBody;
import uz.FonRo.pos.data.model.StoreStats;
import uz.FonRo.pos.data.model.SupportListResponse;
import uz.FonRo.pos.data.model.SupportSendBody;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.model.SyncPushBody;
import uz.FonRo.pos.data.model.VerifyEmailBody;
import uz.FonRo.pos.data.model.WorkerBody;
import uz.FonRo.pos.data.model.WorkerDevicesResponse;
import uz.FonRo.pos.data.model.WorkerKeyBody;
import uz.FonRo.pos.data.model.WorkerListResponse;
import uz.FonRo.pos.data.model.WorkerResponse;
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: ApiService.kt */
@Metadata(d1 = {"\u0000Ô\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020\u0007:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\tJ6\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020\u000f:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\u0010J6\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020\u0013:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015¢\u0006\u0002\u0010\u0014J6\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020\u0017:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0019¢\u0006\u0002\u0010\u0018J6\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020\u0017:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010\u0018J6\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020\u001d:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f¢\u0006\u0002\u0010\u001eJ6\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020!:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#¢\u0006\u0002\u0010\"J6\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020%:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b('¢\u0006\u0002\u0010&J6\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020%:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b('¢\u0006\u0002\u0010&J6\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020%:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b('¢\u0006\u0002\u0010&J(\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H§@b\f\b-\u0012\b\b\u000b\u0012\u0004\b\b(.¢\u0006\u0002\u0010,J(\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00040\u0003H§@b\f\b-\u0012\b\b\u000b\u0012\u0004\b\b(1¢\u0006\u0002\u0010,J(\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u0003H§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3¢\u0006\u0002\u0010,J(\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u0003H§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(5¢\u0006\u0002\u0010,J6\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u000207:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(9¢\u0006\u0002\u00108J6\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020<:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(>¢\u0006\u0002\u0010=JB\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00040\u00032\u0018\b\u0001\u0010A\u001a\u0004\u0018\u00010B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(DH§@b\f\b-\u0012\b\b\u000b\u0012\u0004\b\b(F¢\u0006\u0002\u0010EJ6\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020H:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(J¢\u0006\u0002\u0010IJ(\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u00040\u0003H§@b\f\b-\u0012\b\b\u000b\u0012\u0004\b\b(M¢\u0006\u0002\u0010,J6\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020P:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(M¢\u0006\u0002\u0010QJN\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(S2\f\b\u0001\u0010\u0006\u001a\u00020P:\u0002\b\bH§@b\f\bU\u0012\b\b\u000b\u0012\u0004\b\b(M¢\u0006\u0002\u0010TJ6\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020P:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(M¢\u0006\u0002\u0010QJF\u0010W\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0X0\u00040\u00032\u0016\b\u0003\u0010Z\u001a\u00020[:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(ZH§@b\f\b-\u0012\b\b\u000b\u0012\u0004\b\b(]¢\u0006\u0002\u0010\\J6\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020`:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(]¢\u0006\u0002\u0010aJN\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(S2\f\b\u0001\u0010\u0006\u001a\u00020`:\u0002\b\bH§@b\f\bU\u0012\b\b\u000b\u0012\u0004\b\b(]¢\u0006\u0002\u0010cJ@\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(SH§@b\f\bf\u0012\b\b\u000b\u0012\u0004\b\b(]¢\u0006\u0002\u0010eJ \u0001\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0\u00040\u00032\u0016\b\u0001\u0010i\u001a\u00020j:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(i2\u0016\b\u0001\u0010k\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(l2\u0016\b\u0001\u0010m\u001a\u00020j:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(m2\u0016\b\u0001\u0010n\u001a\u00020[:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(n2\u0016\b\u0001\u0010o\u001a\u00020[:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(oH§@b\f\b-\u0012\b\b\u000b\u0012\u0004\b\b(q¢\u0006\u0002\u0010pJ6\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020t:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(v¢\u0006\u0002\u0010uJF\u0010w\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0X0\u00040\u00032\u0016\b\u0003\u0010Z\u001a\u00020[:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(ZH§@b\f\b-\u0012\b\b\u000b\u0012\u0004\b\b(y¢\u0006\u0002\u0010\\J6\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020{0\u00040\u00032\f\b\u0001\u0010\u0006\u001a\u00020|:\u0002\b\bH§@b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(y¢\u0006\u0002\u0010}JN\u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020{0\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(S2\f\b\u0001\u0010\u0006\u001a\u00020|:\u0002\b\bH§@b\f\bU\u0012\b\b\u000b\u0012\u0004\b\b(y¢\u0006\u0002\u0010\u007fJA\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(SH§@b\f\bf\u0012\b\b\u000b\u0012\u0004\b\b(y¢\u0006\u0002\u0010eJ;\u0010\u0081\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0082\u00010\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030\u0083\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(\u0085\u0001¢\u0006\u0003\u0010\u0084\u0001JS\u0010\u0086\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0082\u00010\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(S2\r\b\u0001\u0010\u0006\u001a\u00030\u0083\u0001:\u0002\b\bH§@b\r\bU\u0012\t\b\u000b\u0012\u0005\b\b(\u0085\u0001¢\u0006\u0003\u0010\u0087\u0001J:\u0010\u0088\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030\u0089\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(\u008b\u0001¢\u0006\u0003\u0010\u008a\u0001J;\u0010\u008c\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008d\u00010\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030\u008e\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(\u0090\u0001¢\u0006\u0003\u0010\u008f\u0001Jd\u0010\u0091\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0092\u00010\u00040\u00032\u001a\b\u0001\u0010\u0093\u0001\u001a\u0004\u0018\u00010j:\r\bC\u0012\t\b\u000b\u0012\u0005\b\b(\u0093\u00012\u001a\b\u0001\u0010\u0094\u0001\u001a\u0004\u0018\u00010j:\r\bC\u0012\t\b\u000b\u0012\u0005\b\b(\u0094\u0001H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(\u0096\u0001¢\u0006\u0003\u0010\u0095\u0001JI\u0010\u0097\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0098\u00010\u00040\u00032\u001b\b\u0001\u0010\u0099\u0001\u001a\u000f\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020j0\u009a\u0001:\u0003\b\u009b\u0001H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(\u009d\u0001¢\u0006\u0003\u0010\u009c\u0001J;\u0010\u009e\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009f\u00010\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030 \u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(¢\u0001¢\u0006\u0003\u0010¡\u0001J:\u0010£\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030¤\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(¦\u0001¢\u0006\u0003\u0010¥\u0001J+\u0010§\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00010\u00040\u0003H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(©\u0001¢\u0006\u0002\u0010,J;\u0010ª\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030«\u00010\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030¬\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(©\u0001¢\u0006\u0003\u0010\u00ad\u0001J1\u0010®\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¯\u00010X0\u00040\u0003H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(°\u0001¢\u0006\u0002\u0010,J:\u0010±\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030²\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(°\u0001¢\u0006\u0003\u0010³\u0001JR\u0010´\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(S2\r\b\u0001\u0010\u0006\u001a\u00030²\u0001:\u0002\b\bH§@b\r\bU\u0012\t\b\u000b\u0012\u0005\b\b(°\u0001¢\u0006\u0003\u0010µ\u0001JB\u0010¶\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\u0016\b\u0001\u0010S\u001a\u00020B:\f\bC\u0012\b\b\u000b\u0012\u0004\b\b(SH§@b\r\bf\u0012\t\b\u000b\u0012\u0005\b\b(°\u0001¢\u0006\u0002\u0010eJH\u0010·\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¸\u00010\u00040\u00032\u001a\b\u0001\u0010¹\u0001\u001a\u0004\u0018\u00010j:\r\bC\u0012\t\b\u000b\u0012\u0005\b\b(¹\u0001H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(»\u0001¢\u0006\u0003\u0010º\u0001JH\u0010¼\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030½\u00010\u00040\u00032\u001a\b\u0003\u0010¾\u0001\u001a\u0004\u0018\u00010j:\r\bC\u0012\t\b\u000b\u0012\u0005\b\b(¾\u0001H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(¿\u0001¢\u0006\u0003\u0010º\u0001J:\u0010À\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030Á\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(¿\u0001¢\u0006\u0003\u0010Â\u0001JH\u0010Ã\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ä\u00010\u00040\u00032\u001a\b\u0001\u0010Å\u0001\u001a\u0004\u0018\u00010j:\r\bC\u0012\t\b\u000b\u0012\u0005\b\b(Å\u0001H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(Æ\u0001¢\u0006\u0003\u0010º\u0001J:\u0010Ç\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030È\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(Ê\u0001¢\u0006\u0003\u0010É\u0001J:\u0010Ë\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030È\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(Ì\u0001¢\u0006\u0003\u0010É\u0001J:\u0010Í\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030È\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(Î\u0001¢\u0006\u0003\u0010É\u0001J:\u0010Ï\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030Ð\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(Ò\u0001¢\u0006\u0003\u0010Ñ\u0001J+\u0010Ó\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ô\u00010\u00040\u0003H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(Õ\u0001¢\u0006\u0002\u0010,J:\u0010Ö\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030×\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(Ù\u0001¢\u0006\u0003\u0010Ø\u0001J+\u0010Ú\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Û\u00010\u00040\u0003H§@b\r\b-\u0012\t\b\u000b\u0012\u0005\b\b(Ü\u0001¢\u0006\u0002\u0010,J:\u0010Ý\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\r\b\u0001\u0010\u0006\u001a\u00030Þ\u0001:\u0002\b\bH§@b\r\b\n\u0012\t\b\u000b\u0012\u0005\b\b(à\u0001¢\u0006\u0003\u0010ß\u0001¨\u0006á\u0001À\u0006\u0003"}, d2 = {"Luz/FonRo/pos/data/net/ApiService;", "", FirebaseAnalytics.Event.LOGIN, "Lretrofit2/Response;", "Luz/FonRo/pos/data/net/ApiEnvelope;", "Luz/FonRo/pos/data/model/Session;", "body", "Luz/FonRo/pos/data/model/LoginBody;", "Lretrofit2/http/Body;", "(Luz/FonRo/pos/data/model/LoginBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/POST;", "value", "api.php?action=login", "register", "Lkotlinx/serialization/json/JsonElement;", "Luz/FonRo/pos/data/model/RegisterBody;", "(Luz/FonRo/pos/data/model/RegisterBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=register", "verifyEmail", "Luz/FonRo/pos/data/model/VerifyEmailBody;", "(Luz/FonRo/pos/data/model/VerifyEmailBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=verify_email", "resendCode", "Luz/FonRo/pos/data/model/EmailBody;", "(Luz/FonRo/pos/data/model/EmailBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=resend_code", "resetRequest", "api_password_reset.php?action=request", "resetVerify", "Luz/FonRo/pos/data/model/ResetVerifyBody;", "(Luz/FonRo/pos/data/model/ResetVerifyBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_password_reset.php?action=verify", "resetComplete", "Luz/FonRo/pos/data/model/ResetCompleteBody;", "(Luz/FonRo/pos/data/model/ResetCompleteBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_password_reset.php?action=complete", "workerKey", "Luz/FonRo/pos/data/model/WorkerKeyBody;", "(Luz/FonRo/pos/data/model/WorkerKeyBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_worker_key.php", "workerKeyDevices", "Luz/FonRo/pos/data/model/WorkerDevicesResponse;", "workerKeyAction", CacheStore.SESSION, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "api.php?action=session", "entitlement", "Luz/FonRo/pos/data/model/Paywall;", "api.php?action=entitlement", "cancelSubscription", "api.php?action=cancel_subscription", "resumeSubscription", "api.php?action=resume_subscription", "changePlan", "Luz/FonRo/pos/data/model/PlanBody;", "(Luz/FonRo/pos/data/model/PlanBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=change_plan", "checkCoupon", "Luz/FonRo/pos/data/model/CouponResponse;", "Luz/FonRo/pos/data/model/CodeBody;", "(Luz/FonRo/pos/data/model/CodeBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=check_coupon", "supportList", "Luz/FonRo/pos/data/model/SupportListResponse;", "afterId", "", "Lretrofit2/http/Query;", "after_id", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_support.php?action=list", "supportSend", "Luz/FonRo/pos/data/model/SupportSendBody;", "(Luz/FonRo/pos/data/model/SupportSendBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_support.php", "workers", "Luz/FonRo/pos/data/model/WorkerListResponse;", "api_workers.php", "workerCreate", "Luz/FonRo/pos/data/model/WorkerResponse;", "Luz/FonRo/pos/data/model/WorkerBody;", "(Luz/FonRo/pos/data/model/WorkerBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "workerUpdate", "id", "(JLuz/FonRo/pos/data/model/WorkerBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/PUT;", "workerRegenerateKey", CacheStore.PRODUCTS, "", "Luz/FonRo/pos/data/model/Product;", "archived", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_products.php", "productCreate", "Luz/FonRo/pos/data/model/ProductResponse;", "Luz/FonRo/pos/data/model/ProductBody;", "(Luz/FonRo/pos/data/model/ProductBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "productUpdate", "(JLuz/FonRo/pos/data/model/ProductBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "productArchive", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/DELETE;", "globalCatalog", "Luz/FonRo/pos/data/model/GlobalCatalogResponse;", "lang", "", "categoryId", "category_id", "q", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "(Ljava/lang/String;JLjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=catalog", "globalCatalogImport", "Luz/FonRo/pos/data/model/GlobalCatalogImportResult;", "Luz/FonRo/pos/data/model/GlobalCatalogImportBody;", "(Luz/FonRo/pos/data/model/GlobalCatalogImportBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=catalog_import", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", "api_categories.php", "categoryCreate", "Luz/FonRo/pos/data/model/CategoryResponse;", "Luz/FonRo/pos/data/model/CategoryBody;", "(Luz/FonRo/pos/data/model/CategoryBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "categoryUpdate", "(JLuz/FonRo/pos/data/model/CategoryBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "categoryArchive", "customerCreate", "Luz/FonRo/pos/data/model/CustomerResponse;", "Luz/FonRo/pos/data/model/CustomerBody;", "(Luz/FonRo/pos/data/model/CustomerBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_customers.php", "customerUpdate", "(JLuz/FonRo/pos/data/model/CustomerBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePosCurrency", "Luz/FonRo/pos/data/model/CurrencyBody;", "(Luz/FonRo/pos/data/model/CurrencyBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=update_pos_currency", "saveSelfLimits", "Luz/FonRo/pos/data/model/SelfLimitsResponse;", "Luz/FonRo/pos/data/model/SelfLimitsBody;", "(Luz/FonRo/pos/data/model/SelfLimitsBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=self_limits", "storeStats", "Luz/FonRo/pos/data/model/StoreStats;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=store_stats", "salesHistory", "Luz/FonRo/pos/data/model/SalesHistoryResponse;", "params", "", "Lretrofit2/http/QueryMap;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api.php?action=sales_history", "saleComplete", "Luz/FonRo/pos/data/model/SaleResult;", "Luz/FonRo/pos/data/model/SaleBody;", "(Luz/FonRo/pos/data/model/SaleBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_sales.php", "returnComplete", "Luz/FonRo/pos/data/model/ReturnBody;", "(Luz/FonRo/pos/data/model/ReturnBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_return.php", Routes.DEBTS, "Luz/FonRo/pos/data/model/DebtsResponse;", "api_debts.php", "debtPay", "Luz/FonRo/pos/data/model/DebtPayResult;", "Luz/FonRo/pos/data/model/DebtPayBody;", "(Luz/FonRo/pos/data/model/DebtPayBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Routes.EXPENSES, "Luz/FonRo/pos/data/model/Expense;", "api_expenses.php", "expenseCreate", "Luz/FonRo/pos/data/model/ExpenseBody;", "(Luz/FonRo/pos/data/model/ExpenseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expenseUpdate", "(JLuz/FonRo/pos/data/model/ExpenseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expenseCancel", "activityLog", "Luz/FonRo/pos/data/model/ActivityLogResponse;", "date", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_activity.php", "syncPull", "Luz/FonRo/pos/data/model/SyncData;", "since", "api_sync.php", "syncPush", "Luz/FonRo/pos/data/model/SyncPushBody;", "(Luz/FonRo/pos/data/model/SyncPushBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shopOrders", "Luz/FonRo/pos/data/model/ShopOrdersResponse;", NotificationCompat.CATEGORY_STATUS, "api_shop.php?action=orders_list", "shopOrderConfirm", "Luz/FonRo/pos/data/model/OrderIdBody;", "(Luz/FonRo/pos/data/model/OrderIdBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_shop.php?action=order_confirm", "shopOrderCancel", "api_shop.php?action=order_cancel", "shopOrderDone", "api_shop.php?action=order_done", "shopUpdateSlug", "Luz/FonRo/pos/data/model/SlugBody;", "(Luz/FonRo/pos/data/model/SlugBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_shop.php?action=update_slug", "shopReviews", "Luz/FonRo/pos/data/model/ShopReviewsResponse;", "api_shop.php?action=reviews_list", "shopReviewReply", "Luz/FonRo/pos/data/model/ReviewReplyBody;", "(Luz/FonRo/pos/data/model/ReviewReplyBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_shop.php?action=review_reply", "shopStoreInfo", "Luz/FonRo/pos/data/model/ShopStoreInfo;", "api_shop.php?action=store_info", "shopUpdateStoreInfo", "Luz/FonRo/pos/data/model/ShopInfoBody;", "(Luz/FonRo/pos/data/model/ShopInfoBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_shop.php?action=update_store_info", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public interface ApiService {
    @GET("api_activity.php")
    Object activityLog(@Query("date") String str, Continuation<? super Response<ApiEnvelope<ActivityLogResponse>>> continuation);

    @POST("api.php?action=cancel_subscription")
    Object cancelSubscription(Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @GET("api_categories.php")
    Object categories(@Query("archived") int i, Continuation<? super Response<ApiEnvelope<List<Category>>>> continuation);

    @DELETE("api_categories.php")
    Object categoryArchive(@Query("id") long j, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_categories.php")
    Object categoryCreate(@Body CategoryBody categoryBody, Continuation<? super Response<ApiEnvelope<CategoryResponse>>> continuation);

    @PUT("api_categories.php")
    Object categoryUpdate(@Query("id") long j, @Body CategoryBody categoryBody, Continuation<? super Response<ApiEnvelope<CategoryResponse>>> continuation);

    @POST("api.php?action=change_plan")
    Object changePlan(@Body PlanBody planBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api.php?action=check_coupon")
    Object checkCoupon(@Body CodeBody codeBody, Continuation<? super Response<ApiEnvelope<CouponResponse>>> continuation);

    @POST("api_customers.php")
    Object customerCreate(@Body CustomerBody customerBody, Continuation<? super Response<ApiEnvelope<CustomerResponse>>> continuation);

    @PUT("api_customers.php")
    Object customerUpdate(@Query("id") long j, @Body CustomerBody customerBody, Continuation<? super Response<ApiEnvelope<CustomerResponse>>> continuation);

    @POST("api_debts.php")
    Object debtPay(@Body DebtPayBody debtPayBody, Continuation<? super Response<ApiEnvelope<DebtPayResult>>> continuation);

    @GET("api_debts.php")
    Object debts(Continuation<? super Response<ApiEnvelope<DebtsResponse>>> continuation);

    @GET("api.php?action=entitlement")
    Object entitlement(Continuation<? super Response<ApiEnvelope<Paywall>>> continuation);

    @DELETE("api_expenses.php")
    Object expenseCancel(@Query("id") long j, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_expenses.php")
    Object expenseCreate(@Body ExpenseBody expenseBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @PUT("api_expenses.php")
    Object expenseUpdate(@Query("id") long j, @Body ExpenseBody expenseBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @GET("api_expenses.php")
    Object expenses(Continuation<? super Response<ApiEnvelope<List<Expense>>>> continuation);

    @GET("api.php?action=catalog")
    Object globalCatalog(@Query("lang") String str, @Query("category_id") long j, @Query("q") String str2, @Query("offset") int i, @Query("limit") int i2, Continuation<? super Response<ApiEnvelope<GlobalCatalogResponse>>> continuation);

    @POST("api.php?action=catalog_import")
    Object globalCatalogImport(@Body GlobalCatalogImportBody globalCatalogImportBody, Continuation<? super Response<ApiEnvelope<GlobalCatalogImportResult>>> continuation);

    @POST("api.php?action=login")
    Object login(@Body LoginBody loginBody, Continuation<? super Response<ApiEnvelope<Session>>> continuation);

    @DELETE("api_products.php")
    Object productArchive(@Query("id") long j, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_products.php")
    Object productCreate(@Body ProductBody productBody, Continuation<? super Response<ApiEnvelope<ProductResponse>>> continuation);

    @PUT("api_products.php")
    Object productUpdate(@Query("id") long j, @Body ProductBody productBody, Continuation<? super Response<ApiEnvelope<ProductResponse>>> continuation);

    @GET("api_products.php")
    Object products(@Query("archived") int i, Continuation<? super Response<ApiEnvelope<List<Product>>>> continuation);

    @POST("api.php?action=register")
    Object register(@Body RegisterBody registerBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api.php?action=resend_code")
    Object resendCode(@Body EmailBody emailBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_password_reset.php?action=complete")
    Object resetComplete(@Body ResetCompleteBody resetCompleteBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_password_reset.php?action=request")
    Object resetRequest(@Body EmailBody emailBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_password_reset.php?action=verify")
    Object resetVerify(@Body ResetVerifyBody resetVerifyBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api.php?action=resume_subscription")
    Object resumeSubscription(Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_return.php")
    Object returnComplete(@Body ReturnBody returnBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_sales.php")
    Object saleComplete(@Body SaleBody saleBody, Continuation<? super Response<ApiEnvelope<SaleResult>>> continuation);

    @GET("api.php?action=sales_history")
    Object salesHistory(@QueryMap Map<String, String> map, Continuation<? super Response<ApiEnvelope<SalesHistoryResponse>>> continuation);

    @POST("api.php?action=self_limits")
    Object saveSelfLimits(@Body SelfLimitsBody selfLimitsBody, Continuation<? super Response<ApiEnvelope<SelfLimitsResponse>>> continuation);

    @GET("api.php?action=session")
    Object session(Continuation<? super Response<ApiEnvelope<Session>>> continuation);

    @POST("api_shop.php?action=order_cancel")
    Object shopOrderCancel(@Body OrderIdBody orderIdBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_shop.php?action=order_confirm")
    Object shopOrderConfirm(@Body OrderIdBody orderIdBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_shop.php?action=order_done")
    Object shopOrderDone(@Body OrderIdBody orderIdBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @GET("api_shop.php?action=orders_list")
    Object shopOrders(@Query("status") String str, Continuation<? super Response<ApiEnvelope<ShopOrdersResponse>>> continuation);

    @POST("api_shop.php?action=review_reply")
    Object shopReviewReply(@Body ReviewReplyBody reviewReplyBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @GET("api_shop.php?action=reviews_list")
    Object shopReviews(Continuation<? super Response<ApiEnvelope<ShopReviewsResponse>>> continuation);

    @GET("api_shop.php?action=store_info")
    Object shopStoreInfo(Continuation<? super Response<ApiEnvelope<ShopStoreInfo>>> continuation);

    @POST("api_shop.php?action=update_slug")
    Object shopUpdateSlug(@Body SlugBody slugBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_shop.php?action=update_store_info")
    Object shopUpdateStoreInfo(@Body ShopInfoBody shopInfoBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @GET("api.php?action=store_stats")
    Object storeStats(@Query("from") String str, @Query("to") String str2, Continuation<? super Response<ApiEnvelope<StoreStats>>> continuation);

    @GET("api_support.php?action=list")
    Object supportList(@Query("after_id") Long l, Continuation<? super Response<ApiEnvelope<SupportListResponse>>> continuation);

    @POST("api_support.php")
    Object supportSend(@Body SupportSendBody supportSendBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @GET("api_sync.php")
    Object syncPull(@Query("since") String str, Continuation<? super Response<ApiEnvelope<SyncData>>> continuation);

    @POST("api_sync.php")
    Object syncPush(@Body SyncPushBody syncPushBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api.php?action=update_pos_currency")
    Object updatePosCurrency(@Body CurrencyBody currencyBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api.php?action=verify_email")
    Object verifyEmail(@Body VerifyEmailBody verifyEmailBody, Continuation<? super Response<ApiEnvelope<Session>>> continuation);

    @POST("api_workers.php")
    Object workerCreate(@Body WorkerBody workerBody, Continuation<? super Response<ApiEnvelope<WorkerResponse>>> continuation);

    @POST("api_worker_key.php")
    Object workerKey(@Body WorkerKeyBody workerKeyBody, Continuation<? super Response<ApiEnvelope<Session>>> continuation);

    @POST("api_worker_key.php")
    Object workerKeyAction(@Body WorkerKeyBody workerKeyBody, Continuation<? super Response<ApiEnvelope<JsonElement>>> continuation);

    @POST("api_worker_key.php")
    Object workerKeyDevices(@Body WorkerKeyBody workerKeyBody, Continuation<? super Response<ApiEnvelope<WorkerDevicesResponse>>> continuation);

    @POST("api_workers.php")
    Object workerRegenerateKey(@Body WorkerBody workerBody, Continuation<? super Response<ApiEnvelope<WorkerResponse>>> continuation);

    @PUT("api_workers.php")
    Object workerUpdate(@Query("id") long j, @Body WorkerBody workerBody, Continuation<? super Response<ApiEnvelope<WorkerResponse>>> continuation);

    @GET("api_workers.php")
    Object workers(Continuation<? super Response<ApiEnvelope<WorkerListResponse>>> continuation);

    /* compiled from: ApiService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object products$default(ApiService apiService, int i, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: products");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return apiService.products(i, continuation);
    }

    static /* synthetic */ Object categories$default(ApiService apiService, int i, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: categories");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return apiService.categories(i, continuation);
    }

    static /* synthetic */ Object syncPull$default(ApiService apiService, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncPull");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return apiService.syncPull(str, continuation);
    }
}
