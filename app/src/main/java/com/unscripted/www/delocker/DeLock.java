package com.unscripted.www.delocker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class DeLock extends AppCompatActivity {

    char[] currentCombo = new char[3];
    String firstNum, secondNum, thirdNum;
    char firstChar, secondChar, thirdChar;
    String temp;
    String[] combinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_lock);

        final Button mBtnGenerate = (Button) findViewById(R.id.btn_generateCombo);
        final TextView mTxtViewONE = (TextView) findViewById(R.id.textView);
        final TextView mTxtViewTWO = (TextView) findViewById(R.id.textView2);
        final TextView mTxtViewTHREE = (TextView) findViewById(R.id.textView3);
        final TextView mTxtViewWholeDisplay = (TextView) findViewById(R.id.txtWholeDisplay);


//        firstNum = Integer.toString(currentCombo[0]);
//        secondNum = Integer.toString(currentCombo[1]);
//        thirdNum = Integer.toString(currentCombo[2]);

        mBtnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combinations = createRange();
                temp = combinations[Randomizer()];
                currentCombo = digitSeparator(temp);

                firstChar = currentCombo[0];
                secondChar = currentCombo[1];
                thirdChar = currentCombo[2];

                firstNum = String.valueOf(firstChar);
                secondNum = String.valueOf(secondChar);
                thirdNum = String.valueOf(thirdChar);


                mTxtViewONE.setText(firstNum);
                mTxtViewTWO.setText(secondNum);
                mTxtViewTHREE.setText(thirdNum);

            }
        });



    }

    protected String[] createRange(){
        // Create an array to hold all combination possibilities
        String[] combinations = new String[1000];

        // Populate array with numerical representations from 000-999
        for (int i = 0; i < combinations.length; i++){
            if (i < 10) {
                combinations[i] = "00" + Integer.toString(i);
            } else if (i < 100){
                combinations[i] = "0" + Integer.toString(i);
            } else {
                combinations[i] = Integer.toString(i);
            }
        }

        // System.out.println(Arrays.toString(combinations));
        return combinations;
    }

    protected static int Randomizer(){
        Random randomizer = new Random();
        int searchNum =  randomizer.nextInt(1000);
        return searchNum;
    }

    protected static char[] digitSeparator(String combination){
        char[] result = new char[3];
        for(int i = 0; i < combination.length(); i++){
            result[i] = combination.charAt(i);
        }
        return result;
    }



}
