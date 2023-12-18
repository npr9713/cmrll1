package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class l1profile extends AppCompatActivity {
    Button b1;
    String eid;
    ImageButton b2,b3;
    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l1profile);
        Intent i = getIntent();
        eid=i.getStringExtra("employeeid_key");
        t1=(TextView) findViewById(R.id.enamep);
        t2=(TextView) findViewById(R.id.eidp);
        t3=(TextView) findViewById(R.id.eemailp);
        t4=(TextView) findViewById(R.id.ephonep);
        b1=(Button) findViewById(R.id.logoutb);
        b2=(ImageButton)  findViewById(R.id.logsbut);
        b3=(ImageButton) findViewById(R.id.homebut);
        t2.setText(eid);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1profile.this, MainActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1profile.this, l1acceptedreq.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1profile.this, l1home.class);
                startActivity(i);
            }
        });


    }
}
