package com.example.utils;

import java.time.Duration;

public final class TimeUtils {

    private TimeUtils() {
        throw new AssertionError("Utility class");
    }

    /**
     * Format a Duration into a compact human-readable string.
     * <p>
     * Examples:
     * - Duration.ofDays(1).plusHours(2).plusMinutes(3).plusSeconds(4) -> "1d 2h 3m 4s"
     * - Duration.ofDays(15) -> "2w 1d"
     * - Duration.ofHours(1).plusMinutes(2).plusSeconds(3) -> "1h 2m 3s"
     * - Duration.ofSeconds(45) -> "45s"
     * - Duration.ZERO or null -> "0s"
     * - Negative durations are prefixed by "-" (e.g., "-1h 1m 1s").
     */
    public static String formatDuration(Duration duration) {
        if (duration == null) {
            return "0s";
        }

        // Normalize sign using Duration APIs to avoid pitfalls with seconds/nanos combinations
        boolean negative = duration.isNegative();
        Duration abs = negative ? duration.negated() : duration;

        long totalSeconds = Math.max(0, abs.getSeconds());

        long weeks = totalSeconds / 604_800; // 7 * 24 * 3600
        long days = (totalSeconds % 604_800) / 86_400;
        long hours = (totalSeconds % 86_400) / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        StringBuilder sb = new StringBuilder();

        if (weeks > 0) {
            sb.append(weeks).append("w");
            if (days > 0 || hours > 0 || minutes > 0 || seconds > 0) sb.append(" ");
        }

        if (days > 0) {
            sb.append(days).append("d");
            if (hours > 0 || minutes > 0 || seconds > 0) sb.append(" ");
        }

        if (hours > 0) {
            sb.append(hours).append("h");
            if (minutes > 0 || seconds > 0) sb.append(" ");
        }

        if (minutes > 0) {
            sb.append(minutes).append("m");
            if (seconds > 0) sb.append(" ");
        }

        if (seconds > 0 || sb.length() == 0) {
            sb.append(seconds).append("s");
        }

        String result = sb.toString();
        return negative ? "-" + result : result;
    }
}