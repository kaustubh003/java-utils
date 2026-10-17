package com.example.utils;

import java.util.Collection;
import java.util.Objects;
import java.util.StringJoiner;

public final class StringUtils {

    private StringUtils() {
        throw new AssertionError("Utility class");
    }

    /**
     * Returns an empty string when the input is null, otherwise returns trimmed string.
     */
    public static String trimToEmpty(String value) {
        return value == null ? "" : value.trim();
    }

    /**
     * Returns defaultValue when the input is null or blank (after trimming).
     */
    public static String defaultIfBlank(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Joins a collection of values using the provided delimiter.
     * Null collection -> empty string.
     * Null elements are skipped.
     */
    public static String join(Collection<String> values, String delimiter) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(delimiter == null ? "" : delimiter);
        for (String v : values) {
            if (v != null) {
                joiner.add(v.toString());
            }
        }
        return joiner.toString();
    }

    /**
     * Joins an array of values using the provided delimiter.
     * Null array -> empty string.
     * Null elements are skipped.
     */
    public static String join(String[] values, String delimiter) {
        if (values == null || values.length == 0) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(delimiter == null ? "" : delimiter);
        for (String v : values) {
            if (v != null) {
                joiner.add(v.toString());
            }
        }
        return joiner.toString();
    }

    /**
     * True when null or trimmed string is empty.
     */
    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Sanitize string to non-null trimmed value.
     */
    public static String sanitize(String value) {
        return value == null ? "" : value.trim();
    }
}

