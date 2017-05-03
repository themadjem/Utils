package themadjem.util;

import java.awt.*;
import java.util.Random;

/**
 * @author themadjem
 *         Copyright 4/9/2017.
 */
public class RandNumGen {
    // Random generator
    private Random rand;
    //array of colors used for generating random colors
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE,
            Color.CYAN, Color.MAGENTA, Color.YELLOW,
            Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY,
            Color.BLACK, Color.WHITE, Color.ORANGE, Color.PINK
    };

    /**
     * Constructor
     * initializes the Random object
     */
    public RandNumGen() {
        rand = new Random();
    }

    /**
     * Constructor
     * initializes the Random object
     * with a given seed
     *
     * @param seed long seed
     */
    public RandNumGen(long seed) {
        rand = new Random(seed);
    }

    /**
     * Sets the seed of the Random Number Generator
     *
     * @param seed seed
     */
    public void setSeed(long seed) {
        rand.setSeed(seed);
    }

    /**
     * Returns a random number between 0 and 1
     * 0<=r<=1
     * values are in steps of tenths
     *
     * @return random tenth between 0 and 1
     */
    public double rand() {
        return rand.nextInt(10) / 10d;
    }

    public double rand(int decimalPlaces) {
        if (decimalPlaces <= 0) return 0;
        int dig = (int) Math.pow(10, decimalPlaces);
        return rand.nextInt(dig) / (double) dig;
    }

    /**
     * Returns a random integer from
     * zero to 2^23
     *
     * @return random integer
     */
    public int randInt() {
        return rand.nextInt();
    }

    /**
     * Returns a random integer from
     * zero to the given bound
     *
     * @param bound upper bound
     * @return 0 < rand < bound
     */
    public int randInt(int bound) {
        return rand.nextInt(bound);
    }

    /**
     * Returns a random number between
     * the lower and upper bounds
     *
     * @param lower lower bound
     * @param upper upper bound
     * @return random number
     */
    public int randInt(int lower, int upper) {//todo make this work
        if (upper <= lower) return 0;
        int i1 = rand.nextInt(upper - lower);
        return 0;
    }

    public boolean randBool() {
        return rand.nextBoolean();
    }

    public Color randColor() {
        return colors[rand.nextInt(colors.length)];
    }

}
