package com.example.android.flashcards.utilities;

import com.example.android.flashcards.Question;

import java.util.ArrayList;

public class QuestionUtils {

    public static ArrayList<Question> getCategoryAQuestions() {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the color of the sky?", "Blue."));
        questions.add(new Question("How many weeks are in a year?", "52"));
        questions.add(new Question("How many people live in the world?", "7.5 Billion"));

        return questions;
    }
}
