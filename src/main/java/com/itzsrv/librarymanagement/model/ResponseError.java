package com.itzsrv.librarymanagement.model;

import org.springframework.http.HttpStatus;

public class ResponseError {

    private HttpStatus code;
    private String userMessage;
    private String systemMessage;

    public ResponseError(HttpStatus code, String userMessage, String systemMessage) {
        this.code = code;
        this.userMessage = userMessage;
        this.systemMessage = systemMessage;
    }

    public ResponseError() {

    }

    @Override
    public String toString() {
        return "ResponseError{" +
                "code='" + code + '\'' +
                ", userMessage='" + userMessage + '\'' +
                ", systemMessage='" + systemMessage + '\'' +
                '}';
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getSystemMessage() {
        return systemMessage;
    }

    public void setSystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
    }
}
