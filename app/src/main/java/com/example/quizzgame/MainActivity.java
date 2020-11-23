package com.example.quizzgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView questionView;
    private Button nextButton;
    private Button previousButton;
    private int currentIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.question_pokemon, true),
            new Question(R.string.question_digimon, false),
            new Question(R.string.question_ffx, false),
            new Question(R.string.question_hollow, true),
            new Question(R.string.question_smite, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionView = (TextView) findViewById(R.id.question);
        int question = questionBank[currentIndex].getTextId();
        questionView.setText(question);

        Button btn = findViewById(R.id.date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        String date = simpleDateFormat.format(new Date());
        btn.setText(date);
    }

    public void nextQuestion(View v){
        currentIndex++;
        questionView = (TextView) findViewById(R.id.question);
        int question = questionBank[currentIndex].getTextId();
        questionView.setText(question);
        checkButton();
    }

    public void previousQuestion(View v) {
        currentIndex--;
        questionView = (TextView) findViewById(R.id.question);
        int question = questionBank[currentIndex].getTextId();
        questionView.setText(question);
        checkButton();
    }

    public void checkButton(){
        nextButton = (Button) findViewById(R.id.next_button);
        previousButton = (Button) findViewById(R.id.previous_button);
        if(currentIndex == questionBank.length-1){
            nextButton.setEnabled(false);
        }else{
            nextButton.setEnabled(true);
        }

        if(currentIndex == 0){
            previousButton.setEnabled(false);
        }else{
            previousButton.setEnabled(true);
        }
    }

    public void checkAnswer(View v){
        boolean answer = questionBank[currentIndex].isAnswer();
        boolean userPressedTrueFalse;
        if(v == findViewById(R.id.true_button)){
            userPressedTrueFalse = true;
        }else{
            userPressedTrueFalse = false;
        }

        int messageId = 0;

        if(userPressedTrueFalse == answer){
            messageId = R.string.correct_toast;
        }else{
            messageId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }

    public void updateTime(View v){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        String date = simpleDateFormat.format(new Date());
        ((Button) v).setText(date);
    }
}