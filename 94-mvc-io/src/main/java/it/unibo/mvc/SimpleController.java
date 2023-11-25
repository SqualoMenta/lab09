package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    Optional<String> strToPrint;
    List<String> printedStrings = new ArrayList<>();

    @Override
    public void setString(String i) {
        strToPrint = Optional.of(Objects.requireNonNull(i));
    }

    @Override
    public String getString() {
        return strToPrint.get();
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(printedStrings);
    }

    @Override
    public void print() {
        strToPrint.ifPresentOrElse(str -> {
            System.out.println(str);
            printedStrings.add(str);
        }, () -> {
            throw new IllegalStateException();
        });
    }

}
