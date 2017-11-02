package com.example.android.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
public class HighestScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);
        TextView txtScore = (TextView) findViewById(R.id.YourScore);
        TextView txtHighScore = (TextView)
                findViewById(R.id.Highscore);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your score: " + score);
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore", 0);
        if (highscore >= score)
            txtHighScore.setText("High score: " + highscore);
        else {
            txtHighScore.setText("New high-score: " + score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("high-score", score);
            editor.commit();
        }
    }
    public void onClick(View view) {
        Intent intent = new Intent(HighestScoreActivity.this,
                MainActivity.class);
        startActivity(intent);
    }
    public void answersClick(View view) {
        Intent intent = new Intent(HighestScoreActivity.this,
                AnswerActivity.class);
        startActivity(intent);
    }
}
