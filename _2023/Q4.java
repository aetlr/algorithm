package _2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();
        String input = sc.nextLine();

        Map<Character, Character> encryptionMap = new HashMap<>();
        char originalChar = 'a';

        for (char c : key.toCharArray()) {
            encryptionMap.put(originalChar, c);
            originalChar++;
        }

        StringBuilder encString = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                encString.append(c);
            }
            else {
                encString.append(encryptionMap.get(c));
            }
        }

        System.out.println(encString);
    }
}
