package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    void setString(String i);

    String getString();

    List<String> getHistory();

    void print();
}
