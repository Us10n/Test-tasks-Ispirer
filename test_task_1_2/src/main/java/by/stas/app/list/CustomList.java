package by.stas.app.list;

import by.stas.app.event.EventListener;

public interface CustomList<T> extends CustomCollection {
    void add(T object);

    T get(int index);

    int size();

    void subscribe(EventListener listener);

    void unsubscribe(EventListener listener);
}
