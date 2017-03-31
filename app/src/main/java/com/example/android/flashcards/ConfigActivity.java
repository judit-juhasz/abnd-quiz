package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void startQuizOnClick(View view) {
        final Intent quizIntent = new Intent(this, QuizActivity.class);
        quizIntent.putExtra(QuizActivity.EXTRA_NAME, "Jane Doe");
        final ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the color of the sky?", "Blue."));
        questions.add(new Question("How many weeks are in a year?", "52"));
        questions.add(new Question("How many people live in the world?", "7.5 Billion"));
        quizIntent.putParcelableArrayListExtra(QuizActivity.EXTRA_QUESTIONS, questions);
        startActivity(quizIntent);
    }
}
