package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.flashcards.utilities.QuestionUtils;

import java.util.ArrayList;
import java.util.Collections;

public class ConfigActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra-name-parameter";

    private EditText mNameEditText;
    private CheckBox mCategoryACheckBox;
    private RadioButton mShuffleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        final Intent intent = getIntent();
        mNameEditText = (EditText) findViewById(R.id.et_name);
        if (intent.hasExtra(EXTRA_NAME)) {
            mNameEditText.setText(intent.getStringExtra(EXTRA_NAME));
        }

        mCategoryACheckBox = (CheckBox) findViewById(R.id.cb_category_a);

        mShuffleRadioButton = (RadioButton) findViewById(R.id.rb_shuffle_true);
    }

    public void onClickStartQuiz(View view) {
        final Intent quizIntent = new Intent(this, QuizActivity.class);

        quizIntent.putExtra(QuizActivity.EXTRA_NAME, "Jane Doe");

        final ArrayList<Question> questions = getQuestionsForSelectedCategories();
        if (mShuffleRadioButton.isChecked()) {
            Collections.shuffle(questions);
        }

        quizIntent.putParcelableArrayListExtra(QuizActivity.EXTRA_QUESTIONS, questions);

        startActivity(quizIntent);
    }

    private ArrayList<Question> getQuestionsForSelectedCategories() {
        final ArrayList<Question> questions = new ArrayList<>();

        if (mCategoryACheckBox.isChecked()) {
            questions.addAll(QuestionUtils.getCategoryAQuestions());
        }

        return questions;
    }
}
