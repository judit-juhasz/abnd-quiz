package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra-name-parameter";
    public static final String EXTRA_QUESTIONS = "extra-questions-parameter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_NAME)) {
            final String name = intent.getStringExtra(EXTRA_NAME);
            final TextView nameTextView = (TextView) findViewById(R.id.tv_name);
            nameTextView.setText(name);
        }
        if (intent.hasExtra(EXTRA_QUESTIONS)) {
            final ArrayList<Question> questions =
                    intent.getParcelableArrayListExtra(EXTRA_QUESTIONS);
        } else {
            // Error
        }
    }
}
