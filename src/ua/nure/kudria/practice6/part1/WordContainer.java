package ua.nure.kudria.practice6.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Artem Kudria
 */
public class WordContainer {
    private static final String ENCODING = "Cp1251";
    private Map<String, Word> words = new TreeMap<>();

    public static void main(String[] args) {
        WordContainer wordContainer = new WordContainer();
        try (Scanner scanner = new Scanner(System.in, ENCODING)) {
            String input;
            while (true) {
                input = scanner.next();
                if ("stop".equalsIgnoreCase(input)) {
                    break;
                }
                wordContainer.add(input);
            }
            wordContainer.print();
        }
    }

    private void add(final String input) {
        if (words.containsKey(input)) {
            Word wordFind = words.get(input);
            wordFind.setFrequency(wordFind.getFrequency() + 1);
            words.put(input, wordFind);
        } else {
            Word newWord = new Word(input, 1);
            words.put(input, newWord);
        }
    }

    private void print() {
        List<Word> list = new ArrayList<>(words.values());
        list.sort((o1, o2) -> o2.getFrequency() - o1.getFrequency());
        for (Word word : list) {
            System.out.println(word.getContent() + " : " + word.getFrequency());
        }
    }
}
