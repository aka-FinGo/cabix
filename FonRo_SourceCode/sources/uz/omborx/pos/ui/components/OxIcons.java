package uz.FonRo.pos.ui.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.AccountBalanceWalletKt;
import androidx.compose.material.icons.rounded.AddKt;
import androidx.compose.material.icons.rounded.ArchiveKt;
import androidx.compose.material.icons.rounded.ArrowBackKt;
import androidx.compose.material.icons.rounded.AssignmentReturnKt;
import androidx.compose.material.icons.rounded.BarChartKt;
import androidx.compose.material.icons.rounded.BluetoothKt;
import androidx.compose.material.icons.rounded.CameraAltKt;
import androidx.compose.material.icons.rounded.ChatBubbleOutlineKt;
import androidx.compose.material.icons.rounded.CheckCircleKt;
import androidx.compose.material.icons.rounded.ChevronRightKt;
import androidx.compose.material.icons.rounded.CloseKt;
import androidx.compose.material.icons.rounded.CreditCardKt;
import androidx.compose.material.icons.rounded.DeleteKt;
import androidx.compose.material.icons.rounded.EditKt;
import androidx.compose.material.icons.rounded.FactCheckKt;
import androidx.compose.material.icons.rounded.FormatSizeKt;
import androidx.compose.material.icons.rounded.FunctionsKt;
import androidx.compose.material.icons.rounded.GridViewKt;
import androidx.compose.material.icons.rounded.GroupsKt;
import androidx.compose.material.icons.rounded.Inventory2Kt;
import androidx.compose.material.icons.rounded.LanguageKt;
import androidx.compose.material.icons.rounded.LocalOfferKt;
import androidx.compose.material.icons.rounded.LockKt;
import androidx.compose.material.icons.rounded.MoveToInboxKt;
import androidx.compose.material.icons.rounded.NotificationsNoneKt;
import androidx.compose.material.icons.rounded.PaletteKt;
import androidx.compose.material.icons.rounded.PaymentsKt;
import androidx.compose.material.icons.rounded.PersonKt;
import androidx.compose.material.icons.rounded.PhoneAndroidKt;
import androidx.compose.material.icons.rounded.PrintKt;
import androidx.compose.material.icons.rounded.QrCode2Kt;
import androidx.compose.material.icons.rounded.QrCodeScannerKt;
import androidx.compose.material.icons.rounded.ReceiptLongKt;
import androidx.compose.material.icons.rounded.RefreshKt;
import androidx.compose.material.icons.rounded.ScheduleKt;
import androidx.compose.material.icons.rounded.SettingsKt;
import androidx.compose.material.icons.rounded.ShareKt;
import androidx.compose.material.icons.rounded.ShoppingBagKt;
import androidx.compose.material.icons.rounded.ShoppingCartKt;
import androidx.compose.material.icons.rounded.StorefrontKt;
import androidx.compose.material.icons.rounded.TableChartKt;
import androidx.compose.material.icons.rounded.WarningKt;
import androidx.compose.material.icons.rounded.WorkspacePremiumKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;

