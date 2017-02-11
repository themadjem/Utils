package com.themadjem;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * This class is a plethora of utilities used in multiple projects
 *
 * @author Jesse Maddox
 * @version 1.2
 */
public class Utils {

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
    public static int yesNoBox(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }

    /**
     * This method will display an informational
     * message box to the user
     *
     * @param message message of box
     * @param title   title of box
     */
    public static void infoBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);

    }


    /**
     * This method will print (to System.out) the difference
     * in time between a starting and an ending time
     *
     * @param start staring LocalTime
     * @param end   ending LocalTime
     */
    public static void reportTimeDiff(LocalTime start, LocalTime end) {

        end = end.minusHours(start.getHour());
        end = end.minusMinutes(start.getMinute());
        end = end.minusSeconds(start.getSecond());
        end = end.minusNanos(start.getNano());
        System.out.print("Computed in ");
        if (end.getHour() != 0) {
            System.out.print(end.getHour() + " Hours, ");
        }
        if (end.getMinute() != 0) {
            System.out.print(end.getMinute() + " Minutes, ");
        }
        if (end.getSecond() != 0 || end.getNano() != 0) {
            int nanos = (int) (end.getNano() / pow(10, 4));
            System.out.print(end.getSecond() + "." + nanos + " Seconds");
        } else {
            System.out.print("less than 0.001 second");
        }
    }

    /**
     * This will return the time difference between a starting and ending time
     *
     * @param start starting LocalTime
     * @param end   ending LocalTime
     * @return LocalTime containing the difference in time
     */
    @Deprecated
    public static LocalTime getTimeDiff(LocalTime start, LocalTime end) {
        return null;
    }

    /**
     * Reports the difference between two LocalTimes
     * reports total difference in one unit of time
     *
     * @param start starting time
     * @param end   ending time
     * @param type  unit of time reported
     */
    public static void repDiff(LocalTime start, LocalTime end, byte type) {
        switch (type) {
            case 0:
                //Hours
                break;
            case 1:
                long diff = Duration.between(start, end).get(ChronoUnit.MINUTES);
                break;
            case 2:
                //seconds
                break;
            default:
                break;
        }
    }
}
