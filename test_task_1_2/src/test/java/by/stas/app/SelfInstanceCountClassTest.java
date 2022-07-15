package by.stas.app;

import by.stas.app.entity.SelfInstanceCountClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SelfInstanceCountClassTest {

    @Test
    void testCounter() {
        List<SelfInstanceCountClass> countClassList = new ArrayList<>();
        for (int i = 0; i < 12; ++i) {
            countClassList.add(new SelfInstanceCountClass());
        }

        long expected = 12;
        long actual = SelfInstanceCountClass.getInstanceAmount();
        Assertions.assertEquals(expected, actual);
    }
}