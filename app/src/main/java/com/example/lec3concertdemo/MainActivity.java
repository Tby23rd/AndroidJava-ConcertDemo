package com.example.lec3concertdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Concert Demo"; //creates a final String to be used in the logs

    Spinner spinnerConcertType; //you can declare this view either here or inside the onCreate method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Starting app..."); //just a test log msg put in the debug logs


        Button btnCalcCost = findViewById(R.id.btnCalcCost);
        EditText editTextNumTix = findViewById(R.id.editTextNumTix);
        spinnerConcertType = findViewById(R.id.spinnerConcertType);


        btnCalcCost.setOnClickListener((View view) -> {
            if (editTextNumTix.getText().toString().equals("")){
                Log.d(TAG,"Number of tickets is empty"); //adding log msg for the programmer
                Toast.makeText(this, "Number of Tickets cannot be empty", Toast.LENGTH_SHORT).show(); //displays a msg for the user on the app screen
            } else{
                //when the edit text non-empty
                try{
                    int numTix = Integer.parseInt(editTextNumTix.getText().toString());
                    int index = spinnerConcertType.getSelectedItemPosition();
                    double cost = 0;
                    switch (index) {
                        case 0:
                            cost = numTix*79.99;
                            break;
                        case 1:
                            cost = numTix*69.99;
                            break;
                        case 2:
                            cost = numTix*59.99;
                            break;
                    }

                    //at this point total cost is computed
                    //We would create an intent to start activity and start results activity

                    //Create an Intent object to start next activity
                   // Intent myResults = new Intent( MainActivity.this,ResultsActivity.class);
Intent myResults = new Intent(MainActivity.this,ResultsActivity.class);



                    //Create a bundle object with all the data
                    Bundle bundle = new Bundle();
                    bundle.putInt("NUMTIX",numTix);
                    bundle.putString("TYPE",spinnerConcertType.getSelectedItem().toString());
                    bundle.putDouble("COST",cost);

                    //Put bundle object into the intent object
                    myResults.putExtras(bundle);

                    //start the next activity
                    startActivity(myResults);

                } catch (Exception ex){
                    Toast.makeText(this, "Please check the input", Toast.LENGTH_SHORT).show();
                    Log.d(TAG,ex.getMessage());
                }
            }
        });


    }
}