package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.mThemeResource = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.mResources != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.mOverrideConfiguration != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.mOverrideConfiguration = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    private Resources getResourcesInternal() {
        Resources resources = this.mResources;
        if (resources != null) {
            return resources;
        }
        if (this.mOverrideConfiguration == null || (Build.VERSION.SDK_INT >= 26 && isEmptyConfiguration(this.mOverrideConfiguration))) {
            Resources resources2 = super.getResources();
            this.mResources = resources2;
            return resources2;
        }
        Resources resources3 = createConfigurationContext(this.mOverrideConfiguration).getResources();
        this.mResources = resources3;
        return resources3;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.mThemeResource != i) {
            this.mThemeResource = i;
            initializeTheme();
        }
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        if (theme != null) {
            return theme;
        }
        if (this.mThemeResource == 0) {
            this.mThemeResource = R.style.Theme_AppCompat_Light;
        }
        initializeTheme();
        return this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            LayoutInflater layoutInflater = this.mInflater;
            if (layoutInflater != null) {
                return layoutInflater;
            }
            LayoutInflater cloneInContext = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            this.mInflater = cloneInContext;
            return cloneInContext;
        }
        return getBaseContext().getSystemService(str);
    }

    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void initializeTheme() {
        boolean z = this.mTheme == null;
        if (z) {
            this.mTheme = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        onApplyThemeResource(this.mTheme, this.mThemeResource, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    private static boolean isEmptyConfiguration(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        Configuration configuration2 = sEmptyConfig;
        if (configuration2 == null) {
            configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            sEmptyConfig = configuration2;
        }
        return configuration.equals(configuration2);
    }
}
