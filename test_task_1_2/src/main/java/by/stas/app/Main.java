package by.stas.app;

import by.stas.app.event.EventListener;
import by.stas.app.event.impl.CustomListEventListener;
import by.stas.app.list.CustomList;
import by.stas.app.list.impl.CustomListImpl;

public class Main {
    public static void main(String[] args) {
        //SelfInstanceCountClass work demonstration


        //Custom list work demonstration
        CustomList<Long> customList = new CustomListImpl<>();
        EventListener listener = new CustomListEventListener();
        customList.subscribe(listener);

        customList.add(1L);
        customList.add(2L);
        customList.unsubscribe(listener);
        customList.add(3L);
    }
}
