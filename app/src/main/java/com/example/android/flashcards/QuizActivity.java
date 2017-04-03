package com.example.android.flashcards;

import android.content.Intent;
import android.os.PersistableBundle;
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

    private static final String SAVE_STATE_KEY = "SAVE_STATE_KEY";
    private static final String SAVE_CURRENT_QUESTION_INDEX_KEY = "SAVE_CURRENT_QUESTION_INDEX_KEY";
    private static final String SAVE_NUMBER_OF_CORRECT_ANSWERS_KEY =
            "SAVE_NUMBER_OF_CORRECT_ANSWERS_KEY";

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
    private int mNumberOfCorrectAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        queryViews();
        extractIntentData();

        mNumberOfCorrectAnswers = 0;
        final int firstQuestionIndex = 0;
        loadQuestion(firstQuestionIndex);

        switchToState(STATE_QUESTION);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_STATE_KEY, mState);
        outState.putInt(SAVE_NUMBER_OF_CORRECT_ANSWERS_KEY, mNumberOfCorrectAnswers);
        outState.putInt(SAVE_CURRENT_QUESTION_INDEX_KEY, mCurrentQuestionIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final int savedState = savedInstanceState.getInt(SAVE_STATE_KEY);
        switchToState(savedState);
        mNumberOfCorrectAnswers = savedInstanceState.getInt(SAVE_NUMBER_OF_CORRECT_ANSWERS_KEY);
        final int savedQuestionIndex = savedInstanceState.getInt(SAVE_CURRENT_QUESTION_INDEX_KEY);
        loadQuestion(savedQuestionIndex);
    }

    private void extractIntentData() {
        final Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_NAME)) {
            mName = intent.getStringExtra(EXTRA_NAME);
        }
        if (intent.hasExtra(EXTRA_QUESTIONS)) {
            mQuestions = intent.getParcelableArrayListExtra(EXTRA_QUESTIONS);
        } else {
            finish();
        }
    }

    private void queryViews() {
        mShowAnswerButton = (Button) findViewById(R.id.b_show_answer);
        mCheckQuestionTextView = (TextView) findViewById(R.id.tv_check_question);
        mYesButton = (Button) findViewById(R.id.b_yes);
        mNoButton = (Button) findViewById(R.id.b_no);
        mQuestionTextView = (TextView) findViewById(R.id.tv_question);
        mAnswerTextView = (TextView) findViewById(R.id.tv_answer);
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
        mState = state;
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
        final Button button = (Button) view;
        if (R.id.b_yes == button.getId()) ++mNumberOfCorrectAnswers;

        final boolean isNextQuestion = loadNextQuestion();
        if (isNextQuestion) {
            switchToState(STATE_QUESTION);
        } else {
            showResult();
        }
    }

    private void showResult() {
        final Intent resultActivityIntent = new Intent(this, ResultActivity.class);
        resultActivityIntent.putExtra(ResultActivity.EXTRA_NAME, mName);
        resultActivityIntent.putExtra(
                ResultActivity.EXTRA_NUMBER_OF_QUESTIONS,
                mQuestions.size()
        );
        resultActivityIntent.putExtra(
                ResultActivity.EXTRA_NUMBER_OF_CORRECT_ANSWERS,
                mNumberOfCorrectAnswers
        );
        startActivity(resultActivityIntent);
    }
}
