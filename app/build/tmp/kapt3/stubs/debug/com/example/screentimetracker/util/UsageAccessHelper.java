package com.example.screentimetracker.util;

/**
 * Handles the "Usage Access" special permission
 * (android.permission.PACKAGE_USAGE_STATS).
 *
 * This cannot be requested via the normal runtime permission dialog --
 * the user must grant it manually from Settings, so we check via
 * AppOpsManager and, if missing, deep-link into the system settings
 * screen for it.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/example/screentimetracker/util/UsageAccessHelper;", "", "()V", "hasUsageAccess", "", "context", "Landroid/content/Context;", "openUsageAccessSettings", "", "app_debug"})
public final class UsageAccessHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.screentimetracker.util.UsageAccessHelper INSTANCE = null;
    
    private UsageAccessHelper() {
        super();
    }
    
    public final boolean hasUsageAccess(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Opens the system "Usage Access" settings screen so the user can
     * grant this app permission. Tries to deep-link directly to this
     * app's entry; falls back to the general list if unsupported.
     */
    public final void openUsageAccessSettings(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}