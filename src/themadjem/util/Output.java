package themadjem.util;

import javax.swing.*;

/**
 * A collection of methods used to give information to the user
 * @author themadjem
 *         Copyright 4/8/2017.
 */
public class Output {
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


}
