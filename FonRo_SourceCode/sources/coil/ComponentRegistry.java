package coil;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.key.Keyer;
import coil.map.Mapper;
import coil.request.Options;
import coil.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComponentRegistry.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001*B«\u0001\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00120\u0010\u0005\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003\u0012(\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003\u0012(\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011J\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ8\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020 H\u0007J8\u0010$\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 \u0018\u00010\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020 H\u0007J\u0006\u0010(\u001a\u00020)R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R;\u0010\u0005\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R3\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R3\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006+"}, d2 = {"Lcoil/ComponentRegistry;", "", "interceptors", "", "Lcoil/intercept/Interceptor;", "mappers", "Lkotlin/Pair;", "Lcoil/map/Mapper;", "Ljava/lang/Class;", "keyers", "Lcoil/key/Keyer;", "fetcherFactories", "Lcoil/fetch/Fetcher$Factory;", "decoderFactories", "Lcoil/decode/Decoder$Factory;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "()V", "getInterceptors", "()Ljava/util/List;", "getMappers", "getKeyers", "getFetcherFactories", "getDecoderFactories", "map", "data", "options", "Lcoil/request/Options;", "key", "", "newFetcher", "Lcoil/fetch/Fetcher;", "", "imageLoader", "Lcoil/ImageLoader;", "startIndex", "newDecoder", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "newBuilder", "Lcoil/ComponentRegistry$Builder;", "Builder", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ComponentRegistry {
    private final List<Decoder.Factory> decoderFactories;
    private final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> fetcherFactories;
    private final List<Interceptor> interceptors;
    private final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> keyers;
    private final List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> mappers;

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    public final Pair<Decoder, Integer> newDecoder(SourceResult sourceResult, Options options, ImageLoader imageLoader) {
        return newDecoder$default(this, sourceResult, options, imageLoader, 0, 8, null);
    }

    public final Pair<Fetcher, Integer> newFetcher(Object obj, Options options, ImageLoader imageLoader) {
        return newFetcher$default(this, obj, options, imageLoader, 0, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ComponentRegistry(List<? extends Interceptor> list, List<? extends Pair<? extends Mapper<? extends Object, ? extends Object>, ? extends Class<? extends Object>>> list2, List<? extends Pair<? extends Keyer<? extends Object>, ? extends Class<? extends Object>>> list3, List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends Class<? extends Object>>> list4, List<? extends Decoder.Factory> list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.fetcherFactories = list4;
        this.decoderFactories = list5;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> getMappers() {
        return this.mappers;
    }

    public final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> getKeyers() {
        return this.keyers;
    }

    public final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> getFetcherFactories() {
        return this.fetcherFactories;
    }

    public final List<Decoder.Factory> getDecoderFactories() {
        return this.decoderFactories;
    }

    public ComponentRegistry() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final Object map(Object data, Options options) {
        List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> list = this.mappers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>> pair = list.get(i);
            Mapper<? extends Object, ? extends Object> component1 = pair.component1();
            if (pair.component2().isAssignableFrom(data.getClass())) {
                Intrinsics.checkNotNull(component1, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object map = component1.map(data, options);
                if (map != null) {
                    data = map;
                }
            }
        }
        return data;
    }

    public final String key(Object data, Options options) {
        List<Pair<Keyer<? extends Object>, Class<? extends Object>>> list = this.keyers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair<Keyer<? extends Object>, Class<? extends Object>> pair = list.get(i);
            Keyer<? extends Object> component1 = pair.component1();
            if (pair.component2().isAssignableFrom(data.getClass())) {
                Intrinsics.checkNotNull(component1, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String key = component1.key(data, options);
                if (key != null) {
                    return key;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair newFetcher$default(ComponentRegistry componentRegistry, Object obj, Options options, ImageLoader imageLoader, int i, int i2, Object obj2) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return componentRegistry.newFetcher(obj, options, imageLoader, i);
    }

    public final Pair<Fetcher, Integer> newFetcher(Object data, Options options, ImageLoader imageLoader, int startIndex) {
        int size = this.fetcherFactories.size();
        while (startIndex < size) {
            Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>> pair = this.fetcherFactories.get(startIndex);
            Fetcher.Factory<? extends Object> component1 = pair.component1();
            if (pair.component2().isAssignableFrom(data.getClass())) {
                Intrinsics.checkNotNull(component1, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                Fetcher create = component1.create(data, options, imageLoader);
                if (create != null) {
                    return TuplesKt.to(create, Integer.valueOf(startIndex));
                }
            }
            startIndex++;
        }
        return null;
    }

    public static /* synthetic */ Pair newDecoder$default(ComponentRegistry componentRegistry, SourceResult sourceResult, Options options, ImageLoader imageLoader, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return componentRegistry.newDecoder(sourceResult, options, imageLoader, i);
    }

    public final Pair<Decoder, Integer> newDecoder(SourceResult result, Options options, ImageLoader imageLoader, int startIndex) {
        int size = this.decoderFactories.size();
        while (startIndex < size) {
            Decoder create = this.decoderFactories.get(startIndex).create(result, options, imageLoader);
            if (create != null) {
                return TuplesKt.to(create, Integer.valueOf(startIndex));
            }
            startIndex++;
        }
        return null;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* compiled from: ComponentRegistry.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\tJ'\u0010\u001a\u001a\u00020\u0000\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\u0010\u0010\u001d\u001a\f\u0012\u0004\u0012\u0002H\u001c\u0012\u0002\b\u00030\u000eH\u0086\bJ0\u0010\u001a\u001a\u00020\u0000\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0010\u0010\u001d\u001a\f\u0012\u0004\u0012\u0002H\u001c\u0012\u0002\b\u00030\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u000fJ#\u0010\u001a\u001a\u00020\u0000\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0012H\u0086\bJ,\u0010\u001a\u001a\u00020\u0000\"\b\b\u0000\u0010\u001c*\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u000fJ#\u0010\u001a\u001a\u00020\u0000\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0015H\u0086\bJ,\u0010\u001a\u001a\u00020\u0000\"\b\b\u0000\u0010\u001c*\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u000fJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR:\u0010\f\u001a(\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\u000e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR6\u0010\u0011\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR6\u0010\u0014\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0015\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f0\r0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000b¨\u0006\""}, d2 = {"Lcoil/ComponentRegistry$Builder;", "", "<init>", "()V", "registry", "Lcoil/ComponentRegistry;", "(Lcoil/ComponentRegistry;)V", "interceptors", "", "Lcoil/intercept/Interceptor;", "getInterceptors$coil_base_release", "()Ljava/util/List;", "mappers", "Lkotlin/Pair;", "Lcoil/map/Mapper;", "Ljava/lang/Class;", "getMappers$coil_base_release", "keyers", "Lcoil/key/Keyer;", "getKeyers$coil_base_release", "fetcherFactories", "Lcoil/fetch/Fetcher$Factory;", "getFetcherFactories$coil_base_release", "decoderFactories", "Lcoil/decode/Decoder$Factory;", "getDecoderFactories$coil_base_release", "add", "interceptor", ExifInterface.GPS_DIRECTION_TRUE, "mapper", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "keyer", "factory", "build", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private final List<Decoder.Factory> decoderFactories;
        private final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> fetcherFactories;
        private final List<Interceptor> interceptors;
        private final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> keyers;
        private final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> mappers;

        public final List<Interceptor> getInterceptors$coil_base_release() {
            return this.interceptors;
        }

        public final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> getMappers$coil_base_release() {
            return this.mappers;
        }

        public final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> getKeyers$coil_base_release() {
            return this.keyers;
        }

        public final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> getFetcherFactories$coil_base_release() {
            return this.fetcherFactories;
        }

        public final List<Decoder.Factory> getDecoderFactories$coil_base_release() {
            return this.decoderFactories;
        }

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.fetcherFactories = new ArrayList();
            this.decoderFactories = new ArrayList();
        }

        public Builder(ComponentRegistry componentRegistry) {
            this.interceptors = CollectionsKt.toMutableList((Collection) componentRegistry.getInterceptors());
            this.mappers = CollectionsKt.toMutableList((Collection) componentRegistry.getMappers());
            this.keyers = CollectionsKt.toMutableList((Collection) componentRegistry.getKeyers());
            this.fetcherFactories = CollectionsKt.toMutableList((Collection) componentRegistry.getFetcherFactories());
            this.decoderFactories = CollectionsKt.toMutableList((Collection) componentRegistry.getDecoderFactories());
        }

        public final Builder add(Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public final /* synthetic */ <T> Builder add(Mapper<T, ?> mapper) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(mapper, Object.class);
        }

        public final <T> Builder add(Mapper<T, ?> mapper, Class<T> type) {
            this.mappers.add(TuplesKt.to(mapper, type));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Keyer<T> keyer) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(keyer, Object.class);
        }

        public final <T> Builder add(Keyer<T> keyer, Class<T> type) {
            this.keyers.add(TuplesKt.to(keyer, type));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Fetcher.Factory<T> factory) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(factory, Object.class);
        }

        public final <T> Builder add(Fetcher.Factory<T> factory, Class<T> type) {
            this.fetcherFactories.add(TuplesKt.to(factory, type));
            return this;
        }

        public final Builder add(Decoder.Factory factory) {
            this.decoderFactories.add(factory);
            return this;
        }

        public final ComponentRegistry build() {
            return new ComponentRegistry(Collections.toImmutableList(this.interceptors), Collections.toImmutableList(this.mappers), Collections.toImmutableList(this.keyers), Collections.toImmutableList(this.fetcherFactories), Collections.toImmutableList(this.decoderFactories), null);
        }
    }
}
