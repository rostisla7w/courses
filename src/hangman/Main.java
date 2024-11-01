package hangman;

import java.util.*;

public class Main {
    private static final String first = "час";
    private static final String second = "машина";
    private static final String third = "лошадь";
    private static final String fourth = "имя";
    private static final String fifth = "дождь";
    private static String[] words = {first, second, third, fourth, fifth};

    public static void main(String[] args) {
        Random ramdom = new Random();
        int index = ramdom.nextInt(words.length);
        String word = words[index];
        Hangman game = new Hangman(word, 3);
        System.out.println("Вы должны угадать слово по буквам");
        game.inputletter();
    }
}

class Hangman {
    private String word;
    private char [] letters;
    private Scanner scanner;
    private boolean isNotGuessed = true;

    private int lifes;



    public Hangman (String word, int lifes) {
        this.word= word;
        letters = new  char[word.length()];
        Arrays.fill(letters, '_');
        scanner = new Scanner(System.in);
        this.lifes = lifes;
    }

    public void inputletter(){
        System.out.println("Введите букву");
        while (lifes > 0 && isNotGuessed){
            String input = scanner.nextLine();
            char letter = input.charAt(0);
            boolean isRightLetter = false;
            for (int i= 0; i < word.length(); i++){
                if (word.charAt(i) == letter) {
                    letters[i] = letter;
                    isRightLetter = true;
                }
            }
            if (!isRightLetter) {
                lifes--;
            }
            System.out.println("Осталось жизней: " + lifes);
            isNotGuessed = hasUnderscore();
            System.out.println(letters);
        }
    }

    private boolean hasUnderscore() {
        for(char letter : letters) {
            if (letter == '_') {
                return true;
            }
        }
        return false;
    }
}