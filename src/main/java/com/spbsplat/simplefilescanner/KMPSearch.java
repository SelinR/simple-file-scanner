package com.spbsplat.simplefilescanner;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class FileScanner {
    private File file = new File("file.txt");


    private int[] compilePatternArray(String pattern) {
        int patternLength = pattern.length();
        int j = 0;
        int i = 1;
        int[] compliedPatternArray = new int[patternLength];
        compliedPatternArray[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                compliedPatternArray[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = compliedPatternArray[j - 1];
                } else {
                    compliedPatternArray[i] = j;
                    i++;
                }
            }
        }
        System.out.println("Compiled Pattern Array " + Arrays.toString(compliedPatternArray));
        return compliedPatternArray;
    }

    public List<Integer> performKMPSearch(String text, String pattern) {
        int[] compliedPatternArray = compilePatternArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        List<Integer> foundIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == pattern.length()) {
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compliedPatternArray[patternIndex - 1];
            }

            else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0)
                    patternIndex = compliedPatternArray[patternIndex - 1];
                else
                    textIndex = textIndex + 1;
            }
        }
        return foundIndexes;
    }



    //    public String scanFileForEntries(File file) {
//        StringBuilder result = new StringBuilder();
//        int entryCount = 0;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please, enter text to search");
//        String line = "";
//
//        try {
//            BufferedReader bReader = new BufferedReader(new FileReader(file));
//            while ((line = bReader.readLine()) != null) {
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return new String();
//    }

}
