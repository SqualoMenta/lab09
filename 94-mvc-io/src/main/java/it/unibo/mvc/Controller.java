package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    public void setString(String i); 

    public String getString();

    public List<String> getHistory();
    
    public void print();
}
