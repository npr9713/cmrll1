package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class cmoaddemp extends AppCompatActivity {
    Button b1;
    ImageButton i1,i2,i3,i4;
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cmoaddemp);
        e1=(EditText) findViewById(R.id.l1name);
        e2=(EditText) findViewById(R.id.l1empid);
        e3=(EditText) findViewById(R.id.l1phoneno);
        e4=(EditText) findViewById(R.id.l1mailid);
        e5=(EditText) findViewById(R.id.l1password);
        i1=(ImageButton) findViewById(R.id.addempbut);
        i2=(ImageButton) findViewById(R.id.homebut);
        i3=(ImageButton) findViewById(R.id.viewreqbut);
        i4=(ImageButton)  findViewById(R.id.profilebut);
        b1=(Button) findViewById(R.id.adddetailb);


        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoaddemp.this, cmohome.class);
                startActivity(i);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoaddemp.this, cmoviewreq.class);
                startActivity(i);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoaddemp.this, cmoprofile.class);
                startActivity(i);
            }
        });

    }
}
