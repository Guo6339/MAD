package my.edu.utar.assignment1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AscendingOrderActivity extends AppCompatActivity {

    private EditText numbersEditText, userAnswerEditText;
    private TextView resultTextView;
    private List<Integer> numbersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descending_order);

        numbersEditText = findViewById(R.id.numbersEditText);
        userAnswerEditText = findViewById(R.id.userAnswerEditText);
        resultTextView = findViewById(R.id.resultTextView);

        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        numbersList = new ArrayList<>();
        Random random = new Random();
        StringBuilder randomNumbersStr = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(100); // Generating random numbers less than 100
            numbersList.add(randomNumber);
            randomNumbersStr.append(randomNumber).append(", ");
        }
        randomNumbersStr.delete(randomNumbersStr.length() - 2, randomNumbersStr.length());
        numbersEditText.setText(randomNumbersStr.toString());
    }

    public void checkOrder(View view) {
        String userAnswer = userAnswerEditText.getText().toString().trim();
        String[] userAnswersArray = userAnswer.split(",");
        Integer[] userAnswers = new Integer[userAnswersArray.length];

        if (userAnswersArray.length != numbersList.size()) {
            resultTextView.setText("Incorrect! Please enter the correct number of elements.");
            resultTextView.setTextColor(Color.RED);
            return;
        }

        for (int i = 0; i < userAnswersArray.length; i++) {
            try {
                userAnswers[i] = Integer.parseInt(userAnswersArray[i].trim());
            } catch (NumberFormatException e) {
                resultTextView.setText("Please enter valid numbers separated by commas");
                resultTextView.setTextColor(Color.RED);
                return;
            }
        }

        Integer[] sortedNumbersAscending = numbersList.toArray(new Integer[0]);
        Arrays.sort(sortedNumbersAscending); // Sort randomly generated numbers in ascending order

        Integer[] sortedNumbersDescending = sortedNumbersAscending.clone();
        Arrays.sort(sortedNumbersDescending, Collections.reverseOrder()); // Sort randomly generated numbers in descending order

        boolean isAscendingOrder = Arrays.equals(userAnswers, sortedNumbersAscending);
        boolean isDescendingOrder = Arrays.equals(userAnswers, sortedNumbersDescending);

        if (isAscendingOrder) {
            resultTextView.setText("Correct! The numbers are in ascending order");
            resultTextView.setTextColor(Color.GREEN);
        } else if (isDescendingOrder) {
            resultTextView.setText("Incorrect! The numbers are not in ascending order");
            resultTextView.setTextColor(Color.RED);
        } else {
            resultTextView.setText("Error !! Please enter again.");
            resultTextView.setTextColor(Color.RED);
        }
    }



    public void generateAgain(View view) {
        userAnswerEditText.setText("");
        resultTextView.setText("");
        generateRandomNumbers();
    }

    public void goBack(View view) {
        finish();
    }
}
