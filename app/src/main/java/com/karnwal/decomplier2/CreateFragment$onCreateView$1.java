package com.karnwal.decomplier2;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"com/karnwal/qrcode2/CreateFragment$onCreateView$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "p0", "Landroid/widget/AdapterView;", "p1", "Landroid/view/View;", "p2", "", "p3", "", "onNothingSelected", "app_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CreateFragment$onCreateView$1 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ String[] $barcodeArray;
    final /* synthetic */ CreateFragment this$0;

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    CreateFragment$onCreateView$1(CreateFragment createFragment, String[] strArr) {
        this.this$0 = createFragment;
        this.$barcodeArray = strArr;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        CreateFragment createFragment = this.this$0;
        String str = this.$barcodeArray[i];
        Intrinsics.checkNotNullExpressionValue(str, "barcodeArray[p2]");
        createFragment.barcodeResultType = str;
    }
}
