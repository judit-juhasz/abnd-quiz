package com.example.android.flashcards;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private CheckBox mCategoryEventsCheckBox;
    private CheckBox mCategoryPersonsCheckBox;
    private CheckBox mCategoryDefinitionsCheckBox;
    private CheckBox mCategoryTopographyCheckBox;
    private CheckBox mCategoryBattlesCheckBox;
    private CheckBox mCategoryCultureCheckBox;
    private RadioButton mShuffleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        setupFloatingLabelError();

        final Intent intent = getIntent();
        mNameEditText = (EditText) findViewById(R.id.et_name);
        if (intent.hasExtra(EXTRA_NAME)) {
            mNameEditText.setText(intent.getStringExtra(EXTRA_NAME));
        }

        mCategoryEventsCheckBox = (CheckBox) findViewById(R.id.cb_category_events);
        mCategoryPersonsCheckBox = (CheckBox) findViewById(R.id.cb_category_persons);
        mCategoryDefinitionsCheckBox = (CheckBox) findViewById(R.id.cb_category_definitions);
        mCategoryTopographyCheckBox = (CheckBox) findViewById(R.id.cb_category_topography);
        mCategoryBattlesCheckBox = (CheckBox) findViewById(R.id.cb_category_battles);
        mCategoryCultureCheckBox = (CheckBox) findViewById(R.id.cb_category_culture);

        mShuffleRadioButton = (RadioButton) findViewById(R.id.rb_shuffle_true);
    }

    private void setupFloatingLabelError() {
        final TextInputLayout floatingUsernameLabel =
                (TextInputLayout) findViewById(R.id.username_text_input_layout);

        floatingUsernameLabel.setError(getString(R.string.name_error));
        floatingUsernameLabel.setErrorEnabled(true);

        floatingUsernameLabel.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() == 0) {
                    floatingUsernameLabel.setError(getString(R.string.name_error));
                    floatingUsernameLabel.setErrorEnabled(true);
                } else {
                    floatingUsernameLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
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

        if (mCategoryEventsCheckBox.isChecked()) {
            questions.addAll(QuestionUtils.getEventsQuestions(this));
        }

        if (mCategoryPersonsCheckBox.isChecked()) {
            questions.addAll(QuestionUtils.getPersonsQuestions(this));
        }

        if (mCategoryDefinitionsCheckBox.isChecked()) {
            questions.addAll(QuestionUtils.getDefinitionsQuestions(this));
        }

        if (mCategoryTopographyCheckBox.isChecked()) {
            questions.addAll(QuestionUtils.getTopographyQuestions(this));
        }

        if (mCategoryBattlesCheckBox.isChecked()) {
            questions.addAll(QuestionUtils.getBattlesQuestions(this));
        }

        if (mCategoryCultureCheckBox.isChecked()) {
            questions.addAll(QuestionUtils.getCultureQuestions(this));
        }

        return questions;
    }

    public boolean isInvalidConfig() {
        final String name = mNameEditText.getText().toString();

        final boolean isNameCorrect = !name.isEmpty();
        final boolean isCategorySelectionCorrect = isOneOrMoreCategorySelected();

        if (!isNameCorrect && !isCategorySelectionCorrect) {
            Toast.makeText(this, getString(R.string.message_missing_name_categories),
                    Toast.LENGTH_LONG).show();
            return true;
        } else if (!isNameCorrect) {
            Toast.makeText(this, getString(R.string.message_missing_name), Toast.LENGTH_LONG).show();
            return true;
        } else if (!isCategorySelectionCorrect) {
            Toast.makeText(this, getString(R.string.message_missing_categories), Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }

    public boolean isOneOrMoreCategorySelected() {
        return mCategoryEventsCheckBox.isChecked() || mCategoryPersonsCheckBox.isChecked() ||
                mCategoryDefinitionsCheckBox.isChecked() || mCategoryTopographyCheckBox.isChecked() ||
                mCategoryBattlesCheckBox.isChecked() || mCategoryCultureCheckBox.isChecked();
    }
}
