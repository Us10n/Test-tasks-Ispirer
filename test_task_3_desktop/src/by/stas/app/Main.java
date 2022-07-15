package by.stas.app;

import javax.swing.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        JFrame frame = new MainWindowGUI("App");
        frame.setVisible(true);
    }
}
