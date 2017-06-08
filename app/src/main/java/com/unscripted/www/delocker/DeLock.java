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

    private int[] createRange(){
        int[] combinations = new int[1000];

        for (int i = 0; i < 1000; i++){
            combinations[i] = i;
        }

        System.out.println(Arrays.toString(combinations));
        return combinations;
    }


}
