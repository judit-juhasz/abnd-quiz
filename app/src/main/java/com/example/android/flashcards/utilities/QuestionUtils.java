package com.example.android.flashcards.utilities;

import android.content.Context;

import com.example.android.flashcards.Question;
import com.example.android.flashcards.R;

import java.util.ArrayList;

public class QuestionUtils {

    public static ArrayList<Question> getEventsQuestions(final Context context) {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(context.getString(R.string.question_events_1), context.getString(R.string.answer_events_1)));
        questions.add(new Question(context.getString(R.string.question_events_2), context.getString(R.string.answer_events_2)));
        questions.add(new Question(context.getString(R.string.question_events_3), context.getString(R.string.answer_events_3)));
        questions.add(new Question(context.getString(R.string.question_events_4), context.getString(R.string.answer_events_4)));
        questions.add(new Question(context.getString(R.string.question_events_5), context.getString(R.string.answer_events_5)));

        return questions;
    }

    public static ArrayList<Question> getPersonsQuestions(final Context context) {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(context.getString(R.string.question_persons_1), context.getString(R.string.answer_persons_1)));
        questions.add(new Question(context.getString(R.string.question_persons_2), context.getString(R.string.answer_persons_2)));
        questions.add(new Question(context.getString(R.string.question_persons_3), context.getString(R.string.answer_persons_3)));
        questions.add(new Question(context.getString(R.string.question_persons_4), context.getString(R.string.answer_persons_4)));
        questions.add(new Question(context.getString(R.string.question_persons_5), context.getString(R.string.answer_persons_5)));

        return questions;
    }

    public static ArrayList<Question> getDefinitionsQuestions(final Context context) {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(context.getString(R.string.question_definitions_1), context.getString(R.string.answer_definitions_1)));
        questions.add(new Question(context.getString(R.string.question_definitions_2), context.getString(R.string.answer_definitions_2)));
        questions.add(new Question(context.getString(R.string.question_definitions_3), context.getString(R.string.answer_definitions_3)));
        questions.add(new Question(context.getString(R.string.question_definitions_4), context.getString(R.string.answer_definitions_4)));
        questions.add(new Question(context.getString(R.string.question_definitions_5), context.getString(R.string.answer_definitions_5)));

        return questions;
    }

    public static ArrayList<Question> getTopographyQuestions(final Context context) {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(context.getString(R.string.question_topography_1), context.getString(R.string.answer_topography_1)));
        questions.add(new Question(context.getString(R.string.question_topography_2), context.getString(R.string.answer_topography_2)));
        questions.add(new Question(context.getString(R.string.question_topography_3), context.getString(R.string.answer_topography_3)));
        questions.add(new Question(context.getString(R.string.question_topography_4), context.getString(R.string.answer_topography_4)));
        questions.add(new Question(context.getString(R.string.question_topography_5), context.getString(R.string.answer_topography_5)));

        return questions;
    }

    public static ArrayList<Question> getBattlesQuestions(final Context context) {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(context.getString(R.string.question_battles_1), context.getString(R.string.answer_battles_1)));
        questions.add(new Question(context.getString(R.string.question_battles_2), context.getString(R.string.answer_battles_2)));
        questions.add(new Question(context.getString(R.string.question_battles_3), context.getString(R.string.answer_battles_3)));
        questions.add(new Question(context.getString(R.string.question_battles_4), context.getString(R.string.answer_battles_4)));

        return questions;
    }

    public static ArrayList<Question> getCultureQuestions(final Context context) {
        final ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(context.getString(R.string.question_culture_1), context.getString(R.string.answer_culture_1)));
        questions.add(new Question(context.getString(R.string.question_culture_2), context.getString(R.string.answer_culture_2)));
        questions.add(new Question(context.getString(R.string.question_culture_3), context.getString(R.string.answer_culture_3)));
        questions.add(new Question(context.getString(R.string.question_culture_4), context.getString(R.string.answer_culture_4)));
        questions.add(new Question(context.getString(R.string.question_culture_5), context.getString(R.string.answer_culture_5)));

        return questions;
    }
}
