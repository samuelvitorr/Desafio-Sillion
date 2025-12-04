package com.exam;

import com.exam.service.TextCounterService;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TextCounterServiceTest {

    TextCounterService service = new TextCounterService();

    @Test
    void testCountPhrase() {
        String content = "hello world hello world hello planet";
        assertEquals(2, service.countPhrase(content, "hello world"));
    }

    @Test
    void testCountWords() {
        String content = "blocos de pedra blocos de pedra pedra";
        String[] words = { "blocos", "de", "pedra" };

        Map<String, Integer> result = service.countWords(content, words);

        assertEquals(2, result.get("blocos"));
        assertEquals(2, result.get("de"));
        assertEquals(3, result.get("pedra"));
    }
}
