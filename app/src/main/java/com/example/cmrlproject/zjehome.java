package com.example.cmrlproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class zjehome extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    ImageButton i1,i2,i3,i4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zjehome);
        e1=(EditText)findViewById(R.id.devicecmoh);
        e1=(EditText)findViewById(R.id.devicenocmoh);
        e1=(EditText)findViewById(R.id.faultdescmoh);
        e1=(EditText)findViewById(R.id.faultackcmoh);
        b1=(Button)findViewById(R.id.submitbcmoh);
        i1=(ImageButton)findViewById(R.id.approvereq);
        i2=(ImageButton)findViewById(R.id.homebut);
        i3=(ImageButton)findViewById(R.id.viewreqbut);
        i4=(ImageButton)findViewById(R.id.profilebut);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjehome.this, zjeapprovereq.class);
                startActivity(i);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjehome.this, zjeviewreq.class);
                startActivity(i);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zjehome.this, zjeprofile.class);
                startActivity(i);
            }
        });






        Spinner stationSpinner = findViewById(R.id.stationSpinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.station_codes, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        stationSpinner.setAdapter(adapter);
    }
}

