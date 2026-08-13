package com.example.screentimetracker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/screentimetracker/ui/AdminViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allSessions", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/screentimetracker/data/SessionEntity;", "getAllSessions", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/example/screentimetracker/data/SessionRepository;", "logSession", "", "session", "app_debug"})
public final class AdminViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.screentimetracker.data.SessionRepository repository = null;
    
    /**
     * All completed sessions, newest first -- the fail-safe permanent history.
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.screentimetracker.data.SessionEntity>> allSessions = null;
    
    public AdminViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    /**
     * All completed sessions, newest first -- the fail-safe permanent history.
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.screentimetracker.data.SessionEntity>> getAllSessions() {
        return null;
    }
    
    public final void logSession(@org.jetbrains.annotations.NotNull()
    com.example.screentimetracker.data.SessionEntity session) {
    }
}