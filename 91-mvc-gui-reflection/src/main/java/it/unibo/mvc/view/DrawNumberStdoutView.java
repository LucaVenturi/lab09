package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdoutView implements DrawNumberView{

    @Override
    public void setController(DrawNumberController observer) {
        //This DrawNumberView is output only.
    }

    @Override
    public void start() {
        //This DrawNumberView is always ready.
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }
    
}
