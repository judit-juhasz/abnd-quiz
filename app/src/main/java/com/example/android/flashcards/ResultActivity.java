package com.example.android.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra-name-parameter";
    public static final String EXTRA_NUMBER_OF_QUESTIONS = "extra-number-of-questions-parameter";
    public static final String EXTRA_NUMBER_OF_CORRECT_ANSWERS =
            "extra-number-of-correct-answers-parameter";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
}
