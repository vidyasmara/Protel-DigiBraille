package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

public class TeksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_teks);

        DigiBraille app = (DigiBraille)getApplication();
        final Communicator communicator = app.getCommunicator();
        Button btnkirim = findViewById(R.id.btn_konfirmasi);
        final MaterialEditText mResultEt = findViewById(R.id.textView);
        btnkirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = mResultEt.getText().toString().trim();
                Log.d("test", result);
                communicator.sendCommands(result);
            }
        });
    }
}
