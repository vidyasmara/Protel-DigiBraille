package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button btnteks = findViewById(R.id.btn_teks);
        btnteks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openTeksActivity();
            }
        });
        Button btngalllery = findViewById(R.id.btn_galeri);
        btngalllery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openGalleryActivity();
            }
        });
        Button setup = findViewById(R.id.setup);
        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetupActivity();
            }
        });

    }

    private void openTeksActivity()
    {
        startActivity(new Intent(this, TeksActivity.class));
    }
    private void openGalleryActivity()
    {
        startActivity(new Intent(this, GalleryActivity.class));
    }
    private void openSetupActivity()
    {
        startActivity(new Intent(this, SetupActivity.class));
    }

}
