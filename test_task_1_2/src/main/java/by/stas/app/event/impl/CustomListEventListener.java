package by.stas.app.event.impl;

import by.stas.app.event.Event;
import by.stas.app.event.EventListener;

public class CustomListEventListener implements EventListener {

    @Override
    public void eventPerformed(Event event) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Action ")
                .append(event.getActionType())
                .append(" performed to the ")
                .append(event.getObject())
                .append(" object.");
        System.out.println(stringBuilder);
    }
}
