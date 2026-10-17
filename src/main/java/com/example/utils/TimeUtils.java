package com.example.utils;

import java.time.Duration;

public final class TimeUtils {

    private TimeUtils() {
        throw new AssertionError("Utility class");
    }

    /**
     * Format a Duration into a compact human-readable string: "1h 2m 3s".
     * Null or zero duration -> "0s".
     */
    public static String formatDuration(Duration duration) {
        if (duration == null) {
            return "0s";
        }

        long seconds = Math.max(0, duration.getSeconds());

        long days = seconds / 86400;
        long hours = (seconds % 86400) / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;

        StringBuilder result = new StringBuilder();

        if (days > 0) {
            result.append(days).append("d");
            if (hours > 0 || minutes > 0 || remainingSeconds > 0) {
                result.append(" ");
            }
        }

        if (hours > 0) {
            result.append(hours).append("h");
            if (minutes > 0 || remainingSeconds > 0) {
                result.append(" ");
            }
        }

        if (minutes > 0) {
            result.append(minutes).append("m");
            if (remainingSeconds > 0) {
                result.append(" ");
            }
        }

        if (remainingSeconds > 0 || (days == 0 && hours == 0 && minutes == 0)) {
            result.append(remainingSeconds).append("s");
        }

        return result.toString();
    }
}