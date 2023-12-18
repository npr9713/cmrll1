package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class acceptedreqdetail extends AppCompatActivity {
    ImageButton b1,b2,b3;
    TextView t1,t2,t3,t4,t5,t6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceptedreqdetail);
        b1=(ImageButton)findViewById(R.id.homebut);
        b2=(ImageButton)findViewById(R.id.profilebut);
        b3=(ImageButton)findViewById(R.id.logsbut);
        t1=(TextView)findViewById(R.id.acceptedackno);
        t2=(TextView)findViewById(R.id.accepteddateandtime);
        t3=(TextView)findViewById(R.id.acceptedstation);
        t4=(TextView)findViewById(R.id.accepteddevice);
        t5=(TextView)findViewById(R.id.accepteddeviceno);
        t6=(TextView)findViewById(R.id.acceptedstatus);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(acceptedreqdetail.this, l1home.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(acceptedreqdetail.this, l1profile.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(acceptedreqdetail.this, l1acceptedreq.class);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("fault")) {
            String selectedFault = intent.getStringExtra("fault");
        }


    }
}
