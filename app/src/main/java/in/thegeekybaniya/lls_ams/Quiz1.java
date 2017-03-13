package in.thegeekybaniya.lls_ams;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static in.thegeekybaniya.lls_ams.R.id.btn1;
import static in.thegeekybaniya.lls_ams.R.id.btn2;
import static in.thegeekybaniya.lls_ams.R.id.btn3;
import static in.thegeekybaniya.lls_ams.R.id.btn4;

public class Quiz1 extends AppCompatActivity {


    static int score=0;

    static int q=0;


    Button op1, op2, op3,op4;
    TextView ques;

    ArrayList<Qna> Qlist = new ArrayList<>();

    private static final String TAG = "Quiz1";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);


        Qlist.add(new Qna("Headache", "No Headache", "Mild Headache", "Moderate Headache","Severe Headache"));
        Qlist.add(new Qna("Gastrointestinal symptoms", "None", "Poor Appetite or Nausea", "Moderate Nausea and Vomitting","Severe Nausea or Vomitting"));
        Qlist.add(new Qna("Fatigue and Weakness", "Not Tired or Weak", "Mild Mild Fatigue/Weakness", "Moderate Fatigue/Weakness","Severe Fatigue/Weakness"));
        Qlist.add(new Qna("Dizziness or Light Headedness", "Not Dizzy", "Mild Dizziness", "Moderate Dizziness","Severe Dizziness,Incapacitating"));
        Qlist.add(new Qna("Difficulty Sleeping", "Slept As Well As Usual", "Did Not Sleep As Well As Usual", "Woke Many Times, Poor Sleep","Did Not Sleep At All"));


        op1= (Button) findViewById(btn1);
        op2= (Button) findViewById(btn2);
        op3= (Button) findViewById(btn3);
        op4= (Button) findViewById(btn4);
        ques= (TextView) findViewById(R.id.textView);

        change(q);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=0;
                q+=1;
                if (q>=5){
                    result(score);
                }else {
                    change(q);

                }

            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=1;
                q+=1;
                if (q>=5){
                    result(score);
                }else {
                    change(q);

                }

            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=2;
                q+=1;
                if (q>=5){
                    result(score);
                }else {
                    change(q);

                }
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=3;
                q+=1;
                if (q>=5){
                    result(score);
                }else {
                    change(q);

                }

            }
        });






    }

    void change(int q){

        Qna c=Qlist.get(q);


        ques.setText(c.getQuestion());
        op1.setText(c.getOp1());
        op2.setText(c.getOp2());
        op3.setText(c.getOp3());
        op4.setText(c.getOp4());


        Log.d(TAG, "change: "+ c.toString());




    }

    void result(int score){

        Toast.makeText(this, "Test Ended With Score: "  + Integer.toString(score), Toast.LENGTH_SHORT).show();

        Intent i = new Intent(Quiz1.this, Result.class);

        i.putExtra("score", score);

        startActivity(i);

    }







}
