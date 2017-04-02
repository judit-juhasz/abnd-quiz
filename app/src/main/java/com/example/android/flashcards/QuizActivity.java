package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra-name-parameter";
    public static final String EXTRA_QUESTIONS = "extra-questions-parameter";

    private static final int STATE_QUESTION = 0;
    private static final int STATE_CHECK_ANSWER = 1;

    private int mState;

    private Button mShowAnswerButton;
    private TextView mCheckQuestionTextView;
    private Button mYesButton;
    private Button mNoButton;
    private TextView mQuestionTextView;
    private TextView mAnswerTextView;

    private String mName;
    private ArrayList<Question> mQuestions;
    private int mCurrentQuestionIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mShowAnswerButton = (Button) findViewById(R.id.b_show_answer);
        mCheckQuestionTextView = (TextView) findViewById(R.id.tv_check_question);
        mYesButton = (Button) findViewById(R.id.b_yes);
        mNoButton = (Button) findViewById(R.id.b_no);
        mQuestionTextView = (TextView) findViewById(R.id.tv_question);
        mAnswerTextView = (TextView) findViewById(R.id.tv_answer);

        final Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_NAME)) {
            mName = intent.getStringExtra(EXTRA_NAME);
        }
        if (intent.hasExtra(EXTRA_QUESTIONS)) {
            mQuestions = intent.getParcelableArrayListExtra(EXTRA_QUESTIONS);
            final int firstQuestionIndex = 0;
            loadQuestion(firstQuestionIndex);
        } else {
            // Error
        }

        switchToState(STATE_QUESTION);
    }

    private void loadQuestion(int index) {
        final Question question = mQuestions.get(index);
        mQuestionTextView.setText(question.getQuestion());
        mAnswerTextView.setText(question.getAnswer());
        mCurrentQuestionIndex = index;
    }

    private boolean loadNextQuestion() {
        final int nextQuestionIndex = mCurrentQuestionIndex + 1;
        if (mQuestions.size() > nextQuestionIndex) {
            loadQuestion(nextQuestionIndex);
            return true;
        } else {
            return false;
        }
    }

    private void switchToState(final int state) {
        if (STATE_QUESTION == state) {
            hideAnswerFeedback();
            showAnswerButton();
        } else if (STATE_CHECK_ANSWER == state) {
            hideAnswerButton();
            showAnswerFeedback();
        }
    }

    private void hideAnswerButton() {
        mShowAnswerButton.setVisibility(View.GONE);
    }

    private void showAnswerButton() {
        mShowAnswerButton.setVisibility(View.VISIBLE);
    }

    private void showAnswerFeedback() {
        mAnswerTextView.setVisibility(View.VISIBLE);
        mYesButton.setVisibility(View.VISIBLE);
        mNoButton.setVisibility(View.VISIBLE);
        mCheckQuestionTextView.setVisibility(View.VISIBLE);
    }

    private void hideAnswerFeedback() {
        mAnswerTextView.setVisibility(View.GONE);
        mYesButton.setVisibility(View.GONE);
        mNoButton.setVisibility(View.GONE);
        mCheckQuestionTextView.setVisibility(View.GONE);
    }

    public void onClickShowAnswer(View view) {
        switchToState(STATE_CHECK_ANSWER);
    }

    public void onClickAnswerFeedback(View view) {
        final boolean isNextQuestion = loadNextQuestion();
        if (isNextQuestion) {
            switchToState(STATE_QUESTION);
        } else {
            final Intent resultActivityIntent = new Intent(this, ResultActivity.class);
            startActivity(resultActivityIntent);
        }
    }
}
