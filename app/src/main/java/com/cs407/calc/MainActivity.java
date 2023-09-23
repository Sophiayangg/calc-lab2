package com.cs407.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickFunction(View view){
        // Getting the two numbers
        EditText myTextField1 = (EditText) findViewById(R.id.editTextText);
        EditText myTextField2 = (EditText) findViewById(R.id.editTextText2);
        int clickedButtonId = view.getId();

        // Get the text from the EditText fields
        String text1 = myTextField1.getText().toString();
        String text2 = myTextField2.getText().toString();

        if (isInteger(text1) && isInteger(text2)) {
            int number1 = Integer.parseInt(text1);
            int number2 = Integer.parseInt(text2);

            // Now, you can pass these values to your 'goToActivity' method
            goToActivity(number1, number2, clickedButtonId);
        } else {
            // Handle the case where the input is not a valid integer
            Toast.makeText(this, "Please enter valid integers", Toast.LENGTH_SHORT).show();
        }

    }
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
        public void goToActivity(int first, int second,int clickedButtonId) {
            Intent intent = new Intent(this, CalculatorActivity.class);
            intent.putExtra("clickedButtonId", clickedButtonId);
            intent.putExtra("number1", first);
            intent.putExtra("number2", second);
            startActivity(intent);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}