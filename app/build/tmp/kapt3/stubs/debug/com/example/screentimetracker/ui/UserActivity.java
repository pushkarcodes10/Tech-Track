package com.example.screentimetracker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/screentimetracker/ui/UserActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "awaitingUsageAccessResult", "", "binding", "Lcom/example/screentimetracker/databinding/ActivityUserBinding;", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "checkUsageAccessAndStart", "", "ensureNotificationPermissionThenStart", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStartTrackingClicked", "refreshActiveSessionState", "refreshPermissionStatusLabel", "startTrackingSession", "app_debug"})
public final class UserActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.screentimetracker.databinding.ActivityUserBinding binding;
    
    /**
     * True while we've sent the user to system Settings and are waiting
     * for them to come back with Usage Access granted.
     */
    private boolean awaitingUsageAccessResult = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> notificationPermissionLauncher = null;
    
    public UserActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void refreshPermissionStatusLabel() {
    }
    
    private final void refreshActiveSessionState() {
    }
    
    private final void onStartTrackingClicked() {
    }
    
    private final void ensureNotificationPermissionThenStart() {
    }
    
    private final void checkUsageAccessAndStart() {
    }
    
    private final void startTrackingSession() {
    }
}