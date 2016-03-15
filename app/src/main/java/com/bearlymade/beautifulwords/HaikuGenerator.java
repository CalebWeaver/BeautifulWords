package com.bearlymade.beautifulwords;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        Log.d("Entering", "MEthod");

        String haiku = "";
        String[] words = WordList.words;
        HashMap<String, Integer> syllableMap = WordList.syllableMap;
        String[] wordSplit = {};

        Random rand = new Random();
        int syllableCount;
        String word;
        for (int i = 0; i < 3; i++) {
            syllableCount = 0;
            while ((i == 0 || i == 2) && syllableCount < 5) {
                word = words[rand.nextInt(words.length)];
                if (syllableCount + syllableMap.get(word) <= 5) {
                    haiku += word + " ";
                    syllableCount += syllableMap.get(word);
                }
            }
            while (i == 1 && syllableCount < 7) {
                word = words[rand.nextInt(words.length)];
                if (syllableCount + syllableMap.get(word) <= 7) {
                    haiku += word + " ";
                    syllableCount += syllableMap.get(word);
                }
            }
            haiku += "\r\n";
        }

        Log.d("Haiku", haiku);
        return haiku;
    }
}
