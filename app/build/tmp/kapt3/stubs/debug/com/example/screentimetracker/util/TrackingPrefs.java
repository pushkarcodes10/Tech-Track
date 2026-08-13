package com.example.screentimetracker.util;

/**
 * Source of truth for active tracking session state and accumulated
 * screen-on time calculation (pausing when screen is off and resuming when on).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004J \u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/screentimetracker/util/TrackingPrefs;", "", "()V", "KEY_ACCUMULATED_TIME", "", "KEY_IS_SCREEN_ON", "KEY_IS_TRACKING", "KEY_LAST_ACTIVE_START_TIME", "KEY_START_TIME", "KEY_USER_NAME", "PREFS_NAME", "endSession", "", "context", "Landroid/content/Context;", "getElapsedTime", "", "getStartTime", "getUserName", "handleScreenOff", "handleScreenOn", "isScreenOn", "", "isTracking", "prefs", "Landroid/content/SharedPreferences;", "saveDraftUserName", "userName", "startSession", "initialScreenOn", "app_debug"})
public final class TrackingPrefs {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "screen_time_tracking_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_TRACKING = "key_is_tracking";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_NAME = "key_user_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_START_TIME = "key_start_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ACCUMULATED_TIME = "key_accumulated_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_ACTIVE_START_TIME = "key_last_active_start_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_SCREEN_ON = "key_is_screen_on";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.screentimetracker.util.TrackingPrefs INSTANCE = null;
    
    private TrackingPrefs() {
        super();
    }
    
    private final android.content.SharedPreferences prefs(android.content.Context context) {
        return null;
    }
    
    public final void startSession(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String userName, boolean initialScreenOn) {
    }
    
    public final void handleScreenOff(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void handleScreenOn(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final long getElapsedTime(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0L;
    }
    
    public final boolean isScreenOn(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void saveDraftUserName(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String userName) {
    }
    
    public final void endSession(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final boolean isTracking(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final long getStartTime(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0L;
    }
}