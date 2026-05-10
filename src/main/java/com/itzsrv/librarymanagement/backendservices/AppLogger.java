package com.itzsrv.librarymanagement.backendservices;

public interface AppLogger {
    void info(String message);
    void info(String message, Object... args);

    void warn(String message);
    void warn(String message, Object... args);

    void error(String message);
    void error(String message, Throwable throwable);
}
