package com.example.utils;

import java.util.Collection;
import java.util.List;
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
    public static String join(Collection<?> values, String delimiter) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(delimiter == null ? "" : delimiter);
        for (Object v : values) {
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
    public static String join(Object[] values, String delimiter) {
        if (values == null || values.length == 0) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(delimiter == null ? "" : delimiter);
        for (Object v : values) {
            if (v != null) {
                joiner.add(v.toString());
            }
        }
        return joiner.toString();
    }

    /**
     * Joins a CharSequence array with a delimiter and option to skip nulls.
     *
     * Behavior:
     * - returns "" for null or empty array
     * - when skipNulls == true: null elements are omitted
     * - when skipNulls == false: null elements are represented by the literal "null"
     *
     * Note: delimiter may be null; null delimiter is treated as empty string.
     */
    public static String join(CharSequence[] values, CharSequence delimiter, boolean skipNulls) {
        if (values == null || values.length == 0) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(delimiter == null ? "" : delimiter.toString());
        for (CharSequence v : values) {
            if (v == null) {
                if (!skipNulls) {
                    joiner.add("null");
                }
            } else {
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

    /**
     * Sanitize a collection of strings:
     * - null collection -> empty list
     * - each element is trimmed; null becomes empty string
     * - if removeBlank is true, elements that are blank after trimming are removed
     *
     * Returns an immutable List.
     */
    public static List<String> sanitizeList(Collection<String> values, boolean removeBlank) {
        if (values == null || values.isEmpty()) {
            return List.of();
        }
        return values.stream()
                .map(v -> v == null ? "" : v.trim())
                .filter(s -> !removeBlank || !s.isBlank())
                .toList();
    }
}