package in.thegeekybaniya.lls_ams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    int score;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv= (TextView) findViewById(R.id.textView8);


        Intent i = getIntent();

        i.getExtras();

        score= i.getIntExtra("score",0);


        if(score<3){
            tv.setText("Congratulations!!\n You Are Not suffering from\n AMS");

        }else if (score<5){
            tv.setText("You are suffering from\n Mild AMS");
        }else {
            tv.setText("You are suffering from\n Severe AMS");

        }




    }
}
