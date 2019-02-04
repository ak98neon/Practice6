package ua.nure.kudria.practice6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Artem Kudria
 */
public class WordContainer {
    private static final String ENCODING = "Cp1251";
    private static Map<String, Word> words = new TreeMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, ENCODING)) {
            String input;
            while (true) {
                input = scanner.next();
                if ("stop".equalsIgnoreCase(input)) {
                    break;
                }
                add(input);
            }
            print();
        }
    }

    private static void add(final String input) {
        if (words.containsKey(input)) {
            Word wordFind = words.get(input);
            wordFind.setFrequency(wordFind.getFrequency() + 1);
            words.put(input, wordFind);
        } else {
            Word newWord = new Word(input, 1);
            words.put(input, newWord);
        }
    }

    private static void print() {
        List<Word> list = new ArrayList<>(words.values());
        list.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o2.getFrequency() - o1.getFrequency();
            }
        });
        for (Word word : list) {
            System.out.println(word.getContent() + " : " + word.getFrequency());
        }
    }
}
