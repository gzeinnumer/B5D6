package com.gzeinnumer.b5d6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.gzeinnumer.b5d6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SessionManager sessionManager;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sessionManager = new SessionManager(getApplicationContext());

        initOnClick();

    }

    private void initOnClick() {
        binding.btnSimpan.setOnClickListener(view -> {
            String id = binding.edId.getText().toString();
            String name = binding.edName.getText().toString();

            sessionManager.setId(id);
//            sessionManager.setValue(SessionManager.KEY_ID, id);
            sessionManager.setValue(SessionManager.KEY_NAME, name);

            binding.edId.setText("");
            binding.edName.setText("");
            Toast.makeText(getApplicationContext(), "Success simpan data ke session", Toast.LENGTH_SHORT).show();
        });

        binding.btnLoadData.setOnClickListener(view -> {
            String id = sessionManager.getId();
//            String id = sessionManager.getValue(SessionManager.KEY_ID);
            String name = sessionManager.getValue(SessionManager.KEY_NAME);

            String msg = "ID : "+id+"\n"+"Name : "+name;
            binding.tvLastData.setText(msg);
        });

        binding.btnLogout.setOnClickListener(view -> {
            sessionManager.logout();
        });

        binding.btnPermission.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PermissionActivity.class);
            startActivity(intent);
        });
    }
}