package my.edu.utar.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToCompareNumbers(View view) {
        Intent intent = new Intent(this, CompareNumbersActivity.class);
        startActivity(intent);
    }

    public void goToOrderingNumbers(View view) {
        Intent intent = new Intent(this, OrderingNumbersActivity.class);
        startActivity(intent);
    }

    public void goToComposingNumbers(View view) {
        Intent intent = new Intent(this, ComposingNumbersActivity.class);
        startActivity(intent);
    }
}