package com.example.screentimetracker.util;

/**
 * Manages verification of the hardcoded Admin page password.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/screentimetracker/util/AdminPasswordPrefs;", "", "()V", "HARDCODED_ADMIN_PASSWORD", "", "hasPassword", "", "context", "Landroid/content/Context;", "verifyPassword", "input", "app_debug"})
public final class AdminPasswordPrefs {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HARDCODED_ADMIN_PASSWORD = "password420";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.screentimetracker.util.AdminPasswordPrefs INSTANCE = null;
    
    private AdminPasswordPrefs() {
        super();
    }
    
    public final boolean hasPassword(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean verifyPassword(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String input) {
        return false;
    }
}