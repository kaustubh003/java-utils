package com.example.utils;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeUtilsTest {

    @Test
    void formatDuration_shouldFormatDaysHoursMinutesAndSeconds() {
        String result = TimeUtils.formatDuration(Duration.ofDays(1).plusHours(2).plusMinutes(3).plusSeconds(4));
        assertEquals("1d 2h 3m 4s", result);
    }

    @Test
    void formatDuration_shouldFormatWeeksAndDays() {
        // 15 days => 2 weeks + 1 day
        String result = TimeUtils.formatDuration(Duration.ofDays(15));
        assertEquals("2w 1d", result);
    }

    @Test
    void formatDuration_shouldFormatHoursMinutesAndSeconds() {
        String result = TimeUtils.formatDuration(Duration.ofHours(1).plusMinutes(2).plusSeconds(3));
        assertEquals("1h 2m 3s", result);
    }

    @Test
    void formatDuration_shouldFormatMinutesAndSeconds() {
        String result = TimeUtils.formatDuration(Duration.ofMinutes(5).plusSeconds(7));
        assertEquals("5m 7s", result);
    }

    @Test
    void formatDuration_shouldHandleSecondsOnly() {
        String result = TimeUtils.formatDuration(Duration.ofSeconds(45));
        assertEquals("45s", result);
    }

    @Test
    void formatDuration_shouldHandleZeroDuration() {
        assertEquals("0s", TimeUtils.formatDuration(Duration.ZERO));
    }

    @Test
    void formatDuration_shouldHandleNull() {
        assertEquals("0s", TimeUtils.formatDuration(null));
    }

    @Test
    void formatDuration_shouldHandleNegativeDurations() {
        // -1 hour, -1 minute, -1 second -> "-1h 1m 1s"
        String result = TimeUtils.formatDuration(Duration.ofSeconds(-3600 - 60 - 1));
        assertEquals("-1h 1m 1s", result);
    }
}