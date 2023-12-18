package com.example.cmrlproject;

import static android.opengl.Matrix.length;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;

import android.os.Bundle;

public class l1login extends AppCompatActivity {
    Button b1,b2,b3;
    TextView t1;
    EditText e1,e2,e3;
    String eid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l1login);
        Intent i = getIntent();
        t1=(TextView)findViewById(R.id.alerttext);
        e1=(EditText) findViewById(R.id.eidl);
        e2=(EditText) findViewById(R.id.phonenol);
        e3=(EditText) findViewById(R.id.passwordl);
        b1=(Button) findViewById(R.id.loginb);
        b2=(Button) findViewById(R.id.resetpass);
        b3=(Button) findViewById(R.id.registerlb);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1login.this, l1signup.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().trim().length()==0||e2.getText().toString().trim().length()==0||e3.getText().toString().trim().length()==0) {
                    t1.setText("Enter all values to continue!!");
                }
                else if (e2.getText().toString().trim().length()!=10) {
                    t1.setText("Phone number must contain 10 digits!!");
                }
                else{
                    eid=e1.getText().toString();
                    Intent i = new Intent(l1login.this, l1home.class);
                    i.putExtra("employeeid_key",eid);
                    startActivity(i);
                }
            }
        });

    }
}
