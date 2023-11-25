package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile = new File(System.getProperty("user.home") + File.separator + "output.txt");

    public void setFile(File file) {
        currentFile = Objects.requireNonNull(file);
    }

    public File getFile() {
        return currentFile;
    }

    public String getPath() {
        return currentFile.getAbsolutePath();
    }

    public void printOnFile(final String input) throws IOException {
        Files.write(currentFile.toPath(), Objects.requireNonNull(input).getBytes(StandardCharsets.UTF_8));
    }
}