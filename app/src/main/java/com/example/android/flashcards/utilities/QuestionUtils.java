package com.example.android.flashcards.utilities;

import com.example.android.flashcards.Question;

import java.util.ArrayList;

public class QuestionUtils {

    public static ArrayList<Question> getEventQuestions() {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("When did Julius Caesar die?", "44 BCE"));
        questions.add(new Question("In what year did the Western Roman Empire come to an end?", "476 CE"));
        questions.add(new Question("The most familiar date given for the foundation of Rome", "753 BCE"));
        questions.add(new Question("The beginning of the Principate", "27 BCE"));
        questions.add(new Question("The First Triumvirate", "60 BCE"));

        return questions;
    }
}
