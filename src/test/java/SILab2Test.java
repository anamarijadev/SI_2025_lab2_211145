import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private List<Item> createList(Item item) {
        return new ArrayList<>(Collections.singletonList(item));
    }

    @Test
    void everyStatementTest(){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item(null, 1, 100, 0)), "1234567890123456"));
        assertTrue(ex.getMessage().contains("Invalid item!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item("apple", 1, 100, 0)), null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(new Item("apple", 1, 100, 0)), "123456789012345a"));
        assertTrue(ex.getMessage().contains("Invalid character in card number!"));

        assertEquals(-930.0, SILab2.checkCart(createList(new Item("apple", 1, 100, 10)), "1234567890123456"));
    }

    @Test
    void multipleConditionsTest(){
        assertEquals(5470.0, SILab2.checkCart(createList(new Item("apple", 11, 500, 0)), "1234567890123456"));

        assertEquals(-18030.0, SILab2.checkCart(createList(new Item("apple", 10, 200, 10)), "1234567890123456"));

        assertEquals(1970.0, SILab2.checkCart(createList(new Item("apple", 20, 100, 0)), "1234567890123456"));

        assertEquals(0.0, SILab2.checkCart(createList(new Item("apple", 0, 0, 0)), "1234567890123456"));
    }
}
