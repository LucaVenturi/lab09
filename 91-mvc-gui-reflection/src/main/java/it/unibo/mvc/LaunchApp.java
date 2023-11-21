package it.unibo.mvc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws SecurityException
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */

    public static void main(final String... args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        // app.addView(new DrawNumberSwingView());
        // app.addView(new DrawNumberSwingView());
        // app.addView(new DrawNumberStdoutView());
        for (String viewType : List.of("Stdout", "Swing")) {
            final Class<?> viewClass = Class.forName("it.unibo.mvc.view.DrawNumber"  + viewType + "View");
            for (int i = 0; i < 3; i++) {
                final DrawNumberView view = (DrawNumberView) viewClass.getConstructor().newInstance();
                app.addView(view);
            }
        }

    }
}
