package androidx.core.content;

import android.content.SharedPreferences;

@Deprecated
/* loaded from: classes4.dex */
public final class SharedPreferencesCompat {

    @Deprecated
    /* loaded from: classes4.dex */
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper = new Helper();

        /* loaded from: classes4.dex */
        private static class Helper {
            Helper() {
            }

            public void apply(SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            EditorCompat editorCompat = sInstance;
            if (editorCompat != null) {
                return editorCompat;
            }
            EditorCompat editorCompat2 = new EditorCompat();
            sInstance = editorCompat2;
            return editorCompat2;
        }

        @Deprecated
        public void apply(SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
