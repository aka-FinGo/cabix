package androidx.privacysandbox.ads.adservices.common;

import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.ReportEventRequest;
import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.adselection.UpdateAdCounterHistogramRequest;
import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.adservices.common.AdData;
import android.adservices.common.AdFilters;
import android.adservices.common.FrequencyCapFilters;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.net.Uri;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class AdFilters$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ ReportEventRequest.Builder m(long j, String str, String str2, int i) {
        return new ReportEventRequest.Builder(j, str, str2, i);
    }

    public static /* synthetic */ ReportImpressionRequest m(long j) {
        return new ReportImpressionRequest(j);
    }

    public static /* synthetic */ ReportImpressionRequest m(long j, AdSelectionConfig adSelectionConfig) {
        return new ReportImpressionRequest(j, adSelectionConfig);
    }

    public static /* synthetic */ UpdateAdCounterHistogramRequest.Builder m(long j, int i, android.adservices.common.AdTechIdentifier adTechIdentifier) {
        return new UpdateAdCounterHistogramRequest.Builder(j, i, adTechIdentifier);
    }

    public static /* bridge */ /* synthetic */ AppSetId m(Object obj) {
        return (AppSetId) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AppSetIdManager m7438m(Object obj) {
        return (AppSetIdManager) obj;
    }

    public static /* synthetic */ AdData.Builder m() {
        return new AdData.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ AdFilters.Builder m7439m() {
        return new AdFilters.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ FrequencyCapFilters.Builder m7441m() {
        return new FrequencyCapFilters.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CustomAudience.Builder m7442m() {
        return new CustomAudience.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CustomAudienceManager m7444m(Object obj) {
        return (CustomAudienceManager) obj;
    }

    public static /* synthetic */ FetchAndJoinCustomAudienceRequest.Builder m(Uri uri) {
        return new FetchAndJoinCustomAudienceRequest.Builder(uri);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ JoinCustomAudienceRequest.Builder m7445m() {
        return new JoinCustomAudienceRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ LeaveCustomAudienceRequest.Builder m7446m() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TrustedBiddingData.Builder m7447m() {
        return new TrustedBiddingData.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ DeletionRequest.Builder m7448m() {
        return new DeletionRequest.Builder();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ MeasurementManager m7450m(Object obj) {
        return (MeasurementManager) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebSourceParams.Builder m7451m(Uri uri) {
        return new WebSourceParams.Builder(uri);
    }

    public static /* synthetic */ WebSourceRegistrationRequest.Builder m(List list, Uri uri) {
        return new WebSourceRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebTriggerParams.Builder m7452m(Uri uri) {
        return new WebTriggerParams.Builder(uri);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebTriggerRegistrationRequest.Builder m7453m(List list, Uri uri) {
        return new WebTriggerRegistrationRequest.Builder(list, uri);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m7454m() {
        return AppSetIdManager.class;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m7456m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return CustomAudienceManager.class;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m7457m$1() {
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return MeasurementManager.class;
    }

    /* renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m7458m$2() {
    }

    public static /* synthetic */ void m$3() {
    }

    public static /* synthetic */ void m$4() {
    }

    public static /* synthetic */ void m$5() {
    }

    public static /* synthetic */ void m$6() {
    }

    public static /* synthetic */ void m$7() {
    }
}
