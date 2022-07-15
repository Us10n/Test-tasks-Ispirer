package by.stas.app.list.impl;

import by.stas.app.event.Event;
import by.stas.app.event.EventListener;
import by.stas.app.event.EventManager;
import by.stas.app.list.CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomListImpl<T> implements CustomList<T> {

    private static final String ACTION_ADD = "ACTION_ADD";

    private final List<T> objects;
    private final EventManager eventManager;

    public CustomListImpl() {
        objects = new ArrayList<>();
        eventManager = new EventManager();
    }

    @Override
    public void add(T object) {
        objects.add(object);
        Event event = new Event(ACTION_ADD, this);
        eventManager.notifyAll(event);
    }

    @Override
    public T get(int index) {
        return objects.get(index);
    }

    @Override
    public int size() {
        return objects.size();
    }

    public void subscribe(EventListener listener) {
        eventManager.subscribe(listener);
    }

    public void unsubscribe(EventListener listener) {
        eventManager.unsubscribe(listener);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomListImpl<?> that = (CustomListImpl<?>) o;

        if (objects != null ? !objects.equals(that.objects) : that.objects != null) return false;
        return eventManager != null ? eventManager.equals(that.eventManager) : that.eventManager == null;
    }

    @Override
    public int hashCode() {
        int result = objects != null ? objects.hashCode() : 0;
        result = 31 * result + (eventManager != null ? eventManager.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomListImpl{");
        sb.append("objects=").append(objects);
        sb.append(", eventManager=").append(eventManager);
        sb.append('}');
        return sb.toString();
    }
}
