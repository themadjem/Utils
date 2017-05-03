package themadjem.util;

import com.sun.istack.internal.Nullable;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author themadjem
 *         Copyright 4/13/2017.
 */
public class Reader {
    private BufferedReader br;
    private String filePath;
    private boolean isNotOpen = true;

    /**
     * Constructor for the writer
     *
     * @param path filepath to the file to be written
     *             A null value with write to a created
     *             file in the program's directory
     *             "file.txt"
     */
    public Reader(@Nullable String path) {
        if (validPath(path))
            open();
        else
            throw new RuntimeException("Invalid Path");
    }

    public String readln() {
        String temp;
        try {
            temp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            temp = null;
        }

        return temp;
    }


    /**
     * Creates a new buffered reader of the
     * filePath
     *
     * @implNote Must have filePath and appendFile pre-defined
     */
    private void open() {
        try {
            br = new BufferedReader(new java.io.FileReader(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        isNotOpen = false;
    }

    /**
     * Checks the filePath to make sure it is not null
     * or empty. If it is , it is set to "file.txt"
     */
    private boolean validPath(String path) {
        if (path == null || path.isEmpty()) {
            path = "file.txt";
        } else {
            int index = -1;
            for (int i = path.length(); i >= 0; i++) {
                if (path.charAt(i) == '.') {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the writer has a file open
     *
     * @return true if open
     */
    public boolean isOpen() {
        return !isNotOpen;
    }

    /**
     * Checks if the writer has a file open
     *
     * @return true if not open
     */
    public boolean isClosed() {
        return isNotOpen;
    }

    /**
     * closes and removes access to the file the file
     */
    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
