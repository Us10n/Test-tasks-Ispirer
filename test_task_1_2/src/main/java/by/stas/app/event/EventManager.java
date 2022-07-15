package by.stas.app.event;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<EventListener> subscribers = new ArrayList<>();

    public void subscribe(EventListener listener) {
        subscribers.add(listener);
    }

    public void unsubscribe(EventListener listener) {
        subscribers.remove(listener);
    }

    public void notifyAll(Event event) {
        subscribers.forEach(sub -> sub.eventPerformed(event));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventManager that = (EventManager) o;

        return subscribers != null ? subscribers.equals(that.subscribers) : that.subscribers == null;
    }

    @Override
    public int hashCode() {
        return subscribers != null ? subscribers.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventManager{");
        sb.append("subscribers=").append(subscribers);
        sb.append('}');
        return sb.toString();
    }
}
