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

public class cmologin extends AppCompatActivity {
    Button b1,b2;
    TextView t1;
    EditText e1,e2,e3;
    String eid;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cmologin);
        Intent i = getIntent();

        e1 = (EditText) findViewById(R.id.eidl);
        e2 = (EditText) findViewById(R.id.phonenol);
        e3 = (EditText) findViewById(R.id.passwordl);
        b1 = (Button) findViewById(R.id.loginb);
        b2 = (Button) findViewById(R.id.resetpass);
        builder= new AlertDialog.Builder(this);
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
                    Intent i = new Intent(cmologin.this, cmohome.class);
                    i.putExtra("employeeid_key",eid);
                    startActivity(i);
                }
            }
        });
    }}
