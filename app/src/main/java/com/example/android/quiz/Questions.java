package com.example.android.quiz;

/**
 * Created by opilane on 02.11.2017.
 */

public class Questions {
    public String MyQuestions[] = {
            "Which country has the largest population?",
            "Which country has the smallest population?",
            "Who was the first president of the US?",
            "In which year was the NATO first established",
            "In which year did World War II end?",
            "Which one of these countries stayed completely neutral during World War II?",
            "In which year was the atomic bomb 'Fat Man' dropped on the japanese city Nagasaki?",


    };

    public String MyChoices [] [] ={
            {"North Korea","China","Russia","India"},
            {"Switzerland","New Zealand","Vatican","Iceland"},
            {"Thomas Jefferson","James Monroe","John Adams","George Washington"},
            {"1930","1944","1978","1949"},
            {"1940","1964","1954","1945"},
            {"Finland","France","Spain","Switzerland"},
            {"1943","1947","1946","1945"},
    };

    public String MyCorrectAnswers [] = {
            "China","Vatican","George Washington","1949","1945","Switzerland","1945"
    };

    public int getLength() {return MyQuestions.length;}

    public String getQuestions(int a) {
        String question = MyQuestions[a];
        return question;
    }

    public String getChoice(int index, int num){
        String choice0=MyChoices[index][num -1];
        return choice0;
    }

    public String getCorrectAnswer (int a){
        String answer = MyCorrectAnswers[a];
        return answer;
    }
}
