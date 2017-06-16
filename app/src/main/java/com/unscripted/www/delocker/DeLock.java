package com.unscripted.www.delocker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class DeLock extends AppCompatActivity {

    private int[] combinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_lock);


    }

    private String[] createRange(){
        // Create an array to hold all combination possiblities
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

        System.out.println(Arrays.toString(combinations));
        return combinations;
    }


}
