package com.unscripted.www.delocker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dONY on 13/08/2017.
 */

public final class DeLockHelper {

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

    public static int Randomizer(){
        Random randomizer = new Random();
        int searchNum = randomizer.nextInt(1000);
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
            String tempString = list.remove(Randomizer());
            for(int j = 0; j < 3; j++){
                char[] tempChar = digitSeparator(tempString);
                shortList[i][j] = tempChar[j];
            }
        }
        return shortList;
    } // eof

    public static String[] getShortCombo(ArrayList<String> list){
        String[] shortset = new String[10];
        for(int i = 0; i < 10; i++){
            shortset[i] = list.remove(Randomizer());
        }
        return shortset;
    }


}
