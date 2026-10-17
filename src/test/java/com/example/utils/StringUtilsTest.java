package com.example.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void trimToEmpty_shouldReturnEmptyForNull() {
        assertEquals("", StringUtils.trimToEmpty(null));
    }

    @Test
    void trimToEmpty_shouldTrimWhitespace() {
        assertEquals("hello", StringUtils.trimToEmpty("   hello   "));
    }

    @Test
    void defaultIfBlank_shouldReturnDefaultForBlankStrings() {
        assertEquals("default", StringUtils.defaultIfBlank("   ", "default"));
        assertEquals("default", StringUtils.defaultIfBlank("", "default"));
        assertEquals("default", StringUtils.defaultIfBlank(null, "default"));
    }

    @Test
    void join_shouldJoinCollectionWithDelimiter() {
        String result = StringUtils.join(List.of("Java", "Spring", "Junit"), ", ");
        assertEquals("Java, Spring, Junit", result);
    }

    @Test
    void join_shouldIgnoreNullValues() {
        String result = StringUtils.join(List.of("Java", null, "Spring"), ", ");
        assertEquals("Java, Spring", result);
    }

    @Test
    void joinArray_shouldJoinWithDelimiter() {
        String result = StringUtils.join(new String[]{"Java", "Maven", "Git"}, " | ");
        assertEquals("Java | Maven | Git", result);
    }
}
