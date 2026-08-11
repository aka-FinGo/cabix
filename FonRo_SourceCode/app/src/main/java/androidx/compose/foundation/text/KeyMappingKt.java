package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: KeyMapping.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    public static final KeyMapping commonKeyMapping(final Function1<? super KeyEvent, Boolean> function1) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1375mapZmokQxo(android.view.KeyEvent event) {
                if (function1.invoke(KeyEvent.m5446boximpl(event)).booleanValue() && KeyEvent_androidKt.m5469isShiftPressedZmokQxo(event)) {
                    if (Key.m5155equalsimpl0(KeyEvent_androidKt.m5463getKeyZmokQxo(event), MappedKeys.INSTANCE.m1430getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (function1.invoke(KeyEvent.m5446boximpl(event)).booleanValue()) {
                    long m5463getKeyZmokQxo = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1409getCEK5gGoQ()) ? true : Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1419getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1427getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1428getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1406getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1429getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1430getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m5467isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m5469isShiftPressedZmokQxo(event)) {
                    long m5463getKeyZmokQxo2 = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1414getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1415getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1416getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1413getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1424getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1423getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1421getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1420getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1419getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long m5463getKeyZmokQxo3 = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1414getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1415getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1416getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1413getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1424getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1423getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1421getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1420getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1417getEnterEK5gGoQ()) ? true : Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1422getNumPadEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1408getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1412getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1425getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1411getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1410getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1426getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping commonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m5467isCtrlPressedZmokQxo(((KeyEvent) obj).m5452unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1375mapZmokQxo(android.view.KeyEvent event) {
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m5469isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m5467isCtrlPressedZmokQxo(event)) {
                    long m5463getKeyZmokQxo = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1414getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1415getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1416getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo, MappedKeys.INSTANCE.m1413getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m5467isCtrlPressedZmokQxo(event)) {
                    long m5463getKeyZmokQxo2 = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1414getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1415getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1416getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1413getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1418getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1412getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1408getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo2, MappedKeys.INSTANCE.m1407getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m5469isShiftPressedZmokQxo(event)) {
                    long m5463getKeyZmokQxo3 = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1421getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_START;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo3, MappedKeys.INSTANCE.m1420getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_END;
                    }
                } else if (KeyEvent_androidKt.m5466isAltPressedZmokQxo(event)) {
                    long m5463getKeyZmokQxo4 = KeyEvent_androidKt.m5463getKeyZmokQxo(event);
                    if (Key.m5155equalsimpl0(m5463getKeyZmokQxo4, MappedKeys.INSTANCE.m1408getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m5155equalsimpl0(m5463getKeyZmokQxo4, MappedKeys.INSTANCE.m1412getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? KeyMapping.this.mo1375mapZmokQxo(event) : keyCommand;
            }
        };
    }
}
