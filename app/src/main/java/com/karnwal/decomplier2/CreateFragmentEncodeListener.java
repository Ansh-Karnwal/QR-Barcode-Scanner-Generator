package com.karnwal.decomplier2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public final class CreateFragmentEncodeListener implements View.OnClickListener {
    public final EditText editText;
    public final CreateFragment createFragment;
    public final ImageView imageView;
    public final ImageView imageView1;
    public final Button button;
    public final Button button1;

    public CreateFragmentEncodeListener(EditText editText, CreateFragment createFragment, ImageView imageView, ImageView imageView2, Button button, Button button2) {
        this.editText = editText;
        this.createFragment = createFragment;
        this.imageView = imageView;
        this.imageView1 = imageView2;
        this.button = button;
        this.button1 = button2;
    }

    public final void onClick(View view) {
        CreateFragment.encodeButtonListener(this.editText, this.createFragment, this.imageView, this.imageView1, this.button, this.button1, view);
    }
}
