package com.cs407.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Retrieve the values passed from the previous activity
        int number1 = getIntent().getIntExtra("number1", 0);
        int number2 = getIntent().getIntExtra("number2", 0);

        // Find the result TextView
        TextView resultTextView = findViewById(R.id.textView2);

        // Get the ID of the button that was clicked
        int clickedButtonId = getIntent().getIntExtra("clickedButtonId", 0);

        // Check which button was clicked and perform the respective operation
        if (clickedButtonId == R.id.addButton) {
            int result = number1 + number2;
            resultTextView.setText(result);
        } else if (clickedButtonId == R.id.subtractButton) {
            int result = number1 - number2;
            resultTextView.setText(result);
        } else if (clickedButtonId == R.id.multiplyButton) {
            int result = number1 * number2;
            resultTextView.setText(result);
        } else if (clickedButtonId == R.id.divideButton) {
            if (number2 == 0) {
                resultTextView.setText("Cannot divide by zero");
            } else {
                int result = number1 / number2;
                resultTextView.setText(result);
            }
        } else {
            resultTextView.setText("Unknown operation");
        }
    }
}