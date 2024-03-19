package my.edu.utar.assignment1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ComposingNumbersActivity extends AppCompatActivity {

    private TextView presentedNumberTextView, number1TextView, number2TextView;
    private StringBuilder number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composing_numbers);

        presentedNumberTextView = findViewById(R.id.presentedNumberTextView);
        number1TextView = findViewById(R.id.number1TextView);
        number2TextView = findViewById(R.id.number2TextView);

        generateRandomNumber();
        number1 = new StringBuilder();
        number2 = new StringBuilder();
    }

    private void generateRandomNumber() {
        // Generate a random number (5 for example)
        int randomNumber = (int) (Math.random() * 10);
        presentedNumberTextView.setText(String.valueOf(randomNumber));
    }

    public void onNumberButtonClick(View view) {
        // Get the text of the clicked button
        String buttonText = ((TextView) view).getText().toString();

        // Append the clicked number to either number1 or number2 based on which TextView is empty
        if (number1TextView.getText().toString().isEmpty()) {
            number1.append(buttonText);
            number1TextView.setText(number1.toString());
        } else if (number2TextView.getText().toString().isEmpty()) {
            number2.append(buttonText);
            number2TextView.setText(number2.toString());
        }
    }

    public void onAgainButtonClick(View view) {
        // Reset the TextViews and generate a new random number
        number1.setLength(0);
        number2.setLength(0);
        number1TextView.setText("");
        number2TextView.setText("");
        generateRandomNumber();
    }

    public void onSubmitButtonClick(View view) {
        // Get the sum of number1 and number2
        int sum = Integer.parseInt(number1.toString()) + Integer.parseInt(number2.toString());

        // Get the presented number
        int presentedNumber = Integer.parseInt(presentedNumberTextView.getText().toString());

        // Check if the sum is equal to the presented number
        if (sum == presentedNumber) {
            // Display correct message
            presentedNumberTextView.setText("Correct! " + number1 + " + " + number2 + " = " + sum);

        } else {
            // Display error message
            presentedNumberTextView.setText("Incorrect! " + number1 + " + " + number2 + " ≠ " + presentedNumber);

        }
    }

}
