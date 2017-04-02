package com.example.android.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ExamActivity extends AppCompatActivity {

    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
    }

    public void submitAnswer(View view) {

        //1. question
        EditText answerForQuestion1 = (EditText) findViewById(R.id.et_answer_1);
        if (answerForQuestion1.getText().toString().equals(getString(R.string.answer_1))) {
            mScore++;
        }

        // 2. question
        RadioButton correctAnswerForQuestion2 = (RadioButton) findViewById(R.id.rb_answer_2_b);

        if (correctAnswerForQuestion2.isChecked()) {
            mScore++;
        }

        // 3. question
        RadioButton correctAnswerForQuestion3 = (RadioButton) findViewById(R.id.rb_answer_3_c);

        if (correctAnswerForQuestion3.isChecked()) {
            mScore++;
        }

        // 4. question
        RadioButton correctAnswerForQuestion4 = (RadioButton) findViewById(R.id.rb_answer_4_b);

        if (correctAnswerForQuestion4.isChecked()) {
            mScore++;
        }

        // 5. question
        RadioButton correctAnswerForQuestion5 = (RadioButton) findViewById(R.id.rb_answer_5_c);

        if (correctAnswerForQuestion5.isChecked()) {
            mScore++;
        }

        // 6. question
        CheckBox answerForQuestion6a = (CheckBox) findViewById(R.id.cb_answer_6_a);
        CheckBox answerForQuestion6b = (CheckBox) findViewById(R.id.cb_answer_6_b);
        CheckBox answerForQuestion6c = (CheckBox) findViewById(R.id.cb_answer_6_c);
        CheckBox answerForQuestion6d = (CheckBox) findViewById(R.id.cb_answer_6_d);
        CheckBox answerForQuestion6e = (CheckBox) findViewById(R.id.cb_answer_6_e);

        if (answerForQuestion6a.isChecked() &&
                answerForQuestion6b.isChecked() &&
                !answerForQuestion6c.isChecked() &&
                !answerForQuestion6d.isChecked() &&
                answerForQuestion6e.isChecked()) {
            mScore++;
        }

        // 7. question
        RadioButton correctAnswerForQuestion7 = (RadioButton) findViewById(R.id.rb_answer_7_c);

        if (correctAnswerForQuestion7.isChecked()) {
            mScore++;
        }

        // 8. question
        RadioButton correctAnswerForQuestion8 = (RadioButton) findViewById(R.id.rb_answer_8_c);

        if (correctAnswerForQuestion8.isChecked()) {
            mScore++;
        }

        // 9. question
        CheckBox answerForQuestion9a = (CheckBox) findViewById(R.id.cb_answer_9_a);
        CheckBox answerForQuestion9b = (CheckBox) findViewById(R.id.cb_answer_9_b);
        CheckBox answerForQuestion9c = (CheckBox) findViewById(R.id.cb_answer_9_c);
        CheckBox answerForQuestion9d = (CheckBox) findViewById(R.id.cb_answer_9_d);

        if (answerForQuestion9a.isChecked() &&
                !answerForQuestion9b.isChecked() &&
                !answerForQuestion9c.isChecked() &&
                answerForQuestion9d.isChecked()) {
            mScore++;
        }

        // 10. question
        RadioButton correctAnswerForQuestion10 = (RadioButton) findViewById(R.id.rb_answer_10_c);

        if (correctAnswerForQuestion10.isChecked()) {
            mScore++;
        }

        Toast.makeText(this, "score " + mScore, Toast.LENGTH_LONG).show();
    }
}
