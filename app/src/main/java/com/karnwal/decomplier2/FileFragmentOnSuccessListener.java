package com.karnwal.decomplier2;

import com.google.android.gms.tasks.OnSuccessListener;
import java.util.List;

public final class FileFragmentOnSuccessListener implements OnSuccessListener {
    public final FileFragment fileFragment;

    public FileFragmentOnSuccessListener(FileFragment fileFragment) {
        this.fileFragment = fileFragment;
    }

    public final void onSuccess(Object obj) {
        FileFragment.decodeFile(this.fileFragment, (List) obj);
    }
}
