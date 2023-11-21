package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_PATH = HOME + SEPARATOR + "output.txt";
    private File currentFile;

    public Controller() {
        this.currentFile = new File(DEFAULT_PATH);
    }

    public void setFile(File file) {
        Objects.requireNonNull(file);
        this.currentFile = file;
    }

    public File getFile() {
        return this.currentFile;
    }

    public String getPath() {
        return this.currentFile.getPath();
    }

    public void writeOnFile(String line) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.println(line);
        }
    }

}
