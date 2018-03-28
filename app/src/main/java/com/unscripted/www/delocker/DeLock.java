package com.unscripted.www.delocker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class DeLock extends AppCompatActivity {

    private final static String LOG_TAG = AppCompatActivity.class.getSimpleName();

    char[] currentCombo = new char[3];
    String firstNum, secondNum, thirdNum;
    char firstChar, secondChar, thirdChar;
    String[] shortset;
    ArrayList<String> combinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_lock);

        final Button mBtnGenerate = (Button) findViewById(R.id.btn_generateCombo);
        final TextView mTxtViewONE = (TextView) findViewById(R.id.textView);
        final TextView mTxtViewTWO = (TextView) findViewById(R.id.textView2);
        final TextView mTxtViewTHREE = (TextView) findViewById(R.id.textView3);
        final TextView mTxtViewWholeDisplay1 = (TextView) findViewById(R.id.txtWhlDisp1);
        final TextView mTxtViewWholeDisplay2 = (TextView) findViewById(R.id.txtWhlDisp2);
        final TextView mTxtViewWholeDisplay3 = (TextView) findViewById(R.id.txtWhlDisp3);
        final TextView mTxtViewWholeDisplay4 = (TextView) findViewById(R.id.txtWhlDisp4);
        final TextView mTxtViewWholeDisplay5 = (TextView) findViewById(R.id.txtWhlDisp5);
        final TextView mTxtViewWholeDisplay6 = (TextView) findViewById(R.id.txtWhlDisp6);
        final TextView mTxtViewWholeDisplay7 = (TextView) findViewById(R.id.txtWhlDisp7);
        final TextView mTxtViewWholeDisplay8 = (TextView) findViewById(R.id.txtWhlDisp8);
        final TextView mTxtViewWholeDisplay9 = (TextView) findViewById(R.id.txtWhlDisp9);

        combinations = DeLockHelper.createCombinations();

        mBtnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                shortset = DeLockHelper.getShortCombo(combinations);
                currentCombo = DeLockHelper.digitSeparator(shortset[0]);

                firstChar = currentCombo[0];
                secondChar = currentCombo[1];
                thirdChar = currentCombo[2];

                firstNum = String.valueOf(firstChar);
                secondNum = String.valueOf(secondChar);
                thirdNum = String.valueOf(thirdChar);


                mTxtViewONE.setText(firstNum);
                mTxtViewTWO.setText(secondNum);
                mTxtViewTHREE.setText(thirdNum);
                mTxtViewWholeDisplay1.setText(shortset[1]);
                mTxtViewWholeDisplay2.setText(shortset[2]);
                mTxtViewWholeDisplay3.setText(shortset[3]);
                mTxtViewWholeDisplay4.setText(shortset[4]);
                mTxtViewWholeDisplay5.setText(shortset[5]);
                mTxtViewWholeDisplay6.setText(shortset[6]);
                mTxtViewWholeDisplay7.setText(shortset[7]);
                mTxtViewWholeDisplay8.setText(shortset[8]);
                mTxtViewWholeDisplay9.setText(shortset[9]);

            }
        });


    }

}
