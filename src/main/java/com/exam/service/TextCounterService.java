package com.exam.service;

import java.util.HashMap;
import java.util.Map;

public class TextCounterService {

    public int countPhrase(String content, String phrase) {
        String text = content.toLowerCase();
        String key = phrase.toLowerCase();

        int count = 0, idx = 0;

        while ((idx = text.indexOf(key, idx)) != -1) {
            count++;
            idx += key.length();
        }

        return count;
    }

    public Map<String, Integer> countWords(String content, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        String text = content.toLowerCase();

        for (String w : words) {
            int count = 0;
            int idx = 0;
            String key = w.toLowerCase();

            while ((idx = text.indexOf(key, idx)) != -1) {
                count++;
                idx += key.length();
            }

            map.put(w, count);
        }

        return map;
    }
}
