package com.ckm.practice;

import java.util.ArrayList;

public class Word {
    private String letters;

    public Word(String letters) {
        this.letters = letters;
    }

    // aeiou
    boolean answer = false;

    public boolean isVowel(int i) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("u");
        list.add("A");
        list.add("E");
        list.add("I");
        list.add("O");
        list.add("U");


        for (int j = 0; j < list.size(); j++) {
            if (letters.substring(i, i + 1).equals(list.get(j))) {
                answer = true;
                break;
            }
        }

        return answer;
    }

    public boolean isConsonant(int i) {
        boolean answer = !isVowel(i);
        return answer;
    }


}


