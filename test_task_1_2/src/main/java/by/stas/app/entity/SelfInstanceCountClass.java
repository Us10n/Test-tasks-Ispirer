package by.stas.app.entity;

public class SelfInstanceCountClass {
    static long instanceAmount;

    public SelfInstanceCountClass() {
        ++instanceAmount;
    }

    public static long getInstanceAmount() {
        return instanceAmount;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        --instanceAmount;
    }
}
