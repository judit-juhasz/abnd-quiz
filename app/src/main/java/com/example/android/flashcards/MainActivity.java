package com.example.android.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPractice(View view) {
        final Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }

    public void onClickTakeExam(View view) {
        final Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
    }
}
