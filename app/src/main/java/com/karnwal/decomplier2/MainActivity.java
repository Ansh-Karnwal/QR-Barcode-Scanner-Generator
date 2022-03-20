package com.karnwal.decomplier2;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import com.fondesa.kpermissions.extension.PermissionsBuilderKt;
import com.google.android.material.navigation.NavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/karnwal/qrcode2/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "drawer", "Landroidx/drawerlayout/widget/DrawerLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "app_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Toolbar toolbar;

    public void onCreate(Bundle bundle) {
        DrawerLayout drawerLayout;
        Toolbar toolbar2;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        PermissionsBuilderKt.permissionsBuilder((FragmentActivity) this, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").build().send();
        View findViewById = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.toolbar)");
        this.toolbar = findViewById(R.id.toolbar);

        DrawerLayout drawerLayout2 = null;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar = null;
        }
        setSupportActionBar(toolbar);
        View findViewById2 = findViewById(R.id.drawer_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.drawer_layout)");
        this.drawer = (DrawerLayout) findViewById2;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Activity activity = this;
        DrawerLayout drawerLayout3 = this.drawer;
        if (drawerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawer");
            drawerLayout = null;
        } else {
            drawerLayout = drawerLayout3;
        }
        Toolbar toolbar4 = this.toolbar;
        if (toolbar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            toolbar2 = null;
        } else {
            toolbar2 = toolbar4;
        }
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        DrawerLayout drawerLayout4 = this.drawer;
        if (drawerLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawer");
        } else {
            drawerLayout2 = drawerLayout4;
        }
        drawerLayout2.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScanFragment()).commit();
            navigationView.setCheckedItem((int) R.id.ic_qr);
        }
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = this.drawer;
        DrawerLayout drawerLayout2 = null;
        if (drawerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawer");
            drawerLayout = null;
        }
        if (drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            DrawerLayout drawerLayout3 = this.drawer;
            if (drawerLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("drawer");
            } else {
                drawerLayout2 = drawerLayout3;
            }
            drawerLayout2.closeDrawer((int) GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        switch (menuItem.getItemId()) {
            case R.id.ic_file /*2131296488*/:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FileFragment()).commit();
                break;
            case R.id.ic_generate /*2131296489*/:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CreateFragment()).commit();
                break;
            case R.id.ic_qr /*2131296490*/:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ScanFragment()).commit();
                break;
        }
        DrawerLayout drawerLayout = this.drawer;
        if (drawerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawer");
            drawerLayout = null;
        }
        drawerLayout.closeDrawer((int) GravityCompat.START);
        return true;
    }
}
