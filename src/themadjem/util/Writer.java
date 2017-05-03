package themadjem.util;

import com.sun.istack.internal.Nullable;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * This class is a collection of functions for writing text to files
 *
 * @author themadjem
 *         Copyright 4/8/2017.
 */
public class Writer {
    private BufferedWriter bw;
    private String filePath;
    private boolean isAppending;
    private boolean isFirstOpen;
    private boolean isNotOpen = true;

    /**
     * Constructor for the writer
     *
     * @param path       filepath to the file to be written
     *                   A null value with write to a created
     *                   file in the program's directory
     *                   "file.txt"
     * @param appendFile whether or not to append/overwrite the file
     */
    public Writer(@Nullable String path, boolean appendFile) {
        //TODO: create test to see if a file has extension
        checkPath();
        isAppending = appendFile;
        filePath = path;
        isFirstOpen = true;
        open();
    }

    /**
     * Constructor for the writer that appends
     *
     * @param path destination file
     */
    public Writer(String path) {
        this(path, true);
    }

    /**
     * Constructor that takes in a destination folder,
     * a file name and a file extension
     *
     * @param folder   destination
     * @param fileName name of file
     * @param ext      extension of file
     */
    public Writer(String folder, String fileName, String ext) {
        this(folder + fileName + ext, true);
    }

    public void setAppending(boolean appending) {
        isAppending = appending;
    }

    /**
     * Creates a new buffered writer of the
     * filePath and isAppending variables
     * <p>
     * Closes already open files
     * <p>
     *
     * @implNote Must have filePath and appendFile pre-defined
     */
    private void open() {
        checkPath();
        if (!isFirstOpen) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bw = new BufferedWriter(new java.io.FileWriter(filePath, isAppending));
        } catch (Exception e) {
            e.printStackTrace();
        }
        isFirstOpen = false;
        isNotOpen = false;
    }

    /**
     * Checks the filePath to make sure it is not null
     * or empty. If it is , it is set to "file.txt"
     */
    private void checkPath() {
        if (filePath == null || filePath.isEmpty()) {
            filePath = "file.txt";
        }
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
     * Writes a given vararg of Objects and creates a
     * new line after each Object.toString().
     *
     * @param strings strings of text to bw written
     */
    public void writeln(Object... strings) {
        if (isClosed()) throwFileError();
        for (Object s : strings) {
            try {
                bw.write(s.toString());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes given object's toString() values to the file
     *
     * @param strings strings of text to bw written
     */
    public void write(Object... strings) {
        if (isClosed()) throwFileError();
        for (Object s : strings) {
            try {
                bw.write(s.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Inserts a carriage return to the end of a file
     * if the Writer is appending the file;
     */
    public void newLine() {
        if (!isAppending) return;
        try {
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves any changes to the file the file
     */
    public void save() {
        try {
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void throwFileError() {
        throw new RuntimeException("No file open");
    }

}
