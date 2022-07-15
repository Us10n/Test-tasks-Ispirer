package by.stas.app.event;

public class Event {
    private String actionType;
    private Object object;

    public Event(String actionType, Object object) {
        this.actionType = actionType;
        this.object = object;
    }

    public String getActionType() {
        return actionType;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (actionType != null ? !actionType.equals(event.actionType) : event.actionType != null) return false;
        return object != null ? object.equals(event.object) : event.object == null;
    }

    @Override
    public int hashCode() {
        int result = actionType != null ? actionType.hashCode() : 0;
        result = 31 * result + (object != null ? object.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("actionType='").append(actionType).append('\'');
        sb.append(", object=").append(object);
        sb.append('}');
        return sb.toString();
    }
}
