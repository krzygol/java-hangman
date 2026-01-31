package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        WordRandomizer randomizer = new WordRandomizer();
        String word = randomizer.getRandomWord();

        ValidData data = new ValidData(word);
        Scanner scanner = new Scanner(System.in);

        int mistakes = 0;
        int maxMistakes = Display.HANGMANPICS.length - 1;

        while (mistakes < maxMistakes) {

            Display.showHangman(mistakes);
            Display.showWord(data.getWord(), data.getFounded());

            System.out.print("Podaj litere: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Podaj jedna litere!");
                continue;
            }

            char letter = input.charAt(0);

            boolean hit = data.updateFounded(letter);

            if (!hit) {
                mistakes++;
                System.out.println("Bledna litera!");
            }

            if (isWordGuessed(data.getFounded())) {
                Display.showWord(data.getWord(), data.getFounded());
                System.out.println("WYGRANA!");
                return;
            }
        }

        Display.showHangman(mistakes);
        System.out.println("PRZEGRANA!");
        System.out.println("Szukane slowo: " + word);
    }

    private static boolean isWordGuessed(boolean[] founded) {
        for (boolean b : founded) {
            if (!b) return false;
        }
        return true;
    }
}
