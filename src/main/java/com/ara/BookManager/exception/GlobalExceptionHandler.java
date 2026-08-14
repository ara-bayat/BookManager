package com.ara.BookManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse buildErrorResponse(Exception ex, HttpStatus status,
                                             int customCode, Map<String, Object> details,
                                             WebRequest request) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String path = request.getDescription(false).replace("uri=", "");

        return new ErrorResponse(
                timestamp,
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),   // پیام پویا از Exception
                path,
                customCode,
                details
        );
    }

    // ----- مدیریت BookNotFound -----
    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFound ex, WebRequest request) {
        Map<String, Object> details = new HashMap<>();
        details.put("bookId", ex.getBookId());  // پارامتر اضافی
        // (اختیاری) می‌توانید URL راهنما هم اضافه کنید
        details.put("helpUrl", "https://docs.example.com/errors/1001");

        ErrorResponse errorResponse = buildErrorResponse(
                ex,
                HttpStatus.NOT_FOUND,
                1001,   // کد خطای اختصاصی برای BookNotFound
                details,
                request
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}