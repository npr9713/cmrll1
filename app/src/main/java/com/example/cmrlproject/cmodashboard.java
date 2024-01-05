package com.example.cmrlproject;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class cmodashboard extends AppCompatActivity {
    TextView tvSWD, tvSWN, tvSTV, tvSTT;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cmodashboard);


        tvSWD = findViewById(R.id.tvSWD);
        tvSWN = findViewById(R.id.tvSWN);
        tvSTV = findViewById(R.id.tvSTV);
        tvSTT = findViewById(R.id.tvSTT);
        pieChart = findViewById(R.id.piechart);


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
