package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class cmoprofile extends AppCompatActivity {
    Button b1;
    ImageButton b2, b3,b4,b5;
    TextView t1, t2, t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cmoprofile);
        t1=(TextView) findViewById(R.id.enamep);
        t2=(TextView) findViewById(R.id.eidp);
        t3=(TextView) findViewById(R.id.eemailp);
        t4=(TextView) findViewById(R.id.ephonep);
        b1=(Button) findViewById(R.id.logoutb);
        b2=(ImageButton)  findViewById(R.id.addempbut);
        b3=(ImageButton) findViewById(R.id.homebut);
        b4=(ImageButton)findViewById(R.id.viewreqbut);
        b5=(ImageButton)findViewById(R.id.dashboardbut);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoprofile.this, MainActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoprofile.this, cmoaddemp.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoprofile.this, cmohome.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoprofile.this, cmoviewreq.class);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmoprofile.this, cmodashboard.class);
                startActivity(i);
            }
        });

    }
}