package coil;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.transition.Transition;
import kotlin.Metadata;

/* compiled from: EventListener.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 ,2\u00020\u0001:\u0002+,J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0017J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0017J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J*\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J*\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eH\u0017J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020 H\u0017J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020 H\u0017J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0017J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0017J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020(H\u0017J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020*H\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006-À\u0006\u0003"}, d2 = {"Lcoil/EventListener;", "Lcoil/request/ImageRequest$Listener;", "onStart", "", "request", "Lcoil/request/ImageRequest;", "resolveSizeStart", "resolveSizeEnd", "size", "Lcoil/size/Size;", "mapStart", "input", "", "mapEnd", "output", "keyStart", "keyEnd", "", "fetchStart", "fetcher", "Lcoil/fetch/Fetcher;", "options", "Lcoil/request/Options;", "fetchEnd", "result", "Lcoil/fetch/FetchResult;", "decodeStart", "decoder", "Lcoil/decode/Decoder;", "decodeEnd", "Lcoil/decode/DecodeResult;", "transformStart", "Landroid/graphics/Bitmap;", "transformEnd", "transitionStart", "transition", "Lcoil/transition/Transition;", "transitionEnd", "onCancel", "onError", "Lcoil/request/ErrorResult;", "onSuccess", "Lcoil/request/SuccessResult;", "Factory", "Companion", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public interface EventListener extends ImageRequest.Listener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final EventListener NONE = new EventListener() { // from class: coil.EventListener$Companion$NONE$1
    };

    default void decodeEnd(ImageRequest request, Decoder decoder, Options options, DecodeResult result) {
    }

    default void decodeStart(ImageRequest request, Decoder decoder, Options options) {
    }

    default void fetchEnd(ImageRequest request, Fetcher fetcher, Options options, FetchResult result) {
    }

    default void fetchStart(ImageRequest request, Fetcher fetcher, Options options) {
    }

    default void keyEnd(ImageRequest request, String output) {
    }

    default void keyStart(ImageRequest request, Object input) {
    }

    default void mapEnd(ImageRequest request, Object output) {
    }

    default void mapStart(ImageRequest request, Object input) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onCancel(ImageRequest request) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onError(ImageRequest request, ErrorResult result) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onStart(ImageRequest request) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onSuccess(ImageRequest request, SuccessResult result) {
    }

    default void resolveSizeEnd(ImageRequest request, Size size) {
    }

    default void resolveSizeStart(ImageRequest request) {
    }

    default void transformEnd(ImageRequest request, Bitmap output) {
    }

    default void transformStart(ImageRequest request, Bitmap input) {
    }

    default void transitionEnd(ImageRequest request, Transition transition) {
    }

    default void transitionStart(ImageRequest request, Transition transition) {
    }

    /* compiled from: EventListener.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onStart(EventListener eventListener, ImageRequest imageRequest) {
            EventListener.super.onStart(imageRequest);
        }

        @Deprecated
        public static void resolveSizeStart(EventListener eventListener, ImageRequest imageRequest) {
            EventListener.super.resolveSizeStart(imageRequest);
        }

        @Deprecated
        public static void resolveSizeEnd(EventListener eventListener, ImageRequest imageRequest, Size size) {
            EventListener.super.resolveSizeEnd(imageRequest, size);
        }

        @Deprecated
        public static void mapStart(EventListener eventListener, ImageRequest imageRequest, Object obj) {
            EventListener.super.mapStart(imageRequest, obj);
        }

        @Deprecated
        public static void mapEnd(EventListener eventListener, ImageRequest imageRequest, Object obj) {
            EventListener.super.mapEnd(imageRequest, obj);
        }

        @Deprecated
        public static void keyStart(EventListener eventListener, ImageRequest imageRequest, Object obj) {
            EventListener.super.keyStart(imageRequest, obj);
        }

        @Deprecated
        public static void keyEnd(EventListener eventListener, ImageRequest imageRequest, String str) {
            EventListener.super.keyEnd(imageRequest, str);
        }

        @Deprecated
        public static void fetchStart(EventListener eventListener, ImageRequest imageRequest, Fetcher fetcher, Options options) {
            EventListener.super.fetchStart(imageRequest, fetcher, options);
        }

        @Deprecated
        public static void fetchEnd(EventListener eventListener, ImageRequest imageRequest, Fetcher fetcher, Options options, FetchResult fetchResult) {
            EventListener.super.fetchEnd(imageRequest, fetcher, options, fetchResult);
        }

        @Deprecated
        public static void decodeStart(EventListener eventListener, ImageRequest imageRequest, Decoder decoder, Options options) {
            EventListener.super.decodeStart(imageRequest, decoder, options);
        }

        @Deprecated
        public static void decodeEnd(EventListener eventListener, ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
            EventListener.super.decodeEnd(imageRequest, decoder, options, decodeResult);
        }

        @Deprecated
        public static void transformStart(EventListener eventListener, ImageRequest imageRequest, Bitmap bitmap) {
            EventListener.super.transformStart(imageRequest, bitmap);
        }

        @Deprecated
        public static void transformEnd(EventListener eventListener, ImageRequest imageRequest, Bitmap bitmap) {
            EventListener.super.transformEnd(imageRequest, bitmap);
        }

        @Deprecated
        public static void transitionStart(EventListener eventListener, ImageRequest imageRequest, Transition transition) {
            EventListener.super.transitionStart(imageRequest, transition);
        }

        @Deprecated
        public static void transitionEnd(EventListener eventListener, ImageRequest imageRequest, Transition transition) {
            EventListener.super.transitionEnd(imageRequest, transition);
        }

        @Deprecated
        public static void onCancel(EventListener eventListener, ImageRequest imageRequest) {
            EventListener.super.onCancel(imageRequest);
        }

        @Deprecated
        public static void onError(EventListener eventListener, ImageRequest imageRequest, ErrorResult errorResult) {
            EventListener.super.onError(imageRequest, errorResult);
        }

        @Deprecated
        public static void onSuccess(EventListener eventListener, ImageRequest imageRequest, SuccessResult successResult) {
            EventListener.super.onSuccess(imageRequest, successResult);
        }
    }

    /* compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcoil/EventListener$Factory;", "", "create", "Lcoil/EventListener;", "request", "Lcoil/request/ImageRequest;", "Companion", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public interface Factory {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final Factory NONE = new Factory() { // from class: coil.EventListener$Factory$$ExternalSyntheticLambda0
            @Override // coil.EventListener.Factory
            public final EventListener create(ImageRequest imageRequest) {
                EventListener eventListener;
                eventListener = EventListener.NONE;
                return eventListener;
            }
        };

        EventListener create(ImageRequest request);

        /* compiled from: EventListener.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lcoil/EventListener$Factory$Companion;", "", "<init>", "()V", "NONE", "Lcoil/EventListener$Factory;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }
    }

    /* compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lcoil/EventListener$Companion;", "", "<init>", "()V", "NONE", "Lcoil/EventListener;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
