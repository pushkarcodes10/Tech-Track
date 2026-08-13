package com.example.screentimetracker.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/example/screentimetracker/util/TimeFormatter;", "", "()V", "formatForFileName", "", "millis", "", "formatHms", "durationMillis", "formatTimestamp", "app_debug"})
public final class TimeFormatter {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.screentimetracker.util.TimeFormatter INSTANCE = null;
    
    private TimeFormatter() {
        super();
    }
    
    /**
     * Formats a duration in milliseconds as HH:mm:ss. Hours are not
     * capped at 24 so multi-hour/day sessions still display correctly
     * (e.g. 30 hours -> "30:00:00").
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatHms(long durationMillis) {
        return null;
    }
    
    /**
     * Human-readable date/time for the history list, e.g. "12 Aug 2026, 14:05".
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatTimestamp(long millis) {
        return null;
    }
    
    /**
     * File-name-safe timestamp, e.g. "20260812_140512".
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatForFileName(long millis) {
        return null;
    }
}