package com.karnwal.decomplier2;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import java.util.Objects;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/karnwal/qrcode2/CreateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "barcodeResultType", "", "getBarcodeFormat", "Lcom/google/zxing/BarcodeFormat;", "getRandomInt", "", "from", "to", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CreateFragment extends Fragment {
    public String barcodeResultType;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_create, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.QRImage);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.BarcodeImage);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView2 = (ImageView) findViewById2;
        Button qrbutton = inflate.findViewById(R.id.saveQRImageButton);
        Button barbutton = inflate.findViewById(R.id.saveBarcodeButton);
        Button encodeButton = inflate.findViewById(R.id.encodeButton);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.spinner);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ContentResolver contentResolver = activity.getContentResolver();
        imageView.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        qrbutton.setVisibility(View.GONE);
        barbutton.setVisibility(View.GONE);
        String[] stringArray = getResources().getStringArray(R.array.barcodeArray);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.barcodeArray)");
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        spinner.setAdapter(new ArrayAdapter(activity2, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, stringArray));
        spinner.setOnItemSelectedListener(new CreateFragment$onCreateView$1(this, stringArray));
        qrbutton.setOnClickListener(new CreateFragment$$ExternalSyntheticLambda1((ImageView) inflate.findViewById(R.id.QRImage), contentResolver, this));
        barbutton.setOnClickListener(new CreateFragment$$ExternalSyntheticLambda2((ImageView) inflate.findViewById(R.id.BarcodeImage), contentResolver, this));
        encodeButton.setOnClickListener(new CreateFragment$$ExternalSyntheticLambda0((EditText) inflate.findViewById(R.id.inputText), this, (ImageView) inflate.findViewById(R.id.QRImage), (ImageView) inflate.findViewById(R.id.BarcodeImage), qrbutton, barbutton));
        return inflate;
    }

    public static final void m237onCreateView$lambda0(EditText editText, CreateFragment createFragment, ImageView imageView, ImageView imageView2, Button button, Button button2, View view) {
        Intrinsics.checkNotNullParameter(createFragment, "this$0");
        Intrinsics.checkNotNullParameter(imageView, "$imageViewQrCode");
        Intrinsics.checkNotNullParameter(imageView2, "$imageViewBarCode");
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap encodeBitmap = barcodeEncoder.encodeBitmap(String.valueOf(editText.getText()), BarcodeFormat.QR_CODE, 650, 650);
            Bitmap encodeBitmap2 = barcodeEncoder.encodeBitmap(String.valueOf(editText.getText()), createFragment.getBarcodeFormat(), 1200, 300);
            imageView.setImageBitmap(encodeBitmap);
            imageView2.setImageBitmap(encodeBitmap2);
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
        } catch (Exception unused) {
        }
    }


    public static final void m238onCreateView$lambda1(ImageView imageView, ContentResolver contentResolver, CreateFragment createFragment, View view) {
        Intrinsics.checkNotNullParameter(createFragment, "this$0");
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Intrinsics.checkNotNullExpressionValue(drawable, "qRimage.drawable");
        MediaStore.Images.Media.insertImage(contentResolver, bitmap, Intrinsics.stringPlus("QR Code ", Integer.valueOf(createFragment.getRandomInt(1, 1000000000))), "QR Code");

    }


    public static final void m239onCreateView$lambda2(ImageView imageView, ContentResolver contentResolver, CreateFragment createFragment, View view) {
        Intrinsics.checkNotNullParameter(createFragment, "this$0");
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Intrinsics.checkNotNullExpressionValue(drawable, "barcodeImage.drawable");
        MediaStore.Images.Media.insertImage(contentResolver, bitmap, Intrinsics.stringPlus("Bar Code ", Integer.valueOf(createFragment.getRandomInt(1, 1000000000))), "Bar Code");
    }

    private final int getRandomInt(int i, int i2) {
        return new Random().nextInt(i2 - i) + i;
    }

    private final BarcodeFormat getBarcodeFormat() {
        String str = this.barcodeResultType;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str = null;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "Code 128")) {
            return BarcodeFormat.CODE_128;
        }
        String str3 = this.barcodeResultType;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str3 = null;
        }
        if (Intrinsics.areEqual((Object) str3, (Object) "Code 39")) {
            return BarcodeFormat.CODE_39;
        }
        String str4 = this.barcodeResultType;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str4 = null;
        }
        if (Intrinsics.areEqual((Object) str4, (Object) "Code 93")) {
            return BarcodeFormat.CODE_93;
        }
        String str5 = this.barcodeResultType;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str5 = null;
        }
        if (Intrinsics.areEqual((Object) str5, (Object) "EAN 13")) {
            return BarcodeFormat.EAN_13;
        }
        String str6 = this.barcodeResultType;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str6 = null;
        }
        if (Intrinsics.areEqual((Object) str6, (Object) "EAN 8")) {
            return BarcodeFormat.EAN_8;
        }
        String str7 = this.barcodeResultType;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str7 = null;
        }
        if (Intrinsics.areEqual((Object) str7, (Object) "ITF")) {
            return BarcodeFormat.ITF;
        }
        String str8 = this.barcodeResultType;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str8 = null;
        }
        if (Intrinsics.areEqual((Object) str8, (Object) "UPC A")) {
            return BarcodeFormat.UPC_A;
        }
        String str9 = this.barcodeResultType;
        if (str9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
            str9 = null;
        }
        if (Intrinsics.areEqual((Object) str9, (Object) "UPC E")) {
            return BarcodeFormat.UPC_E;
        }
        String str10 = this.barcodeResultType;
        if (str10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeResultType");
        } else {
            str2 = str10;
        }
        if (Intrinsics.areEqual((Object) str2, (Object) "CODABAR")) {
            return BarcodeFormat.CODABAR;
        }
        return BarcodeFormat.CODE_128;
    }
}
