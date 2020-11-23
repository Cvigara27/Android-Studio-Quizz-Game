package com.example.quizzgame;

public class Question {

    private int TextId;
    private boolean Answer;

    public Question(int myTextId, boolean myAnswer){
        setTextId(myTextId);
        setAnswer(myAnswer);
    }

    public int getTextId() {
        return TextId;
    }

    public void setTextId(int textId) {
        TextId = textId;
    }

    public boolean isAnswer() {
        return Answer;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }
}
