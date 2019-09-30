package com.example.robber_hadi.idealweightcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText age = findViewById(R.id.age_input);
        final EditText height = findViewById(R.id.height_input);
        final TextView result = findViewById(R.id.result_view);
        final RadioButton male = findViewById(R.id.male_select);
        final RadioButton female = findViewById(R.id.female_select);
        final RadioGroup butgroup = findViewById(R.id.button_group);


        findViewById(R.id.calculate_button).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                int age_no = Integer.parseInt(age.getText().toString());
                Double height_no = Double.parseDouble(height.getText().toString());

                Double hamwi;
                Double devine;
                Double robinson;
                Double miller;

                if (age_no >= 18) {
                    if (male.isChecked()) {
                        if (height_no > 152.4) {

                            // 1 inch = 2.54 cm
                            // 5 foot = 152.4 cm
                            hamwi = Math.round((48 + (((height_no - 152.4) / 2.54) * 2.7)) * 100) / 100.0d;
                            devine = Math.round((50 + (((height_no - 152.4) / 2.54) * 2.3)) * 100) / 100.0d;
                            robinson = Math.round((52 + (((height_no - 152.4) / 2.54) * 1.9)) * 100) / 100.0d;
                            miller = Math.round((56.2 + (((height_no - 152.4) / 2.54) * 1.41)) * 100) / 100.0d;

                            result.setText("Your Result by different formula : \n\nHamwi = " + hamwi + " kgs\nDevine = " + devine + " kgs\nRobinson = " + robinson + " kgs\nMiller = " + miller + " kgs");
                        } else {
                            result.setText("show bmi only");
                        }
                    }
                    if (female.isChecked()) {
                        if (height_no > 152.4) {
                            hamwi = Math.round((45.5 + (((height_no - 152.4) / 2.54) * 2.2)) * 100) / 100.0d;
                            devine = Math.round((45.5 + (((height_no - 152.4) / 2.54) * 2.3)) * 100) / 100.0d;
                            robinson = Math.round((49 + (((height_no - 152.4) / 2.54) * 1.7)) * 100) / 100.0d;
                            miller = Math.round((53.1 + (((height_no - 152.4) / 2.54) * 1.36)) * 100) / 100.0d;

                            result.setText("Your Result by different formula : \n\nHamwi = " + hamwi + " kgs\nDevine = " + devine + " kgs\nRobinson = " + robinson + " kgs\nMiller = " + miller + " kgs");
                        } else {
                            result.setText("show bmi only");
                        }
                    }
                } else if (age_no < 18 && age_no > 1) {
                    result.setText("show bmi only");
                } else if (age_no == 1) {
                    result.setText("Please enter age higher than 2 years old");
                }
            }
        });

        findViewById(R.id.clear_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butgroup.clearCheck();
                age.setText("");
                result.setText("");
                height.setText("");
            }
        });
    }
}
