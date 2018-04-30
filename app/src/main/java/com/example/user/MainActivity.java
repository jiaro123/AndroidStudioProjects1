package com.example.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = (Button) findViewById(R.id.submit);

        mButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText fill_lend = (EditText) findViewById(R.id.input_lend);
                EditText fill_rate = (EditText) findViewById(R.id.input_rate);
                EditText fill_number = (EditText) findViewById(R.id.input_number);

                double lend = Double.parseDouble(fill_lend.getText().toString());
                double rate = Double.parseDouble(fill_rate.getText().toString());
                double number = Double.parseDouble(fill_number.getText().toString());

                double rate_avg = (rate / 100 / 12) + 1;
                double rate_count = 1;

                for (int i = 1; i <= number; i++) {
                    rate_count = rate_count * rate_avg;
                }

                int total = (int) (rate_count * lend);

                TextView myOutput = (TextView) findViewById(R.id.amount);

                myOutput.setText("本利合為:" + total);

            }
        });
    }
}
