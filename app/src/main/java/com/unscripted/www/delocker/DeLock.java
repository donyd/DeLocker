package com.unscripted.www.delocker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class DeLock extends AppCompatActivity {

    private String temp;
    private char[] currentCombo = new char[3];
    private String[] combinations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_lock);
        final Button mBtnGenerate = (Button) findViewById(R.id.btn_generateCombo);
        final TextView mTxtViewONE = (TextView) findViewById(R.id.textView);
        final TextView mTxtViewTWO = (TextView) findViewById(R.id.textView2);
        final TextView mTxtViewTHREE = (TextView) findViewById(R.id.textView3);

        combinations = createRange();
        temp = combinations[Randomizer()];
        currentCombo = digitSeparator(temp);

        mBtnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTxtViewONE.setText("");
                mTxtViewTWO.setText("");
                mTxtViewTHREE.setText("");
            }
        });

    }

    private String[] createRange(){
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

    private int Randomizer(){
        Random randomizer = new Random();
        int searchNum =  randomizer.nextInt(1000);
        return searchNum;
    }

    private char[] digitSeparator(String combination){
        char[] result = new char[3];
        for(int i = 0; i < combination.length(); i++){
            result[i] = combination.charAt(i);
        }
        return result;
    }


}
