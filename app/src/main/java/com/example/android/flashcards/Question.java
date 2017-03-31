package com.example.android.flashcards;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    private String mQuestion;
    private String mAnswer;

    public Question(final String question, final String answer) {
        this.mQuestion = question;
        this.mAnswer = answer;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getAnswer() {
        return mAnswer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mQuestion);
        dest.writeString(mAnswer);
    }

    public Question(final Parcel in) {
        mQuestion = in.readString();
        mAnswer = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
