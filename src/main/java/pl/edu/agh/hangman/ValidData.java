package pl.edu.agh.hangman;

public class ValidData {

    private final String word;
    private final boolean[] founded;

    public ValidData(String word) {
        this.word = word;
        this.founded = new boolean[word.length()];
    }

    public String getWord() {
        return word;
    }

    public boolean[] getFounded() {
        return founded;
    }

    public boolean updateFounded(char letter) {
        boolean found = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                founded[i] = true;
                found = true;
            }
        }
        return found;
    }
}
