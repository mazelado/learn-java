import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    private static boolean is_anagram(String word1, String word2) {
        int len_word1 = word1.length();
        int len_word2 = word2.length();

        if (len_word1 != len_word2) {
            return false;
        }

        char[] sorted_word1 = word1.toCharArray();
        char[] sorted_word2 = word2.toCharArray();

        Arrays.sort(sorted_word1);
        Arrays.sort(sorted_word2);

        for (int i = 0; i < len_word1; i++) {
            if (sorted_word1[i] != sorted_word2[i]) {
                return false;
            }
        }

        return true;
    }

    private static ArrayList<String> file_to_list() throws FileNotFoundException {
        Scanner f = new Scanner(new File("words_alpha.txt"));
        ArrayList<String> word_list = new ArrayList<>();

        while (f.hasNext()) {
            word_list.add(f.next());
        }

        f.close();

        return word_list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> word_list = file_to_list();
        int len_word_list = word_list.size();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check for anagrams: ");
        String user_input = scanner.nextLine();

        for (String s : word_list) {
            if ((!user_input.equals(s)) && is_anagram(user_input, s)) {
                System.out.println(s);
            }
        }
    }
}
