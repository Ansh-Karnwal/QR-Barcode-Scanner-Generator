package com.karnwal.decomplier2;

import android.content.ContentResolver;
import android.view.View;
import android.widget.ImageView;

public final class CreateFragmentQRImageListener implements View.OnClickListener {
    public final ImageView imageView;
    public final ContentResolver contentResolver;
    public final CreateFragment createFragment;

    public CreateFragmentQRImageListener(ImageView imageView, ContentResolver contentResolver, CreateFragment createFragment) {
        this.imageView = imageView;
        this.contentResolver = contentResolver;
        this.createFragment = createFragment;
    }

    public final void onClick(View view) {
        CreateFragment.saveQRImageListener(this.imageView, this.contentResolver, this.createFragment, view);
    }
}
