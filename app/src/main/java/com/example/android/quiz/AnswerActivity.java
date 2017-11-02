package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class AnswerActivity extends AppCompatActivity {

    private Questions MyQuestions = new Questions();
    private TextView answers1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        answers1 = (TextView) findViewById(R.id.answers1);
        int arraySize = MyQuestions.MyCorrectAnswers.length;
        for (int i = 0; i < arraySize; i++){
            answers1.append(i+1 + ". " + MyQuestions.MyCorrectAnswers[i] + "\n");
        }
    }
    public void onagain(View view) {
        Intent intent = new Intent(AnswerActivity.this,
                MainActivity.class);
        startActivity(intent);
    }
    public void onback(View view) {
        Intent intent = new Intent(AnswerActivity.this,
                HighestScoreActivity.class);
        startActivity(intent);
    }
}