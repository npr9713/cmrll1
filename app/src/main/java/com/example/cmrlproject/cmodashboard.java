package com.example.cmrlproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class cmodashboard extends AppCompatActivity {
    TextView tvSWD, tvSWN, tvSTV, tvSTT;
    ImageButton b1,b2,b3,b4;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cmodashboard);
        b1=(ImageButton)findViewById(R.id.homebut);
        b2=(ImageButton)findViewById(R.id.addempbut);
        b3=(ImageButton)findViewById(R.id.viewreqbut);
        b4=(ImageButton)findViewById(R.id.profilebut);

        tvSWD = findViewById(R.id.tvSWD);
        tvSWN = findViewById(R.id.tvSWN);
        tvSTV = findViewById(R.id.tvSTV);
        tvSTT = findViewById(R.id.tvSTT);
        pieChart = findViewById(R.id.piechart);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmodashboard.this, cmohome.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmodashboard.this, cmoaddemp.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmodashboard.this, cmoviewreq.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cmodashboard.this, cmoprofile.class);
                startActivity(i);
            }
        });


        setData();
    }

    private void setData()
    {

        // Set the percentage of language used
        tvSWD.setText(Integer.toString(40));
        tvSWN.setText(Integer.toString(30));
        tvSTV.setText(Integer.toString(100));
        tvSTT.setText(Integer.toString(25));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "SWD",
                        Integer.parseInt(tvSWD.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "SWN",
                        Integer.parseInt(tvSWN.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "STV",
                        Integer.parseInt(tvSTV.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "STT",
                        Integer.parseInt(tvSTT.getText().toString()),
                        Color.parseColor("#29B6F6")));

        // To animate the pie chart
        pieChart.startAnimation();
    }
}
