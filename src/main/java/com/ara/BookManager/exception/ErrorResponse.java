package com.ara.BookManager.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private int customCode;          // کد خطای اختصاصی شما
    private Map<String, Object> details;  // ← فیلدهای اضافی (اختیاری)

    // سازنده کامل
    public ErrorResponse(String timestamp, int status, String error,
                         String message, String path, int customCode,
                         Map<String, Object> details) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.customCode = customCode;
        this.details = details != null ? details : new HashMap<>();
    }

    // Getterها (برای JSON)
    public String getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
    public int getCustomCode() { return customCode; }
    public Map<String, Object> getDetails() { return details; }
}
