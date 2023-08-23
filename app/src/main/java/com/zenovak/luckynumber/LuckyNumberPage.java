package com.zenovak.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumberPage extends AppCompatActivity {

    Button button;
    TextView luckyNumber;
    TextView nameDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number_page);

        nameDisplay = findViewById(R.id.nameDisplay);
        button = findViewById(R.id.buttonShareNumber);
        luckyNumber = findViewById(R.id.luckyNumber);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        nameDisplay.setText(name);

        luckyNumber.setText("" + generateRandomNumber());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, name);
                i.putExtra(Intent.EXTRA_TEXT, luckyNumber.getText().toString());
                startActivity(Intent.createChooser(i, "Choose a mailing option"));
            }
        });
    }

    private int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(1000);
    }
}