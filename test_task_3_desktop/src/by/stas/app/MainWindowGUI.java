package by.stas.app;

import by.stas.app.entity.LanguageEnum;

import javax.swing.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindowGUI extends JFrame {

    private static final String LABEL_TEXT_KEY = "label.text";
    private static final String BUTTON_TEXT_KEY = "button.text";
    private static final String LANG_BUNDLE = "lang";

    private JPanel mainPanel;
    private JButton button;
    private JComboBox langBox;
    private JLabel wordLabel;

    private Locale currentLocale = Locale.getDefault();

    public MainWindowGUI(String title) {
        super(title);

        //config elements
        configureWindow();
        configureLangComboBox();

        //set elements text
        button.setText(getStringFromResources(BUTTON_TEXT_KEY, currentLocale));
        wordLabel.setText(getStringFromResources(LABEL_TEXT_KEY, currentLocale));

        //action listeners
        button.addActionListener(e -> {
            String text = getStringFromResources(LABEL_TEXT_KEY, currentLocale);
            wordLabel.setText(text);
        });
        langBox.addActionListener(e -> {
            String selectedString = langBox.getSelectedItem().toString();
            LanguageEnum selectedItem = LanguageEnum.getComboItemByValue(selectedString);
            switch (selectedItem) {
                case ENGLISH:
                    currentLocale = Locale.US;
                    break;
                case RUSSIAN:
                    currentLocale = new Locale("ru", "RU");
                    break;
            }
            String text = getStringFromResources(BUTTON_TEXT_KEY, currentLocale);
            button.setText(text);
        });
    }

    private String getStringFromResources(String key, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(LANG_BUNDLE, locale);
        return resourceBundle.getString(key);
    }

    private void configureWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(500, 500);
    }

    private void configureLangComboBox() {
        Object[] langs = Arrays.stream(LanguageEnum.values()).map(LanguageEnum::getValue).toArray();
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(langs);
        langBox.setModel(model);
    }
}
