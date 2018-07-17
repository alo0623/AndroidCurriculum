package com.alvinlo.currencyconverterv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText currencyInUSDEditText;
    EditText currencyInHKDEditText;

    public void convertToUSD(View view){
        currencyInHKDEditText.setTag("true");
        currencyInUSDEditText.setTag("false");
        Toast.makeText(MainActivity.this, currencyInHKDEditText.getTag().toString(), Toast.LENGTH_LONG).show();
    }

    public void convertToHKD(View view) {
        currencyInUSDEditText.setTag("true");
        currencyInHKDEditText.setTag("false");
        Toast.makeText(MainActivity.this, currencyInUSDEditText.getTag().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencyInHKDEditText = findViewById(R.id.currencyInHKDEditText);
        currencyInUSDEditText = findViewById(R.id.currencyInUSDEditText);

        currencyInHKDEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (currencyInHKDEditText.getTag().toString().equals("true")) {
                    try {
                        Double currencyInUSD = Double.parseDouble(currencyInHKDEditText.getText().toString()) / 7.82;
                        if (currencyInUSD < 0)
                            throw new IllegalStateException();
                        currencyInUSDEditText.setText(String.format("%.2f", currencyInUSD));
                        Toast.makeText(MainActivity.this, "$" + String.format("%.2f", currencyInUSD) + " in USD", Toast.LENGTH_LONG).show();
                    } catch (Exception ex) {
                        Toast.makeText(MainActivity.this, "Amount must be represented by a non-negative numeric value", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        currencyInUSDEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (currencyInUSDEditText.getTag().toString().equals("true")) {
                    try {
                        Double currencyInHKD = Double.parseDouble(currencyInUSDEditText.getText().toString()) * 7.82;
                        if (currencyInHKD < 0)
                            throw new IllegalStateException();
                        currencyInHKDEditText.setText(String.format("%.2f", currencyInHKD));
                        Toast.makeText(MainActivity.this, "$" + String.format("%.2f", currencyInHKD) + " in USD", Toast.LENGTH_LONG).show();
                    } catch (Exception ex) {
                        Toast.makeText(MainActivity.this, "Amount must be represented by a non-negative numeric value", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
