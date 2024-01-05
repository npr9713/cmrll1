package com.example.cmrlproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class cmofaultdetail extends AppCompatActivity{
    ImageButton b1,b2,b3,b4,b5;
    Button acc;
    TextView t1,t2,t3,t4,t5,t6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cmofaultdetail);
        b1=(ImageButton)findViewById(R.id.homebut);
        b2=(ImageButton)findViewById(R.id.addempbut);
        b3=(ImageButton)findViewById(R.id.viewreqbut);
        b4=(ImageButton)findViewById(R.id.profilebut);
        b5=(ImageButton)findViewById(R.id.dashboardbut);
        t1=(TextView)findViewById(R.id.acceptedackno);
        t2=(TextView)findViewById(R.id.accepteddateandtime);
        t3=(TextView)findViewById(R.id.acceptedstation);
        t4=(TextView)findViewById(R.id.accepteddevice);
        t5=(TextView)findViewById(R.id.accepteddeviceno);
        t6=(TextView)findViewById(R.id.acceptedstatus);
        acc=(Button)findViewById(R.id.acceptb);
        Spinner employeeSpinner =(Spinner) findViewById(R.id.employeeSpinner);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmofaultdetail.this, cmohome.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmofaultdetail.this, cmoaddemp.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmofaultdetail.this, cmoviewreq.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmofaultdetail.this, cmoprofile.class);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmofaultdetail.this, cmodashboard.class);
                startActivity(i);
            }
        });
        //checking whether the fault is available or not and we have to see properly
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("ackno")) {
            String ackno = intent.getStringExtra("ackno");
            String date = intent.getStringExtra("date");
            String station = intent.getStringExtra("station");
            String device = intent.getStringExtra("device");
            String deviceno = intent.getStringExtra("deviceno");
            String status = intent.getStringExtra("status");

            t1.setText(ackno);
            t2.setText(date);
            t3.setText(station);
            t4.setText(device);
            t5.setText(deviceno);
            t6.setText(status);

        }
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmofaultdetail.this, cmoviewreq.class);

                startActivity(i);


            }
        });



    }
}