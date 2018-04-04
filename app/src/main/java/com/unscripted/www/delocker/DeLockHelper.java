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

        int randElement = randomizer.nextInt(limit);
        Log.d(LOG_TAG, "Current index size is " + limit + "\nReturned index element is " + randElement);
        return randElement;
    } // eof

    public static char[] digitSeparator(String currCombo){
        char[] result = new char[3];
        for(int i = 0; i < currCombo.length(); i++){
            result[i] = currCombo.charAt(i);
        }
        return result;
    } // eof

//    public char[][] getCombinations(ArrayList<String> list){
//        char[][] shortList = new char[10][3];
//
//        for(int i = 0; i < 10; i++){
//            String tempString = list.remove(Randomizer(1000));
//            for(int j = 0; j < 3; j++){
//                char[] tempChar = digitSeparator(tempString);
//                shortList[i][j] = tempChar[j];
//            }
//        }
//        return shortList;
//    } // eof - very highly redundant code, remove after verification

    public static String[] getShortCombo(ArrayList<String> list) {
        String[] shortset = new String[10];
        if (COMBINATION_LIMIT > 0) {
            for (int i = 0; i < 10; i++) {
                int a = Randomizer(COMBINATION_LIMIT);
                shortset[i] = list.remove(a);
                Log.d(LOG_TAG, "Current shortset list item removed from list is " + shortset[i] + "\n--------------------");

                COMBINATION_LIMIT -= 1;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                shortset[i] = "000";
            }

        }
        return shortset;
    }

    public static ArrayList<String> showList(ArrayList<String> list){
        ArrayList<String> listElements = new ArrayList<String>();

        for(String p: list){
            listElements.add(p);
        }

        return listElements;
    }

}
