package my.edu.utar.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CompareNumbersActivity extends AppCompatActivity {

    private TextView number1TextView, number2TextView, resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_numbers);

        number1TextView = findViewById(R.id.number1TextView);
        number2TextView = findViewById(R.id.number2TextView);
        resultTextView = findViewById(R.id.resultTextView);

        generateNumbers();
    }

    private void generateNumbers() {
        Random random = new Random();
        int number1 = random.nextInt(100); // Generate a random number less than 100
        int number2 = random.nextInt(100);

        number1TextView.setText(String.valueOf(number1));
        number2TextView.setText(String.valueOf(number2));
    }

    public void chooseGreater(View view) {
        int number1 = Integer.parseInt(number1TextView.getText().toString());
        int number2 = Integer.parseInt(number2TextView.getText().toString());

        if (number1 > number2) {
            resultTextView.setText("Correct! " + number1 + " is greater than " + number2);
            resultTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            resultTextView.setText("Incorrect! " + number1 + " is not greater than " + number2);
            resultTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }

    public void chooseSmaller(View view) {
        int number1 = Integer.parseInt(number1TextView.getText().toString());
        int number2 = Integer.parseInt(number2TextView.getText().toString());

        if (number1 < number2) {
            resultTextView.setText("Correct! " + number1 + " is smaller than " + number2);
            resultTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            resultTextView.setText("Incorrect! " + number1 + " is not smaller than " + number2);
            resultTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }

    public void chooseEqual(View view) {
        int number1 = Integer.parseInt(number1TextView.getText().toString());
        int number2 = Integer.parseInt(number2TextView.getText().toString());

        if (number1 == number2) {
            resultTextView.setText("Correct! " + number1 + " is equal to " + number2);
            resultTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            resultTextView.setText("Incorrect! " + number1 + " is not equal to " + number2);
            resultTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }

    public void goBack(View view) {

        finish();
    }

    public void generateNumbers(View view) {
        resultTextView.setText("");
        generateNumbers();
    }
}