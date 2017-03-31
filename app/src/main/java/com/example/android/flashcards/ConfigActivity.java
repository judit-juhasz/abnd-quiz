package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void startQuizOnClick(View view) {
        final Intent quizIntent = new Intent(this, QuizActivity.class);
        quizIntent.putExtra(QuizActivity.EXTRA_NAME, "Jane Doe");
        startActivity(quizIntent);
    }
}
