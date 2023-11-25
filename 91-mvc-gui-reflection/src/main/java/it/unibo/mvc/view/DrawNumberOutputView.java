package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;


public class DrawNumberOutputView implements DrawNumberView {

    private static final String FRAME_NAME = "Printer Frame";
    private static final String NEW_GAME = ": a new game starts!";

    @Override
    public void setController(DrawNumberController observer) {
    }

    @Override
    public void start() {
    }

    @Override
    public void result(DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW -> System.out.println(res.getDescription());
            case YOU_WON, YOU_LOST -> System.out.println(res.getDescription() + NEW_GAME);
        }
    }

}
