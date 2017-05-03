package themadjem.util;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.util.Scanner;

/**
 * A collection of static methods used to get input from the user
 *
 * @author themadjem
 * @version 1.0
 *          Copyright 4/8/2017.
 */
public class Input {
    //Private scanner used for user input
    private static Scanner sc = new Scanner(System.in);

    /**
     * This returns a line of user input
     *
     * @return single string of input
     */
    public static String getSysIn() {
        return sc.nextLine();
    }

    /**
     * This returns an integer number from user input
     *
     * @return integer from user input
     */
    public static int getIntIn() {
        return sc.nextInt();
    }

    /**
     * This returns a long number from user input
     *
     * @return long from user input
     */
    public static long getLngIn() {
        return sc.nextLong();
    }

    /**
     * This method will display an input dialog box
     * to receive a string of input from user
     *
     * @param message message to be displayed
     * @param title   title of window
     * @return string input from user
     */
    public static String getStrInPane(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * This method will display an option dialog box
     * to get an index value of a given array of
     * options
     *
     * @param message message to be displayed
     * @param title   title of window
     * @param options array of options
     * @return index of option chosen
     */
    public static int optionWindow(String message, String title, String[] options) {

        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, 0);
    }

    /**
     * This method will display an confirm dialog box
     * to receive Yes/No response
     *
     * @param message message to be displayed
     * @param title   title of window
     * @return 0 = yes/ 1 = no/ -1 = closed
     */
    public static int yesNoBox(@NotNull String message, @Nullable String title) {
        if (title == null) title = "[Y/N]";
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }
}
