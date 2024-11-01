package generator;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordGeneration generation = new PasswordGeneration();
        generation.generate();
    }
}

class PasswordGeneration {
    private Scanner scanner;
    private char[] symbols;

    public  PasswordGeneration(){
        scanner = new Scanner(System.in);
    }
    public void generate(){
        System.out.println("Введите количество символов пароля: ");
        int length = scanner.nextInt();

        while(length<8 || length>12) {
            System.out.println("Вы ввели неправильное количество символов. Введите заново.");
            length = scanner.nextInt();
        }
        symbols = new char[length];
        Random ramdom = new Random();
        for (int i = 0; i < length; i++) {
            symbols[i] = (char)(ramdom.nextInt(99) + 33);
        }
        System.out.println(symbols);
    }

}
