package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.flashcards.utilities.QuestionUtils;

import java.util.ArrayList;
import java.util.Collections;

public class ConfigActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra-name-parameter";

    private EditText mNameEditText;
    private CheckBox mCategoryACheckBox;
    private CheckBox mCategoryBCheckBox;
    private CheckBox mCategoryCCheckBox;
    private CheckBox mCategoryDCheckBox;
    private CheckBox mCategoryECheckBox;
    private CheckBox mCategoryFCheckBox;
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
        mCategoryBCheckBox = (CheckBox) findViewById(R.id.cb_category_b);
        mCategoryCCheckBox = (CheckBox) findViewById(R.id.cb_category_c);
        mCategoryDCheckBox = (CheckBox) findViewById(R.id.cb_category_d);
        mCategoryECheckBox = (CheckBox) findViewById(R.id.cb_category_e);
        mCategoryFCheckBox = (CheckBox) findViewById(R.id.cb_category_f);

        mShuffleRadioButton = (RadioButton) findViewById(R.id.rb_shuffle_true);
    }

    public void onClickStartQuiz(View view) {
        final Intent quizIntent = new Intent(this, QuizActivity.class);

        if (isInvalidConfig()) {
            return;
        }

        quizIntent.putExtra(QuizActivity.EXTRA_NAME, mNameEditText.getText().toString());

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

    public boolean isInvalidConfig() {
        final String name = mNameEditText.getText().toString();

        final boolean isNameCorrect = !name.isEmpty();
        final boolean isCategorySelectionCorrect = isOneOrMoreCategorySelected();

        if (!isNameCorrect && !isCategorySelectionCorrect) {
            Toast.makeText(this, "Please type your name and select at least one category.",
                    Toast.LENGTH_LONG).show();
            return true;
        } else if (!isNameCorrect) {
            Toast.makeText(this, "Please type your name.", Toast.LENGTH_LONG).show();
            return true;
        } else if (!isCategorySelectionCorrect) {
            Toast.makeText(this, "Please select at least one category.", Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }

    public boolean isOneOrMoreCategorySelected() {
        return mCategoryACheckBox.isChecked() || mCategoryBCheckBox.isChecked() ||
                mCategoryCCheckBox.isChecked() || mCategoryDCheckBox.isChecked() ||
                mCategoryECheckBox.isChecked() || mCategoryFCheckBox.isChecked();
    }
}
