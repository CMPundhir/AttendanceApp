package com.cmpundhir.cm.attendanceapp.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cmpundhir.cm.attendanceapp.R;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String msg = getIntent().getStringExtra("aesehi");
        Toast.makeText(this, msg,   Toast.LENGTH_SHORT).show();
    }
}
