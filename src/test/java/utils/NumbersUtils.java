package utils;

import java.util.Random;

public class NumbersUtils {

    public static int generateNumber() {
        Random randomNumbers = new Random();
        int upperbound = 10001;
        int numb = randomNumbers.nextInt(upperbound);
        return numb += 1;
    }
}
