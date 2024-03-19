package my.edu.utar.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class OrderingNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_numbers);
    }

    public void openAscendingOrderActivity(View view) {
        Intent intent = new Intent(this, AscendingOrderActivity.class);
        startActivity(intent);
    }

    public void openDescendingOrderActivity(View view) {
        Intent intent = new Intent(this, DescendingOrderActivity.class);
        startActivity(intent);
    }
}