package com.example.cmrlproject;

import static android.opengl.Matrix.length;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zjelogin);
        Intent i = getIntent();

        e1 = (EditText) findViewById(R.id.eidzje);
        e2 = (EditText) findViewById(R.id.phonenozje);
        e3 = (EditText) findViewById(R.id.passwordzje);
        b1 = (Button) findViewById(R.id.loginb);
        b2 = (Button) findViewById(R.id.resetpass);
        b3 = (Button) findViewById(R.id.registerb);
        builder= new AlertDialog.Builder(this);
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
                if(e1.getText().toString().trim().length()==0||e2.getText().toString().trim().length()==0||e3.getText().toString().trim().length()==0) {
                    builder.setTitle("Error!!")
                            .setMessage("Enter all the value to continue!")
                            .setCancelable(true)
                            .show();
                }
                else if (e2.getText().toString().trim().length()!=10) {
                    builder.setTitle("Error!!")
                            .setMessage("Phone no must contain 10 digits!! ")
                            .setCancelable(true)
                            .show();
                }
                else{
                    eid=e1.getText().toString();
                    Intent i = new Intent(zjelogin.this, zjehome.class);
                    startActivity(i);
                }
            }
        });

    }}