/* compiled from: OxIcons.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bY\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0011\u0010<\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0011\u0010@\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0011\u0010L\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0011\u0010\\\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007Ê\u0001\f\b_\u0012\b\b`\u0012\u0004\b\u0003\u0010\u0002¨\u0006^"}, d2 = {"Luz/FonRo/pos/ui/components/OxIcons;", "", "<init>", "()V", "Inbox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getInbox", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "Box", "getBox", "Cart", "getCart", "Chart", "getChart", "Clipboard", "getClipboard", "Bell", "getBell", "Clock", "getClock", "Gear", "getGear", "Store", "getStore", "Undo", "getUndo", "Users", "getUsers", "User", "getUser", "Printer", "getPrinter", "Chat", "getChat", "Phone", "getPhone", "Card", "getCard", "Bag", "getBag", "Wallet", "getWallet", "Receipt", "getReceipt", "Cash", "getCash", "Scan", "getScan", "QrCode", "getQrCode", "Camera", "getCamera", "Add", "getAdd", "Edit", "getEdit", "Delete", "getDelete", "Back", "getBack", "Chevron", "getChevron", "TextSize", "getTextSize", "Ok", "getOk", HttpHeaders.WARNING, "getWarning", "Tag", "getTag", "Table", "getTable", "Bluetooth", "getBluetooth", "Share", "getShare", HttpHeaders.REFRESH, "getRefresh", "Close", "getClose", "Lock", "getLock", "Archive", "getArchive", "Grid", "getGrid", "Sum", "getSum", "Palette", "getPalette", "Language", "getLanguage", "Crown", "getCrown", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class OxIcons {
    public static final int $stable = 0;
    public static final OxIcons INSTANCE = new OxIcons();
    private static final ImageVector Inbox = MoveToInboxKt.getMoveToInbox(Icons.Rounded.INSTANCE);
    private static final ImageVector Box = Inventory2Kt.getInventory2(Icons.Rounded.INSTANCE);
    private static final ImageVector Cart = ShoppingCartKt.getShoppingCart(Icons.Rounded.INSTANCE);
    private static final ImageVector Chart = BarChartKt.getBarChart(Icons.Rounded.INSTANCE);
    private static final ImageVector Clipboard = FactCheckKt.getFactCheck(Icons.Rounded.INSTANCE);
    private static final ImageVector Bell = NotificationsNoneKt.getNotificationsNone(Icons.Rounded.INSTANCE);
    private static final ImageVector Clock = ScheduleKt.getSchedule(Icons.Rounded.INSTANCE);
    private static final ImageVector Gear = SettingsKt.getSettings(Icons.Rounded.INSTANCE);
    private static final ImageVector Store = StorefrontKt.getStorefront(Icons.Rounded.INSTANCE);
    private static final ImageVector Undo = AssignmentReturnKt.getAssignmentReturn(Icons.Rounded.INSTANCE);
    private static final ImageVector Users = GroupsKt.getGroups(Icons.Rounded.INSTANCE);
    private static final ImageVector User = PersonKt.getPerson(Icons.Rounded.INSTANCE);
    private static final ImageVector Printer = PrintKt.getPrint(Icons.Rounded.INSTANCE);
    private static final ImageVector Chat = ChatBubbleOutlineKt.getChatBubbleOutline(Icons.Rounded.INSTANCE);
    private static final ImageVector Phone = PhoneAndroidKt.getPhoneAndroid(Icons.Rounded.INSTANCE);
    private static final ImageVector Card = CreditCardKt.getCreditCard(Icons.Rounded.INSTANCE);
    private static final ImageVector Bag = ShoppingBagKt.getShoppingBag(Icons.Rounded.INSTANCE);
    private static final ImageVector Wallet = AccountBalanceWalletKt.getAccountBalanceWallet(Icons.Rounded.INSTANCE);
    private static final ImageVector Receipt = ReceiptLongKt.getReceiptLong(Icons.Rounded.INSTANCE);
    private static final ImageVector Cash = PaymentsKt.getPayments(Icons.Rounded.INSTANCE);
    private static final ImageVector Scan = QrCodeScannerKt.getQrCodeScanner(Icons.Rounded.INSTANCE);
    private static final ImageVector QrCode = QrCode2Kt.getQrCode2(Icons.Rounded.INSTANCE);
    private static final ImageVector Camera = CameraAltKt.getCameraAlt(Icons.Rounded.INSTANCE);
    private static final ImageVector Add = AddKt.getAdd(Icons.Rounded.INSTANCE);
    private static final ImageVector Edit = EditKt.getEdit(Icons.Rounded.INSTANCE);
    private static final ImageVector Delete = DeleteKt.getDelete(Icons.Rounded.INSTANCE);
    private static final ImageVector Back = ArrowBackKt.getArrowBack(Icons.Rounded.INSTANCE);
    private static final ImageVector Chevron = ChevronRightKt.getChevronRight(Icons.Rounded.INSTANCE);
    private static final ImageVector TextSize = FormatSizeKt.getFormatSize(Icons.Rounded.INSTANCE);
    private static final ImageVector Ok = CheckCircleKt.getCheckCircle(Icons.Rounded.INSTANCE);
    private static final ImageVector Warning = WarningKt.getWarning(Icons.Rounded.INSTANCE);
    private static final ImageVector Tag = LocalOfferKt.getLocalOffer(Icons.Rounded.INSTANCE);
    private static final ImageVector Table = TableChartKt.getTableChart(Icons.Rounded.INSTANCE);
    private static final ImageVector Bluetooth = BluetoothKt.getBluetooth(Icons.Rounded.INSTANCE);
    private static final ImageVector Share = ShareKt.getShare(Icons.Rounded.INSTANCE);
    private static final ImageVector Refresh = RefreshKt.getRefresh(Icons.Rounded.INSTANCE);
    private static final ImageVector Close = CloseKt.getClose(Icons.Rounded.INSTANCE);
    private static final ImageVector Lock = LockKt.getLock(Icons.Rounded.INSTANCE);
    private static final ImageVector Archive = ArchiveKt.getArchive(Icons.Rounded.INSTANCE);
    private static final ImageVector Grid = GridViewKt.getGridView(Icons.Rounded.INSTANCE);
    private static final ImageVector Sum = FunctionsKt.getFunctions(Icons.Rounded.INSTANCE);
    private static final ImageVector Palette = PaletteKt.getPalette(Icons.Rounded.INSTANCE);
    private static final ImageVector Language = LanguageKt.getLanguage(Icons.Rounded.INSTANCE);
    private static final ImageVector Crown = WorkspacePremiumKt.getWorkspacePremium(Icons.Rounded.INSTANCE);

    private OxIcons() {
    }

    public final ImageVector getInbox() {
        return Inbox;
    }

    public final ImageVector getBox() {
        return Box;
    }

    public final ImageVector getCart() {
        return Cart;
    }

    public final ImageVector getChart() {
        return Chart;
    }

    public final ImageVector getClipboard() {
        return Clipboard;
    }

    public final ImageVector getBell() {
        return Bell;
    }

    public final ImageVector getClock() {
        return Clock;
    }

    public final ImageVector getGear() {
        return Gear;
    }

    public final ImageVector getStore() {
        return Store;
    }

    public final ImageVector getUndo() {
        return Undo;
    }

    public final ImageVector getUsers() {
        return Users;
    }

    public final ImageVector getUser() {
        return User;
    }

    public final ImageVector getPrinter() {
        return Printer;
    }

    public final ImageVector getChat() {
        return Chat;
    }

    public final ImageVector getPhone() {
        return Phone;
    }

    public final ImageVector getCard() {
        return Card;
    }

    public final ImageVector getBag() {
        return Bag;
    }

    public final ImageVector getWallet() {
        return Wallet;
    }

    public final ImageVector getReceipt() {
        return Receipt;
    }

    public final ImageVector getCash() {
        return Cash;
    }

    public final ImageVector getScan() {
        return Scan;
    }

    public final ImageVector getQrCode() {
        return QrCode;
    }

    public final ImageVector getCamera() {
        return Camera;
    }

    public final ImageVector getAdd() {
        return Add;
    }

    public final ImageVector getEdit() {
        return Edit;
    }

    public final ImageVector getDelete() {
        return Delete;
    }

    public final ImageVector getBack() {
        return Back;
    }

    public final ImageVector getChevron() {
        return Chevron;
    }

    public final ImageVector getTextSize() {
        return TextSize;
    }

    public final ImageVector getOk() {
        return Ok;
    }

    public final ImageVector getWarning() {
        return Warning;
    }

    public final ImageVector getTag() {
        return Tag;
    }

    public final ImageVector getTable() {
        return Table;
    }

    public final ImageVector getBluetooth() {
        return Bluetooth;
    }

    public final ImageVector getShare() {
        return Share;
    }

    public final ImageVector getRefresh() {
        return Refresh;
    }

    public final ImageVector getClose() {
        return Close;
    }

    public final ImageVector getLock() {
        return Lock;
    }

    public final ImageVector getArchive() {
        return Archive;
    }

    public final ImageVector getGrid() {
        return Grid;
    }

    public final ImageVector getSum() {
        return Sum;
    }

    public final ImageVector getPalette() {
        return Palette;
    }

    public final ImageVector getLanguage() {
        return Language;
    }

    public final ImageVector getCrown() {
        return Crown;
    }
}
