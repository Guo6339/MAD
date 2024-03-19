package my.edu.utar.assignment1;

import android.annotation.SuppressLint;
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

public class DescendingOrderActivity extends AppCompatActivity {

    private EditText numbersEditText, userAnswerEditText;
    private TextView resultTextView;
    private List<Integer> numbersList;

    @SuppressLint("MissingInflatedId")
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
        numbersList = generateRandomNumberList(5); // Generate a list of 5 random numbers
        StringBuilder randomNumbersStr = new StringBuilder();
        for (int number : numbersList) {
            randomNumbersStr.append(number).append(", ");
        }
        randomNumbersStr.delete(randomNumbersStr.length() - 2, randomNumbersStr.length());
        numbersEditText.setText(randomNumbersStr.toString());
    }

    private List<Integer> generateRandomNumberList(int size) {
        Random random = new Random();
        List<Integer> randomNumbers = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(random.nextInt(100)); // Generating random numbers less than 100
        }
        return randomNumbers;
    }

    public void checkOrder(View view) {
        String userAnswer = userAnswerEditText.getText().toString().trim();
        String[] userAnswersArray = userAnswer.split(",");
        Integer[] userAnswers = new Integer[userAnswersArray.length];

        for (int i = 0; i < userAnswersArray.length; i++) {
            try {
                userAnswers[i] = Integer.parseInt(userAnswersArray[i].trim());
            } catch (NumberFormatException e) {
                resultTextView.setText("Please enter valid numbers separated by commas");
                resultTextView.setTextColor(Color.RED);
                return;
            }
        }

        // Get a sorted copy of the original list in descending order
        List<Integer> sortedList = new ArrayList<>(numbersList);
        Collections.sort(sortedList, Collections.reverseOrder());

        // Compare user's answers with the sorted list
        if (Arrays.equals(userAnswers, sortedList.toArray(new Integer[0]))) {
            resultTextView.setText("Correct! The numbers are in descending order");
            resultTextView.setTextColor(Color.GREEN);
        } else {
            resultTextView.setText("Incorrect! The numbers are not in descending order");
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
