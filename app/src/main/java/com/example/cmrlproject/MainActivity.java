package com.example.cmrlproject;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.content.Intent;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button getStartedButton;
    private int userType = 0;
    private RadioGroup radioGroup;
    private RadioButton cmoRadioButton;
    private RadioButton l1RadioButton;
    private RadioButton zjeRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStartedButton = findViewById(R.id.button3);
        radioGroup = findViewById(R.id.radioGroup);
        cmoRadioButton = findViewById(R.id.checkbox01);
        l1RadioButton = findViewById(R.id.checkbox03);
        zjeRadioButton = findViewById(R.id.checkbox02);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.checkbox01) {
                    userType = 0;
                } else if (checkedId == R.id.checkbox02) {
                    userType = 1;
                } else if (checkedId == R.id.checkbox03) {
                    userType = 2;
                }
            }
        });

        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent;
                    switch (userType) {
                        case 0:
                            intent = new Intent(MainActivity.this, cmologin.class);
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, zjelogin.class);
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, l1login.class);
                            startActivity(intent);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
