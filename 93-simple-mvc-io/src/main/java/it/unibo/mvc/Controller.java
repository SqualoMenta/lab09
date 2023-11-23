package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private Optional<File> currentFile;

    public void setFile(File file) {
        currentFile = Optional.of(file);
    }

    public File getFile() {
        return currentFile.get();
    }

    public String getPath() {
        return currentFile.get().getAbsolutePath();
    }

    public void printOnFile(final String input) {
        try {
            Files.write(currentFile.get().toPath(), Objects.requireNonNull(input).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            
        }
    }
}