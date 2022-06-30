package com.gzeinnumer.b5d6;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

public class PermissionActivity extends BasePermissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        String[] permission = {
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        requestPermission(
                permission,
                new PermissionCallBack() {
                    @Override
                    public void isGranted(boolean isGranted) {
                        if (isGranted)
                            //maukemana
                            Toast.makeText(getApplicationContext(), "intent to clickMulti:diizinkan", Toast.LENGTH_SHORT).show();
                        else
                            openSettings();
                    }
                });
    }
}