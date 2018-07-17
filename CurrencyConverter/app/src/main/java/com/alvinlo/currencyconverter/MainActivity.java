package com.alvinlo.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void convert(View view){
        EditText currencyInUSDEditText = (EditText) findViewById(R.id.currencyInUSDEditText);
        EditText currencyInHKDEditText = (EditText) findViewById(R.id.currencyInHKDEditText);

        if (!currencyInHKDEditText.getText().toString().equals("") && !currencyInUSDEditText.getText().toString().equals(""))
            Toast.makeText(MainActivity.this, "At least one field must be empty.", Toast.LENGTH_LONG).show();

        try {
            if (!currencyInHKDEditText.getText().toString().equals("")){
                Double currencyInUSD = Double.parseDouble(currencyInHKDEditText.getText().toString()) / 7.82;
                if (currencyInUSD < 0)
                    throw new IllegalStateException("Amount must be non-negative");
                currencyInUSDEditText.setText(String.format("%.2f", currencyInUSD));
                Toast.makeText(MainActivity.this, "$" + String.format("%.2f", currencyInUSD), Toast.LENGTH_LONG).show();
            } else if (!currencyInUSDEditText.getText().toString().equals("")) {
                Double currencyInHKD = Double.parseDouble(currencyInUSDEditText.getText().toString()) * 7.82;
                if (currencyInHKD < 0)
                    throw new IllegalStateException("Amount must be non-negative");
                currencyInHKDEditText.setText(String.format("%.2f", currencyInHKD));
                Toast.makeText(MainActivity.this, "$" + String.format("%.2f", currencyInHKD), Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex){
            Toast.makeText(MainActivity.this, "Amount must be represented by a non-negative numeric value", Toast.LENGTH_LONG).show();
        }
    }

    public void clearInput(View view){
        EditText currencyInUSDEditText = (EditText) findViewById(R.id.currencyInUSDEditText);
        EditText currencyInHKDEditText = (EditText) findViewById(R.id.currencyInHKDEditText);

        currencyInHKDEditText.setText("");
        currencyInUSDEditText.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
