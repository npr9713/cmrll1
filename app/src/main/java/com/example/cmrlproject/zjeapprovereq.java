package com.example.cmrlproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class zjeapprovereq extends AppCompatActivity {
    ImageButton i1,i2,i3,i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zjeapprovereq);
        i1=(ImageButton)findViewById(R.id.approvereq);
        i2=(ImageButton)findViewById(R.id.homebut);
        i3=(ImageButton)findViewById(R.id.viewreqbut);
        i4=(ImageButton)findViewById(R.id.profilebut);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeapprovereq.this, zjehome.class);
                startActivity(i);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeapprovereq.this, zjeviewreq.class);
                startActivity(i);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjeapprovereq.this, zjeprofile.class);
                startActivity(i);
            }
        });
    }
}
