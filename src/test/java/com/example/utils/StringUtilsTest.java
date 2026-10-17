package com.example.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void trimToEmpty_shouldHandleUnicodeWhitespace() {
        // Java's trim removes control characters <= ' ', this test documents expected behavior
        String input = "\u2003hello\u2003"; // em space around the word
        assertEquals("\u2003hello\u2003".trim(), StringUtils.trimToEmpty(input)); // evidence of current behavior
    }

    @Test
    void defaultIfBlank_shouldReturnDefaultForBlankStrings() {
        assertEquals("fallback", StringUtils.defaultIfBlank("   ", "fallback"));
        assertEquals("fallback", StringUtils.defaultIfBlank("", "fallback"));
        assertEquals("fallback", StringUtils.defaultIfBlank(null, "fallback"));
    }

    @Test
    void join_shouldJoinCollectionWithDelimiter() {
        String result = StringUtils.join(List.of("Java", "Spring", "Junit"), ", ");
        assertEquals("Java, Spring, Junit", result);
    }

    @Test
    void join_shouldIgnoreNullValues() {
        List<String> values = new ArrayList<>();
        values.add("Java");
        values.add(null);
        values.add("Spring");
        String result = StringUtils.join(values, ", ");
        assertEquals("Java, Spring", result);
    }

    @Test
    void joinArray_shouldJoinWithDelimiter() {
        String result = StringUtils.join(new String[]{"Java", "Maven", "Git"}, " | ");
        assertEquals("Java | Maven | Git", result);
    }

    @Test
    void sanitizeList_shouldTrimAndRemoveBlank() {
        List<String> in = new ArrayList<>();
        in.add("  a  ");
        in.add(null);
        in.add("   ");
        in.add("b");
        List<String> out = StringUtils.sanitizeList(in, true);
        assertEquals(List.of("a", "b"), out);
    }

    @Test
    void sanitizeList_shouldKeepEmptyWhenRequested() {
        List<String> in = new ArrayList<>();
        in.add("  a  ");
        in.add(null);
        in.add("   ");
        in.add("b");
        List<String> out = StringUtils.sanitizeList(in, false);
        assertEquals(List.of("a", "", "", "b"), out);
    }

    @Test
    void joinCharSequenceArray_skipNulls() {
        String[] arr = new String[]{"a", null, "b"};
        String result = StringUtils.join(arr, ",", true);
        assertEquals("a,b", result);
    }

    @Test
    void joinCharSequenceArray_includeNulls() {
        String[] arr = new String[]{"a", null, "b"};
        String result = StringUtils.join(arr, ",", false);
        assertEquals("a,null,b", result);
    }
}