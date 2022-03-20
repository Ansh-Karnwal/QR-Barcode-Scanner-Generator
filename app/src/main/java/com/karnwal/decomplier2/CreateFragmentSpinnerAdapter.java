package com.karnwal.decomplier2;

import android.view.View;
import android.widget.AdapterView;

import kotlin.jvm.internal.Intrinsics;

public final class CreateFragmentSpinnerAdapter implements AdapterView.OnItemSelectedListener {
    final String[] barcodeArray;
    final CreateFragment createFragment;

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    CreateFragmentSpinnerAdapter(CreateFragment createFragment, String[] strArr) {
        this.createFragment = createFragment;
        this.barcodeArray = strArr;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        CreateFragment createFragment = this.createFragment;
        String str = this.barcodeArray[i];
        Intrinsics.checkNotNullExpressionValue(str, "barcodeArray[p2]");
        createFragment.barcodeResultType = str;
    }
}
