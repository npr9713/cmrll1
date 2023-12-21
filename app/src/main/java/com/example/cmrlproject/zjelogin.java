package com.example.cmrlproject;

import static android.opengl.Matrix.length;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;

import android.os.Bundle;

public class zjelogin extends AppCompatActivity {
    Button b1,b2,b3;
    TextView t1;
    EditText e1,e2,e3;
    String eid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zjelogin);
        Intent i = getIntent();
        t1 = (TextView) findViewById(R.id.alerttext);
        e1 = (EditText) findViewById(R.id.eidzje);
        e2 = (EditText) findViewById(R.id.phonenozje);
        e3 = (EditText) findViewById(R.id.passwordzje);
        b1 = (Button) findViewById(R.id.loginb);
        b2 = (Button) findViewById(R.id.resetpass);
        b3 = (Button) findViewById(R.id.registerb);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjelogin.this, zjesignup.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjelogin.this, zjehome.class);
                startActivity(i);
            }
        });

    }}
