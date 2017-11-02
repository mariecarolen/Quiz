package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Questions MyQuestions = new Questions();
    private ImageView myImageView;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private TextView result;
    private TextView Question;
    private String MyAnswer;
    private int MyScore =0;
    private int MyQuestionNumber =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);
        result = (TextView) findViewById(R.id.result);
        Question = (TextView) findViewById(R.id.Question);
        updateQuestion();
        updateScore(MyScore);
    }

    private void updateQuestion() {
        if (MyQuestionNumber < MyQuestions.getLength()){
            Question.setText(MyQuestions.getQuestions(MyQuestionNumber));
            answer1.setText(MyQuestions.getChoice(MyQuestionNumber,1));
            answer2.setText(MyQuestions.getChoice(MyQuestionNumber,2));
            answer3.setText(MyQuestions.getChoice(MyQuestionNumber,3));
            answer4.setText(MyQuestions.getChoice(MyQuestionNumber,4));
            MyAnswer = MyQuestions.getCorrectAnswer(MyQuestionNumber);
            MyQuestionNumber++;
        }
        else{
            Toast.makeText(MainActivity.this, "You've finished the quiz!",Toast.LENGTH_SHORT).show();;
            Intent intent = new Intent(MainActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", MyScore);
            startActivity(intent);
        }
    }
    private void updateScore(int point){
        result.setText(""+ MyScore +"/"+MyQuestions.getLength());
    }
    public void onClick(View view){
        Button answer = (Button) view;
        if(answer.getText()==MyAnswer){
            MyScore += 1;
            Toast.makeText(MainActivity.this,"Correct!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this,"False!",Toast.LENGTH_SHORT).show();
        }
        updateScore(MyScore);
        updateQuestion();
    }
}
