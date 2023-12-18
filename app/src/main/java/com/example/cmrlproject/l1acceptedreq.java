package com.example.cmrlproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ImageButton;
import android.widget.ListView;

public class l1acceptedreq extends AppCompatActivity {
    ImageButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l1acceptedreq);
        b1=(ImageButton)findViewById(R.id.homebut);
        b2=(ImageButton)findViewById(R.id.profilebut);
        b3=(ImageButton)findViewById(R.id.logsbut);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1acceptedreq.this, l1home.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1acceptedreq.this, l1profile.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(l1acceptedreq.this, l1acceptedreq.class);
                startActivity(i);
            }
        });


        ListView faultListView = findViewById(R.id.faultListView);

        // Sample data for the fault list
        String[] faults = {"Fault 1", "Fault 2", "Fault 3", /* Add more faults as needed */};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, faults);
        faultListView.setAdapter(adapter);

        // Handle item click to open details page
        faultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFault = faults[position];
                openFaultDetails(selectedFault);
            }
        });
    }
    private void openFaultDetails(String fault) {
        Intent intent = new Intent(this, acceptedreqdetail.class);
        intent.putExtra("fault", fault);
        startActivity(intent);
    }
}
