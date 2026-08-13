package com.example.screentimetracker.util;

/**
 * Generates the per-session report as a CSV file under
 * getExternalFilesDir(DIRECTORY_DOCUMENTS) and prepares secure,
 * shareable Uris for it via FileProvider.
 *
 * CSV (not .xlsx) is used so the report opens natively in Excel /
 * Google Sheets / Numbers with zero extra dependencies. Files are
 * never overwritten or deleted by the app -- each session gets a
 * uniquely timestamped file name, and the Room database (see
 * data/SessionEntity.kt) separately records every file's path so a
 * session can always be re-shared later even after the app restarts.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/screentimetracker/util/CsvExporter;", "", "()V", "FILE_PROVIDER_SUFFIX", "", "buildShareIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "escapeCsv", "value", "exportSessionCsv", "Lcom/example/screentimetracker/util/CsvExporter$ExportResult;", "userName", "screenTimeFormatted", "sessionEndMillis", "", "uriForFile", "file", "Ljava/io/File;", "ExportResult", "app_debug"})
public final class CsvExporter {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILE_PROVIDER_SUFFIX = ".fileprovider";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.screentimetracker.util.CsvExporter INSTANCE = null;
    
    private CsvExporter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.screentimetracker.util.CsvExporter.ExportResult exportSessionCsv(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String screenTimeFormatted, long sessionEndMillis) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri uriForFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    private final java.lang.String escapeCsv(java.lang.String value) {
        return null;
    }
    
    /**
     * Builds a chooser Intent to open/share the report with Excel, Sheets, Drive, Gmail, etc.
     */
    @org.jetbrains.annotations.NotNull()
    public final android.content.Intent buildShareIntent(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/example/screentimetracker/util/CsvExporter$ExportResult;", "", "file", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "(Ljava/io/File;Landroid/net/Uri;)V", "getFile", "()Ljava/io/File;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ExportResult {
        @org.jetbrains.annotations.NotNull()
        private final java.io.File file = null;
        @org.jetbrains.annotations.NotNull()
        private final android.net.Uri uri = null;
        
        public ExportResult(@org.jetbrains.annotations.NotNull()
        java.io.File file, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.io.File getFile() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri getUri() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.io.File component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.screentimetracker.util.CsvExporter.ExportResult copy(@org.jetbrains.annotations.NotNull()
        java.io.File file, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}