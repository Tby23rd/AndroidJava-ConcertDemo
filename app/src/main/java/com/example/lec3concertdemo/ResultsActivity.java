package com.example.lec3concertdemo;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {
    final String TAG = "Concert Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView txtViewResults = findViewById(R.id.txtViewResults);

        try {
           double cost = getIntent().getExtras().getDouble("COST",0);
           int numTix = getIntent().getExtras().getInt("NUMTIX",0);
           String concertType = getIntent().getExtras().getString("TYPE"); //can also be called without default value

           DecimalFormat df = new DecimalFormat("$#.##");

           String outputStr = "Concert Type: " + concertType + "\n"
                            + "Num Tix: " + numTix + "\n"
                            + "Total Cost: " + df.format(cost);

           txtViewResults.setText(outputStr);
           txtViewResults.setTextSize(Dimension.SP,24);
           txtViewResults.setGravity(Gravity.CENTER);

        } catch (Exception ex){
            Log.d(TAG,ex.getMessage()); //this displays as log msg the exception's object message
        }
    }
}