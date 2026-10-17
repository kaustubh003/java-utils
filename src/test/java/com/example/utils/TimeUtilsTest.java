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
    void formatDuration_shouldHandleZeroDuration() {
        assertEquals("0s", TimeUtils.formatDuration(Duration.ZERO));
    }

    @Test
    void formatDuration_shouldHandleNull() {
        assertEquals("0s", TimeUtils.formatDuration(null));
    }
}