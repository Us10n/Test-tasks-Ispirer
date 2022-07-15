package by.stas.app;

import by.stas.app.list.CustomList;
import by.stas.app.list.impl.CustomListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomListImplTest {

    private CustomList<Long> customList;

    @BeforeAll
    void setUp() {
        customList = new CustomListImpl<>();
    }

    @Test
    void add() {
        int before = customList.size();
        customList.add(1L);
        int after = customList.size();
        Assertions.assertEquals(before + 1, after);
    }

    @Test
    void get() {
        customList.add(323L);
        Long number = customList.get(customList.size() - 1);
        Assertions.assertEquals(323L, number);
    }

    @Test
    void size(){
        int before = customList.size();
        customList.add(1L);
        int after = customList.size();
        Assertions.assertEquals(before + 1, after);
    }
}