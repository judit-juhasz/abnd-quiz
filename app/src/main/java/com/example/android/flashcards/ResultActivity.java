package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra-name-parameter";
    public static final String EXTRA_NUMBER_OF_QUESTIONS = "extra-number-of-questions-parameter";
    public static final String EXTRA_NUMBER_OF_CORRECT_ANSWERS =
            "extra-number-of-correct-answers-parameter";

    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final Intent intent = getIntent();

        final TextView congratulationsTextView = (TextView) findViewById(R.id.tv_congratulations);
        if (intent.hasExtra(EXTRA_NAME)) {
            mName = intent.getStringExtra(EXTRA_NAME);
            congratulationsTextView.setText("Congratulations, " + mName + "!");
        } else {
            congratulationsTextView.setText("Congratulations!");
        }

        final int numberOfQuestions = intent.getIntExtra(EXTRA_NUMBER_OF_QUESTIONS, 1);
        final int numberOfCorrectAnswers =
                intent.getIntExtra(EXTRA_NUMBER_OF_CORRECT_ANSWERS, numberOfQuestions);
        final int resultPercentage = (int) ((numberOfCorrectAnswers * 100.0) / numberOfQuestions);
        final TextView resultTextView = (TextView) findViewById(R.id.tv_result);
        resultTextView.setText("Your result is " + resultPercentage + "% which is not that bad!");
    }

    public void onClickNewQuiz(View view) {
        final Intent intent = new Intent(this, ConfigActivity.class);
        if (!mName.isEmpty()) {
            intent.putExtra(ConfigActivity.EXTRA_NAME, mName);
        }
        startActivity(intent);
    }

    public void onClickTakeExam(View view) {
        final Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
    }
}
