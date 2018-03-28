package com.unscripted.www.delocker;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dONY on 13/08/2017.
 */

public final class DeLockHelper {

    private final static String LOG_TAG = DeLockHelper.class.getSimpleName();
    private static int COMBINATION_LIMIT = 1000;

    public static ArrayList<String> createCombinations(){
        ArrayList<String> numbers = new ArrayList<String>();

        // Populate with array with numbers from 000-999 inclusive
        for (int i = 0; i < 1000; i++){
            if (i < 10){
                numbers.add("00" + Integer.toString(i));
            } else if (i < 100){
                numbers.add("0" + Integer.toString(i));
            } else {
                numbers.add(Integer.toString(i));
            }
        }
        return numbers;
    } // eof

    public static int Randomizer(int limit){

        Random randomizer = new Random();
        int searchNum = randomizer.nextInt(limit);
        Log.d(LOG_TAG, "Randomizer Run" + "\n limit size " + limit +"\n return size " + searchNum);
        return searchNum;
    } // eof

    public static char[] digitSeparator(String currCombo){
        char[] result = new char[3];
        for(int i = 0; i < currCombo.length(); i++){
            result[i] = currCombo.charAt(i);
        }
        return result;
    } // eof

    public char[][] getCombinations(ArrayList<String> list){
        char[][] shortList = new char[10][3];

        for(int i = 0; i < 10; i++){
            String tempString = list.remove(Randomizer(1000));
            for(int j = 0; j < 3; j++){
                char[] tempChar = digitSeparator(tempString);
                shortList[i][j] = tempChar[j];
            }
        }
        return shortList;
    } // eof - very highly redundant code, remove after verification

    public static String[] getShortCombo(ArrayList<String> list){
        String[] shortset = new String[10];
        for(int i = 0; i < 10; i++){
            shortset[i] = list.remove(Randomizer(COMBINATION_LIMIT));
            COMBINATION_LIMIT -= 10;
        }
        return shortset;
    }


}
