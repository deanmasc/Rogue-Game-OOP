package game;
import java.util.Random;

/**
 * Utility class used to generate random number.
 *
 * @author Dean Mascitti.
 */
public class Utility {
    /**
     * Static class that generates a random number between 2 bounds.
     *
     * @param lower lower bound
     * @param upper upper bound
     * @return random number between 2 bounds.
     */
    public static int generateRandom(int lower, int upper) {

        Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }
}
