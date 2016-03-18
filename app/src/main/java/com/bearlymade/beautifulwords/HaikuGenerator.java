package com.bearlymade.beautifulwords;

import android.content.Context;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by cweaver on 2/18/2016.
 */
public class HaikuGenerator {

    Context context;

    public HaikuGenerator(Context context){
        this.context = context;
    }

    public String generateHaiku() {

        String haiku = "";
        String[] words = WordList.words;
        HashMap<String, Integer> syllableMap = WordList.syllableMap;
        String[] wordSplit = {};

        Random rand = new Random();
        int syllableCount;
        String keyWord;
        String word;
        boolean continueLine;
        int targetSyllables = 0;
        for (int i = 0; i < 3; i++) {

            syllableCount = 0;
            continueLine = true;

            if (i == 0 || i == 2) {
                targetSyllables = 5;
            } else {
                targetSyllables = 7;
            }

            while (continueLine) {
                word = words[rand.nextInt(words.length)];
                keyWord = word+"";
                if (syllableCount + syllableMap.get(keyWord) <= targetSyllables) {
                    if (syllableCount == 0) {
                        word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                    }
                    syllableCount += syllableMap.get(keyWord);
                    haiku += word + " ";
                    if (syllableCount == targetSyllables) {
                        continueLine = false;
                    }
                }
            }
            haiku += "\r\n";
        }

        return haiku;
    }
}
