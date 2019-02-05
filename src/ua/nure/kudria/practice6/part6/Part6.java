package ua.nure.kudria.practice6.part6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Part6 {
    private static List<String> commands;

    public static void main(String[] args) {
        init();
        if (commands.contains(args[0])) {
            String txtFromFile = readFromFile(args[1]);
            txtFromFile = txtFromFile.replaceAll("(\\r|\\n)", " ");
            switch (args[3]) {
                case "length":
                    lengthWord(txtFromFile);
                    break;
                case "frequency":
                    frequency(txtFromFile);
                    break;
                case "duplicates":
                    duplicates(txtFromFile);
                    break;
                default:
                    break;
            }
        }
    }

    private static void init() {
        commands = new ArrayList<>();
        commands.add("-i");
        commands.add("--input");
        commands.add("-t");
        commands.add("--task");
    }

    public static void lengthWord(String text) {
        List<String> maxWords = new ArrayList<>();
        String[] txtArr = text.trim().split(" ");
        for (int j = 0; j < 3; j++) {
            String max = txtArr[0];
            for (int i = 1; i < txtArr.length; i++) {
                if (txtArr[i].length() > max.length() && !maxWords.contains(txtArr[i])) {
                    max = txtArr[i];
                }
            }
            maxWords.add(max);
        }

        maxWords.sort((o1, o2) -> o2.length() - o1.length());
        for (String s : maxWords) {
            System.out.println(s + " ==> " + s.length());
        }
    }

    public static void frequency(String text) {
        Map<String, Integer> maxWords = new HashMap<>();
        String[] txtArr = text.trim().split(" ");
        txtArr = removeNullValue(txtArr);
        Arrays.sort(txtArr);

        for (int i = 0; i < 3; i++) {
            String maxWord = "", word = "";
            int maxCount = 0, count = 1;

            for (String s : txtArr) {
                if (s.equals(word) && !maxWords.containsKey(word)) {
                    count++;
                } else {
                    if (count > maxCount) {
                        maxCount = count;
                        maxWord = word;
                    }
                    word = s;
                    count = 1;
                }
            }
            maxWords.put(maxWord, maxCount);
        }

        for (Map.Entry<String, Integer> elem : maxWords.entrySet()) {
            System.out.println(elem.getKey() + " ==> " + elem.getValue());
        }
    }

    public static void duplicates(String text) {
        List<String> listDuplicates = new ArrayList<>();
        String[] txtArr = text.trim().split(" ");
        txtArr = removeNullValue(txtArr);

        int maxCountDuplicates = 3;
        int countDuplicates = 0;
        for (int i = 0; i < txtArr.length; i++) {
            for (int j = 0; j < txtArr.length; j++) {
                if (i == j) {
                    continue;
                }

                if (txtArr[j].equals(txtArr[i]) && !listDuplicates.contains(txtArr[i])) {
                    listDuplicates.add(txtArr[i]);
                    countDuplicates++;
                    break;
                }
            }
            if (countDuplicates == maxCountDuplicates) {
                break;
            }
        }

        for (String s : listDuplicates) {
            System.out.println(new StringBuilder(s.toUpperCase()).reverse());
        }
    }

    public static String readFromFile(String fileName) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(fileName)),
                "Cp1251")) {
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line;
            while ((line = br.readLine()) != null) {
                joiner.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return joiner.toString().replaceAll("(?m)^\\s", "");
    }

    public static String[] removeNullValue(String[] firstArray) {
        List<String> list = new ArrayList<>();
        for (String s : firstArray) {
            if (s != null && s.length() > 0) {
                list.add(s);
            }
        }

        return list.toArray(new String[0]);
    }
}
