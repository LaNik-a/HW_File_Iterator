package ru.hse.homework;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileIteratorTest {
    String path = "./src/main/resources/testIterator";
    FileIterator it = new FileIterator(path);

    FileIteratorTest() throws Exception {
    }

    @org.junit.jupiter.api.Test
    void hasNext() {
        assertTrue(it.hasNext());
        it.next();
        it.next();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @org.junit.jupiter.api.Test
    void next() {
        assertEquals("Hi", it.next());
        assertEquals("How are you", it.next());
        assertEquals("I'm tired", it.next());
        assertEquals("By", it.next());
        assertNull(it.next());
    }



    @org.junit.jupiter.api.Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FileIterator("ds");
        });
    }


}