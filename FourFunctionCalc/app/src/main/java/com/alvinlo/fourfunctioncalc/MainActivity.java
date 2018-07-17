package com.alvinlo.fourfunctioncalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input1EditText;
    EditText input2EditText;
    TextView answerTextView;

    public void add(View view){
        try {
            Double input1 = Double.parseDouble(input1EditText.getText().toString());
            Double input2 = Double.parseDouble(input2EditText.getText().toString());
            String value;
            if ((input1 + input2) % 0.0000000001 != 0)
                value = String.format("%.9f", input1 + input2);
            else
                value = String.valueOf(input1 + input2);
            answerTextView.setText("Result: " + value);
            answerTextView.setVisibility(View.VISIBLE);
        } catch (Exception ex){
            Toast.makeText(MainActivity.this, "There must be both inputs.", Toast.LENGTH_LONG).show();
        }
    }

    public void subtract(View view){
        try {
            Double input1 = Double.parseDouble(input1EditText.getText().toString());
            Double input2 = Double.parseDouble(input2EditText.getText().toString());
            String value;
            if ((input1 - input2) % 0.0000000001 != 0)
                value = String.format("%.9f", input1 - input2);
            else
                value = String.valueOf(input1 - input2);
            answerTextView.setText("Result: " + value);
            answerTextView.setVisibility(View.VISIBLE);
        } catch (Exception ex){
            Toast.makeText(MainActivity.this, "There must be both inputs.", Toast.LENGTH_LONG).show();
        }
    }

    public void multiply(View view){
        try {
            Double input1 = Double.parseDouble(input1EditText.getText().toString());
            Double input2 = Double.parseDouble(input2EditText.getText().toString());
            String value;
            if ((input1 * input2) % 0.0000000001 != 0)
                value = String.format("%.9f", input1 * input2);
            else
                value = String.valueOf(input1 * input2);
            answerTextView.setText("Result: " + value);
            answerTextView.setVisibility(View.VISIBLE);
        } catch (Exception ex){
            Toast.makeText(MainActivity.this, "There must be both inputs.", Toast.LENGTH_LONG).show();
        }
    }

    public void divide(View view){
        try {
            Double input1 = Double.parseDouble(input1EditText.getText().toString());
            Double input2 = Double.parseDouble(input2EditText.getText().toString());
            if (input2 == 0)
                throw new IllegalArgumentException("Input 2 must not be 0.");

            String value;
            if ((input1 / input2) % 0.0000000001 != 0)
                value = String.format("%.9f", input1 / input2);
            else
                value = String.valueOf(input1 / input2);
            answerTextView.setText("Result: " + value);
            answerTextView.setVisibility(View.VISIBLE);
        } catch (Exception ex){
            Toast.makeText(MainActivity.this, "There must be both inputs, and input 2 must not be 0.", Toast.LENGTH_LONG).show();
        }
    }

    public void clearInput(View view){
        answerTextView.setVisibility(View.INVISIBLE);
        input1EditText.setText("");
        input2EditText.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1EditText = (EditText) findViewById(R.id.input1EditText);
        input2EditText = (EditText) findViewById(R.id.input2EditText);
        answerTextView = (TextView) findViewById(R.id.answerTextView);
    }
}
