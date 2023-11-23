package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

import javax.swing.JFrame;

public class DrawNumberOutputView implements DrawNumberView {

    private static final String FRAME_NAME = "Printer Frame";
    private static final String NEW_GAME = ": a new game starts!";

    private DrawNumberController controller;
    private final JFrame frame = new JFrame(FRAME_NAME);

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
        this.frame.setVisible(true);
    }

    @Override
    public void result(DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW -> System.out.println(res.getDescription());
            case YOU_WON, YOU_LOST -> System.out.println(res.getDescription() + NEW_GAME);
        }
    }

}
